package TicTacToe;

import java.util.List;

import TicTacToe.state.*;
import TicTacToe.strategy.*;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;
    private Player winnerPlayer;

    private GameStatus status;
    private GameState gameState;

    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2){
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;

        this.currentPlayer = player1;
        this.winnerPlayer = null;

        this.status = GameStatus.IN_PROGRESS;
        this.gameState = new InProgressState();

        winningStrategies = List.of(
            new RowWinningStrategy(),
            new ColumnWinningStrategy(),
            new DiagonalWinningStrategy()
        );
    }

    public void makeMove(Player player, int row, int col){
        gameState.handleMove(this, player, row, col);
    }

    public boolean checkWinner(Player player){
        for(WinningStrategy strategy: winningStrategies){
            if(strategy.checkWinner(board, player)){
                return true;
            }
        }
        return false;
    }

    public void switchPlayer(){
        this.currentPlayer = (currentPlayer == player1)? player2:player1;
    }

    public Board getBoard() { return board; }
    public Player getCurrentPlayer() { return currentPlayer; }
    public Player getWinner() { return winnerPlayer; }
    public void setWinner(Player winner) { this.winnerPlayer = winner; }
    public GameStatus getStatus() { return status; }
    public void setState(GameState state) { this.gameState = state; }
    public void setStatus(GameStatus status) {
        this.status = status;
        // Notify observers when the status changes to a finished state
        if (status != GameStatus.IN_PROGRESS) {
            // notifyObservers();
        }
    }


}
