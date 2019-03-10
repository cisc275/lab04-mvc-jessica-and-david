//T Harvey
//based loosely on http://www.java2s.com/Code/JavaAPI/java.awt/GraphicsdrawImageImageimgintxintyImageObserverob.htm
 
// Students: Nishant Chintala, Justin Schnee, David Olaoye
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Animation extends JPanel {

    final int frameCount = 10;
    int picNum = 0;
    BufferedImage[][] pics;
    int xloc = 0;
    int yloc = 0;
    final int xIncr = 8;
    final int yIncr = 2;
    final static int frameWidth = 500;
    final static int frameHeight = 300;
    final static int imgWidth = 165;
    final static int imgHeight = 165;
    int direction = 6; // represents southwest, see array in Animation()


    public void paint(Graphics g) {
    	picNum = (picNum + 1) % frameCount;
    	g.drawImage(pics[this.direction][picNum], this.xloc, this.yloc, Color.gray, this);
    }

    //Constructor: get image, segment and store in array
    public Animation(){
    	String[] directions = {"east", "north", "south", "west", "northeast", "northwest",
        "southeast", "southwest"};
    
    	pics = new BufferedImage[8][10];
        
    	for(int i = 0; i < 8; i++){
            BufferedImage img = createImage(directions[i]);
            for(int j = 0; j < frameCount; j++)
                pics[i][j] = img.getSubimage(imgWidth*j, 0, imgWidth, imgHeight);
        }
    	
    	// TODO: Change this constructor so that at least eight orc animation pngs are loaded
    }  
    
    //Read image from file and return
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
}