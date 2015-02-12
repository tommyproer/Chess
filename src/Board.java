import java.awt.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

// Prints out the entire board
public class Board extends JComponent {
	
	private BufferedImage image;
	
	public Board() throws Exception{
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Exit application window close operation
		window.setBounds(0,0,1600,845);
		window.getContentPane().add(new Board());
		window.setVisible(true);				// Lets window be visible
		
		/*
		try{
			image = ImageIO.read(new File("C:\\Users\\chent10\\Pictures\\cute.png"));
		}catch (Exception e){
          e.printStackTrace();
          System.exit(1);
        }
        */
		
	}
	
	
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;

	    Image img1 = Toolkit.getDefaultToolkit().getImage("C:\\Users\\chent10\\Pictures\\cute.png");
	    g2.drawImage(img1, 10, 10, this);
	    g2.finalize();
	    
		// Make the Board (8x8 board)
		/*
		int x = 90;
		int y = 130;
		g.setColor(Color.BLACK);
		for(int i = 0; i < 9; i++){
			g.drawLine(100, 50 + x*i, 100 + y*8, 50 + x*i);
		}
		for(int i = 0; i < 9; i++){
			g.drawLine(100 + y*i, 50, 100 + y*i, 50 + 8*x);
		}
		*/
		//g.drawImage(image, 40, 40, this);

		
	}


}
