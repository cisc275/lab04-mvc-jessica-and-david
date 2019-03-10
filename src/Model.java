import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 * Model: Contains all the state and logic
 * Does not contain anything about images or graphics, must ask view for that
 *
 * has methods to
 *  detect collision with boundaries
 * decide next direction
 * provide direction
 * provide location
 **/
public class Model {
	
    int picNum = 0;
    int xloc = 0;
    int yloc = 0;
    int xIncr = 8;
    int yIncr = 2;
    int frameWidth;
    int frameHeight;
    int imgWidth;
    int imgHeight;
    final int frameCount = 10;
    int direction = 6; // represents southwest, see array in Animation()
    Direction d;
	
    
    public Model(int fmw, int fmh, int imgw, int imgh){
		frameWidth = fmw;
        frameHeight = fmh;
        imgWidth = imgw;
        imgHeight = imgh;
		
	}
    
    public int getX() {
    	return this.xloc;
    }
    public int getY() {
    	return this.yloc;
    }
    public int getDirect() {
    	return this.direction;
    }
	
    public void updateLocationAndDirection() {
    	picNum = (picNum + 1) % frameCount;
    	
    	if(xloc > frameWidth - imgWidth){
            if(direction == 6){ // southeast
                direction = 7; //southwest
                xloc-=xIncr;
                yloc+=yIncr;
   
            }
            else if(direction == 4){ // northeast
                direction = 5; //northwest
                xloc-=xIncr;
                yloc-=yIncr;
         
            }
            else { // east
                direction = 3; // west
                xloc-=xIncr;
                yloc+=yIncr;
     
            }
            
        }
        else if(xloc < 0){
            if(direction == 7){ //southwest
                direction = 6; // southeast
                xloc+=xIncr;
                yloc+=yIncr;
                
            }
            else if(direction == 5){ //northwest
                direction = 4; //northeast
                xloc+=xIncr;
                yloc-=yIncr;
             
            }
            else { //west
                direction = 0; //east
                xloc+=xIncr;
                yloc+=yIncr;
               
            }
        }
        else if(yloc > frameHeight - imgHeight){
            if(direction== 6){ //southeast
                direction= 4; //northeast
                xloc+=xIncr;
                yloc-=yIncr;
                
            }
            else if(direction == 7){ //southwest
                direction = 5; //northwest
                xloc-=xIncr;
                yloc-=yIncr;
                
            }
            else { // south
                direction = 1; //north
                xloc+= 0;
                yloc-=yIncr;
               
            }
        }
        else if(yloc < 0){
            if(direction==4){ //northeast
                direction = 6;//southeast
                xloc+=xIncr;
                yloc+=yIncr;
                
            }
            else if(direction==5){ //northwest
                direction = 7; // southwest
                xloc-=xIncr;
                yloc+=yIncr;
                
            }
            else { //north
                direction = 2; //south
                xloc+=0;
                yloc+=yIncr;
                
            }
        }
        else{
            if(direction == 0){ // east
            	 xloc+=xIncr;
                 yloc+=0;
              
            }
            else if(direction == 1){ //north
            	 xloc+=0;
                 yloc-=yIncr;
                
            }
            else if(direction == 2){ // south
            	 xloc+= 0;
                 yloc+=yIncr;
               
            }
            else if(direction == 3){ //west
            	 xloc-=xIncr;
                 yloc+=0;
              
            }
            else if(direction == 4){ //northeast
            	 xloc+=xIncr;
                 yloc-=yIncr;
                
            }
            else if(direction == 5){ //northwest
            	 xloc-=xIncr;
                 yloc-=yIncr;
                
            }
            else if(direction == 6){ //southeast
            	 xloc+=xIncr;
                 yloc+=yIncr;
                
            }
            else{ //southwest
            	 xloc-=xIncr;
                 yloc+=yIncr;
                
            }
        }
		 
	}
}
    
    