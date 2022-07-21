package GUI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GUI {

    private static gameplayervisual g = new gameplayervisual(20, 20);

    private static List reward_obstacleList = new ArrayList<>();

    private static JFrame frame = null;

    //source to help make initial GUI frame: https://www.guru99.com/java-swing-gui.html#4
    public static void main(String[] args) {


        GUI.frame_setup();
        GUI.makeGoldenApple(20, 140);
        GUI.makeObstacle(100, 120);
        GUI.makePoisonApple(200, 50);
        GUI.frame_visible();

    }

    public static void makeGoldenApple(int xpos, int ypos){

        goldenapplevisual ga = new goldenapplevisual(xpos, ypos);

        frame.add(ga);
        reward_obstacleList.add(ga);

    }

    public static void makeObstacle(int xpos, int height){
        int bottom_obs_y = height + 50;
        obstaclevisual top_obs = new obstaclevisual(xpos, 0, height);
        obstaclevisual bottom_obs = new obstaclevisual(xpos, bottom_obs_y, 600 - height);
        frame.add(top_obs);
        frame.add(bottom_obs);
        reward_obstacleList.add(top_obs);
        reward_obstacleList.add(bottom_obs);
    }

    public static void makePoisonApple(int xpos, int ypos){

        poisonapplevisual pa = new poisonapplevisual(xpos, ypos);

        frame.add(pa);
        reward_obstacleList.add(pa);


    }

    public static void movegameplayervisual(int xpos, int ypos){
        g.setXpos(xpos);
        g.setYpos(ypos);
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

}



