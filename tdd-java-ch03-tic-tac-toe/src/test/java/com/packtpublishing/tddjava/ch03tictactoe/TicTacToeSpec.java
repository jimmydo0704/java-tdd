package com.packtpublishing.tddjava.ch03tictactoe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by dvdat on 6/10/16.
 */
public class TicTacToeSpec {
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private TicTacToe instance;

    @Before
    public void before() {
        instance = new TicTacToe();
    }

    // Req 1
    @Test
    public void whenXOutsideThenRuntimeException() {
        expectedException.expect(RuntimeException.class);
        instance.play(4, 1);
    }

    @Test
    public void whenYOutsideThenRuntimeException() {
        expectedException.expect(RuntimeException.class);
        instance.play(1, 5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        instance.play(1, 2);
        expectedException.expect(RuntimeException.class);
        instance.play(1, 2);
    }

    // Req 2
    @Test
    public void givenFirstPlayerThenNextPlayerX() {
        Assert.assertEquals(TicTacToe.playX, instance.nextPlayer());
    }

    @Test
    public void givenPlayerXThenNextPlayerO() {
        instance.play(1, 1);
        Assert.assertEquals(TicTacToe.playO, instance.nextPlayer());
    }

    // Req 3
    @Test
    public void whenPlayNoWinner() {
        String actual = instance.play(1, 1);
        Assert.assertEquals(actual, TicTacToe.NO_WINNER);
    }

    @Test
    public void whenPlayAndWholeHorizontalLineThenWinner() {
        instance.play(1, 1); // X
        instance.play(1, 2); // O
        instance.play(2, 1); // X
        instance.play(2, 2); // O
        String actual = instance.play(3, 1);
        Assert.assertEquals(TicTacToe.X_WINNER, actual);
    }

    @Test
    public void whenPlayAndWholeVerticalLineThenWinner() {
        instance.play(1, 1);
        instance.play(2, 1);
        instance.play(1, 2);
        instance.play(2, 2);
        String actual = instance.play(1, 3);
        Assert.assertEquals(TicTacToe.X_WINNER, actual);
    }
}
