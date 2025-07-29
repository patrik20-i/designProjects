package ChessGame;

import ChessGame.Piece.*;

public class Cell {
    private final int row;
    private final int col;
    private Color color;
    private final boolean isOccupied;

    private Piece piece;

    public Cell(int i, int j){
        this.row = i;
        this.col = j;
        isOccupied = false;
        piece = null;
    }
    
    public void setColor(Color color){
        this.color = color;
    }

    public int getRow(){
        return row;
    }

    public int getCol(){
        return col;
    }

    public Color getColor(){
        return color;
    }

    public boolean isOccupied(){
        return isOccupied;
    }

    public Piece getPeice(){
        return piece;
    }

    public void setPiece(Piece piece){
        this.piece = piece;
    }


}
