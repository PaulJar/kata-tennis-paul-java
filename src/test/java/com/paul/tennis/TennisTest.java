package com.paul.tennis;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TennisTest {

    private TennisGame tennisGame;

    @BeforeEach
    public void setUpTennisGame() {
        TennisPlayer tennisPlayer1 = new TennisPlayer("Paul");
        TennisPlayer tennisPlayer2 = new TennisPlayer("Hervé");
        tennisGame = new TennisGame(tennisPlayer1, tennisPlayer2);
    }

    @Test
    void testTennisGameStatus() {

        // ARRANGE

        // ACT
        String tennisGameStatus = tennisGame.getStatus();

        // ASSERT
        // check if we return at least something
        Assertions.assertNotNull(tennisGameStatus);
    }

    @Test
    void testScorePlusOneAtStartGame() {

        // ARRANGE
        int player1ScoreInit = tennisGame.getPlayer1().getScore();
        int player2ScoreInit = tennisGame.getPlayer2().getScore();

        // ACT
        tennisGame.updateScore();
        int player1ScoreEnd = tennisGame.getPlayer1().getScore();
        int player2ScoreEnd = tennisGame.getPlayer2().getScore();

        // ASSERT
        // check if at least one player won a point at the start of the game
        Assertions.assertTrue((player1ScoreEnd==player1ScoreInit+1) ||
                (player2ScoreEnd==player2ScoreInit+1));
    }

    @Test
    void testGameHasWinner() {

        // ARRANGE

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
