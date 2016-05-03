package src;

public interface Piece {

	public boolean canMove(int x, int y, Piece[][] b);
	public void move(int x, int y);
	public boolean getColor();
	public String getPieceName();
	public boolean getHasMoved();
}
