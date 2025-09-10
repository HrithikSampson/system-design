package dto;
import dto.Piece;
import dto.GameStatus;
import dto.Player;
import dto.PieceType;
import java.util.Deque;
import java.util.ArrayDeque;
public class Board {
    private Piece[][] board;
    private int size;
    
    public Board(int size) {
        this.size = size;
        this.board = new Piece[size][size];
    }

    public boolean play(Player player, int row, int col) {
        if (row < 0 || row >= size || col < 0 || col >= size) {
            return false; // Invalid position
        }
        
        if(board[row][col] != null) {
            return false; // Cell already occupied
        }
        
        board[row][col] = new Piece(player.getPieceType());
        return true;
    }
    
    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkWin(Player player) {
        // Check rows
        for(int i = 0; i < size; i++) {
            boolean win = true;
            for(int j = 0; j < size; j++) {
                if(board[i][j] == null || board[i][j].getPieceType() != player.getPieceType()) {
                    win = false;
                    break;
                }
            }
            if(win) {
                return true;
            }
        }
        
        // Check columns
        for(int j = 0; j < size; j++) {
            boolean win = true;
            for(int i = 0; i < size; i++) {
                if(board[i][j] == null || board[i][j].getPieceType() != player.getPieceType()) {
                    win = false;
                    break;
                }
            }
            if(win) {
                return true;
            }
        }
        
        // Check main diagonal
        boolean diagonalWin = true;
        for(int i = 0; i < size; i++) {
            if(board[i][i] == null || board[i][i].getPieceType() != player.getPieceType()) {
                diagonalWin = false;
                break;
            }
        }
        if(diagonalWin) {
            return true;
        }
        
        // Check anti-diagonal
        boolean antiDiagonalWin = true;
        for(int i = 0; i < size; i++) {
            if(board[i][size - i - 1] == null || board[i][size - i - 1].getPieceType() != player.getPieceType()) {
                antiDiagonalWin = false;
                break;
            }
        }
        if(antiDiagonalWin) {
            return true;
        }
        
        return false;
    }
    

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }
    
    public int getSize() {
        return size;
    }
    
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    System.out.print("-");
                } else {
                    System.out.print(board[i][j].getPieceType());
                }
                if (j < size - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}


