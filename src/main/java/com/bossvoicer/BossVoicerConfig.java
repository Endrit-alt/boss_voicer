package com.bossvoicer;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.Range;

@ConfigGroup(BossVoicerConfig.GROUP)
public interface BossVoicerConfig extends Config
{
	String GROUP = "bossVoicer";

	@ConfigItem(
			keyName = "includeGraardor",
			name = "General Graardor",
			description = "Whether or not General Graardor should be voiced.",
			position = 1
	)
	default boolean includeGraardor() { return true; }

	@ConfigItem(
			keyName = "includeKril",
			name = "K'ril Tsutsaroth",
			description = "Whether or not K'ril Tsutsaroth should be voiced.",
			position = 2
	)
	default boolean includeKril() { return true; }

	@ConfigItem(
			keyName = "includeKree",
			name = "Kree'arra",
			description = "Whether or not Kree'arra should be voiced.",
			position = 3
	)
	default boolean includeKree() { return true; }

	@ConfigItem(
			keyName = "includeZily",
			name = "Commander Zilyana",
			description = "Whether or not Commander Zilyana should be voiced.",
			position = 4
	)
	default boolean includeZily() { return true; }

	@ConfigItem(
			keyName = "includeVetion",
			name = "Vet'ion & Calvar'ion",
			description = "Whether or not Vet'ion & Calvar'ion should be voiced.",
			position = 5
	)
	default boolean includeVetion() { return true; }

	@ConfigItem(
			keyName = "includeBarrows",
			name = "Barrows Brothers",
			description = "Whether or not the Barrows Brothers should be voiced (only 2 lines).",
			position = 6
	)
	default boolean includeBarrows() { return true; }

	@ConfigItem(
			keyName = "includeVerzik",
			name = "Verzik Vitur",
			description = "Whether or not Lazy Verzik Vitur should be voiced.",
			position = 7
	)
	default boolean includeVerzik() { return true; }

	@ConfigItem(
			keyName = "includeSol",
			name = "Sol Heredit",
			description = "Whether or not Sol Heredit should be voiced.",
			position = 8
	)
	default boolean includeSol() { return true; }

	@ConfigItem(
			keyName = "volumeGain",
			name = "Volume Gain",
			description = "The volume gain used for the voice over audios.",
			position = 9
	)
	@Range(min = -25, max = 6)
	default int volumeGain() {
		return -10;
	}
}