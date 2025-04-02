/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: Managment company
 * Due: 4/1/2025
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: __Natnael Tenagashaw________
*/
public class Plot {
	// fields
	private int x;
	private int y;
    private int width;
    private int depth;
    
    
    // constuctors
    public Plot() {
    	this.width = 1;
    	this.depth = 1;
    }
    public Plot(int x, int y, int width, int depth) {
    	this.x = x;
    	this.y = y;
    	this.width = width;
    	this.depth = depth;
    }
    public Plot(Plot otherPlot) {
    	this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth; 
    }

    
    // getters 
    public int getDepth() {
    	return depth;
    }
    public int getWidth() {
    	return width; 
    }
    public int getX() {
    	return x;
    }
    public int getY() {
    	return y; 
    }
    // setters
    public void setDepth(int depth) {
    	this.depth = depth;
    }
    public void setWidth(int width) {
    	this.width = width;
    }
    public void setX(int x) {
    	this.x = x;
    }
    public void setY(int y) {
    	this.y = y;
    }
    
     
    
    
    public boolean encompasses(Plot plot) {
        if (plot == null) return false; 
        
    	return (plot.x >= this.x && plot.y >= this.y && plot.x + plot.width <= this.x + this.width && plot.y + plot.depth <= this.y + this.depth);
    }
    
    public boolean overlaps(Plot plot) {
        if (plot == null) return false;

        return !(plot.x + plot.width <= this.x || plot.x >= this.x + this.width || plot.y + plot.depth <= this.y || plot.y >= this.y + this.depth);
    }
    
    public String toString() {
    	return x + ", " + y + ", " + width + ", " + depth; 
    }
    
    
    
}

