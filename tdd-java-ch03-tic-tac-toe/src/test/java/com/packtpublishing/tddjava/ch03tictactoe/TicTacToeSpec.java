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

    @Test
    public void givenFirstPlayerThenNextPlayerX() {
        Assert.assertEquals(TicTacToe.playX, instance.nextPlayer());
    }

    @Test
    public void givenPlayerXThenNextPlayerO() {
        instance.play(1, 1);
        Assert.assertEquals(TicTacToe.playO, instance.nextPlayer());
    }

    @Test
    public void givenLastPlayerOThenNextPlayerX() {
        instance.play(1, 1);
        instance.play(1, 2);
        Assert.assertEquals(TicTacToe.playX, instance.nextPlayer());
    }
}
