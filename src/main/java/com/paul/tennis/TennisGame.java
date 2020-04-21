package com.paul.tennis;

public class TennisGame {

    TennisPlayer tennisPlayer1;
    TennisPlayer tennisPlayer2;

    /**
     * Create a new tennis game
     * @param tennisPlayer1 - 1st player
     * @param tennisPlayer2 - 2nd player
     */
    public TennisGame(TennisPlayer tennisPlayer1, TennisPlayer tennisPlayer2) {
        this.tennisPlayer1 = tennisPlayer1;
        this.tennisPlayer2 = tennisPlayer2;
    }

    /**
     * Return the player 1
     * @return the player 1
     */
    public TennisPlayer getPlayer1() {
        return tennisPlayer1;
    }

    /**
     * Return the player 2
     * @return the player 2
     */
    public TennisPlayer getPlayer2() {
        return tennisPlayer2;
    }

    /**
     * Return the current status of the game
     * @return the status of the game
     */
    public String getStatus() {
        String status;

        // specific case : DEUCE
        if(tennisPlayer1.getScore() == 3 &&
                tennisPlayer2.getScore() == 3) {
            status = "DEUCE\n" ;
        } else {
            status = tennisPlayer1.getName() + "\t" + tennisPlayer1.getScoreFormatted()
                    + "\t-\t"
                    + tennisPlayer2.getScoreFormatted() + "\t" + tennisPlayer2.getName() + "\n" ;
        }
        return status;
    }

    /**
     * Play a ball, and update players score
     */
    public void updateScore() {

        // to determine the winner of the current ball : random number [1,2]
        int min = 1;
        int max = 2;
        int winner = (int)(Math.random() * ((max - min) + 1)) + min;

        int player1Score = this.tennisPlayer1.getScore();
        int player2Score = this.tennisPlayer2.getScore();

        // update the score of the winner and of the loser (in case of ADV. lost)
        switch (winner) {
            case 1:
                calculateScore(tennisPlayer1, tennisPlayer2);
                break;
            case 2:
                calculateScore(tennisPlayer2, tennisPlayer1);
                break;
        }
    }

    /**
     * Calculate players score
     */
    public void calculateScore(TennisPlayer winner, TennisPlayer loser) {
        System.out.println(winner.getName() + " wins the ball.");

        // +1 on the winner's score
        winner.setScore(winner.getScore() + 1);

        // specific case : winner just got ADV.
        if(winner.getScore() == 4 &&
                loser.getScore() == 3) {
            winner.setAdvantage(true);
            System.out.println(winner.getName() + " has ADVANTAGE.");
        }
        // specific case : loser had ADV. He lost it.
        // but winner's score did not change (still 40)
        if(winner.getScore() == 4 &&
                loser.getScore() == 4) {
            winner.setScore(loser.getScore() - 1);
            loser.setScore(loser.getScore() - 1);
            loser.setAdvantage(false);
        }
    }

    /**
     * Check if the current game has a winner
     * @return true if the current game has a winner
     */
    public boolean hasWinner() {
        if(this.getPlayer1().isWinner(this.getPlayer2().getScore()) ||
                this.getPlayer2().isWinner(this.getPlayer1().getScore())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Return the winner of the game
     * @return the winner of the game
     */
    public TennisPlayer getWinner() {
        if(hasWinner() &&
                this.getPlayer1().isWinner(this.getPlayer2().getScore())) {
            return this.getPlayer1();
        } else {
            return this.getPlayer2();
        }
    }

    /**
     * Display the current status of the game
     */
    public void displayStatus() {
        if(!this.hasWinner()) {
            System.out.println(this.getStatus());
        }
    }
}
