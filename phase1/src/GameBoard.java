import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoard {

    private final int width = 300;

    private final int height = 600;

    private final List<Reward> rewardsList = new ArrayList<>();

    private final List<Obstacle> obstacleList = new ArrayList<>();

    private final String player_username = UserAccount.getUsername();

    /**
     * Creates new GameBoard object.
     */
    public GameBoard() {
        this.obstacleList.add(new Obstacle(120, 120, 100));
        this.obstacleList.add(randomizeObstacle());
        obstacleList.get(1).setLocation(220);
    }

    /**
     * Checks if player has hit an obstacle.
     * @param player the player in the current game
     * @return boolean
     */
    public boolean isTouchingObstacle(GamePlayer player) {
        for (Obstacle o : obstacleList) {
            int oLocation = o.getLocation();
            int blank = o.getBottomObstacleHeight();
            List<Double> playerPosition = player.getLocation();
            int width = player.getWidth();
            int height = player.getHeight();
            if (playerPosition.get(0) - width <= oLocation && oLocation <= playerPosition.get(0)) {
                return playerPosition.get(1) <= blank && playerPosition.get(1) + height >= blank + 40;
            } else { return false; }
        }
        return false;
    }

    /**
     * Checks if player has hit the bottom of the game board.
     * @param player the player in the current game
     * @return boolean
     */
    public boolean isTouchingBottom(GamePlayer player) {
        List<Double> playerPosition = player.getLocation();
        return playerPosition.get(1) < 0;
    }

    /**
     * Checks if player has collected a reward.
     * @param player the player in the current game
     * @return boolean
     */
    public Reward isTouchingReward(GamePlayer player) {
        List<Double> playerPosition = player.getLocation();
        Double xPos = playerPosition.get(0);
        Double yPos = playerPosition.get(1);
        List<Reward> remove = new ArrayList<>();
        for (Reward r : rewardsList) {
            List<Double> rewardPosition = r.getRewardsLocation();
            if (xPos > rewardPosition.get(0) && xPos - player.getHeight() < rewardPosition.get(0) + r.getWidth()) {
                if (yPos + player.getHeight() > rewardPosition.get(1) && yPos < rewardPosition.get(1) + r.getHeight()) {
                    remove.add(r);
                }
            }
        }
        return removeReward(remove);
    }

    private Reward removeReward(List<Reward> remove) {
        if (!remove.isEmpty()) {
            rewardsList.remove(remove.get(0));
            return remove.get(0);
        }
        return null;
    }

    /**
     * Adds new obstacle to the game board.
     */
    public void updateObstacles() {
        if (obstacleList.get(0).getLocation() == 60) {
            obstacleList.add(randomizeObstacle());
        } else if (obstacleList.get(0).getLocation() + obstacleList.get(0).getWidth() == 0) {
            obstacleList.remove(0);
        }
    }

    /**
     * Adds new reward to the game board.
     */
    public void updateRewards() {
        Obstacle last = obstacleList.get(obstacleList.size() - 1);
        if (last.getLocation() == 300) {
            rewardsList.add(randomizeReward());
        }
        if (!rewardsList.isEmpty()) {
            if (rewardsList.get(0).getXCoordinate() + rewardsList.get(0).getWidth() == 0) {
                rewardsList.remove(0);
            }
        }
    }

    /**
     * Creates a new randomized obstacle.
     * @return Obstacle
     */
    public Obstacle randomizeObstacle() {
        List<Obstacle> obstacleList = new ArrayList<>();
        obstacleList.add(new Obstacle(160, 80, this.width));
        obstacleList.add(new Obstacle(80, 160, this.width));
        obstacleList.add(new Obstacle(120, 120, this.width));
        Random rand = new Random();
        int index = rand.nextInt(obstacleList.size());
        return obstacleList.get(index);
    }

    /**
     * Creates a new randomized reward.
     * @return Rewards
     */
    public Reward randomizeReward() {
        List<Reward> reward = new ArrayList<>();
        Random rand = new Random();
        reward.add(new PoisonApple(this.width + 70, rand.nextInt(this.height - 20) + 5));
        reward.add(new GoldenApple(this.width + 70, rand.nextInt(this.height - 20) + 5));
        int index = rand.nextInt(reward.size());
        return reward.get(index);
    }

    /**
     * Moves all objects on the game board (excluding player) left by 1 square.
     */
    public void moveObjects() {
        for (Obstacle o : obstacleList) {
            o.moveLeft();
            }
        for (Reward r : rewardsList) {
            r.moveLeft();
        }
    }

    public List<Obstacle> getObstacleList() {
        return obstacleList;
    }
}






