package br.com.claucio.dev.tictactoe.core;

import br.com.claucio.dev.tictactoe.Constants;
import br.com.claucio.dev.tictactoe.ui.UI;

public class Game {

    Board board = new Board();
    Player[] players = new Player[Constants.SYMBOL_PLAYER.length];

    public void play(){

        UI.printGameTitle();
        board.print();
    }
}