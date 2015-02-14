
public class Pawn implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	private boolean color;
	
	//Test if the pawn can move to that position
	public boolean canMove(int x, int y, Piece[][] b){
		if(x > 8 || x < 1 || y > 8 || y < 1)
			return false;
		// If pawn is white
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
		}else{
			System.out.println("y1: " + this.y + " y2: " + y);
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
	
	public void move(int x, int y){
		this.x = x;
		this.y = y;
	
	}
	
	public boolean getColor(){
		return color;
	}
	
	public Pawn(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}
}
