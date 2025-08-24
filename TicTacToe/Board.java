package TicTacToe;

import ChessGame.InvalidMoveException;

public class Board {
    private final int size;
    private int movesCount;

    private final Cell[][] board;

    public Board(int size){
        this.size = size;
        movesCount = 0;
        this.board = new Cell[size][size];
        initializeBoard();
    }

    private void initializeBoard(){
        for(int i=0; i<this.size; i++){
            for(int j=0; j<this.size; j++){
                board[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return size;
    }

    public int getMovesCount() {
        return movesCount;
    }

    public void incrementMovesCount() {
        this.movesCount++;
    }

    public Cell getCell(int row, int col) {
        if (row >= 0 && row < size && col >= 0 && col < size) {
            return board[row][col];
        }
        return null;
    }

    public boolean isFull(){
        return movesCount == size*size;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public boolean placeSymbol(int row, int col, Symbol symbol){
        if(row<0 || row>=size || col<0 || col>=size){
            throw new InvalidMoveException("position out of bounds");
        }
        if(board[row][col].getSymbol()!=Symbol.Empty){
            throw new InvalidMoveException("Cell is already used");
        }

        board[row][col].setSymbol(symbol);
        movesCount++;
        return true;
    }

    
}
