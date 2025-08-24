package TicTacToe.state;

import ChessGame.InvalidMoveException;
import TicTacToe.*;

public class WinnerState implements GameState {

    @Override
    public void handleMove(Game game, Player player, int row, int col){
        throw new InvalidMoveException("match already over, GO HOME!");
    }
    
}
