
public class King implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	boolean color;
	boolean hasMoved;
	
	public boolean canMove(int x, int y, Piece[][] b){
		// Makes sure its not moving to its own position
		if(this.x == x && this.y == y)
			return false;
		// Makes sure its not moving to a spot where its own piece is already occupying it
		if((b[x][y] != null) && b[this.x][this.y].getColor() == b[x][y].getColor())
			return false;
		// Checks if King can move to that position
		if(Math.abs(this.x - x) > 1 || Math.abs(this.y - y) > 1){
			
			//Check to see if King is castling
			if(hasMoved){
				return false;
			}
			if(color){
				// For white piece
				if(this.x == 4 && this.y == 7 && y == 7){
					if(x == 6){
						if(b[5][7] == null && b[6][7] == null && b[7][7].getPieceName() == "Rook" && !b[7][7].getHasMoved()){
							return true;
						}
					}else if(x == 2){
						if(b[2][7] == null && b[3][7] == null && b[0][7].getPieceName() == "Rook" && !b[0][7].getHasMoved()){
							return true;
						}
					}
				}
			}else{
				// For black piece
				if(this.x == 4 && this.y == 0 && y == 0){
					if(x == 6){
						if(b[5][0] == null && b[6][0] == null && b[7][0].getPieceName() == "Rook" && !b[7][0].getHasMoved()){
							return true;
						}
					}else if(x == 2){
						if(b[2][0] == null && b[3][0] == null && b[0][0].getPieceName() == "Rook" && !b[0][0].getHasMoved()){
							return true;
						}
					}
				}
			}
			
			return false;
		}
		return true;
	}
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
		hasMoved = true;
	}
	
	public boolean getColor(){
		return color;
	}
	
	public String getPieceName(){
		return "King";
	}
	
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	public King(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
		hasMoved = false;
	}

}
