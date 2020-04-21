package com.paul.tennis;

public class TennisPlayer {

    private String name;
    private int score;
    private boolean isWinner;
    private boolean hasAdvantage;

    /**
     * Constructor of a TennisPlayer
     * @param name
     */
    public TennisPlayer(String name) {
        this.name = name;
    }

    /**
     * Return the name of the TennisPlayer
     * @return the name of the TennisPlayer
     */
    public String getName() {
        return name;
    }

    /**
     * Return the score of the TennisPlayer
     * @return the score of the TennisPlayer
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Set the score of the TennisPlayer
     * @param score the score of the TennisPlayer
     */
    public void setScore(int score) {
        this.score = score;
    }

    /** Return the formatted score (love / fifteen...)
     * 0 = 0
     * 1 = 15
     * 2 = 30
     * 3 = 40
     * 4 = * / ADV.
     * @return
     */
    public String getScoreFormatted() {
        String scoreFormatted = "";
        switch (this.score) {
            case 0:
                scoreFormatted = "love (0)";
                break;
            case 1:
                scoreFormatted = "fifteen (15)";
                break;
            case 2:
                scoreFormatted = "thirty (30)";
                break;
            case 3:
                scoreFormatted = "forty (40)";
                break;
            case 4:
                scoreFormatted = "ADV";
                break;
        }
        return scoreFormatted;
    }

    /**
     * Return true if the TennisPlayer has advantage
     * @return true if the TennisPlayer has advantage
     */
    public boolean hasAdvantage() {
        return this.hasAdvantage;
    }

    /**
     * Set the advantage (or not) to the TennisPlayer
     * @param advantage advantage (or not) of TennisPlayer
     */
    public void setAdvantage(boolean advantage) {
        this.hasAdvantage = advantage;
    }

    /**
     * Return true is the current player is the winner
     * 0 = 0
     * 1 = 15
     * 2 = 30
     * 3 = 40
     * 4 = * / ADV.
     * @param scoreOtherPlayer
     * @return
     */
    public boolean isWinner(int scoreOtherPlayer) {
        if(this.score >= 4 && scoreOtherPlayer < 3) {
            this.isWinner = true;
            return true;
        } else if(this.score > 4 && scoreOtherPlayer == 3) {
            this.isWinner = true;
            return true;
        } else {
            return false;
        }
    }
}
