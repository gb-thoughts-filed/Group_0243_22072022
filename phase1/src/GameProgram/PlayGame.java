package GameProgram;

import GUI.GUI;
import GameProgram.GameBoard;
import GameProgram.GameManager;
import GameProgram.Leaderboard;

import java.awt.event.KeyEvent;
import java.util.Map;
import java.awt.event.KeyListener;

public class PlayGame {
    private KeyListener listener;

    private boolean up, down;
    GameManager manager;
    GameBoard board = new GameBoard();
    GUI gui_gamescreen = new GUI();
    private static int lineNumber; //A count to print different lines
    private boolean running;

    /**
     * Creates new GameProgram.PlayGame object.
     */
    public PlayGame(Login.UserAccount user){
        lineNumber = 0;
        running = true;
        this.manager = new GameManager(user);
    }

    public int selectOption(String input){
        int output;
        if (input.equals("1")){
            output = 1;
            runGame();
        }
        else if (input.equals("2")) {
            output = 2;
        }
        else output = 3;
        return output;
        }
    public boolean isRunning() {
        return running;
    }

    public void stopRunning() {
        running = false;
    }

    public Map displayLeaderboard(){
        Leaderboard scoreBoard = new Leaderboard();
        return scoreBoard.getAllTimeScores();
    }

    public void runGame(){
        manager.startGame();
        while(manager.runGame()) {
            if (up) {
                manager.moveUp();
            } else if (down) {
                manager.moveDown();
            }
        }
    }

    public void move(){
        //https://stackoverflow.com/questions/65374511/how-to-move-object-with-keylistener-in-java source to help make this
        listener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: down = true;
                    case KeyEvent.VK_UP: up = true;
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_DOWN: down = false;
                    case KeyEvent.VK_UP: up = false;
                }

            }
        };
    }



}
