
public class King implements Piece {
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
		// Checks if King can move to that position
		if(Math.abs(this.x - x) > 1 || Math.abs(this.y - y) > 1){
			return false;
		}
		return true;
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public boolean getColor(){
		return color;
	}
	
	public King(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

}
