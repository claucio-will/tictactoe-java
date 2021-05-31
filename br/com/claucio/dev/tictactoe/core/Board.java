package br.com.claucio.dev.tictactoe.core;

import br.com.claucio.dev.tictactoe.Constants;
import br.com.claucio.dev.tictactoe.ui.UI;

public class Board {

    public char[][] matrix;


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

    public boolean play(Player player, Move move) {
      int row = move.row;
      int col = move.column;

      matrix[row][col] = player.symbol;
      //TODO: checar se o jogador ganhou
      return  false;

    }
}
