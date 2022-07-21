package GameProgram;

import java.awt.*;

public class Obstacle {
    private final Dimension topObstacle;
    private final Dimension bottomObstacle;

    private int xCoordinate;

    public Obstacle(int topHeight, int bottomHeight, int x) {
        topObstacle = new Dimension(30, topHeight);
        bottomObstacle = new Dimension(30, bottomHeight);
        xCoordinate = x;
    }

    public void setObstacleSize(int topHeight, int bottomHeight, int width){
        topObstacle.setSize(width, topHeight);
        bottomObstacle.setSize(width, bottomHeight);
    }

    public int getTopObstacleHeight(){
        return topObstacle.height;
    }

    public int getBottomObstacleHeight(){
        return bottomObstacle.height;
    }

    public int getWidth() { return bottomObstacle.width; }

    public int getLocation() {
        return xCoordinate;
    }

    public void moveLeft() {
        xCoordinate -= 1;
    }

    public void setLocation(int x) { this.xCoordinate = x; }
}
