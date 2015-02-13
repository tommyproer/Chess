
public class Pawn implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	boolean color;
	
	//Test if the pawn can move to that position
	public boolean canMove(int x, int y){
		if(x > 8 || x < 1 || y > 8 || y < 1)
			return false;
		// If pawn is white
		if(color){
			if(this.y == 2){
				if(this.x == x && (y == 3 || y == 4))
					return true;
				return false;
			}else{
				if(this.x == x && this.y + 1 == y)
					return true;
				return false;
			}
		}else{
			if(this.y == 7){
				if(this.x == x && (y == 6 || y == 5))
					return true;
				return false;
			}else{
				if(this.x == x && this.y - 1 == y)
					return true;
				return false;
			}
		}
	}
	
	public void move(int x, int y){
		
	
	}
	
	public Pawn(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
}
