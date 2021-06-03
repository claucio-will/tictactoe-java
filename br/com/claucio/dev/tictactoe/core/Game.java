package br.com.claucio.dev.tictactoe.core;

import br.com.claucio.dev.tictactoe.Constants;
import br.com.claucio.dev.tictactoe.ui.UI;

public class Game {

    private Board board = new Board();
    private Player[] players = new Player[Constants.SYMBOL_PLAYER.length];
    private int currentPlayerIndex = -1;

    public void play() {
        UI.printGameTitle();
        for (int i = 0; i < players.length; i++) {
            players[i] = createPlayer(i);
        }

        boolean gameEnded = false;
        Player currentPlayer = nextPlayer();
        Player winner = null;
        boolean sequenceFound;

        while (!gameEnded) {
            board.print();

            try {
                sequenceFound = currentPlayer.play();

            } catch (InvalidMoveException e) {
                UI.printText("Erro: " + e.getMessage());
                continue;
            }

            if (sequenceFound) {
                gameEnded = true;
                winner = currentPlayer;

            } else if (board.isFull()) {
                gameEnded = true;
            }
            currentPlayer = nextPlayer();
        }
        if (winner == null) {
            UI.printText("Deu velha");
        } else {
            UI.printText("O jogador " + winner.getName() + " Venceu o jogo");
        }

        board.print();
        UI.printText("Fim do jogo");
    }

    private Player createPlayer(int index) {
        String name = UI.readInput("Jogador " + (index + 1) + " =>");
        char symbol = Constants.SYMBOL_PLAYER[index];
        Player player = new Player(name, board, symbol);

        UI.printText("O Jogador " + name + " vai usar o simbolo " + symbol);

        return player;
    }


    private Player nextPlayer() {

        currentPlayerIndex++;

        if (currentPlayerIndex >= players.length) {
            currentPlayerIndex = 0;
        }

        return players[currentPlayerIndex];
    }
}