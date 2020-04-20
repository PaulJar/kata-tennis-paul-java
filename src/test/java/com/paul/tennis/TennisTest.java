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
    void testScore() {

        // ARRANGE
        int a = 1;
        int b = 3;
        TennisGame tennisGame = new TennisGame();

        // ACT
        int somme = tennisGame.getScore(a, b);

        // ASSERT
        Assertions.assertEquals(4, somme);
    }
}
