
package gui;
import java.util.ArrayList;

/**
 * Simulates a Hungarian Mode Player
 * @author  Sokratis Athanasiadis
 * @author Kwnstantinos Perrakis
 * @version 1.2
 */


public class HungarianPlayer {
    protected ArrayList<Tile> Stack;
    protected int points;
    protected int numTiles;
    
    /**
     * The construction of a Player
     * @param startingStack  The main stack that each player will take his  starting Tiles
     * @param numTiles how many Tiles each player will takes, it changes according to how many players are playing
     */
    public HungarianPlayer(TileStack startingStack,int numTiles){
        this.numTiles=numTiles;
        Stack =new ArrayList<>();
        for(int i=0;i<numTiles;i++){
            Stack.add(startingStack.getTile());
        
        }
        points=0;
    }
    
    
    /**
     * A copy constructor
     * @param another The class that will be copied
     */
     public HungarianPlayer(HungarianPlayer another){
        this.Stack=another.Stack;
        this.points=another.points;
    }
    
    
     /**
      * Performs a move
      * @param table The Tiles which are on the table at the given moment
      * @param position is an ArrayList with the structure (selected_tile,reverse/no_reverse,place_left/right)
      * @return true if the move has been made, false else
      */
    public boolean moves(ArrayList<Tile> table,ArrayList<Integer> position){
        if(table.isEmpty()){           
            table.add(removeTile(position.get(0)));
            return true;
        }
        if (position==null){  //Checks if the ArrayList is null. Normally if it is null this method should n't begin but it is needed in order to perform tests
            return false;
        }
        Tile selected=Stack.get(position.get(0));//The Tile that we will place in the table
        if(position.get(1)==1){ //if we will reverse it
             selected.swap_sides();
        }
        
        if(position.get(2)==0){            // The tile gets placed on the left side
          if(table.get(0).get_side1()== selected.get_side2()){
             table.add(0,removeTile(position.get(0)));
             return true;
          }
          
          else{        // If the Tile doen't match    
           return false;
          }      
        }
        else if(position.get(2)==1){   // The tile is place on the right side        
           if(table.get(table.size()-1).get_side2()==selected.get_side1()){
                  table.add(removeTile(position.get(0)));
                  return true;
           }
           else{ // If the Tile doen't match 
                return false;
           }
        }
        return false; // If no move has been done
    }
    
    
    /**
     * Returns a copy of the player's stack
     * @return the player's stack
     */
    public ArrayList <Tile>GetTilesStack(){
        ArrayList <Tile> copy=new ArrayList<>();
        for (int i=0;i<Stack.size();i++){
            Tile tile=Stack.get(i);
            copy.add(tile);
        }
        return copy;
    }
    
    
    /**
     * Adds the points that are given to a player
     * @param points the points that should be added
     */
    public void addPoints(int points){
        this.points=this.points+points;
    }
    
    
    /**
     * Returns the points of a player
     * @return The points of the player
     */
    public int getPoints(){
        return points;
    }
    
    
    /**
     * Creates a new player's Tile Stack for a new round
     * @param stack Main Tile Stack
     */
    public void newTileStack(TileStack stack){
        Stack =new ArrayList<>();
        for(int i=0;i<numTiles;i++){
            Stack.add(stack.getTile());
        
        }
    }
    
   
     /**
     * Finds the Maximum Double Tile
     * @return The Maximum Double Tile or if the player doesn't have any double tile returns -1 
     */
    public int checkMaxDouble(){
       boolean flag=false;
       Tile check=null;
       int i=0;
       while(i<numTiles && flag==false){          //We found the first double(based on the posion on the stack), if there is one 
           if(Stack.get(i).get_side1()==Stack.get(i).get_side2()){
               check=Stack.get(i);
               flag=true;
           }
           i++;
       }
       if (flag!=false)
       {
           while(i<numTiles){  // If there is a double(for example in place i=4) we search the rest tiles(i>4) to find if there is a bigger one
            if(Stack.get(i).get_side1()==Stack.get(i).get_side2()){
               if(Stack.get(i).get_side1()>check.get_side1()){
                   check=Stack.get(i);                       
               }
            }
            i++;
           }
           return check.get_side1();
               
       }
       else{
           return -1;
       }
    }
      
    
    /**
     * Calculates the points of the remaining tiles on player's hand
     * @return the points of the remaining tiles on player's hand
     */
     public int handPoints(){
        int countpoints=0;
        if(Stack.isEmpty()){
            return 0;
        }
        for(int i=0;i<Stack.size();i++){
            countpoints=countpoints+Stack.get(i).get_side1()+Stack.get(i).get_side2();
        }
        return countpoints;
    }
     
     
     
     /**
      * Calculates the highest valued Tile
      * @return The highest valued Tile
      */
    public int tilePoints(){
        int maxPoints=Stack.get(0).get_side1()+Stack.get(0).get_side2();
        for (int i=1;i<numTiles;i++){
            if(Stack.get(i).get_side1()+Stack.get(i).get_side2() > maxPoints){
                maxPoints=Stack.get(i).get_side1()+Stack.get(i).get_side2();
                
            }
            
        }
       
        return maxPoints;
    }
    
    /**
     * Checks if the player's stack is empty
     * @return True if it's empty, false else
     */
    public boolean isEmpty(){
       return Stack.isEmpty();
    }
    
    
    /**
     * Checks if player has available moves
     * @param table the stack of tiles on the table
     * @return true if player has available moves, false if not
     */
    public boolean checkAvailableMoves(ArrayList<Tile> table){
        int count=0;
        if(Stack.isEmpty()){
            return false;
        }
        if (table.isEmpty()){
            return true;
        }
        for(int i=0;i<Stack.size();i++){
            //If the Tile in the place i cant be added in the table count is increased by one
            if(( Stack.get(i).get_side1()!=table.get(0).get_side1() )&& ( Stack.get(i).get_side1()!=table.get(table.size()-1).get_side2() )){
                if((Stack.get(i).get_side2()!=table.get(0).get_side1() )&& ( Stack.get(i).get_side2()!=table.get(table.size()-1).get_side2())){
                    count++;
                
                }
            }
        }
        //If count equals the size of the cards of the players hand,it means that he does not have any more moves
        return !(count==Stack.size());
    }
    
    /**
     * Auto chose if the selected Tile need to be reversed.
     * 0 means Tile won't be reversed and it will be placed left
     * 1 means Tile won't be reversed and it will be placed right
     * 10 means Tile will be reversed and it will be placed left
     * 11 means Tile will be reversed and it will be placed right
     * @param i the position of the selected Tile
     * @param firsttile the first Tile of the Table
     * @param lasttile the last Tile of the Table
     * @return 0,1,10 or 11 as described above
     */
    public int chooseSideRotate(int i,Tile firsttile,Tile lasttile){
            if (Stack.get(i).get_side2()==firsttile.get_side1()){
                return 0;
            }
            if (Stack.get(i).get_side1()==lasttile.get_side2()){
                return 1;
            }
            if (Stack.get(i).get_side1()==firsttile.get_side1()){
                
                return 10;
            }
            if(Stack.get(i).get_side2()==lasttile.get_side2()){
                return 11;
            }
        return -1;
    }
    
    /**
     * Returns a copy of a particular Tile
     * @param i the number of the Tile in the ArrayList
     * @return The tile on (i)th place in the ArrayList
     */
    public Tile getTile(int  i){
        Tile copy=Stack.get(i);// The class Tile has a copy constructor
        return copy;
    }
    
    
    /**
     * Removes a particular Tile and returns it's value
     * @param i The Tile that will be deleted
     * @return The value of the deleted Tile
     */
    public Tile removeTile(int i){
        Tile choice=Stack.get(i);
        Stack.remove(i);
        return choice;
    }
   
    
    /**
     * Returns the size of the player's stack
     * @return The size of the player's stack 
     */
    public int listSize(){
        return Stack.size();
    }
    
    /**
     * Reverses the given tile
     * @param i The tile that should be reversed
     */
    public void reverseTile(int i)
    {
        Stack.get(i).swap_sides();
    }
}
