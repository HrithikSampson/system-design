
import dto.Game;
import dto.Player;
import dto.Board;
import dto.GameStatus;
import dto.PieceType;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read player names
        String line1 = scanner.nextLine().trim();
        String line2 = scanner.nextLine().trim();
        
        // Parse player information
        String[] parts1 = line1.split(" ");
        String[] parts2 = line2.split(" ");
        
        if (parts1.length != 2 || parts2.length != 2) {
            System.out.println("Invalid input format");
            return;
        }
        
        PieceType pieceType1 = PieceType.valueOf(parts1[0]);
        String playerName1 = parts1[1];
        
        PieceType pieceType2 = PieceType.valueOf(parts2[0]);
        String playerName2 = parts2[1];
        
        // Create players
        Deque<Player> players = new ArrayDeque<>();
        players.add(new Player(pieceType1, playerName1));
        players.add(new Player(pieceType2, playerName2));
        
        // Create board and game
        Board board = new Board(3);
        Game game = new Game(players, board);
        
        // Print initial board
        game.printInitialBoard();
        
        // Game loop
        String input;
        while (scanner.hasNextLine()) {
            input = scanner.nextLine().trim();
            
            if (input.equals("exit")) {
                break;
            }
            
            // Parse move
            String[] moveParts = input.split(" ");
            if (moveParts.length != 2) {
                System.out.println("Invalid Move");
                continue;
            }
            
            try {
                int row = Integer.parseInt(moveParts[0]);
                int col = Integer.parseInt(moveParts[1]);
                
                // Check if game is still in progress
                if (game.getGameStatus() != GameStatus.IN_PROGRESS) {
                    continue; // Ignore moves after game is over
                }
                
                // Make move
                boolean validMove = game.makeMove(row, col);
                
                if (!validMove) {
                    System.out.println("Invalid Move");
                }
                
            } catch (NumberFormatException e) {
                System.out.println("Invalid Move");
            }
        }
        
        scanner.close();
    }
}
