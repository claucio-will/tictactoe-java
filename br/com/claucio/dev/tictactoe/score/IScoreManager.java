package br.com.claucio.dev.tictactoe.score;

import br.com.claucio.dev.tictactoe.core.Player;

public interface IScoreManager {
    
    public Integer getScore(Player player);

    public void saveScore(Player player);
}
