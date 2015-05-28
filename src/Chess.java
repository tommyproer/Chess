import java.util.Scanner;
import javax.swing.JFrame;

public class Chess{

	private static Scanner scan = new Scanner(System.in);
	private static Piece[][] b = new Piece[8][8];
	private static Board board = new Board(b);
	//private static JFrame window;
	private static boolean whiteMove;
	public static int x1,x2,y1,y2;
	
	private static String getInput()
	{
		//System.out.print("\n> ");
		return scan.nextLine();
	}
	
	// Convert the board position to the number in the array
	private static int convertToInt(char c){
		if(c == 'a')
			return 0;
		if(c == 'b')
			return 1;
		if(c == 'c')
			return 2;
		if(c == 'd')
			return 3;
		if(c == 'e')
			return 4;
		if(c == 'f')
			return 5;
		if(c == 'g')
			return 6;
		if(c == 'h')
			return 7;
		return -1;
	}
	
	// Checks if the first input is valid
	private static boolean checkInput(String input, boolean whiteMove){
		if(input.length() != 2){
			System.out.println("Invalid position(length of position is not 2)");
			return false;
		}
		if(convertToInt(input.charAt(0)) == -1){
			System.out.println("Invalid position");
			return false;
		}
		if(Character.getNumericValue(input.charAt(1)) > 8 || Character.getNumericValue(input.charAt(1)) < 1){
			System.out.println("Invalid positon");
			return false;
		}
		if(b[convertToInt(input.charAt(0))][8 - Character.getNumericValue(input.charAt(1))] == null){
			System.out.println("No piece located at " + input.charAt(0) + input.charAt(1));
			return false;
		}
		if(b[convertToInt(input.charAt(0))][8 - Character.getNumericValue(input.charAt(1))].getColor() != whiteMove){
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
	private static boolean checkInput2(String input){
		if(input.length() != 2){
			System.out.println("Invalid position(length of position is not 2)");
			return false;
		}
		if(convertToInt(input.charAt(0)) == -1){
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
	private static void firstInput(){
		// Check if first input is valid
		System.out.print("Type the position of the piece to move");
    	if(whiteMove)
    		System.out.print("(white to move): ");
    	else
    		System.out.print("(black to move): ");
    	String input = getInput();
    	while(!checkInput(input, whiteMove)){
	    	input = getInput();
    	}
    	
    	// Convert position to coordinates in array
    	x1 = convertToInt(input.charAt(0));
    	y1 = 8 - Character.getNumericValue(input.charAt(1));
	}
	
	// The user will enter in the second input, the position of where they want the piece to go to
	private static void secondInput(){
		// Check if second input is valid
		System.out.print("Type the position you want to move the piece to: ");
    	String input2 = getInput();
    	while(!checkInput2(input2)){
	    	input2 = getInput();
    	}
    	
    	// Convert position to coordinates in array
    	x2 = convertToInt(input2.charAt(0));
    	y2 = 8 - Character.getNumericValue(input2.charAt(1));
	}
	
	public static void main(String[] args) {
		System.out.println("Hello, welcome to my chess program");
		System.out.println("Type end to terminate the program");
		
		// Initialize array b to chess pieces
	    for(int i = 0; i < 8; i++){
	    	b[i][6] = new Pawn(i, 6, true);
	    	b[i][1] = new Pawn(i, 1, false);
	    }
	    b[0][7] = new Rook(0,7,true);
	    b[7][7] = new Rook(7,7,true);
	    b[0][0] = new Rook(0,0,false);
	    b[7][0] = new Rook(7,0,false);
	    b[1][7] = new Knight(1,7,true);
	    b[6][7] = new Knight(6,7,true);
	    b[1][0] = new Knight(1,0,false);
	    b[6][0] = new Knight(6,0,false);
	    b[2][7] = new Bishop(2,7,true);
	    b[5][7] = new Bishop(5,7,true);
	    b[2][0] = new Bishop(2,0,false);
	    b[5][0] = new Bishop(5,0,false);
	    b[3][7] = new Queen(3,7,true);
	    b[3][0] = new Queen(3,0,false);
	    b[4][7] = new King(4,7,true);
	    b[4][0] = new King(4,0,false);
	    
	    // Create JFrame window
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 900, 800);
	    window.getContentPane().add(board);
	    window.setVisible(true);
	    
	    // Main loop
	    whiteMove = true;
	    while(true){
	    	
	    	// Check input
	    	firstInput();
	    	
	    	// Check second input
	    	secondInput();
	    	
	    	// Check if piece can move to that spot
	    	while(!b[x1][y1].canMove(x2,y2,b)){
	    		System.out.println("Invalid move");
	    		firstInput();
	    		secondInput();
	    	}
	    	
	    	// Move the pieces in the array
	    	b[x2][y2] = b[x1][y1];
	    	b[x1][y1] = null;
	    	
	    	// Update position on board
	    	b[x2][y2].move(x2,y2);
	    	
	    	//SPECIAL CASE WHEN KING IS CASTLING, need to update rook
	    	//For white king castling queen side
	    	if(b[x2][y2].getPieceName() == "King" && x1 == 4 && y1 == 7 && x2 == 2 && y2 == 7){
	    		b[3][7] = b[0][7];
	    		b[0][7] = null;
	    		b[3][7].move(0,7);
	    	}
	    	//For white king castling king side
	    	if(b[x2][y2].getPieceName() == "King" && x1 == 4 && y1 == 7 && x2 == 6 && y2 == 7){
	    		b[5][7] = b[7][7];
	    		b[7][7] = null;
	    		b[5][7].move(7,7);
	    	}
	    	//For black king castling queen side
	    	if(b[x2][y2].getPieceName() == "King" && x1 == 4 && y1 == 0 && x2 == 2 && y2 == 0){
	    		b[3][0] = b[0][0];
	    		b[0][0] = null;
	    		b[3][0].move(0,0);
	    	}
	    	//For black king castling king side
	    	if(b[x2][y2].getPieceName() == "King" && x1 == 4 && y1 == 0 && x2 == 6 && y2 == 0){
	    		b[5][0] = b[7][0];
	    		b[7][0] = null;
	    		b[5][0].move(7,0);
	    	}
	    	
			// Repaint the board
			board.editBoard(b);
		    window.repaint();
		    
		    // Next player's turn
		    whiteMove = (!whiteMove);
		}
	    
	}
}
