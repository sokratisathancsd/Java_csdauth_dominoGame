
package gui;


import java.util.*;
/**
 * Simulates the Solo1 Domino game
 * @author Sokratis Athanasiadis
 * @author Kwnstantinos Perrakis
 * @version 1.1
 */
public class Solo1 {
    
    
    private ArrayList<ArrayList<Tile>>rows;
    private ArrayList<Tile> table;
    
    /**
     * Creates the Stack of the Tiles that are on the table
     * @param gameStack The stack of the Tiles
     */
    public Solo1(TileStack gameStack){
        table =new ArrayList<>();
        rows=new ArrayList<ArrayList<Tile>>(4);
        for(int i=0;i<4;i++){
           rows.add(i,new ArrayList<>());
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<7;j++){
                rows.get(i).add(gameStack.getTile());
            }
        
        
        
        
        
        }
    }
    
    
    /**
     * This method restarts the game
     * @param gameStack new Stack of Tiles
     */
    public void restart(TileStack gameStack){
        table =new ArrayList<>();
        rows=new ArrayList<ArrayList<Tile>>(4);
        for(int i=0;i<4;i++){
           rows.add(i,new ArrayList<>());
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<7;j++){
                rows.get(i).add(gameStack.getTile());
            }
    }
    }
    /**
     * Makes a move
     * @param position is an ArrayList which contains the number of the tile and in which position it will be placed (described better in searchtile method of Hungarian Mode)
     * @param round The current round
     * @return true if a move have been made
     */
    public boolean moves(ArrayList<Integer> position,int round) {
                Tile selected=rows.get(position.get(0)).get(rows.get(position.get(0)).size()-1);
                rows.get(position.get(0)).remove(rows.get(position.get(0)).size()-1);
                if(position.get(1)==1){
                    selected.swap_sides();
                }
                if(round==1){
                 table.add(selected);
                 return true;
                }
                if(position.get(2)==1){
                  if(table.get(table.size()-1).get_side2()== selected.get_side1()){
                  table.add(selected);
                  return true;
                  }
                  else{
                      rows.get(position.get(0)).add(selected);  
                      return false;
                      }
                  }
                
               else {
                  if(table.get(0).get_side1() == selected.get_side2()){
                  table.add(0,selected);
                  return true;
                  }
                  else{
                      rows.get(position.get(0)).add(selected);
                      return false;
                    }
               }
           }
    
    
 
        
        
    
    
    
    /**
     * Checks how many lines are empty
     * @return the number of empty lines
     */
    public int checkEmptyLines(){
        int count=4;
        for(int i=0;i<4;i++){
           if(rows.get(i).isEmpty()){
               count--;
           }
        }
        return count;
    }
    
    /**
     * Checks for available moves
     * @param count the number of the rows which have Tiles
     * @return true if you don't have available moves false if you have
     */
    public boolean checkAvailableMoves(int count){
        if(count==0){
            return true;//game ends with win
        }
        int count2=0;
        for(int i=0;i<4;i++){
             if(rows.get(i).isEmpty()==false){   
                  Tile check=rows.get(i).get(rows.get(i).size()-1);
                  if(check.get_side1()!=table.get(0).get_side1()&&check.get_side2()!=table.get(0).get_side1()){
                      if(check.get_side1()!=table.get(table.size()-1).get_side2()&&check.get_side2()!=table.get(table.size()-1).get_side2()){
                        count2++;  
                      }
                    }
                  
                }
           }  
            
        return count2!=count;
    }
    
    

  /**
     * Returns the PlayArea
     * @return the playArea 
     */
    public ArrayList<Tile> getPlayArea(){
        return table;
    }
    
    /**
     * Returns the Rows
     * @return the rows
     */
    public ArrayList<ArrayList<Tile>> getRows(){
        return rows;
    }
}

    

    
    
    
    

