package src;

public class Bishop implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	boolean color, hasMoved;
	
	public boolean canMove(int x, int y, Piece[][] b){
		// Makes sure its not moving to its own position
		if(this.x == x && this.y == y)
			return false;
		// Makes sure its not moving to a spot where its own piece is already occupying it
		if((b[x][y] != null) && b[this.x][this.y].getColor() == b[x][y].getColor())
			return false;
		
		// Check to see if Bishop can move there
		if(Math.abs(this.x - x) == Math.abs(this.y - y)){
			
			for(int i = 1; i < Math.abs(this.x - x); i++){
				if(x > this.x){
					if(y > this.y){
						if(b[this.x + i][this.y + i] != null)
							return false;
					}else{
						if(b[this.x + i][this.y - i] != null)
							return false;
					}
				}else{
					if(y > this.y){
						if(b[this.x - i][this.y + i] != null)
							return false;
					}else{
						if(b[this.x - i][this.y - i] != null)
							return false;
					}
				}
			}
			
			return true;
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
	
	public String getPieceName(){
		return "Bishop";
	}
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	public Bishop(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
}
