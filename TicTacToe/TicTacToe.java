package TicTacToe;

import TicTacToe.observer.ScoreBoard;

public class TicTacToe {
    private static volatile TicTacToe instance;
    private Game game;
    private final ScoreBoard scoreBoard;

    private TicTacToe(){
        scoreBoard = new ScoreBoard();
    }

    public static TicTacToe getInstance(){
        if(instance == null){
            synchronized(TicTacToe.class){
                if(instance == null){
                    instance = new TicTacToe();
                }
            }
        }

        return instance;
    }

    public void createGame(Player player1, Player player2) {
        this.game = new Game(player1, player2);
        // Register the scoreboard as an observer for this new game

        System.out.printf("Game started between %s (X) and %s (O).%n", player1.getName(), player2.getName());
    }

    public void makeMove(Player player, int row, int col) {
        if (game == null) {
            System.out.println("No game in progress. Please create a game first.");
            return;
        }
        try {
            System.out.printf("%s plays at (%d, %d)%n", player.getName(), row, col);
            game.makeMove(player, row, col);
            System.out.println("Game Status: " + game.getStatus());
            if (game.getWinner() != null) {
                System.out.println("Winner: " + game.getWinner().getName());
            }
        } catch (InvalidMoveException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

  

    public void printScoreBoard() {
        scoreBoard.printScores();
    }
}
