import GameProgram.GamePlayer;
import org.junit.Test;

public class GamePlayerTest {

    @Test(timeout = 100)
    public void testInitializer() {
        GamePlayer player = new GamePlayer("kid");
        assert (player.isDead()==false);
    }
}
