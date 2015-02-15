
public class Rook implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	boolean color;
	
	public boolean canMove(int x, int y, Piece[][] b){
		// Makes sure the the rook is moving either vertically or horizontally
		if(this.x != x && this.y != y)
			return false;
		// Makes sure its not moving to its own position
		if(this.x == x && this.y == y)
			return false;
		// Makes sure its not moving to a spot where its own piece is already occupying it
		if((b[x][y] != null) && b[this.x][this.y].getColor() == b[x][y].getColor())
			return false;
		
		
		if(this.x != x){	// The rook is moving horizontally
			if(this.x > x){
				for(int i = this.x - 1; i > x; i--){	// Test if there are any pieces in the way
					if(b[i][y] != null)
						return false;
				}
			}else{
				for(int i = this.x + 1; i < x; i++){
					if(b[i][y] != null)
						return false;
				}
			}
		}else{				// The rook is moving vertically
			if(this.y > y){
				for(int i = this.y - 1; i > y; i--){	// Test if there are any pieces in the way
					if(b[x][i] != null)
						return false;
				}
			}else{
				for(int i = this.y + 1; i < y; i++){
					if(b[x][i] != null)
						return false;
				}
			}
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
	
	public Rook(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

}
