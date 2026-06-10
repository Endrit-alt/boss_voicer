package com.bossvoicer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;

@ConfigGroup(BossVoicerConfig.GROUP)
public interface BossVoicerConfig extends Config
{
	String GROUP = "bossVoicer";

	@ConfigSection(
			name = "Voice Settings",
			description = "Voice playback settings.",
			position = 0
	)
	String voiceSettings = "voiceSettings";

	@ConfigSection(
			name = "Bosses",
			description = "Boss voice toggles.",
			position = 1
	)
	String bosses = "bosses";

	@ConfigItem(
			keyName = "includeGraardor",
			name = "General Graardor",
			description = "Whether or not General Graardor should be voiced.",
			position = 1,
			section = bosses
	)
	default boolean includeGraardor() { return true; }

	@ConfigItem(
			keyName = "includeKril",
			name = "K'ril Tsutsaroth",
			description = "Whether or not K'ril Tsutsaroth should be voiced.",
			position = 2,
			section = bosses
	)
	default boolean includeKril() { return true; }

	@ConfigItem(
			keyName = "includeKree",
			name = "Kree'arra",
			description = "Whether or not Kree'arra should be voiced.",
			position = 3,
			section = bosses
	)
	default boolean includeKree() { return true; }

	@ConfigItem(
			keyName = "includeZily",
			name = "Commander Zilyana",
			description = "Whether or not Commander Zilyana should be voiced.",
			position = 4,
			section = bosses
	)
	default boolean includeZily() { return true; }

	@ConfigItem(
			keyName = "includeVetion",
			name = "Vet'ion & Calvar'ion",
			description = "Whether or not Vet'ion & Calvar'ion should be voiced.",
			position = 5,
			section = bosses
	)
	default boolean includeVetion() { return true; }

	@ConfigItem(
			keyName = "includeBarrows",
			name = "Barrows Brothers",
			description = "Whether or not the Barrows Brothers should be voiced (only 2 lines).",
			position = 6,
			section = bosses
	)
	default boolean includeBarrows() { return true; }

	@ConfigItem(
			keyName = "includeVerzik",
			name = "Verzik Vitur",
			description = "Whether or not Lazy Verzik Vitur should be voiced.",
			position = 7,
			section = bosses
	)
	default boolean includeVerzik() { return true; }

	@ConfigItem(
			keyName = "includeSol",
			name = "Sol Heredit",
			description = "Whether or not Sol Heredit should be voiced.",
			position = 8,
			section = bosses
	)
	default boolean includeSol() { return true; }

	@ConfigItem(
			keyName = "useV2Voices",
			name = "Immersive Voices",
			description = "Use the _v2 voice folders for K'ril Tsutsaroth, Verzik Vitur, and Sol Heredit.",
			position = 1,
			section = voiceSettings
	)
	default boolean useV2Voices() { return false; }

	@ConfigItem(
			keyName = "volumeGain",
			name = "Volume Gain",
			description = "The volume gain used for the voice over audios.",
			position = 2,
			section = voiceSettings
	)
	@Range(min = -25, max = 6)
	default int volumeGain() {
		return -10;
	}
}
