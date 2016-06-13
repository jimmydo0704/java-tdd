package com.packtpublishing.tddjava.ch03tictactoe;

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
    public void whenPlacePieceOutsideXThrowRuntimeException() {
        expectedException.expect(RuntimeException.class);
        instance.placeX(3);
    }
}
