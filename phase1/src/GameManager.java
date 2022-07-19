import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameManager{
    private Stopwatch timer;

    private List<GoldenApple> total_golden_apples;

    private final GamePlayer player;
    int score;

    /**
     * Creates new GameManager object. Stores a new GamePlayer object in an instance variable and assigns to it the
     * username of the current user.
     */
    public GameManager(){
        player = new GamePlayer(UserAccount.getUsername());
        score = 0;
    }

    /**
     * Moves the player upwards by 1 square.
     */
    public void moveUp(){
        Double xCoord = player.getLocation().get(0);
        Double yCoord = player.getLocation().get(1);
        double newY = yCoord + 1.0;
        player.setLocation(xCoord, newY);
    }

    /**
     * Moves the player downwards by 1 square.
     */
    public void moveDown(){
        Double xCoord = player.getLocation().get(0);
        Double yCoord = player.getLocation().get(1);
        double newY = yCoord - 1.0;
        player.setLocation(xCoord, newY);
    }

    /**
     * Starts a new game and ends it when the player has hit an obstacle or the bottom of the game board. Calculates
     * the score and updates the leaderboard after the game ended.
     * @return boolean
     */
    public boolean runGame(){
        // if we don't want to make player an instance variable, call it here
        // GamePlayer newPlayer = new GamePlayer(UserAccount username insert here)
        GameBoard grid = new GameBoard();
        timer.start();
        if(grid.isTouchingBottom(this.player) || grid.isTouchingObstacle(this.player)){
            return endGame();
        }
        return true;
    }

    /**
     * Ends the current game, calculates the score of the game and updates the leaderboard, if required.
     * @return boolean
     */
    public boolean endGame(){
        Leaderboard scoreBoard = new Leaderboard();
        timer.stop();
        score = (int)timer.getElapsedSeconds();
        if (!scoreBoard.updateExistingScore(player.getUsername(), score)){
            scoreBoard.addNewScore(player.getUsername(), score);
        }else{
            scoreBoard.updateExistingScore(player.getUsername(), score);
        }
        return false;
    }

    /**
     * Updates the score variable while the game is running based on the time elapsed.
     */
    public void updateScore(){
        while(timer.isStopWatchRunning()) {
            score = (int)timer.getElapsedSeconds();
        }
    }

    /**
     * Calculates the score for the current game based on the time elapsed and the number of
     * Golden Apples collected. Stores it in an instance variable.
     */
    public void generateRewardScore(){
        score = (int)timer.getElapsedSeconds() + total_golden_apples.size() * 10;
    }

    /**
     * Returns the score of the current game.
     * @return int score of the current game
     */
    public int getScore(){
        return score;
    }

    /**
     * Returns the player of the current game.
     * @return GamePlayer player of the current game
     */
    public GamePlayer getPlayer() { return player; }




    // public Reward randomizeReward(){
    //  similar to above, just need reward class to be completed

}
