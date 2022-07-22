import GameProgram.Leaderboard;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LeaderboardTest {

    @Test(timeout = 50)
    public void testAddNewScore() {
        Leaderboard scoreBoard = new Leaderboard();
        scoreBoard.addNewScore("Mary", 10);
        scoreBoard.addNewScore("Judy", 12);
        assertTrue(scoreBoard.getScoreMap().containsKey("Mary"));
        assert(scoreBoard.getScoreMap().get("Judy") == 12);
    }

    @Test(timeout = 50)
    public void testUpdateExistingScore() {
        Leaderboard scoreBoard = new Leaderboard();
        scoreBoard.addNewScore("Mary", 10);
        scoreBoard.updateExistingScore("Mary", 16);
        assert(scoreBoard.getScoreMap().get("Mary") == 16);
    }
}
