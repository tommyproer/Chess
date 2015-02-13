import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Chess extends JComponent{

	Pawn board [][];		// Will store the pieces in the array
	
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
		
		//Place all the images of the chess pieces
	    Image whitePawn = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_pawn.jpg");
	    for(int i= 0; i < 8; i++){
	    	g.drawImage(whitePawn, 100 + 80*i, 530, this);
	    }
	    Image whiteRook = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_rook.jpg");
	    g.drawImage(whiteRook, 100, 610, this);
	    g.drawImage(whiteRook, 660, 610, this);
	    Image whiteKnight = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_knight.jpg");
	    g.drawImage(whiteKnight, 180, 610, this);
	    g.drawImage(whiteKnight, 580, 610, this);
	    Image whiteBishop = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_bishop.jpg");
	    g.drawImage(whiteBishop, 260, 610, this);
	    g.drawImage(whiteBishop, 500, 610, this);
	    Image whiteQueen = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_queen.jpg");
	    g.drawImage(whiteQueen, 340, 610, this);
	    Image whiteKing = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_king.jpg");
	    g.drawImage(whiteKing, 420, 610, this);
	    
	    // The black pieces
	    Image blackPawn = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_pawn.jpg");
	    for(int i= 0; i < 8; i++){
	    	g.drawImage(blackPawn, 100 + 80*i, 130, this);
	    }
	    Image blackRook = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_rook.jpg");
	    g.drawImage(blackRook, 100, 50, this);
	    g.drawImage(blackRook, 660, 50, this);
	    Image blackKnight = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_knight.jpg");
	    g.drawImage(blackKnight, 180, 50, this);
	    g.drawImage(blackKnight, 580, 50, this);
	    Image blackBishop = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_bishop.jpg");
	    g.drawImage(blackBishop, 260, 50, this);
	    g.drawImage(blackBishop, 500, 50, this);
	    Image blackQueen = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_queen.jpg");
	    g.drawImage(blackQueen, 340, 50, this);
	    Image blackKing = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_king.jpg");
	    g.drawImage(blackKing, 420, 50, this);
		
    }
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 900, 800);
	    window.getContentPane().add(new Chess());
	    window.setVisible(true);
	}

}
