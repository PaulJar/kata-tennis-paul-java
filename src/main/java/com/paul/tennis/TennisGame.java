package com.paul.tennis;

public class TennisGame {

    TennisPlayer tennisPlayer1;
    TennisPlayer tennisPlayer2;

    public TennisGame() {}

    /**
     * Create a new tennis game
     * @param tennisPlayer1 - 1st player
     * @param tennisPlayer2 - 2nd player
     */
    public TennisGame(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
    }

    public int getScore(int a, int b) {

        return a + b;
    }

    public String getStatus() {
        String status = tennisPlayer1.getName() + " - " + tennisPlayer2.getName();
        return status;
    }
}
