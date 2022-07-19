import java.awt.*;
import java.util.ArrayList;
import java.util.List;
public class Reward {


    private final Point rewardLocation = new Point();
    private final Dimension dimensions = new Dimension(10, 10);


    public Reward(int start_x, int start_y){
        this.rewardLocation.x = start_x;
        rewardLocation.y = start_y;
    }

    public List<Double> getRewardsLocation(){
        List<Double> coordinates = new ArrayList<>();
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