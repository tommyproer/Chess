
public class Knight implements Piece {
	//Store the positions
	int x, y;
	//Color is 1 for white, 2 for black
	boolean color;
	
	public boolean canMove(int x, int y, Piece[][] b){
		return true;
	}
	
	public void move(int x, int y){
		
		
	}
	
	public boolean getColor(){
		return color;
	}
	
	public Knight(int x, int y, boolean color){
		this.x = x;
		this.y = y;
		this.color = color;
	}

}
