package br.com.claucio.dev.tictactoe.core;

public class Move {
    private int column;
    private int row;

    public Move(String moveStr) {
     String[] token = moveStr.split(",");
     this.row = Integer.parseInt(token[0]);
     this.column = Integer.parseInt(token[1]);

    }

    public int getColumn() {
        return column;
    }


    public int getRow() {
        return row;
    }


}
