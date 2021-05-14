
package gui;

import javax.swing.ImageIcon;

/**
 * Simulates a single Tile of the Domino game
 * @author Sokratis Athanasiadis
 * @author Kwnstantinos Perrakis
 * @version 1.1
 */
public class Tile {
   private int side1, side2;
   private ImageIcon icon;
       
    
    /**
     * Creates a new Tile
     * @param num1 the number of dots in the left side of the tile
     * @param num2 the number of dots in the right side of the tile
     */
    public Tile(int num1,int num2){
        side1=num1;
        side2=num2;
        String temp1=String.valueOf(num1);
        String temp2=String.valueOf(num2);
        String file=temp1+"-"+temp2+".png";
        icon=new ImageIcon(file);
    }
    
    /**
     * Copy Constructor
     * @param another the Tile that will be copied 
     */
    public Tile(Tile another){
        this.side1=another.side1;
        this.side2=another.side2;
    }
    
    /**
     * Reverses a Tile by swapping it's sides
     */
    public void swap_sides(){
        int temp=side1;
        side1=side2;
        side2=temp;
    }
    
    /**
     * Returns the number of the left side of the Tile
     * @return left side
     */
    public int get_side1(){
        return side1;
    }
    
    /**
     * Returns the number of the right side of the Tile
     * @return right side
     */
    public int get_side2(){
        return side2;
    }
    
    
    /**
     * Returns the Url of the image of the Tile
     * @return the right icon for the right tile
     */
    public ImageIcon getFile(){
        return icon;
    }
    
}
