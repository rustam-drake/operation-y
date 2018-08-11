package com.drake;

import com.drake.rts.battle.AttackService;
import com.drake.rts.battle.BattleArmy;

import java.util.Scanner;

public class RunApp {

    public static void run() {
        displayWelcomePage();
    }

    private static void displayWelcomePage() {

        AttackService attackService = new AttackService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Rustyland, you are the King\n\n".toUpperCase());
        System.out.println("options:");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Retreat");
        System.out.println("\t3. Defend");

        BattleArmy battleArmy = new BattleArmy(10000L, 0L);
        BattleArmy enemyBattleArmy = new BattleArmy(20000L, 0L);

        int selction = scanner.nextInt();
        if (selction == 1) {
            attackService.result(enemyBattleArmy, battleArmy);
        }
    }
}
