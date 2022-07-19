import java.util.*;

public class Leaderboard {
    private Map<String, Integer> scoreMap;

    /**
     * Creates new Leaderboard object.
     */
    public Leaderboard(){
        scoreMap = new HashMap<>();
    }

    /**
     *
     */
    public void setScoreMap(){
        IntegerComparator n = new IntegerComparator(scoreMap);
        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(n);
        this.scoreMap = sorted;
    }

    public Map<String, Integer> getAllTimeScores(){
        IntegerComparator n = new IntegerComparator(scoreMap);
        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(n);
        return sorted;
    }

    /**
     * Adds a new user and their highest score to the leaderboard.
     * @param username username of the user
     * @param score user's highest score
     */
    public void addNewScore(String username, int score){
        scoreMap.put(username, score);
        new IntegerComparator(scoreMap);
    }

    /**
     * Updates the score of the user that is already on the leaderboard to a new highest score.
     * @param username username of the user
     * @param score new highest score of the user
     * @return boolean
     */
    public boolean updateExistingScore(String username, int score){
        if (!scoreMap.containsKey(username)){
            return false;
        }
        scoreMap.replace(username, scoreMap.get(username), score);
        return true;
    }



}

