package tic_tac_toe;

import lombok.Getter;
import lombok.Setter;
import tic_tac_toe.constants.SYMBOL;

import java.util.ArrayList;

@Getter
@Setter
public class Board {
    private int size;
    private SYMBOL[][] board;

    public Board(int size) {
        this.size = size;
        board = new SYMBOL[size][size];

    }

    public void markMove(int cell, Player player) {
        int row = (cell - 1) / size;
        int col = (cell - 1) % size;
        if (isCellAvailable(cell)) {
            board[row][col] = player.getSymbol();
        } else {
            throw new RuntimeException("cell not available.");
        }
        printBoard();
    }

    public boolean isCellAvailable(int cell) {
        int row = (cell - 1) / size;
        int col = (cell - 1) % size;
        return board[row][col] == null;
    }

    public boolean isWinner(Player player, int cell) {
        int row = (cell - 1) / size;
        int col = (cell - 1) % size;

        // check row
        int symbolCount = 0;
        for (int i = 0; i < size; i++) {
            if (board[row][i] == player.getSymbol()) symbolCount++;
        }
        if (symbolCount == size) return true;

        // check column
        symbolCount = 0;
        for (int i = 0; i < size; i++) {
            if (board[i][col] == player.getSymbol()) symbolCount++;
        }
        if (symbolCount == size) return true;

        // check diagonals if applicable
        symbolCount = 0;
        if (row == col) {
            for (int i = 0; i < size; i++) {
                if (board[i][i] == player.getSymbol()) symbolCount++;
            }
            if (symbolCount == size) return true;
        }

        symbolCount = 0;
        if (Math.abs(row - col) == size - 1) {
            for (int tempRow = 0; tempRow < size; tempRow++) {
                if (board[tempRow][size - tempRow - 1] == player.getSymbol()) symbolCount++;
            }
            if (symbolCount == size) return true;;
        }

        return false;
    }


    public void printBoard() {

        System.out.println("----------------------------------------------");
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (board[row][col] == null) {
                    System.out.print('_');
                } else {
                    System.out.print(board[row][col]);
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("----------------------------------------------");
    }
}
