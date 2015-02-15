
public class Queen implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	boolean color;
	
	public boolean canMove(int x, int y, Piece[][] b){
		// Makes sure its not moving to its own position
		if(this.x == x && this.y == y)
			return false;
		// Makes sure its not moving to a spot where its own piece is already occupying it
		if((b[x][y] != null) && b[this.x][this.y].getColor() == b[x][y].getColor())
			return false;
		
		if(this.x == x || this.y == y){
			
		}else if(Math.abs(this.x - x) == Math.abs(this.y - y)){
			
		}else{
			return false;
		}
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
		
	}
	
	public boolean getColor(){
		return color;
	}
	
	public Queen(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

}
