package com.paul.tennis;

public class TennisGameLauncher {

    public static void main(String[] args){
        TennisPlayer tennisPlayer1 = new TennisPlayer("Paul");
        TennisPlayer tennisPlayer2 = new TennisPlayer("Lucie");
        TennisGame tennisGame = new TennisGame(tennisPlayer1, tennisPlayer2);

        System.out.println("******* GAME START *******");
        System.out.println(tennisGame.getStatus());
        while(!tennisGame.hasWinner()) {
            tennisGame.updateScore();
            tennisGame.displayStatus();
        }
        System.out.println("******* " + tennisGame.getWinner().getName() + " WON ! *******");
    }

}
