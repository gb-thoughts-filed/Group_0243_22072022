package GameProgram;

import GameProgram.GameBoard;
import Login.UserAccount;

import java.util.ArrayList;
import java.util.List;
import The_GUI.*;

public class GameManager{
    private final Stopwatch timer;

    private final List<Reward> totalGoldenApples = new ArrayList<>();

    private final GamePlayer player;

    private GameBoard grid;
    int score;

    /**
     * Creates new GameProgram.GameManager object. Stores a new GameProgram.GamePlayer object in an instance variable and assigns to it the
     * username of the current user.
     */
    public GameManager(UserAccount user) {
        player = new GamePlayer(user.getUsername());
        score = 0;
        timer = new Stopwatch();
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
     * Starts a new game.
     */
    public void startGame() {
        // if we don't want to make player an instance variable, call it here
        // GameProgram.GamePlayer newPlayer = new GameProgram.GamePlayer(UserAccount username insert here)
        this.grid = new GameBoard();
        timer.start();
    }

    /**
     * Runs the game and ends it when the player has hit an obstacle or the bottom of the game board. Calculates
     * the score and updates the leaderboard after the game ended.
     * @return boolean
     */
    public boolean runGame() {
        grid.moveObjects();
        grid.updateObstacles();
        grid.updateRewards();
        return !isTouching();
    }

    private boolean isTouching() {
        if(grid.isTouchingBottom(this.player) || grid.isTouchingObstacle(this.player)){
            endGame();
            return true;
        } else if (grid.isTouchingReward(this.player) != null) {
            Reward r = grid.isTouchingReward(this.player);
            if (r instanceof PoisonApple) {
                endGame();
                return true;
            } else if (r instanceof GoldenApple) {
                this.totalGoldenApples.add(r);
            }
        }
        return false;
    }

    /**
     * Ends the current game, calculates the score of the game and updates the leaderboard, if required.
     * @return boolean
     */
    public void endGame() {
        Leaderboard scoreBoard = new Leaderboard();
        timer.stop();
        score = (int)timer.getElapsedSeconds();
        if (!scoreBoard.updateExistingScore(player.getUsername(), score)){
            scoreBoard.addNewScore(player.getUsername(), score);
        }else{
            scoreBoard.updateExistingScore(player.getUsername(), score);
        }
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
        score = (int)timer.getElapsedSeconds() + totalGoldenApples.size() * 10;
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
     * @return GameProgram.GamePlayer player of the current game
     */
    public GamePlayer getPlayer() { return player; }


}
