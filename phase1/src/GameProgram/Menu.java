package GameProgram;

import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        PlayGame play = new PlayGame();
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please select a menu option: PLAY, LEADERBOARD, GAME TUTORIAL");
        String choice = myObj.nextLine();
        switch (choice) {
            case "PLAY" -> play.runGame();
            case "LEADERBOARD" -> play.displayLeaderboard();
            case "GAME TUTORIAL" ->
                    System.out.println("Use UP and DOWN arrow keys to move the bird and avoid obstacles. Collect golden " +
                            "apples to increase your score. Avoid poison apples or the game will end");
        }
    }
}
