package com.packtpublishing.tddjava.ch03tictactoe;

/**
 * Created by dvdat on 6/10/16.
 */
public class TicTacToe {
    public static final String NO_WINNER = "No winner";
    public static final String X_WINNER = "X is a winner";
    public static final String O_WINNER = "O is a winner";
    public static final String DRAW = "Draw";
    private static char empty = '\0';
    public static char playX = 'X';
    public static char playO = 'O';

    private char [][] board = {{empty, empty, empty},
            {empty, empty, empty}, {empty, empty, empty}};

    private char lastPlayer = empty;
    private int SIZE = 3;

    public String play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        lastPlayer = nextPlayer();
        setBox(x, y);
        if (isWin())
            return lastPlayer == playX ? X_WINNER : O_WINNER;
        else if(isDraw())
            return DRAW;
        return NO_WINNER;
    }

    private boolean isDraw() {
        for(int x = 0; x < SIZE; x++) {
            for(int y = 0; y < SIZE; y++) {
                if(board[x][y] == empty)
                    return false;
            }
        }
        return true;
    }

    private boolean isWin() {
        int playTotal = lastPlayer * SIZE;
        int diagonal1 = empty;
        int diagonal2 = empty;
        for(int index = 0; index < SIZE; index++) {
            diagonal1 += board[index][index];
            diagonal2 += board[SIZE - index - 1][index];
            if((board[0][index] + board[1][index] + board[2][index]
                    == playTotal) ||
            (board[index][0] + board[index][1] + board[index][2] ==
                    playTotal)){
                return true;
            }

        }
        if(diagonal1 == playTotal || diagonal2 == playTotal)
            return true;
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
