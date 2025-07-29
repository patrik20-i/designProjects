package ChessGame;

import ChessGame.Piece.Bishop;
import ChessGame.Piece.King;
import ChessGame.Piece.Knight;
import ChessGame.Piece.Pawn;
import ChessGame.Piece.Piece;
import ChessGame.Piece.Queen;
import ChessGame.Piece.Rook;

public class ChessBoard {
    private final Cell[][] board;

    public ChessBoard(){
        board = new Cell[8][8];

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                board[i][j] = new Cell(i,j);
            }
        }
        setupPieces();
    }

     private void setupPieces() {
        // Add pawns and main pieces for both sides
        for (int j = 0; j < 8; j++) {
            board[1][j].setPiece(new Pawn(Color.WHITE));
            board[6][j].setPiece(new Pawn(Color.BLACK));
        }

        // Initialize white pieces
        board[0][0].setPiece(new Rook(Color.WHITE));
        board[0][1].setPiece(new Knight(Color.WHITE));
        board[0][2].setPiece(new Bishop(Color.WHITE));
        board[0][3].setPiece(new Queen(Color.WHITE));
        board[0][4].setPiece(new King(Color.WHITE));
        board[0][5].setPiece(new Bishop(Color.WHITE));
        board[0][6].setPiece(new Knight(Color.WHITE));
        board[0][7].setPiece(new Rook(Color.WHITE));

        // Initialize black pieces
        board[7][0].setPiece(new Rook(Color.BLACK));
        board[7][1].setPiece(new Knight(Color.BLACK));
        board[7][2].setPiece(new Bishop(Color.BLACK));
        board[7][3].setPiece(new Queen(Color.BLACK));
        board[7][4].setPiece(new King(Color.BLACK));
        board[7][5].setPiece(new Bishop(Color.BLACK));
        board[7][6].setPiece(new Knight(Color.BLACK));
        board[7][7].setPiece(new Rook(Color.BLACK));
    }

    public void setPiece(int i, int j, Piece piece){
        board[i][j].setPiece(piece);
    }

    public Cell getCell(int row, int col){
        return board[row][col];
    }

    public Piece getPiece(int row, int col){
        return board[row][col].getPeice();
    }

    public synchronized void movePiece(Move move){
        Cell startCell = move.getStart();
        Cell endCell = move.getEnd();

        Piece piece = getPiece(startCell.getRow(), startCell.getCol());

        if(piece.isValidMove(startCell, endCell)){

        }
    }

    public boolean isCheckmate(Color color){
        return true;
    }

    public boolean isStalemate(Color color){
        return false;
    }

    
}
