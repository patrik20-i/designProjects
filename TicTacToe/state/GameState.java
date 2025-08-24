package TicTacToe.state;

import TicTacToe.Game;
import TicTacToe.Player;


public interface GameState {
    void handleMove(Game game, Player player, int row, int col);
}
