import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Chess extends JComponent{

	public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\ChessPieces\\pawn.jpg");
	    g2.drawImage(img1, 100, 590, this);
	    
	    int x = 90;
		int y = 130;
		for(int i = 0; i < 9; i++){
			g2.drawLine(100, 50 + x*i, 100 + y*8, 50 + x*i);
		}
		for(int i = 0; i < 9; i++){
			g2.drawLine(100 + y*i, 50, 100 + y*i, 50 + 8*x);
		}
		
	    g2.finalize();
	  }
	
	
	public static void main(String[] args) {
		JFrame window = new JFrame();
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setBounds(0, 0, 1800, 1500);
	    window.getContentPane().add(new Chess());
	    window.setVisible(true);
	    

	}

}
