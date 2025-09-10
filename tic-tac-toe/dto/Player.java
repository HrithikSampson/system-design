package dto;
import dto.PieceType;
import dto.Game;
public class Player {
    private PieceType pieceType;
    private String name;
    private Game game;
    public Player(PieceType pieceType, String name) {
        this.pieceType = pieceType;
        this.name = name;
        this.game = null;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public Game getGame() {
        return game;
    }
    public PieceType getPieceType() {
        return pieceType;
    }
    public String getName() {
        return name;
    }
}
