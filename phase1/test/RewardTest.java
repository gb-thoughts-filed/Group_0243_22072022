import org.junit.Test;

public class RewardTest {

    @Test(timeout = 100)
    public void testXPosition() {
        Reward apple = new Reward(3,4);
        assert(apple.getXCoordinate()==3);
    }

    @Test(timeout = 100)
    public void testWidth() {
        Reward apple = new Reward(3,4);
        assert(apple.getWidth()==10);
    }

    @Test(timeout = 100)
    public void testHeight() {
        Reward apple = new Reward(3,4);
        assert(apple.getHeight()==10);
    }
}
