package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dvdat on 6/10/16.
 */
public class TicTacToe {
    public static final String NO_WINNER = "No winner";
    private static char empty = ' ';
    public static char playX = 'X';
    public static char playO = 'O';

    private char [][] board = {{empty, empty, empty},
            {empty, empty, empty}, {empty, empty, empty}};

    private char lastPlayer = empty;

    public String play(int x, int y) {
        checkAxis(x);

        checkAxis(y);

        setBox(x, y);
        lastPlayer = nextPlayer();
        return NO_WINNER;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException("Outside the board");
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
