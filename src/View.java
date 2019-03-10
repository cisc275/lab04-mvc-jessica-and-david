import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * View: Contains everything about graphics and images
 * Know size of world, which images to load etc
 *
 * has methods to
 * provide boundaries
 * use proper images for direction
 * load images for all direction (an image should only be loaded once!!! why?)
 **/

public class View {
	
	Animation anim;
    JFrame frame;
    
    
    
    public View() {
    	anim = new Animation();
        JFrame frame = new JFrame();
    	frame.getContentPane().add(anim);
    	frame.setBackground(Color.gray);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	frame.setSize(Animation.frameWidth, Animation.frameHeight);
    	frame.setVisible(true);
    	
  
    	
    }
    
    
    
    private BufferedImage createImage(String aDirection){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File("images/orc/orc_forward_"+ 
                        aDirection +".png"));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    	// TODO: Change this method so you can load other orc animation bitmaps
    }
    

    
    public void update(int newX, int newY, int dir) {
    	
    	anim.xloc = newX;
    	anim.yloc = newY;
    	anim.direction = dir;
    	frame.repaint();
    }
    
    public int getWidth() {
    	return anim.frameWidth;
    }
    public int getHeight() {
    	return anim.frameHeight;
    }
    public int getImageWidth() {
    	return anim.frameHeight;
    }
    public int getImageHeight() {
    	return anim.frameHeight;
    }
    
	
}
