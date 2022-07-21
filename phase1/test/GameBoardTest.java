import GameProgram.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GameBoardTest {

    @Test(timeout = 100)
    public void testInitializer() {
        GameBoard board = new GameBoard();
        assert(board.getObstacleList().get(0).getTopObstacleHeight()==120);
        assert(board.getObstacleList().get(0).getBottomObstacleHeight()==120);
        assert(board.getObstacleList().get(0).getWidth()==30);
    }

    @Test(timeout = 50)
    public void testIsTouchingObstacleTrue() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(101, 100);
        assertTrue(grid.isTouchingObstacle(player));
    }

    @Test(timeout = 150)
    public void testIsTouchingObstacleFalse() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(110, 125);
        assertFalse(grid.isTouchingObstacle(player));
    }

    @Test(timeout = 50)
    public void testIsTouchingBottomFalse() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(150, 0);
        assertFalse(grid.isTouchingBottom(player));
    }

    @Test(timeout = 50)
    public void testIsTouchingBottomTrue() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(160, -1);
        assertTrue(grid.isTouchingBottom(player));
    }

    @Test(timeout = 50)
    public void testIsTouchingRewardNoRewards() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(160, 125);
        assertNull(grid.isTouchingReward(player));
    }

    @Test(timeout = 50)
    public void testIsTouchingRewardFalse() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(160, 100);
        grid.addReward(new GoldenApple(160, 100));
        assertNull(grid.isTouchingReward(player));
    }

    @Test(timeout = 50)
    public void testIsTouchingRewardTrue() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(161, 100);
        grid.addReward(new GoldenApple(160, 100));
        Reward reward = grid.isTouchingReward(player);
        assert(reward instanceof GoldenApple);
        assert(grid.getRewardsList().isEmpty());
    }

    @Test(timeout = 50)
    public void isTouchingRewardTrue2() {
        GameBoard grid = new GameBoard();
        GamePlayer player = new GamePlayer("bird");
        player.setLocation(190, 86);
        grid.addReward(new PoisonApple(160, 100));
        grid.addReward(new GoldenApple(50, 50));
        Reward reward = grid.isTouchingReward(player);
        assert(reward instanceof PoisonApple);
        assert(grid.getRewardsList().size() == 1);
        assert(grid.getRewardsList().get(0) instanceof GoldenApple);
    }

    @Test(timeout = 50)
    public void testRandomizeObstacle() {
        GameBoard grid = new GameBoard();
        Obstacle ob = grid.randomizeObstacle();
        assert(ob.getLocation() == 300);
        assert(ob.getBottomObstacleHeight() == 80 | ob.getBottomObstacleHeight() == 120 |
                ob.getBottomObstacleHeight() == 160);
    }

    @Test(timeout = 50)
    public void testRandomizeReward() {
        GameBoard grid = new GameBoard();
        Reward apple = grid.randomizeReward();
        assert(apple.getXCoordinate() == 370);
        List<Double> location = apple.getRewardsLocation();
        assert(5 <= location.get(1) && 585 >= location.get(1));
    }

    @Test(timeout = 50)
    public void testMoveObjects() {
        GameBoard grid = new GameBoard();
        grid.addReward(new GoldenApple(160, 100));
        grid.moveObjects();
        List<Obstacle> obstacles = grid.getObstacleList();
        assert(obstacles.get(0).getLocation() == 99);
        assert(obstacles.get(1).getLocation() == 219);
        assert (grid.getRewardsList().get(0).getXCoordinate() == 159);
    }

    @Test(timeout = 50)
    public void testUpdateObstacles() {
        GameBoard grid = new GameBoard();
        Obstacle ob = grid.getObstacleList().get(0);
        while (ob.getLocation() != 60) {
            grid.moveObjects();
        }
        grid.updateObstacles();
        assert(grid.getObstacleList().size() == 3);
        assert(grid.getObstacleList().get(2).getLocation() == 300);
        while (ob.getLocation() != -ob.getWidth()) {
            grid.moveObjects();
        }
        grid.updateObstacles();
        assert(grid.getObstacleList().size() == 2);
    }

    @Test(timeout = 50)
    public void testUpdateRewards() {
        GameBoard grid = new GameBoard();
        Obstacle ob = grid.getObstacleList().get(0);
        while (ob.getLocation() != 60) {
            grid.moveObjects();
        }
        grid.updateObstacles();
        grid.updateRewards();
        assert(grid.getRewardsList().size() == 1);
    }
}
