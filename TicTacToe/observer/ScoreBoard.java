package TicTacToe.observer;

import java.util.concurrent.ConcurrentHashMap;
import java.util.Map;

import TicTacToe.Game;

public class ScoreBoard implements GameObserver {
    private final Map<String, Integer> scores;

    public ScoreBoard(){
        scores = new ConcurrentHashMap<>();
    }

    @Override
    public void update(Game game){
        if(game.getWinner()!=null){
            String winnerName = game.getWinner().getName();
            scores.put(winnerName, scores.getOrDefault(winnerName, 0)+1);
            System.out.printf("[Scoreboard] %s wins! Their new score is %d.%n", winnerName, scores.get(winnerName));
        }
    }

    public void printScores() {
        System.out.println("\n--- Overall Scoreboard ---");
        if (scores.isEmpty()) {
            System.out.println("No games with a winner have been played yet.");
            return;
        }
        scores.forEach((playerName, score) ->
                System.out.printf("Player: %-10s | Wins: %d%n", playerName, score)
        );
        System.out.println("--------------------------\n");
    }
}
