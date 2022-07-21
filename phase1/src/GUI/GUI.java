package GUI;

import GameProgram.GameGUIControllerInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GUI implements GameGUIControllerInterface {

    private static gameplayervisual g = new gameplayervisual(20, 20);

    private static List<goldenapplevisual> goldenapplevisualList = new ArrayList<goldenapplevisual>();

    private static List<poisonapplevisual> poisonapplevisualList = new ArrayList<poisonapplevisual>();

    private static List<obstaclevisual> obstaclevisualList = new ArrayList<obstaclevisual>();

    private static JFrame frame = null;

    //source to help make initial GUI frame: https://www.guru99.com/java-swing-gui.html#4

    public GUI(){

        frame_setup();
        frame_visible();

    }

    public static void frame_setup(){

        frame = new JFrame("Not Flappy Bird");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(300, 600);
        frame.add(g);

    }

    public static void frame_visible(){

        frame.setResizable(false);
        frame.setVisible(true);

    }

    public void moveGamePlayer(int xpos, int ypos) {

        g.setXpos(xpos);
        g.setYpos(ypos);

    }

    public void makeObstacle(int xpos, int height) {

        int bottom_obs_y = height + 50;
        obstaclevisual top_obs = new obstaclevisual(xpos, 0, height);
        obstaclevisual bottom_obs = new obstaclevisual(xpos, bottom_obs_y, 600 - height);
        frame.add(top_obs);
        frame.add(bottom_obs);
        obstaclevisualList.add(top_obs);
        obstaclevisualList.add(bottom_obs);

    }

    public void makeGoldenApple(int xpos, int ypos) {

        goldenapplevisual ga = new goldenapplevisual(xpos, ypos);

        frame.add(ga);
        goldenapplevisualList.add(ga);

    }

    public void makePoisonApple(int xpos, int ypos) {

        poisonapplevisual pa = new poisonapplevisual(xpos, ypos);

        frame.add(pa);
        poisonapplevisualList.add(pa);

    }

    public void moveAllLeft() {

        for(obstaclevisual i : obstaclevisualList){
            int x_position = i.getXpos();
            i.setXpos(x_position - 1);
        }

        for(goldenapplevisual i : goldenapplevisualList){
            int x_position = i.getXpos();
            i.setXpos(x_position - 1);
        }

        for(poisonapplevisual i : poisonapplevisualList){
            int x_position = i.getXpos();
            i.setXpos(x_position - 1);
        }

    }
}



