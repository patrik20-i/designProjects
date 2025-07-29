package ChessGame.Piece;

import ChessGame.*;

public class King implements Piece {
    private final Color color;

    public King(Color color){
        this.color = color;

    }

    public boolean isValidMove(Cell start, Cell end){
        int a = start.getRow();
        int b = start.getCol();

        int c = end.getRow();
        int d = end.getCol();
        
        
        if(a+b==c+d){
            return true;
        }

        return false;
        
    }

    public Color getColor(){
        return color;
    }
}
