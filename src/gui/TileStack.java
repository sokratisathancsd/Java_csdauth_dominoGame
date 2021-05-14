
package gui;

import java.util.*;

/**
 * Simulates the Domino Tile Stack of all Tiles
 * @author Sokratis Athanasiadis
 * @author Kwnstantinos Perrakis
 * @version 1.1
 */
public class TileStack {
   private ArrayList<Tile> stackOfTiles;
   
   /**
    * Creates a new Stack of 24 Tiles. 
    */
   public TileStack(){
       stackOfTiles=new ArrayList<>();
       for(int i=0;i<7;i++){
            for(int j=i;j<7;j++){
                stackOfTiles.add(new Tile(i,j));
            }
        }
   }
   
   
   /**
    * Removes and returns the last tile of the stack
    * @return the last tile of the stack
    */
   public Tile getTile(){
       Tile last=stackOfTiles.get(stackOfTiles.size()-1);
       stackOfTiles.remove(stackOfTiles.size()-1);
       return last;
   }
   
   /**
    * Returns game Stack
    * @return stack Of Tiles
    */
   public ArrayList<Tile>getStack(){
       return stackOfTiles;
   }
   
   /**
    * Shuffles the Stack of Tiles. It is only used in tests
    */
   public void shuffledStuck(){
         Collections.shuffle(stackOfTiles);
        }
   
   /**
    * Checks if List is Empty
    * @return true if empty false else.
    */
   public boolean isEmpty(){
       return stackOfTiles.isEmpty();
   }
   }



