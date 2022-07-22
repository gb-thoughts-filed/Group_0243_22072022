package GameProgram;

public interface GameGUIControllerInterface {

    public void moveGamePlayer(int ypos);

    public void makeObstacle(int xpos, int height);

    public void makeGoldenApple(int xpos, int ypos);

    public void makePoisonApple(int xpos, int ypos);

    public void moveAllLeft();


}
