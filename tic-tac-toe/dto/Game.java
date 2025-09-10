package dto;
import dto.Player;
import dto.Board;
import dto.GameStatus;
import java.util.Deque;
import java.util.ArrayDeque;

public class Game {
    private Deque<Player> players;
    private Board board;
    private GameStatus gameStatus;
    private Player winner;
    private Player currentPlayer;
    
    public Game(Deque<Player> players, Board board) {
        if (players.size() != 2) {
            throw new IllegalArgumentException("Game must have 2 players");
        }
        if (players.peek().getPieceType() == players.peekLast().getPieceType()) {
            throw new IllegalArgumentException("Players must have different piece types");
        }
        for(Player player : players) {
            if(player.getGame() != null) {
                throw new IllegalArgumentException("Player already in a game");
            }
            player.setGame(this);
        }
        this.players = players;
        this.board = board;
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winner = null;
        this.currentPlayer = this.players.poll();
    }

    public boolean makeMove(int row, int col) {
        if (gameStatus != GameStatus.IN_PROGRESS) {
            return false; // Game is over
        }
        
        // Convert 1-based to 0-based indexing
        int actualRow = row - 1;
        int actualCol = col - 1;
        
        boolean validMove = board.play(currentPlayer, actualRow, actualCol);
        if (!validMove) {
            return false; // Invalid move
        }
        
        // Valid move - print board
        board.printBoard();
        
        // Check for win
        boolean win = checkWin(currentPlayer);
        if (win) {
            winner = currentPlayer;
            gameStatus = GameStatus.COMPLETED;
        } else if (board.isBoardFull()) {
            gameStatus = GameStatus.DRAW;
        }
        
        if (gameStatus == GameStatus.COMPLETED) {
            for(Player player : players) {
                player.setGame(null);
            }
            System.out.println(winner.getName() + " won the game");
            return true;
        } else if (gameStatus == GameStatus.DRAW) {
            System.out.println("Game Over");
            return true;
        }
        
        // Switch players
        players.add(currentPlayer);
        currentPlayer = players.poll();
        
        return true;
    }
    public void resign() {
        if(gameStatus != GameStatus.IN_PROGRESS) {
            throw new IllegalArgumentException("Game is not in progress");
        }
        gameStatus = GameStatus.RESIGNED;
        players.poll();
        winner = players.peek();
    }
    public GameStatus getGameStatus() {
        return gameStatus;
    }
    
    public void printInitialBoard() {
        board.printBoard();
    }
    
    private boolean checkWin(Player player) {
        return board.checkWin(player);
    }
}

