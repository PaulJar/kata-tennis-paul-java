package com.paul.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TennisTest {

    @Test
    void testTennisGameStatus() {

        // ARRANGE
        TennisPlayer tennisPlayer1 = new TennisPlayer("Paul");
        TennisPlayer tennisPlayer2 = new TennisPlayer("Hervé");
        TennisGame tennisGame = new TennisGame(tennisPlayer1, tennisPlayer2);

        // ACT
        String tennisGameStatus = tennisGame.getStatus();

        // ASSERT
        Assertions.assertNotNull(tennisGameStatus);
    }

    @Test
    void testScorePlusOne() {

        // ARRANGE
        TennisGame tennisGame = new TennisGame();
        int player1ScoreInit = tennisGame.getPlayer1().getScore();
        int player2ScoreInit = tennisGame.getPlayer2().getScore();

        // ACT
        tennisGame.updateScore();
        int player1ScoreEnd = tennisGame.getPlayer1().getScore();
        int player2ScoreEnd = tennisGame.getPlayer2().getScore();

        // ASSERT
        // check if at least one player won a point
        Assertions.assertTrue((player1ScoreEnd==player1ScoreInit+1) ||
                (player2ScoreEnd==player2ScoreInit+1));
    }

    @Test
    void testGameHasWinner() {

        // ARRANGE
        TennisGame tennisGame = new TennisGame();
        int player1ScoreInit = tennisGame.getPlayer1().getScore();
        int player2ScoreInit = tennisGame.getPlayer2().getScore();

        // ACT
        while(!tennisGame.hasWinner()) {
            tennisGame.updateScore();
        }

        // ASSERT
        // check if at least one player won the match
        Assertions.assertTrue((tennisGame.getPlayer1().isWinner(tennisGame.getPlayer2().getScore())) ||
                (tennisGame.getPlayer2().isWinner(tennisGame.getPlayer1().getScore())));
    }
}
