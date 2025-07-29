package ChessGame.Piece;

import ChessGame.Color;

import ChessGame.Cell;

public interface Piece {
    public boolean isValidMove(Cell start, Cell end);
    public Color getColor();
}
