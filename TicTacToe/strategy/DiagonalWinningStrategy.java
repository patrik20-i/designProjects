package TicTacToe.strategy;

import TicTacToe.*;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player){
        return false;
    }
}