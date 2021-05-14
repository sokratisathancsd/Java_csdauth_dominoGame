/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

/**
 * Simulates an All-7 Domino game
 * @author Kwnstantinos Perrakis
 * @author Sokratis Athanasiadis
 * @version 1.1
 */
public class All7 {
    private ArrayList<Tile> table;
    private ArrayList<All7Player> players;
    private int turn;
    private TileStack gameStack;
    
    
    /**
     * The constructor creates the stack on each player 's hand
     * @param Stack the game stack of Tiles
     * @param numP is how many players are playing
     */
    public All7(TileStack Stack,int numP){
        gameStack=Stack;
        players=new ArrayList<>();
        int numTiles = 0;
        if(numP==2){
            numTiles=7;
         
        }
        else if(numP>2 && numP<=4){
            numTiles=5;
        }
        players.add(new All7Player(gameStack,numTiles));
        for(int i=0;i<numP-1;i++){
            players.add(new BotAll7(gameStack,numTiles));
        }
        table=new ArrayList<>();
        turn=startingPlayer();
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
     * Simulates when user is taking a Tile from the Stack
     * @return 1 if a Tile has been taken, 0 else.
     */
    public int playerdrawTile(){
        return players.get(0).drawTile(gameStack);
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
     * Checks if any player has available moves
     * @return true if one player has available moves
     */
     public boolean checkMoves(){
        boolean flag=false;
        int i=0;
        while(flag==false&&i<players.size()){
            if (players.get(i).checkAvailableMoves(table,gameStack))
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
        this.gameStack=gameStack;
        for(int i=0;i<players.size();i++){
         players.get(i).newTileStack(gameStack);
        }
        table=new ArrayList<>();
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
    
     /**
      * Returns a copy of the list of players
      * @return The copied list of players
      */  
    public ArrayList<All7Player> getPlayers(){
        ArrayList<All7Player> copy= new ArrayList<>();
        for(int i=0;i<players.size();i++){
            All7Player player=players.get(i);// The HungarianPlayer class has a copy constructor
            copy.add(player);
        }
        return copy;
    }
    
    /**
     * Returns whose turn is
     * @return the position of the player that is playing
     */
    public int getTurn(){
        return turn;
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
     * Checks if any player has more than 100 points and Returns The Winner
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
     * Returns the table
     * @return the table
     */
    public ArrayList<Tile> getTable(){
        return table;
    }
    
    
    /**
     * Returns the main game Stack of Tiles
     * @return the GameStack of Tiles
     */
    public TileStack getGameStack(){
        return gameStack;
    }
    
    /**
     * Simulates that a player is forced to draw Tiles as soon as he doesn't have a move, and there are more than 2 Tiles available on the game Stack of Tiles
     */
    public void PlayerAutoDraw(){
        int flag=1;
        while((flag==1)&&(players.get(turn).checkAvailableMoves(table,gameStack)==false)){
           flag= players.get(0).drawTile(gameStack);
        }
    }
    
    
    /**
    * This method performs the moves  by the player
    * @param i the selected tile
   */
    public void playerMoves(int i){
        ArrayList<Integer> position=new ArrayList<>();
        if(table.isEmpty()){//if table is empty, player can put any Tile he wants
            position.add(i);
            position.add(0);
            position.add(0);
            players.get(0).moves(table, position);
            changeTurn();
            return;
          
        }
       else if(table.get(0).get_side1()==0){ //If there's a 0 on any side of the table, player can add any Tile he wants (according to Rules Given)
            
            position.add(i);
            position.add(0);
            position.add(0);
            players.get(0).moves(table, position);
            changeTurn();
            return;
       }
       else if(table.get(table.size()-1).get_side2()==0){
           
           position.add(i);
           position.add(0);
           position.add(1);
           players.get(0).moves(table, position);
           changeTurn();
           return;
       }
       else if(players.get(0).checkBalader(i)==1){ //if the selected Tile is a Wildcard, player can added with no exemptions
           
           position.add(i);
           position.add(0);
           position.add(1);
           players.get(0).moves(table, position);
           changeTurn();
           return;
       }
       else{
        int sideRotate=players.get(0).chooseSideRotate(i, table.get(0), table.get(table.size()-1)); //checks if selected Tile needed to be reversed
        if (sideRotate==-1){
           return;
        }
        if (sideRotate<10){
           position.add(i);
           position.add(0);
           position.add(sideRotate);
           players.get(0).moves(table, position);
           changeTurn();
           return;
       }
       else if (sideRotate==10){
           position.add(i);
           position.add(1);
           position.add(0);
           players.get(0).moves(table, position);
           changeTurn();
           return;
       }
       else if (sideRotate==11){
           position.add(i);
           position.add(1);
           position.add(1);
           players.get(0).moves(table, position);
           changeTurn();
           return;  
       }
       }
        
    }
    
    /**
         * Performs moves by a Bot Player
         */
    public void botMoves(){
        if(turn==0 ){
            return;
        }
        int flag=1;
        while((flag==1)&&(players.get(turn).checkAvailableMoves(table,gameStack)==false)){
            flag=players.get(turn).drawTile(gameStack);
        }
        if (flag==0){
            changeTurn();
        }
        else if(players.get(turn).checkAvailableMoves(table,gameStack)==true){
            players.get(turn).moves(table, new ArrayList<>());
            changeTurn();
         }
        if(turn==0&&gameStack.getStack().size()<=2){
            changeTurn();
        }
        return ;
       }
       
      }
    
