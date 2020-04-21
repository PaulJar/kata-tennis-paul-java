package com.paul.tennis;

public class TennisGameLauncher {

    /**
     * Main class used to launch the game
     * @param args
     */
    public static void main(String[] args){

        // Init the game with 2 players
        TennisPlayer tennisPlayer1 = new TennisPlayer("Paul");
        TennisPlayer tennisPlayer2 = new TennisPlayer("Hervé");
        TennisGame tennisGame = new TennisGame(tennisPlayer1, tennisPlayer2);

        // Launch the game and display the status after each ball played
        System.out.println("******* GAME START *******");
        System.out.println(tennisGame.getStatus());
        while(!tennisGame.hasWinner()) {
            tennisGame.updateScore();
            tennisGame.displayStatus();
        }

        // End of the game : display the winner
        System.out.println("******* " + tennisGame.getWinner().getName() + " WON ! *******");
    }

}
