package TicTacToe.observer;

import TicTacToe.Game;

import java.util.ArrayList;
import java.util.List;

public abstract class GameSubject {
    private final List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public abstract void notifyObservers();
}