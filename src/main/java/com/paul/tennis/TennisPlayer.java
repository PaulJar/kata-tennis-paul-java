package com.paul.tennis;

public class TennisPlayer {

    private String name;
    private int score;
    private boolean isWinner;
    private boolean hasAdvantage;

    public TennisPlayer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

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

    public void setAdvantage(boolean advantage) {
        this.hasAdvantage = advantage;
    }

    public boolean hasAdvantage() {
        return this.hasAdvantage;
    }
}
