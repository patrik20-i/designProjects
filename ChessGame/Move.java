package ChessGame;

import ChessGame.Piece.*;

public class Move {
    private final Cell startCell;
    private final Cell endCell;
    ChessBoard board;
    private Piece piece;
    
    public Move(Cell start, Cell end){
        this.startCell = start;
        this.endCell = end;
    }

    public boolean isValidMove(){
        return piece.isValidMove(startCell, endCell);
    }

    public Cell getStart(){
        return startCell;
    }

    public Cell getEnd(){
        return endCell;
    }
}
