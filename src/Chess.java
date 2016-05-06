package src;

import java.util.Scanner;
import java.util.Map;
import com.google.common.collect.ImmutableMap;

import javax.swing.JFrame;

import config.Config;

//TODO: Add ANT to automate building
//TODO: Make code a lot clearer and separate out calls even more, add logic of board in separate class or in config
//TODO: Also make a Builder for pieces
public class Chess{

	private final Scanner scan = new Scanner(System.in);
	private final Piece[][] pieceMap = new Piece[Config.BOARD_SIZE][Config.BOARD_SIZE];
	private final Board board = new Board(pieceMap);
	
	private boolean whiteMove;
	private int sourceX,sourceY,targetX,targetY;
	private static Map<Character, Integer> charPositionToInt = new ImmutableMap.Builder<Character, Integer>()
		.put('a', 0)
		.put('b', 1)
		.put('c', 2)
		.put('d', 3)
		.put('e', 4)
		.put('f', 5)
		.put('g', 6)
		.put('h', 7)
		.build();
	
	private String getInput() {
		return scan.nextLine();
	}
	
	private int getIntFromCharPosition(char charPosition){
		try{
			return charPositionToInt.get(Character.toLowerCase(charPosition));
		}catch(NullPointerException e){
			System.out.println(String.format("Invalid position %c.", charPosition));
		}
		return -1;
	}
	
	// Checks if the first input is valid
	private boolean checkInput(String input, boolean whiteMove){
		if(input.length() != 2){
			System.out.println("Invalid input, inappropiate length.");
			return false;
		}
		if(getIntFromCharPosition(input.charAt(0)) == -1){
			return false;
		}
		if(Character.getNumericValue(input.charAt(1)) > 8 || Character.getNumericValue(input.charAt(1)) < 1){
			System.out.println(String.format("Invalid positon %d", input.charAt(1)));
			return false;
		}
		if(pieceMap[getIntFromCharPosition(input.charAt(0))][8 - Character.getNumericValue(input.charAt(1))] == null){
			System.out.println("No piece located at " + input.charAt(0) + input.charAt(1));
			return false;
		}
		if(pieceMap[getIntFromCharPosition(input.charAt(0))][8 - Character.getNumericValue(input.charAt(1))].getColor() != whiteMove){
			System.out.print("Please select a ");
			if(whiteMove)
				System.out.println("white piece to move");
			else
				System.out.println("black piece to move");
			return false;
		}
		return true;
	}
	
	// Checks if the second input is valid
	private boolean checkInput2(String input){
		if(input.length() != 2){
			System.out.println("Invalid position(length of position is not 2)");
			return false;
		}
		if(getIntFromCharPosition(input.charAt(0)) == -1){
			System.out.println("Invalid position");
			return false;
		}
		if(Character.getNumericValue(input.charAt(1)) > 8 || Character.getNumericValue(input.charAt(1)) < 1){
			System.out.println("Invalid positon");
			return false;
		}
		return true;
	}
	
	// The user will enter in the first input, the position of the piece they want to move
	private void getPieceSource(){
		// Check if first input is valid
		System.out.print("Type the position of the piece to move");
    		if(whiteMove){
    			System.out.println("(white to move): ");
		}else{
    			System.out.println("(black to move): ");
		}
    		String input = getInput();
    		while(!checkInput(input, whiteMove)){
	    		input = getInput();
    		}
    	
    		// Convert position to coordinates in array
    		sourceX = getIntFromCharPosition(input.charAt(0));
    		targetX = 8 - Character.getNumericValue(input.charAt(1));
	}
	
	// The user will enter in the second input, the position of where they want the piece to go to
	private void getPieceTarget(){
		// Check if second input is valid
		System.out.print("Type the position you want to move the piece to: ");
    		String input2 = getInput();
    		while(!checkInput2(input2)){
	    		input2 = getInput();
    		}
    	
    		// Convert position to coordinates in array
    		sourceY = getIntFromCharPosition(input2.charAt(0));
    		targetY = 8 - Character.getNumericValue(input2.charAt(1));
	}

	public void Chess(){
		init();	
	    
	    			
	}

	private void init(){
		
		
	 	

	}

	protected void run(){

		// Initialize array pieceMap to chess pieces
	    	for(int i = 0; i < 8; i++){
	    		pieceMap[i][6] = new Pawn(i, 6, true);
	    		pieceMap[i][1] = new Pawn(i, 1, false);
	    	}
	    	pieceMap[0][7] = new Rook(0,7,true);
	    	pieceMap[7][7] = new Rook(7,7,true);
	    	pieceMap[0][0] = new Rook(0,0,false);
	    	pieceMap[7][0] = new Rook(7,0,false);
	    	pieceMap[1][7] = new Knight(1,7,true);
	    	pieceMap[6][7] = new Knight(6,7,true);
	    	pieceMap[1][0] = new Knight(1,0,false);
	    	pieceMap[6][0] = new Knight(6,0,false);
	    	pieceMap[2][7] = new Bishop(2,7,true);
	    	pieceMap[5][7] = new Bishop(5,7,true);
	    	pieceMap[2][0] = new Bishop(2,0,false);
	    	pieceMap[5][0] = new Bishop(5,0,false);
	    	pieceMap[3][7] = new Queen(3,7,true);
	    	pieceMap[3][0] = new Queen(3,0,false);
	    	pieceMap[4][7] = new King(4,7,true);
	    	pieceMap[4][0] = new King(4,0,false);	
		// Create JFrame window
		JFrame window = new JFrame();
	    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	window.setBounds(0, 0, 900, 800);
	    	window.getContentPane().add(board);
	    	window.setVisible(true);

		System.out.println("Hello, welcome to my chess program");
		System.out.println("Type end to terminate the program");

	    	// Main loop
	    	whiteMove = true;
	    	while(true){
	    		// Check input
	    		getPieceSource();
	    	
	    		// Check second input
	    		getPieceTarget();
	    	
	    		// Check if piece can move to that spot
	    		while(!pieceMap[sourceX][targetX].canMove(sourceY,targetY,pieceMap)){
	    			System.out.println("Invalid move");
	    			getPieceSource();
	    			getPieceTarget();
	    		}
	    	
	    		// Move the pieces in the array
	    		pieceMap[sourceY][targetY] = pieceMap[sourceX][targetX];
	    		pieceMap[sourceX][targetX] = null;
	    	
	    		// Update position on board
	    		pieceMap[sourceY][targetY].move(sourceY,targetY);
	    	
	    		//SPECIAL CASE WHEN KING IS CASTLING, need to update rook
	    		//For white king castling queen side
	    		if(pieceMap[sourceY][targetY].getPieceName() == "King" && sourceX == 4 && targetX == 7 && sourceY == 2 && targetY == 7){
	    			pieceMap[3][7] = pieceMap[0][7];
	    			pieceMap[0][7] = null;
	    			pieceMap[3][7].move(0,7);
	    		}
	    		//For white king castling king side
	    		if(pieceMap[sourceY][targetY].getPieceName() == "King" && sourceX == 4 && targetX == 7 && sourceY == 6 && targetY == 7){
	    			pieceMap[5][7] = pieceMap[7][7];
	    			pieceMap[7][7] = null;
	    			pieceMap[5][7].move(7,7);
	    		}
	    		//For black king castling queen side
	    		if(pieceMap[sourceY][targetY].getPieceName() == "King" && sourceX == 4 && targetX == 0 && sourceY == 2 && targetY == 0){
	    			pieceMap[3][0] = pieceMap[0][0];
	    			pieceMap[0][0] = null;
	    			pieceMap[3][0].move(0,0);
	    		}
	    		//For black king castling king side
	    		if(pieceMap[sourceY][targetY].getPieceName() == "King" && sourceX == 4 && targetX == 0 && sourceY == 6 && targetY == 0){
	    			pieceMap[5][0] = pieceMap[7][0];
	    			pieceMap[7][0] = null;
	    			pieceMap[5][0].move(7,0);
	    		}
	    	
			// Repaint the board
			board.editBoard(pieceMap);
		    	window.repaint();
		    
		    	// Next player's turn
		    	whiteMove = (!whiteMove);
		}	
	}
}
