package dto;
import dto.PieceType;
public class Piece {
    private PieceType pieceType;
    public Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }
    public PieceType getPieceType() {
        return pieceType;
    }
}
