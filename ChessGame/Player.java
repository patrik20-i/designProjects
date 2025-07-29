package ChessGame;

public class Player {
    private final String playername;
    private final Color color;

    public Player(String name, Color color){
        this.playername = name;
        this.color = color;
    }

    public String getName(){
        return playername;
    }

    public Color getColor(){
        return color;
    }
    
}
