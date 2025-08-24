package TicTacToe.strategy;

import TicTacToe.*;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player){
        return false;
    }
}
