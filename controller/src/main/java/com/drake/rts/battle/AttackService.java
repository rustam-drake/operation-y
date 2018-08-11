package com.drake.rts.battle;

import java.util.Random;

public class AttackService {

    public Long result(BattleArmy attackerBattleArmy,  BattleArmy defenderBattleArmy) {

        Random random = new Random();

        float rand = random.nextFloat();

        long result = attackerBattleArmy.getFoot() - defenderBattleArmy.getFoot() ;


        return null;
    }
}
