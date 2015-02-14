import java.util.Scanner;
import javax.swing.JFrame;

public class Chess{

	private static Scanner scan = new Scanner(System.in);
	private static Piece[][] b = new Piece[8][8];
	private static Board board = new Board(b);
	private static JFrame window;
	
	private static String getInput()
	{
		System.out.println("> ");
		return scan.nextLine();
	}
	
	public static void loop(){
		
	}
	
	public static void main(String[] args) {
		System.out.println("Hello, welcome to my chess program");
		System.out.println("Type end to terminate the program");
		
		// Initialize array b
		
	    for(int i = 0; i < 8; i++){
	    	b[i][6] = new Pawn(i, 6, true);
	    }
	    
	    
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 900, 800);
	    
	    window.getContentPane().add(board);
	    window.setVisible(true);
	    
	    
	    // Main loop
	    String move = getInput();
		while(!move.equals("end")){
			System.out.println(move);
			if(move.equals("1")){
				System.out.println("test");
				for(int i = 0; i < 8; i++){
			    	b[i][1] = new Pawn(i, 1, false);
			    }
			    
			}else if(move.equals("2")){
				b[0][4] = b[0][6];
				b[0][6] = null;
				
			}
			board.editBoard(b);
		    window.repaint();
			move = getInput();
		}
	    
	}

}
