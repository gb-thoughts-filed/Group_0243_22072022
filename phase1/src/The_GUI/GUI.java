package The_GUI;

import GameProgram.GameGUIControllerInterface;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class GUI implements GameGUIControllerInterface {

    private static GamePlayerVisual g = new GamePlayerVisual(20, 20);

    private static List<GoldenAppleVisual> goldenapplevisualList = new ArrayList<GoldenAppleVisual>();

    private static List<PoisonAppleVisual> poisonapplevisualList = new ArrayList<PoisonAppleVisual>();

    private static List<ObstacleVisual> obstaclevisualList = new ArrayList<ObstacleVisual>();

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

    public static void moveGamePlayerVisual(int ypos) {

        g.setYpos(ypos);

    }

    public static void makeObstacleVisual(int xpos, int height) {

        int bottom_obs_y = height + 50;
        ObstacleVisual top_obs = new ObstacleVisual(xpos, 0, height);
        ObstacleVisual bottom_obs = new ObstacleVisual(xpos, bottom_obs_y, 600 - height);
        frame.add(top_obs);
        frame.add(bottom_obs);
        obstaclevisualList.add(top_obs);
        obstaclevisualList.add(bottom_obs);

    }

    public static void makeGoldenAppleVisual(int xpos, int ypos) {

        GoldenAppleVisual ga = new GoldenAppleVisual(xpos, ypos);

        frame.add(ga);
        goldenapplevisualList.add(ga);

    }

    public static void makePoisonAppleVisual(int xpos, int ypos) {

        PoisonAppleVisual pa = new PoisonAppleVisual(xpos, ypos);

        frame.add(pa);
        poisonapplevisualList.add(pa);

    }

    public static void moveAllLeftVisual() {

        for(ObstacleVisual i : obstaclevisualList){
            int x_position = i.getXpos();
            i.setXpos(x_position - 1);
        }

        for(GoldenAppleVisual i : goldenapplevisualList){
            int x_position = i.getXpos();
            i.setXpos(x_position - 1);
        }

        for(PoisonAppleVisual i : poisonapplevisualList){
            int x_position = i.getXpos();
            i.setXpos(x_position - 1);
        }

    }
}



