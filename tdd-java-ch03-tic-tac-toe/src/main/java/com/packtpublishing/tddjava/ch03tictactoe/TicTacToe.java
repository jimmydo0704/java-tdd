package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dvdat on 6/10/16.
 */
public class TicTacToe {
    private static char empty = ' ';
    public static char playX = 'X';
    public static char playO = 'O';

    private char [][] board = {{empty, empty, empty},
            {empty, empty, empty}, {empty, empty, empty}};

    private char lastPlayer = empty;

    public void play(int x, int y) {
        checkAxis(x, "X outside the board");

        checkAxis(y, "Y outside the board");

        setBox(x, y);
        lastPlayer = nextPlayer();
    }

    private void checkAxis(int axis, String errorMsg) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException(errorMsg);
    }

    private void setBox(int x, int y) {
        if(board[x - 1][y - 1] != empty)
            throw new RuntimeException("Already occurred");
        else
            board[x - 1][y - 1] = playX;
    }

    public char nextPlayer() {
        if(lastPlayer == playX)
            return playO;

        return playX;
    }
}
