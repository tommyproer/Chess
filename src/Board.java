import java.awt.*;
import javax.swing.*;

// Prints out the entire board
public class Board extends JComponent {
	
	public Graphics g;
	Piece[][] board = new Piece[8][8];		// Will store the pieces in the array
	
	// Initialize all the piece images into variables
	String baseDir = "/home/tommy/workspace/Chess/resources/";
	Image blank = Toolkit.getDefaultToolkit().getImage(baseDir + "blank.jpg");
	Image whitePawn = Toolkit.getDefaultToolkit().getImage(baseDir + "white_pawn.jpg");
	Image whiteRook = Toolkit.getDefaultToolkit().getImage(baseDir + "white_rook.jpg");
	Image whiteKnight = Toolkit.getDefaultToolkit().getImage(baseDir + "white_knight.jpg");
	Image whiteBishop = Toolkit.getDefaultToolkit().getImage(baseDir + "white_bishop.jpg");
	Image whiteQueen = Toolkit.getDefaultToolkit().getImage(baseDir + "white_queen.jpg");
    	Image blackPawn = Toolkit.getDefaultToolkit().getImage(baseDir + "black_pawn.jpg");
    	Image whiteKing = Toolkit.getDefaultToolkit().getImage(baseDir + "white_king.jpg");
    	Image blackRook = Toolkit.getDefaultToolkit().getImage(baseDir + "black_rook.jpg");
    	Image blackKnight = Toolkit.getDefaultToolkit().getImage(baseDir + "black_knight.jpg");
    	Image blackBishop = Toolkit.getDefaultToolkit().getImage(baseDir + "black_bishop.jpg");
    	Image blackKing = Toolkit.getDefaultToolkit().getImage(baseDir + "black_king.jpg");
    	Image blackQueen = Toolkit.getDefaultToolkit().getImage(baseDir + "black_queen.jpg");
    
	public Board(Piece[][] b){
		this.board = b;
	}
	
	public void editBoard(Piece[][] b){
		this.board = b;
	}

	public void paint(Graphics g) {
	    
		// Initialize the board squares
		int x = 80;
		int y = 80;
		for(int i = 0; i < 9; i++){
			g.drawLine(100, 50 + x*i, 100 + y*8, 50 + x*i);
		}
		for(int i = 0; i < 9; i++){
			g.drawLine(100 + y*i, 50, 100 + y*i, 50 + 8*x);
		}
		// Initialize board positions
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\a.jpg"), 100, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\b.jpg"), 180, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\c.jpg"), 260, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\d.jpg"), 340, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\e.jpg"), 420, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\f.jpg"), 500, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\g.jpg"), 580, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\h.jpg"), 660, 691, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\8.jpg"), 20, 50, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\7.jpg"), 20, 130, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\6.jpg"), 20, 210, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\5.jpg"), 20, 290, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\4.jpg"), 20, 370, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\3.jpg"), 20, 450, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\2.jpg"), 20, 530, this);
		g.drawImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\1.jpg"), 20, 610, this);
		
		// Place all the images of the chess pieces
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 8; j++){
				if(board[i][j] instanceof Pawn){
					if(board[i][j].getColor()){
						g.drawImage(whitePawn, 100 + 80*i, 50 + 80*j, this);
					}else{
						g.drawImage(blackPawn, 100 + 80*i, 50 + 80*j, this);
					}
				}else if(board[i][j] instanceof Rook){
					if(board[i][j].getColor()){
						g.drawImage(whiteRook, 100 + 80*i, 50 + 80*j, this);
					}else{
						g.drawImage(blackRook, 100 + 80*i, 50 + 80*j, this);
					}
				}else if(board[i][j] instanceof Knight){
					if(board[i][j].getColor()){
						g.drawImage(whiteKnight, 100 + 80*i, 50 + 80*j, this);
					}else{
						g.drawImage(blackKnight, 100 + 80*i, 50 + 80*j, this);
					}
				}else if(board[i][j] instanceof Bishop){
					if(board[i][j].getColor()){
						g.drawImage(whiteBishop, 100 + 80*i, 50 + 80*j, this);
					}else{
						g.drawImage(blackBishop, 100 + 80*i, 50 + 80*j, this);
					}
				}else if(board[i][j] instanceof Queen){
					if(board[i][j].getColor()){
						g.drawImage(whiteQueen, 100 + 80*i, 50 + 80*j, this);
					}else{
						g.drawImage(blackQueen, 100 + 80*i, 50 + 80*j, this);
					}
				}else if(board[i][j] instanceof King){
					if(board[i][j].getColor()){
						g.drawImage(whiteKing, 100 + 80*i, 50 + 80*j, this);
					}else{
						g.drawImage(blackKing, 100 + 80*i, 50 + 80*j, this);
					}
				}
			}
		}
    }
}
