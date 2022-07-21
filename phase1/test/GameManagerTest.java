import GameProgram.GameManager;
import Login.UserAccount;
import org.junit.Test;

public class GameManagerTest {

    @Test(timeout = 150)
    public void testInitializer() {
        UserAccount user = new UserAccount("Jane", "12345678", false);
        GameManager manager = new GameManager(user);
        assert(manager.getScore() == 0);
        assert(manager.getPlayer().getUsername() == "Jane");
    }

    @Test(timeout = 50)
    public void testMoveUp() {
        UserAccount user = new UserAccount("Jane", "12345678", false);
        GameManager manager = new GameManager(user);
        manager.moveUp();
        assert(manager.getPlayer().getLocation().get(1) == 141);
    }

    @Test(timeout = 50)
    public void testMoveDown() {
        UserAccount user = new UserAccount("Jane", "12345678", false);
        GameManager manager = new GameManager(user);
        manager.moveDown();
        assert(manager.getPlayer().getLocation().get(1) == 139);
    }



}
