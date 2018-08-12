package com.drake;

import com.drake.rts.battle.BattleArmy;
import com.drake.rts.battle.BattleFactors;
import com.drake.rts.battle.enums.BattleOutcome;
import com.drake.rts.battle.service.AttackService;

import java.util.Scanner;

public class RunApp {

    private boolean active = true;
    public void run() {
        displayWelcomePage();
    }

    private void displayWelcomePage() {

        AttackService attackService = new AttackService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rustyland, you are the King\n\n".toUpperCase());


        BattleFactors attackFactors = new BattleFactors(.2F, .1F);
        BattleArmy battleArmy = new BattleArmy(15000L, 0L, attackFactors);

        BattleFactors defendersFactors = new BattleFactors(.21F, .1F);
        BattleArmy enemyBattleArmy = new BattleArmy(10000L, 0L, defendersFactors);

        while (active) {
            System.out.println("options:");
            System.out.println("\t1. Attack");
            System.out.println("\t2. Retreat");
            System.out.println("\t3. Defend");

            int selection = scanner.nextInt();
            isActive(selection);
            if (selection == 1) {
                attackService.result(battleArmy, enemyBattleArmy);
                if (battleArmy.isVictory().equals(BattleOutcome.VICTORY)) {
                    System.out.println("Victory!");
                } else if (enemyBattleArmy.isVictory().equals(BattleOutcome.DEFEAT)){
                    System.out.println("Defeat!!");
                } else if (enemyBattleArmy.isVictory().equals(BattleOutcome.DRAW)){
                    System.out.println("Draw!!");
                }
            }
        }
    }

    private void isActive(int selection) {
        if (selection == 0) {
            active = false;
        }

    }
}
