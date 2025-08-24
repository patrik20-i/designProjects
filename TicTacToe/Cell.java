package TicTacToe;

public class Cell {
    private Symbol symbol;

    public Cell(){
        this.symbol = Symbol.Empty;
    }

    public Symbol getSymbol(){
        return this.symbol;
    }

    public void setSymbol(Symbol symbol){
        this.symbol = symbol;
    }
    
}
