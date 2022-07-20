import org.junit.Test;

public class PoisonAppleTest {

    @Test(timeout = 100)
    public void testInitializer() {
        PoisonApple apple = new PoisonApple(4, 8);
        assert (apple.getXCoordinate() == 4);
    }
}
