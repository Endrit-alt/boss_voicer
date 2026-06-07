package com.bossvoicer;

import com.google.inject.Provides;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.*;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.util.Text;
import javax.inject.Inject;
import javax.sound.sampled.*;
import javax.sound.sampled.FloatControl.Type;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import net.runelite.api.widgets.ComponentID;
import net.runelite.api.widgets.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import java.util.Random;

@Slf4j
@PluginDescriptor(
	name = "Boss Voicer"
)
public class BossVoicerPlugin extends Plugin {
	private final Map<VoiceActing, Clip> voiceActingClips = new HashMap<>();
	Clip previousClip;

	@Inject
	private BossVoicerConfig config;
	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;

	Timer timer = new Timer();

	// Basic common functions
	@Override
	protected void startUp() throws Exception {
		log.info("Boss Voicer started!");
		loadVoiceActs();
		log.debug("Loaded {} voice over sounds", voiceActingClips.size());
		updateVolumeGain(config.volumeGain());
	}
	@Override
	protected void shutDown() throws Exception {
		unloadVoiceActs();
		log.info("Boss Voicer stopped.");
	}
	@Provides
	BossVoicerConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(BossVoicerConfig.class);
	}

	// Chatbox Dialogue Logic
	@Subscribe(priority=-100)
	private void onWidgetLoaded(WidgetLoaded event) {
		if (event.getGroupId() == InterfaceID.DIALOG_NPC) {
			// InvokeAtTickEnd to wait until the text has loaded in
			clientThread.invokeAtTickEnd(() -> {
				Widget npcNameWidget = client.getWidget(ComponentID.DIALOG_NPC_NAME);
				if (npcNameWidget == null) {
					log.error("NPC name textWidget is null");
					return;
				}
				String npcName = npcNameWidget.getText();
				if ((npcName.equals("Verzik Vitur") && config.includeVerzik())
						|| (npcName.equals("Sol Heredit") && config.includeSol())) {
					Widget textWidget = client.getWidget(ComponentID.DIALOG_NPC_TEXT);
					if (textWidget == null || textWidget.getText() == null) {
						log.error("NPC dialog textWidget or textWidget.getText() is null");
						return;
					}
					String text = Text.sanitizeMultilineText(textWidget.getText());
					log.debug("About to try to play a sound from the chatbox : " + text);
					VoiceActing voiceAct = VoiceActing.forTriggerLine(text);
					if (voiceAct != null) {
						playVoiceAct(npcName, voiceAct);
					}
				}
			});
		}
	}

	// Overhead Dialogue Logic
	@Subscribe
	public void onOverheadTextChanged(OverheadTextChanged event) {
		if (event.getActor() != null && event.getActor().getName() != null && event.getOverheadText() != null) {
			String actorName = event.getActor().getName();
			if ((actorName.equals("General Graardor") && config.includeGraardor())
					|| (actorName.equals("K'ril Tsutsaroth") && config.includeKril())
					|| (actorName.equals("Kree'arra") && config.includeKree())
					|| (actorName.equals("Commander Zilyana") && config.includeZily())
					|| (actorName.equals("Vet'ion") && config.includeVetion())
					|| (actorName.equals("Calvar'ion") && config.includeVetion())
					|| (actorName.equals("Sol Heredit") && config.includeSol())
					|| (actorName.equals("Verzik Vitur") && config.includeVerzik())
					|| (actorName.equals("Ahrim the Blighted") && config.includeBarrows())
					|| (actorName.equals("Dharok the Wretched") && config.includeBarrows())
					|| (actorName.equals("Guthan the Infested") && config.includeBarrows())
					|| (actorName.equals("Karil the Tainted") && config.includeBarrows())
					|| (actorName.equals("Torag the Corrupted") && config.includeBarrows())
					|| (actorName.equals("Verac the Defiled") && config.includeBarrows())) {
				String text = Text.removeTags(event.getOverheadText());
				log.debug("About to try to play a sound from an overhead : " + text);
				VoiceActing voiceAct = VoiceActing.forTriggerLine(text);
				if (voiceAct == null) {
					if (actorName.equals("Vet'ion") || actorName.equals("Calvar'ion")) {
						voiceAct = VoiceActing.forTriggerLine(text.toUpperCase());
						if (voiceAct != null) {
							playVoiceAct(actorName, voiceAct);
						}
					}
				} else {
					playVoiceAct(actorName, voiceAct);
				}
			}
		}
	}

	// Death Sounds Logic, for bosses whose deaths feel a little bit lacking!
	@Subscribe
	public void onAnimationChanged(AnimationChanged event) {
		if (event != null && event.getActor() != null && event.getActor().getName() != null) {
			String actorName = event.getActor().getName();
			int animationID = event.getActor().getAnimation();
			if ((actorName.equals("General Graardor") && animationID == 7020 && config.includeGraardor())
					|| (actorName.equals("K'ril Tsutsaroth") && animationID == 6949 && config.includeKril())
					|| (actorName.equals("Verzik Vitur") && animationID == 8128 && config.includeVerzik())) {
				log.debug("About to try to play a sound from a death");
				VoiceActing voiceAct = VoiceActing.forTriggerLine(actorName + " Death");
				if (voiceAct != null) {
					playVoiceAct(actorName, voiceAct);
				}
			}
		}
	}

// ---------------------------------------------------------------------------

	// Volume Adjustment Logic
	@Subscribe
	public void onConfigChanged(ConfigChanged event) {
		if (event.getGroup().equals(BossVoicerConfig.GROUP)) {
			log.debug("Updating volume gain to {} Db", config.volumeGain());
			updateVolumeGain(config.volumeGain());
		}
	}
	private void updateVolumeGain(float decibels) {
		for (Clip clip : voiceActingClips.values()) {
			FloatControl control = (FloatControl) clip.getControl(Type.MASTER_GAIN);
			control.setValue(decibels);
		}
	}

	// Voice Loading & Unloading Logic
	private void loadVoiceActs() {
		for (VoiceActing voiceAct : VoiceActing.values()) {
			try {
				Clip audioClip = AudioSystem.getClip();
				loadSound(audioClip, voiceAct.file());
				voiceActingClips.put(voiceAct, audioClip);
			} catch (LineUnavailableException e) {
				log.warn("Failed to load audio clip", e);
			}
		}
	}
	private void loadSound(Clip audioClip, String name) {
		InputStream in = getClass().getResourceAsStream("/sounds/" + name);
		if (in == null) {
			log.warn("Missing audio file {}", name);
			return;
		}
		try (InputStream fileStream = new BufferedInputStream(in);
			 AudioInputStream audioStream = AudioSystem.getAudioInputStream(fileStream)) {
			audioClip.open(audioStream);
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
			log.warn("Failed to load audio file", e);
		}
	}
	private void unloadVoiceActs() {
		for (Clip audioClip : voiceActingClips.values()) {
			audioClip.stop();
			audioClip.close();
		}
	}

	// Voice Playing Logic
	private void playVoiceAct(String actorName, VoiceActing voiceAct) {
		if (previousClip != null && previousClip.isRunning() && !config.allowMultipleVoices())
			previousClip.stop();
		Clip clip = voiceActingClips.get(voiceAct);
		if (clip == null) {
			log.warn("Voice clip '{}' is not loaded.", voiceAct);
		} else {
			clip.setFramePosition(0);
			clip.loop(0);
			previousClip = clip;
		}
	}
}
