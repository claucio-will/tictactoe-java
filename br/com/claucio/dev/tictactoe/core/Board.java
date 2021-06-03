package br.com.claucio.dev.tictactoe.core;

import br.com.claucio.dev.tictactoe.Constants;
import br.com.claucio.dev.tictactoe.ui.UI;

public class Board {

    private char[][] matrix;

    public char[][] getMatrix() {
        return matrix;
    }

    Board() {
        matrix = new char[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
        clear();
    }

    public void clear() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = ' ';
            }
        }

    }

    public void print() {
        UI.printNewLine();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                UI.printTextWithNoNewLine(String.valueOf(matrix[row][col]));
                if (col < matrix[row].length - 1) {
                    UI.printTextWithNoNewLine(" | ");

                }
            }
            UI.printNewLine();
            if (row < matrix.length - 1) {
                UI.printText("---------");

            }
        }
    }

    public boolean isFull() {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == ' ') ;
                return false;

            }
            return true;
        }

        return false;
    }

    public boolean play(Player player, Move move) throws InvalidMoveException {
        int row = move.getRow();
        int col = move.getColumn();

        if (row < 0 || col < 0 || row >= Constants.BOARD_SIZE || col >= Constants.BOARD_SIZE){
            throw new InvalidMoveException("O intervalo da jogada é inválido");
        }

        if (matrix[row][col] != ' '){
            throw new InvalidMoveException("Essa jogada já foi realizada");
        }

        matrix[row][col] = player.getSymbol();

        return checkRows(player) || checkCols(player) || checkDiagonal1(player) || checkDiagonal2(player);

    }

    private boolean checkRows(Player player) {
        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            if (checkRow(row, player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkRow(int row, Player player) {
        char symbol = player.getSymbol();

        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            if (matrix[row][col] != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCols(Player player) {
        for (int col = 0; col < Constants.BOARD_SIZE; col++) {
            if (checkCol(col, player)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkCol(int col, Player player) {
        char symbol = player.getSymbol();

        for (int row = 0; row < Constants.BOARD_SIZE; row++) {
            if (matrix[row][col] != symbol) {
                return false;
            }
        }

        return true;
    }

    private boolean checkDiagonal1(Player player) {
        char symbol = player.getSymbol();
        for (int i = 0; i < Constants.BOARD_SIZE; i++) {
            if (matrix[i][i] != symbol) {
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal2(Player player) {
        char symbol = player.getSymbol();
        int lastLine = Constants.BOARD_SIZE - 1;

        for (int row = lastLine, col = 0; row >= 0; row--, col++) {
            if (matrix[row][col] != symbol) {
                return false;
            }
        }
        return true;
    }


}
