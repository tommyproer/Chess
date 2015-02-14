public interface Piece {

	public boolean canMove(int x, int y, Piece[][] b);
	public void move(int x, int y);
	public boolean getColor();
}
