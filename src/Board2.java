import java.awt.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.image.*;
import java.io.*;

import javax.imageio.*;

// Prints out the entire board
public class Board2 extends JComponent {
	
	private int i = 1;
	public Graphics g;
	private static Scanner scan = new Scanner(System.in);
	Piece[][] board = new Piece[8][8];		// Will store the pieces in the array
	
	// Initialize all the piece images into variables
	Image blank = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\blank.jpg");
	Image whitePawn = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_pawn.jpg");
	Image whiteRook = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_rook.jpg");
	Image whiteKnight = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_knight.jpg");
	Image whiteBishop = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_bishop.jpg");
    Image whiteQueen = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_queen.jpg");
    Image blackPawn = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_pawn.jpg");
    Image whiteKing = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\white_king.jpg");
    Image blackRook = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_rook.jpg");
    Image blackKnight = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_knight.jpg");
    Image blackBishop = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_bishop.jpg");
    Image blackKing = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_king.jpg");
    Image blackQueen = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\black_queen.jpg");
	
	public Board2(){
		
		
	}
	
	private void mainLoop(){		
	}
	
	private static String getInput()
	{
		System.out.println("> ");
		return scan.nextLine().toLowerCase();
	}
	
	private void move(Graphics g){
		
		g.drawImage(blank, 260, 50, this);
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
		
		//Place all the images of the chess pieces
	    for(int i= 0; i < 8; i++){
	    	g.drawImage(whitePawn, 100 + 80*i, 530, this);
	    }
	    
	    g.drawImage(whiteRook, 100, 610, this);
	    g.drawImage(whiteRook, 660, 610, this);
	    
	    g.drawImage(whiteKnight, 180, 610, this);
	    g.drawImage(whiteKnight, 580, 610, this);
	    
	    g.drawImage(whiteBishop, 260, 610, this);
	    g.drawImage(whiteBishop, 500, 610, this);
	    
	    g.drawImage(whiteQueen, 340, 610, this);
	    g.drawImage(whiteKing, 420, 610, this);
	    
	    // The black pieces
	    
	    for(int i= 0; i < 8; i++){
	    	g.drawImage(blackPawn, 100 + 80*i, 130, this);
	    }
	    
	    g.drawImage(blackRook, 100, 50, this);
	    g.drawImage(blackRook, 660, 50, this);
	    
	    g.drawImage(blackKnight, 180, 50, this);
	    g.drawImage(blackKnight, 580, 50, this);
	    
	    g.drawImage(blackBishop, 260, 50, this);
	    g.drawImage(blackBishop, 500, 50, this);
	    
	    g.drawImage(blackQueen, 340, 50, this);
	    
	    g.drawImage(blackKing, 420, 50, this);
	    
	   
	    g.drawImage(blank, 260, 50, this);
	    
    }
}
