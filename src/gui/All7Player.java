/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

/**
 * Simulates an All-7 Mode Player
 * @author Kwnstantinos Perrakis
 * @author Sokratis Athanasiadis
 * @version 1.1
 */
public class All7Player {
    protected ArrayList<Tile> Stack;
    protected int points;
    protected int numTiles;

    
    /**
     * /**
     * The construction of a Player
     * @param startingStack  The main stack that each player will take his  starting Tiles
     *
     * @param numTiles how many Tiles will be drawn from the startingStack of Tiles, it changes according to how many players are playing
     */
    public All7Player(TileStack startingStack,int numTiles){
        this.numTiles=numTiles;
        Stack = new ArrayList<>();
         for(int i=0;i<numTiles;i++){
            Stack.add(startingStack.getTile());
        
        }
        points=0;
    }
    
    /**
     * Checks if a Tile can be used as Wildcard
     * @param i the position of the Tile that will be checked
     * @return true if the Tile is Wildcard, false if not
     */
    public int checkBalader(int i){
        if ((Stack.get(i).get_side1()+Stack.get(i).get_side2()==7)||(Stack.get(i).get_side1()==0&&Stack.get(i).get_side2()==0)){
            return 1;
        }
        return 0;
   }
   
    
    /**
      * Performs a move
      * @param table The Tiles which are on the table at the given moment
      * @param position is an ArrayList with the structure (selected_tile,reverse/no_reverse,place_left/right)
      * @return true if the move has been made, false else
      */
    public boolean moves(ArrayList<Tile> table,ArrayList<Integer> position){
        Tile selected=Stack.get(position.get(0));
        if(position.get(1)==1){ //if we will reverse it
             selected.swap_sides();
        }
        if(position.get(2)==0){            // The tile gets placed on the left side
             table.add(0,removeTile(position.get(0)));
             return true;
        }
        else if(position.get(2)==1){   // The tile is place on the right side        
                  table.add(removeTile(position.get(0)));
                  return true;
           }
        
        
        return false;//no move has been done
    }
    
    /**
     * Removes a Tile from a player's Stack
     * @param i the Tile that it will be removed
     * @return the Tile that it is removed.
     */
    public Tile removeTile(int i){
        Tile choice=Stack.get(i);
        Stack.remove(i);
        return choice;
    }
    
    /**
     * Checks if the player's stack is empty
     * @return True if it's empty, false else
     */
    public boolean isEmpty(){
       return Stack.isEmpty();
    }
    
    /**
     * Add points in total score of a player
     * @param points the points that will be added
     */
    public void addPoints(int points){
        this.points=this.points+points;
    }
    /**
     * Returns the total score of a player 
     * @return points of a player
     */
    public int getPoints(){
        return points;
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
     * Returns a copy of a particular Tile
     * @param i the number of the Tile in the ArrayList
     * @return The tile on (i)th place in the ArrayList
     */
    public Tile getTile(int  i){
        Tile copy=Stack.get(i);// The class Tile has a copy constructor
        return copy;
    }
    
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
    
    /**
     * Simulates when a player is needed or he just wants to draw a Tile from the remaining Tiles that are in startingStack
     * @param startingStack the remaining stack of Tiles
     * @return 1 if a drawn was been made, 0 else
     */
    public int drawTile(TileStack startingStack){
        if(startingStack.getStack().size()>2){
          Stack.add(startingStack.getTile());
          return 1;
        }
        else{
            return 0;
        }
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
            if (Stack.get(i).get_side2()+firsttile.get_side1()==7){
                
                return 0;
            }
            if (Stack.get(i).get_side1()+lasttile.get_side2()==7){
                return 1;
            }
            if (Stack.get(i).get_side1()+firsttile.get_side1()==7){
                
                return 10;
            }
            if(Stack.get(i).get_side2()+lasttile.get_side2()==7){
                return 11;
            }
        return -1;
    }
    
    /**
     * Checks if player has available moves
     * @param table the stack of tiles on the table
     * @param startingStack The stack
     * @return true if player has available moves, false if not
     */
    public boolean checkAvailableMoves(ArrayList<Tile> table,TileStack startingStack){
        int count=0;
        if (table.isEmpty()){
            return true;
        }
        else if(Stack.isEmpty()){
            return false;
        }
        else if ((table.get(0).get_side1()==0)||(table.get(table.size()-1).get_side2()==0)){
            return true;
        }
        else{
        for(int i=0;i<Stack.size();i++){
            if (checkBalader(i)==1){
                
                return true;
            }
        }        
        for(int i=0;i<Stack.size();i++){
            //If the Tile in the place i cant be added in the table count is increased by one
            if(( Stack.get(i).get_side1()+table.get(0).get_side1() !=7)&& ( Stack.get(i).get_side1()+table.get(table.size()-1).get_side2() !=7)){
                if((Stack.get(i).get_side2()+table.get(0).get_side1() !=7)&&( Stack.get(i).get_side2()+table.get(table.size()-1).get_side2() !=7)){
                    count++;
                
                }
            }
        }
        //If count equals the size of the cards of the players hand,it means that he does not have any more moves
            return !(count==Stack.size());
         }
        }
}


