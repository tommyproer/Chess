package src;

public class Queen implements Piece {
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
		
		if(this.x == x){
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
			return true;
		}else if(this.y == y){
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
			return true;
		}else if(Math.abs(this.x - x) == Math.abs(this.y - y)){
			
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
		return "Queen";
	}
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	public Queen(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

}
