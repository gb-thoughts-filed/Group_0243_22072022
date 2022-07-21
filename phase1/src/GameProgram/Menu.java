package GameProgram;

import java.util.Scanner;

public class Menu {

    public void mainMenu(Login.UserAccount user) {
        PlayGame play = new PlayGame(user);
        Scanner myObj = new Scanner(System.in);
        int line;
        System.out.println("Welcome to our Game!");

        while (play.isRunning()) {
            System.out.println("Please select a menu option:");
            System.out.println("1. PLAY GAME");
            System.out.println("2. LEADERBOARD");
            System.out.println("3. HOW TO PLAY");

            String userInput = myObj.nextLine();
            line = play.selectOption(userInput);

            if (line == 1) {
                System.out.println("BEGIN GAME");
            } else if (line == 2) {
                System.out.println(play.displayLeaderboard());
            } else if (line == 3) {
                System.out.println("Use UP and DOWN arrow keys to move the bird and avoid obstacles. Collect golden apples " +
                        "to increase your score. Avoid poison apples or the game will end!");
            }
        }
}
}
