package src;

public class Pawn implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	private boolean color, hasMoved;
	
	// Test if the pawn can take that piece
	private boolean takePiece(int x, int y, Piece[][] b){
		// Return false if they are the same color piece
		if(b[this.x][this.y].getColor() == b[x][y].getColor()){
			return false;
		}
		
		if(color){
			if(this.x - 1 == x || this.x + 1 == x){
				if(this.y - 1 == y)
					return true;
				else
					return false;
			}else{
				return false;
			}
			
		}else{
			if(this.x - 1 == x || this.x + 1 == x){
				if(this.y + 1 == y)
					return true;
				else
					return false;
			}else{
				return false;
			}
		}
	}
	
	
	// Implement later: if the piece moves to the last row of the board it can transfer to any piece
	private boolean movePiece(int x, int y, Piece[][] b){
		// If the piece is white
		if(color){
			if(this.y == 6){
				if(this.x == x && (y == 5 || y == 4))
					return true;
				return false;
			}else{
				if(this.x == x && this.y - 1 == y)
					return true;
				return false;
			}
			
		// Otherwise the piece is black
		}else{
			if(this.y == 1){
				if(this.x == x && (y == 2 || y == 3))
					return true;
				return false;
			}else{
				if(this.x == x && this.y + 1 == y)
					return true;
				return false;
			}
		}
	}
	
	//Test if the pawn can move to that position
	public boolean canMove(int x, int y, Piece[][] b){
		if(this.x == x && this.y == y)
			return false;
		
		// if it's going to take a piece, test in takePiece, otherwise test in movePiece
		if(b[x][y] != null){
			return takePiece(x,y,b);
		}else{
			return movePiece(x,y,b);
		}
		
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean getColor(){
		return color;
	}
	
	public String getPieceName(){
		return "Pawn";
	}
	
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	public Pawn(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
}
