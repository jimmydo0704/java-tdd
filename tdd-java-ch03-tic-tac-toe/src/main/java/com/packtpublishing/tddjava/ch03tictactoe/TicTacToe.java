package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dvdat on 6/10/16.
 */
public class TicTacToe {
    public static final String NO_WINNER = "No winner";
    public static final String X_WINNER = "X is a winner";
    public static final String O_WINNER = "O is a winner";
    private static char empty = ' ';
    public static char playX = 'X';
    public static char playO = 'O';

    private char [][] board = {{empty, empty, empty},
            {empty, empty, empty}, {empty, empty, empty}};

    private char lastPlayer = empty;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWin())
            return lastPlayer == playX ? X_WINNER : O_WINNER;
        return NO_WINNER;
    }

    private boolean isWin() {
        for(int index = 0; index < 3; index++) {
            if((board[0][index] == lastPlayer &&
                    board[1][index] == lastPlayer &&
                    board[2][index] == lastPlayer) ||
            (board[index][0] == lastPlayer &&
                    board[index][1] == lastPlayer &&
                    board[index][2] == lastPlayer)){
                return true;
            }
        }
        return false;
    }

    private void checkAxis(int axis) {
        if (axis < 1 || axis > 3)
            throw new RuntimeException("Outside the board");
    }

    private void setBox(int x, int y) {
        if(board[x - 1][y - 1] != empty)
            throw new RuntimeException("Already occurred");
        else
            board[x - 1][y - 1] = lastPlayer;
    }

    public char nextPlayer() {
        if(lastPlayer == playX)
            return playO;

        return playX;
    }
}
