package com.drake.rts.battle.service;

import com.drake.rts.battle.BattleArmy;
import com.drake.rts.battle.enums.BattleOutcome;

import java.util.Random;

public class AttackService {

    private BattleArmy attackerBattleArmy;
    private BattleArmy defenderBattleArmy;

    public boolean result(BattleArmy attackerBattleArmy, BattleArmy defenderBattleArmy) {

        this.attackerBattleArmy = attackerBattleArmy;
        this.defenderBattleArmy = defenderBattleArmy;

        Float result  = battleStages();

        System.out.println("Results : " + result);

        return result > 0;
    }

    private Float battleStages() {

        Float attackerRoute = attackerBattleArmy.getStrength() * 0.4F;
        Float defenderRoute = defenderBattleArmy.getStrength() * 0.4F;

        Float attacker = attackerBattleArmy.getStrength();
        Float defender = defenderBattleArmy.getStrength();

        short count = 0;
        while (count < 10 ) {

            attacker = attackerBattleArmy.getStrength();
            defender = defenderBattleArmy.getStrength();

            attacker = attacker * luck() - defender * 0.1F;
            defender = defender * luck() - attackerBattleArmy.getStrength() * 0.1F;
            attackerBattleArmy.setFoot((long) (attacker * (1 - attackerBattleArmy.getFactors().getResult())));
            defenderBattleArmy.setFoot((long) (defender * (1 - defenderBattleArmy.getFactors().getResult())));
            count++;

            if (attacker < attackerRoute) {
                defenderBattleArmy.setVictory(BattleOutcome.VICTORY);
                count = 100;
            }

            if (defender < defenderRoute) {
                attackerBattleArmy.setVictory(BattleOutcome.VICTORY);
                count = 100;
            }

            if (attackerBattleArmy.isVictory().equals(BattleOutcome.VICTORY)
                    && defenderBattleArmy.isVictory().equals(BattleOutcome.VICTORY)) {
                attackerBattleArmy.setVictory(BattleOutcome.DRAW);
                defenderBattleArmy.setVictory(BattleOutcome.DRAW);
            }
        }
        System.out.println("---attacker HP -> " + attacker);
        System.out.println("---defender HP -> " + defender);

        return attacker - defender;
    }

    private Float luck() {
        return 1 + new Random().nextInt( 5) / 100F;
    }

    public BattleArmy getAttackerBattleArmy() {
        return attackerBattleArmy;
    }

    public void setAttackerBattleArmy(BattleArmy attackerBattleArmy) {
        this.attackerBattleArmy = attackerBattleArmy;
    }

    public BattleArmy getDefenderBattleArmy() {
        return defenderBattleArmy;
    }

    public void setDefenderBattleArmy(BattleArmy defenderBattleArmy) {
        this.defenderBattleArmy = defenderBattleArmy;
    }
}
