import java.awt.*;
import java.util.List;
public class Reward {


    private Point rewardLocation;
    private final Dimension dimensions = new Dimension(10, 10);


    public Reward(int start_x, int start_y){
        rewardLocation.x = start_x;
        rewardLocation.y = start_y;
    }

    public List<Double> getRewardsLocation(){

        List<Double> coordinates = null;
        coordinates.add((double) rewardLocation.x);
        coordinates.add((double) rewardLocation.y);
        return coordinates;
    }

    public int getXCoordinate() { return rewardLocation.x; }

    public void moveLeft() {
        rewardLocation.x -= 1;
    }

    public int getWidth() { return dimensions.width; }

    public int getHeight() { return dimensions.height; }
}