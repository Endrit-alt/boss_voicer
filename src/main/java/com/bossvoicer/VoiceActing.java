package com.bossvoicer;

import java.util.HashMap;
import java.util.Map;

public enum VoiceActing {

    // General Graardor text
    ALL_GLORY_TO_BANDOS("All glory to Bandos!","graardor/all_glory_to_bandos.wav"),
    SPLIT_THEIR_SKULLS("Split their skulls!","graardor/split_their_skulls.wav"),
    CRUSH_THEM_UNDERFOOT("Crush them underfoot!","graardor/crush_them_underfoot.wav"),
    FOR_GLORY_OF_WAR_GOD("For the glory of the Big High War God!","graardor/for_glory_of_war_god.wav"),
    BRARGH("Brargh!","graardor/brargh.wav"),
    CHAAARGE("CHAAARGE!","graardor/chaaarge.wav"),
    FEAST_ON_BONES("We feast on the bones of our enemies tonight!","graardor/feast_on_bones.wav"),
    DEATH_TO_OUR_ENEMIES("Death to our enemies!","graardor/death_to_our_enemies.wav"),
    BREAK_THEIR_BONES("Break their bones!","graardor/break_their_bones.wav"),
    GRRRAAAAAR("GRRRAAAAAR!","graardor/grrraaaaar.wav"),
    GRAARDOR_DEATH("General Graardor Death","graardor/death.wav"),

    // K'ril Tsutsaroth text
    KILL_THEM_YOU_COWARDS("Kill them, you cowards!","kril/kill_them_you_cowards.wav"),
    ZAMORAK_CURSE_THEM("Zamorak curse them!","kril/zamorak_curse_them.wav"),
    DEATH_TO_SARADOMINS_DOGS("Death to Saradomin's dogs!","kril/death_to_saradomins_dogs.wav"),
    REND_THEM_LIMB_FROM_LIMB("Rend them limb from limb!","kril/rend_them_limb_from_limb.wav"),
    FLAY_THEM_ALL("Flay them all!","kril/flay_them_all.wav"),
    ATTACK_THEM_YOU_DOGS("Attack them, you dogs!","kril/attack_them_you_dogs.wav"),
    FORWARD("Forward!","kril/forward.wav"),
    ATTACK("Attack!","kril/attack.wav"),
    THE_DARK_ONE_WILL_HAVE_THEIR_SOULS("The Dark One will have their souls!","kril/the_dark_one_will_have_their_souls.wav"),
    NO_RETREAT("No retreat!","kril/no_retreat.wav"),
    YARRR("YARRRRRRR!","kril/yarrr.wav"),
    KRIL_DEATH("K'ril Tsutsaroth Death", "kril/death.wav"),

    // Kree'arra text
    SKREEEEE("Skreeeee!","kree/skreeeee.wav"),
    KRAAAAW("Kraaaw!","kree/kraaaw.wav"),

    // Commander Zilyana text
    ALL_PRAISE_SARADOMIN("All praise Saradomin!","zily/all_praise_saradomin.wav"),
    SLAY_THE_EVIL_ONES("Slay the evil ones!","zily/slay_the_evil_ones.wav"),
    DEATH_TO_THE_ENEMIES_OF_THE_LIGHT("Death to the enemies of the light!","zily/death_to_the_enemies_of_the_light.wav"),
    SARADOMIN_LEND_ME_STRENGTH("Saradomin lend me strength!","zily/saradomin_lend_me_strength.wav"),
    SARADOMIN_IS_WITH_US("Saradomin is with us!","zily/saradomin_is_with_us.wav"),
    FORWARD_OUR_ALLIES_ARE_WITH_US("Forward! Our allies are with us!","zily/forward_our_allies_are_with_us.wav"),
    GOOD_WILL_ALWAYS_TRIUMPH("Good will always triumph!","zily/good_will_always_triumph.wav"),
    MAY_SARADOMIN_BE_MY_SWORD("May Saradomin be my sword!","zily/may_saradomin_be_my_sword.wav"),
    IN_THE_NAME_OF_SARADOMIN("In the name of Saradomin!","zily/in_the_name_of_saradomin.wav"),
    ATTACK_FIND_THE_GODSWORD("Attack! Find the Godsword!","zily/attack_find_the_godsword.wav"),

    // Vet'ion & Calvar'ion text
    I_WILL_SMITE_YOU("I WILL SMITE YOU!", "vetion/i_will_smite_you.wav"),
    I_GOT_YOU_NOW("I'VE GOT YOU NOW!", "vetion/i_got_you_now.wav"),
    STAND_STILL_RAT("STAND STILL, RAT!", "vetion/stand_still_rat.wav"),
    YOU_CANT_ESCAPE("YOU CAN'T ESCAPE!", "vetion/you_cant_escape.wav"),
    FOR_THE_LORD("FOR THE LORD!", "vetion/for_the_lord.wav"),
    YOU_CALL_THAT_A_WEAPON("YOU CALL THAT A WEAPON?!", "vetion/you_call_that_a_weapon.wav"),
    DODGE_THIS("DODGE THIS!", "vetion/dodge_this.wav"),
    PERISH_FOOL("PERISH, FOOL!", "vetion/perish_fool.wav"),
    YOU_ARE_POWERLESS_TO_ME("YOU ARE POWERLESS TO ME!", "vetion/you_are_powerless_to_me.wav"),
    TIME_TO_DIE_MORTAL("TIME TO DIE, MORTAL!", "vetion/time_to_die_mortal.wav"),
    DIE("DIE!", "vetion/die.wav"),
    DIE_RODENT("DIE, RODENT!", "vetion/die_rodent.wav"),
    HOLD_STILL_SO_I_CAN_SMITE_YOU("HOLD STILL SO I CAN SMITE YOU!", "vetion/hold_still_so_I_can_smite_you.wav"),
    YOURE_MINE_NOW("YOU'RE MINE NOW!", "vetion/youre_mine_now.wav"),
    RAAARGH("RAAARGH!", "vetion/raaargh.wav"),
    WEAK_FEEBLE("YOU ARE WEAK! YOU ARE FEEBLE!", "vetion/you_are_weak_you_are_feeble.wav"),
    ILL_CUT_YOU_DOWN("I WILL CUT YOU DOWN!", "vetion/ill_cut_you_down.wav"),
    ILL_END_YOU("I WILL END YOU!", "vetion/ill_end_you.wav"),
    NOW_I_GOT_YOU("NOW I'VE GOT YOU!", "vetion/now_i_got_you.wav"),
    HANDS_OFF_WRETCH("HANDS OFF, WRETCH!", "vetion/hands_off_wretch.wav"),
    GRRRAH("GRRRAH!", "vetion/grrrah.wav"),
    FILTHY_WHELPS("FILTHY WHELPS!", "vetion/filthy_whelps.wav"),
    YOURE_NOT_BLOCKING_THIS_ONE("YOU'RE NOT BLOCKING THIS ONE!", "vetion/youre_not_blocking_this_one.wav"),
    DEFEND_YOURSELF("DEFEND YOURSELF!", "vetion/defend_yourself.wav"),
    TAKE_THIS("TAKE THIS!", "vetion/take_this.wav"),
    TOO_CLOSE("TOO CLOSE!", "vetion/too_close.wav"),
    BACK_OFF_MUTT("BACK OFF, MUTT!", "vetion/back_off_mutt.wav"),
    TIME_TO_FEAST_HOUNDS("TIME TO FEAST, HOUNDS!", "vetion/time_to_feast_hounds.wav"),
    HOUNDS_DISPOSE_OF_THESE_TRESSPASSERS("HOUNDS! DISPOSE OF THESE TRESSPASSERS!", "vetion/hounds_dispose_of_these_tresspassers.wav"),
    HOUNDS_GET_THEM("GAH! HOUNDS! GET THEM!", "vetion/hounds_get_them.wav"),
    ENOUGH_OF_THIS("I'VE HAD ENOUGH OF THIS! HOUNDS!", "vetion/enough_of_this.wav"),
    GET_RID_OF_THESE_INTERLOPERS("HOUNDS! GET RID OF THESE INTERLOPERS!", "vetion/get_rid_of_these_interlopers.wav"),
    GO_FORTH_MY_HOUNDS("GO FORTH, MY HOUNDS, AND DESTROY THEM!", "vetion/go_forth_my_hounds.wav"),
    MUST_I_DO_EVERYTHING_AROUND_HERE("MUST I DO EVERYTHING AROUND HERE?!", "vetion/must_i_do_everything_around_here.wav"),
    ILL_KILL_YOU_FOR_KILLING_MY_PETS("I'LL KILL YOU FOR KILLING MY PETS!", "vetion/ill_kill_you_for_killing_my_pets.wav"),
    FINE_ILL_DEAL_WITH_YOU_MYSELF("FINE! I'LL DEAL WITH YOU MYSELF!", "vetion/fine_ill_deal_with_you_myself.wav"),
    MAKE_YOU_PAY("MY HOUNDS! I'LL MAKE YOU PAY FOR THAT!", "vetion/make_you_pay.wav"),
    NOW_DO_IT_AGAIN("Now... DO IT AGAIN!!!", "vetion/now_do_it_again.wav"),
    URGH_NOT_AGAIN("Urgh... not... again...", "vetion/not_again.wav"),
    URK_I_FAILED("Urk! I... failed...", "vetion/i_failed.wav"),
    ILL_BE_BACK("I'll... be... back...", "vetion/ill_be_back.wav"),
    THIS_ISNT_THE_LAST_OF_ME("This isn't... the last... of me...", "vetion/this_isnt_the_last_of_me.wav"),
    MY_LORD_IM_SORRY("My lord... I'm... sorry...", "vetion/my_lord_im_sorry.wav"),
    ILL_GET_YOU_NEXT_TIME("I'll get you... next... time...", "vetion/ill_get_you_next_time.wav"),

    // Barrows Brothers text
    DISTURB_MY_REST("You dare disturb my rest!", "barrows/you_dare_disturb_my_rest.wav"),
    STEAL_FROM_US("You dare steal from us!", "barrows/you_dare_steal_from_us.wav"),

    // Verzik Vitur text
    IM_GOING_TO_ENJOY_THIS("Oh I'm going to enjoy this...", "verzik/im_going_to_enjoy_this.wav"),
    YOU_THINK_YOU_CAN_DEFEAT_ME("You think you can defeat me?", "verzik/you_think_you_can_defeat_me.wav"),
    NOTHING_UNDER_THERE_FOR_YOU("There's nothing under there for you!", "verzik/nothing_under_there_for_you.wav"),
    BEHOLD_MY_TRUE_NATURE("Behold my true nature!", "verzik/behold_my_true_nature.wav"),
    NOT_FINISHED_WITH_YOU("I'm not finished with you just yet!", "verzik/not_finished_with_you_just_yet.wav"),
    YOU_THINK_THIS_IS_OVER("You think this is over?!", "verzik/you_think_this_is_over.wav"),
    VERZIK_DEATH("Verzik Vitur Death", "verzik/death.wav"),

    // Sol Heredit text
    REAL_FOE("Now let's see how you handle a real foe...","sol/real_foe.wav"),
    WHAT_YOU_HAVE_THIS_TIME("But you're clearly different. Let's see what you have this time...","sol/what_you_have_this_time.wav"),
    TO_ARMS("To arms!","sol/to_arms.wav"),
    SHALL_WE("You might be an incapable fighter, but at least you're persistent. Shall we?,","sol/shall_we.wav"),
    FOOTWORK("Let's start by testing your footwork.","sol/testing_your_footwork.wav"),
    SOMETHING_ELSE("Not bad. Let's try something else...","sol/try_something_else.wav"),
    HANDLE_THIS("Impressive. Let's see how you handle this...","sol/see_how_you_handle_this.wav"),
    CANT_WIN("You can't win!","sol/you_cant_win.wav"),
    GUIDE_MY_HAND("Ralos guides my hand!","sol/ralos_guide_my_hand.wav"),
    END_THIS("LET'S END THIS!","sol/lets_end_this.wav"),
    BREAK_BACK("I'LL BREAK YOUR BACK!","sol/break_your_back.wav"),
    CRUSH_BODY("I'LL CRUSH YOUR BODY!","sol/crush_your_body.wav"),
    TWIST_HANDS("I'LL TWIST YOUR HANDS OFF!","sol/twist_your_hands_off.wav"),
    BREAK_LEGS("I'LL BREAK YOUR LEGS!","sol/break_your_legs.wav"),
    CUT_FEET("I'LL CUT YOUR FEET OFF!","sol/cut_your_feet_off.wav"),
    SHINES_BRIGHTLY("Your light shines... brightly...","sol/your_light_shines_brightly.wav"),
    WORTHY_OPPONENT("A worthy... opponent...","sol/a_worthy_opponent.wav"),
    SMILED_UPON_YOU("Ralos has smiled upon you...","sol/ralos_has_smiled_upon_you.wav"),
    COMPLIMENTS_CHAMPION("My compliments, champion...","sol/my_compliments_champion.wav"),
    HOW_DISAPPOINTING("How disappointing...","sol/how_disappointing.wav"),
    WERENT_THE_ONE("I knew you weren't the one.","sol/i_knew_you_werent_the_one.wav"),
    ALMOST_EXCITED("You almost had me excited for a moment.","sol/you_almost_had_me_excited_for_a_moment.wav"),
    LACK_OF_COORD("Your lack of coordination is concerning.","sol/your_lack_of_coordination_is_concerning.wav"),
    SHINES_NO_LONGER("Your light shines no longer.","sol/your_light_shines_no_longer.wav"),
    MAYBE_NEXT_TIME("Maybe next time...","sol/maybe_next_time.wav"),
    PATHETIC_REALLY("Pathetic, really...","sol/pathetic_really.wav"),
    ;

    private static final Map<String, VoiceActing> triggerLines = new HashMap<>();
    static {
        for (VoiceActing voiceAct : values()) {
            triggerLines.put(voiceAct.triggerLine, voiceAct);
        }
    }

    private final String triggerLine;
    private final String file;

    VoiceActing(String triggerLine, String file) {
        this.triggerLine = triggerLine;
        this.file = file;
    }

    public static VoiceActing forTriggerLine(String triggerLine) {
        return triggerLines.get(triggerLine);
    }

    public String trigger() {
        return triggerLine;
    }

    public String file() {
        return file;
    }
}