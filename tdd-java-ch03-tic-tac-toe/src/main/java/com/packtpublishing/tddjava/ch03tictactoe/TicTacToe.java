package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dvdat on 6/10/16.
 */
public class TicTacToe {
    public void placeX(int i) {
        if(i > 3)
            throw new RuntimeException("Place outside the board");
    }
}
