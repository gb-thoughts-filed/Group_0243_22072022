import org.junit.Test;

public class GameBoardTest {

    @Test(timeout = 100)
    public void testInitializer() {
        GameBoard board = new GameBoard();
        assert(board.getObstacleList().get(0).getTopObstacleHeight()==120);
        assert(board.getObstacleList().get(0).getBottomObstacleHeight()==120);
        assert(board.getObstacleList().get(0).getWidth()==30);
    }
}
