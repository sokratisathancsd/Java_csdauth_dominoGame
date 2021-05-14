
package gui;
import java.util.*;

/**
 * Simulates a Hungarian Mode Domino game
 * @author Sokratis Athanasiadis
 * @author Konstantinos Perrakis
 * @version 1.1
 * 
 */


public class HungarianMode {
    
    private ArrayList<Tile> table;
    private ArrayList<HungarianPlayer> players;
    private int turn;
    
    /**
     * The constructor creates the stack on each player 's hand
     * @param gameStack the game Stack of Tiles
     * @param numP is how many players are playing
     */
    public HungarianMode(TileStack gameStack,int numP){
        players=new ArrayList<>();
        int numTiles;
        if(numP==2){
           numTiles=12;  
        }
        else if(numP==3){
            numTiles=8;
        }
        else{
            numTiles=6;
        }
        players.add(new HungarianPlayer(gameStack,numTiles));
        for(int i=0;i<numP-1;i++){
            players.add(new Bot(gameStack,numTiles));
        }
        table=new ArrayList<>();
        turn=startingPlayer();
    } 
    
    /**
     * Checks if any player has available moves
     * @return true if one player has available moves
     */
    public boolean checkMoves(){
        boolean flag=false;
        int i=0;
        while(flag==false&&i<players.size()){
            if (players.get(i).checkAvailableMoves(table))
            {
                flag=true;
            }
            i++;
        }
        return flag;
    }
    
    
    /**
     * After the end of a round this method creates a new one
     * @param gameStack the game Stack of Tiles
     */
    public void newRound(TileStack gameStack){
        for(int i=0;i<players.size();i++){
         players.get(i).newTileStack(gameStack);
        }
        table=new ArrayList<>();
    }
    
    
    /**
     * Finds the player who will begin the game according to Hungarian Mode rules
     * @return the player that starts first
     * 
     */
    public int startingPlayer(){
       //test
       ArrayList<Integer> maxDouble=new ArrayList<>();
       for (int i=0;i<players.size();i++){
        maxDouble.add(players.get(i).checkMaxDouble());
       }
        int Max=maxDouble.get(0);
        int firstplay=0;
        for(int i=1;i<maxDouble.size();i++){
            if(maxDouble.get(i)>Max){
                Max=maxDouble.get(i);
                firstplay=i;
            }
        }
        if( Max!=-1){
           turn=firstplay;
           return firstplay;
       }
       else{
          Max=players.get(0).tilePoints();
          firstplay=0;
          for(int i=0;i<players.size();i++){
              if(players.get(i).tilePoints()>Max){
                  Max=players.get(i).tilePoints();
                  firstplay=i;
              }
          }
          turn=firstplay;
          return firstplay;
       }
    }
    
    /**
     * Simulates that a player is playing after another. Changes the turn
     */
    public void changeTurn(){
        turn=turn+1;
        if (turn>=players.size()){
            turn=0;
        }
    }
    
    public int getTurn(){
        return turn;
    }
    
    /**
     * Checks if any player has more than 100 points and Returns The Winner,
     * @return the number of the winner or -1 there is no winner
     */
     public int checkPoints(){
        boolean flag=false;
        int check=0;
        while(check<players.size()&&flag==false){
            if(players.get(check).getPoints()>=100){
                flag=true;
                continue;
            }
           check++;
        }
        if (flag==false){
            return -1;
        }
        int Min=0;
        for(int i=0;i<players.size();i++){
            if(players.get(i).getPoints()<players.get(Min).getPoints()){
                Min=i;
            }
        }
        return Min;
    }
     /**
      * Returns a copy of the list of players
      * @return The copied list of players
      */  
    public ArrayList<HungarianPlayer> getPlayers(){
        ArrayList<HungarianPlayer> copy= new ArrayList<>();
        for(int i=0;i<players.size();i++){
            HungarianPlayer player=players.get(i);// The HungarianPlayer class has a copy constructor
            copy.add(player);
        }
        return copy;
    }
     
    
    /**
     * Checks if someone's Tile Stack is empty
     * @return true if at least one stack is empty
     */
   public boolean emptyStacks(){
    int i=0;
    boolean flag=false;
    while (i<players.size()){
        if(players.get(i).isEmpty()==true){
            flag=true;
        }
        i++;
    }
    return flag;
    }
   
   /**
    * Prints all player Points
    * @return current game score
    */
   public ArrayList<String> getAllPlayersPoints(){
       ArrayList<String> temp=new ArrayList<>();
       for(int i=0;i<players.size();i++){
           temp.add("Player"+(i+1)+" Points: "+String.valueOf(players.get(i).getPoints()+"\n"));
       }
       return temp;
   }
    
    /**
    * Adds the points to a player
    * 
    */
    public void addPoints(){
        for(int i=0;i<players.size();i++){
        players.get(i).addPoints(players.get(i).handPoints());
        }
    }
    
    /**
     * Returns  the table
     * @return the table
     */
    public ArrayList<Tile> getTable(){
       
        return table;
    }
    
   /**
    * This method performs the moves  by the player
    * @param i the selected tile
   */
   public void playermoves(int i){
       if(players.get(turn).checkAvailableMoves(table)==false){
           changeTurn(); 
           return;
       }
       ArrayList<Integer> posistion=new ArrayList<>();
       if (table.isEmpty()){
           posistion.add(i);
           posistion.add(0);
           posistion.add(0);
           players.get(0).moves(table, posistion);
       }
       else {
       int sideRotate=players.get(0).chooseSideRotate(i, table.get(0), table.get(table.size()-1));
       if (sideRotate==-1){
           return;
       }
       if (sideRotate<10){
           posistion.add(i);
           posistion.add(0);
           posistion.add(sideRotate);
           players.get(0).moves(table, posistion);
       }
       else if (sideRotate==10){
           posistion.add(i);
           posistion.add(1);
           posistion.add(0);
           players.get(0).moves(table, posistion);
       }
       else if (sideRotate==11){
           posistion.add(i);
           posistion.add(1);
           posistion.add(1);
           players.get(0).moves(table, posistion);
           
       }
       }
       if (players.get(0).checkAvailableMoves(table)==false){
           changeTurn();
       }
   }
       
   
        /**
         * Performs moves by a Bot Player
         */
       public void botMoves(){
        if(turn==0 ){
            return;
        }
        else if(players.get(turn).checkAvailableMoves(table)==false){
            changeTurn();
            return;
        }
        while (players.get(turn).checkAvailableMoves(table)==true){
            players.get(turn).moves(table, new ArrayList<>());
        }
        changeTurn();
        if (turn==0){
            if (players.get(0).checkAvailableMoves(table)==false){
                changeTurn();// When the bot before the player plays we check for moves for the player, and if there is no available moves, we skip the player
            }
        }
       }
       
      }
   
   
   
 
    
    

