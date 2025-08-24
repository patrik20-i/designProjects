package TicTacToe.strategy;

import TicTacToe.*;

public interface WinningStrategy {
    boolean checkWinner(Board board, Player player);    
}
