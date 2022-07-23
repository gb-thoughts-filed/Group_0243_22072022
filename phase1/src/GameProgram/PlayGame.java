package GameProgram;

import The_GUI.GUI;
import GameProgram.GameBoard;
import GameProgram.GameManager;
import GameProgram.Leaderboard;

import java.awt.event.KeyEvent;
import java.util.Map;
import java.awt.event.KeyListener;

public class PlayGame implements KeyListener{

    private boolean up, down;
    GameManager manager;
    GameBoard board = new GameBoard();
    private boolean running;

    /**
     * Creates new GameProgram.PlayGame object.
     */
    public PlayGame(Login.UserAccount user) {
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

    public Map<String, Integer> displayLeaderboard(){
        Leaderboard scoreBoard = new Leaderboard();
        return scoreBoard.getScoreMap();
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


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP) {
            manager.moveUp();
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN){
            manager.moveDown();
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {

    }
}
