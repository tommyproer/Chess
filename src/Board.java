import java.awt.*;

import javax.swing.*;

public class Board extends JFrame {
	
	public Board(){
		this.setTitle("Chess");
		this.setSize(1600,845);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public void paint(Graphics g){
		int x = 90;
		int y = 130;
		// Make the Board
		g.setColor(Color.BLACK);
		for(int i = 0; i < 9; i++){
			g.drawLine(100, 50 + x*i, 100 + y*8, 50 + x*i);
		}
		for(int i = 0; i < 9; i++){
			g.drawLine(100 + y*i, 50, 100 + y*i, 50 + 8*x);
		}

		
	}


}
