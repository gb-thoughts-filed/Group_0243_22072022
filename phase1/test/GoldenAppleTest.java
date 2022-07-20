import org.junit.Test;

public class GoldenAppleTest {

    @Test(timeout = 100)
    public void testInitializer() {
        GoldenApple apple = new GoldenApple(1,2);
        assert(apple.getXCoordinate()==1);
    }
}
