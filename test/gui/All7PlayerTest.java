/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Athan
 */
public class All7PlayerTest {
    
    public All7PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkBalader method, of class All7Player.
     */
    @Test
    public void testCheckBalader() {
       TileStack gameStack=new TileStack();
       All7Player instance=new All7Player(gameStack,28);// We create a player with 28 cards in his hand because we know that there will be a total of 4 Wildcards
       int count=0;
       for(int i=0;i<instance.GetTilesStack().size();i++){
           if(instance.checkBalader(i)==1){
               count++;
           }
       }
       int expResult=4;
       int result=count;
       assertEquals(expResult,result);
    }

    /**
     * Test of moves method, of class All7Player.
     */
    @Test
    public void testMoves() {
        System.out.println("moves");
        ArrayList<Integer> test=new ArrayList<>();
        ArrayList<Tile> table = new ArrayList<>();
        TileStack stack=new TileStack();        //  The stack is unshuffled.(|0|0|,|0|1|,...|5|6|,|6|6|)
        HungarianPlayer instance = new HungarianPlayer(stack,28);// Players stack is: |6|6|,|5|6|,|5|5|,...|2|6|,|2|5| because in order to create we remove tiles from the end of the stack
        Tile expResult=new Tile(6,6);
        test.add(0); 
        test.add(0);
        test.add(0);
        instance.moves(table,test);
        boolean flag=(expResult.get_side1()==table.get(0).get_side1())&&(expResult.get_side2()==table.get(0).get_side2());
        assertEquals(true,flag); // Class Tile has a copy constructor so the only way is to check each side manual  
        test=new ArrayList<>();
        test.add(14);// This Tile is the Tile 1|6 which is the firstr matching Tile 
        test.add(0);
        test.add(0);
        expResult=new Tile(1,6);
        instance.moves(table,test);
        flag=(expResult.get_side1()==table.get(0).get_side1())&&(expResult.get_side2()==table.get(0).get_side2());
        assertEquals(true,flag);
    }

   
       /**
     * Test of removeTile method, of class All7Player
     */
    @Test
    public void testRemoveTile() {
        System.out.println("removeTile");
        int i = 0;
        TileStack stack=new TileStack();
        All7Player instance =new All7Player(stack,7) ;
        Tile expResult;
        Tile result = instance.removeTile(i); //The method return a copy of the tile that has been removed
        if (instance.listSize()==i)// If i was the Last item(size=i+1). Then if the method works the new size should be i 
            assertTrue(true);
        else{
        expResult=instance.getTile(i);
        assertNotEquals(expResult,result);
    }
    }
    

    

    /**
     * Test of addPoints method, of class All7Player.
     */
    @Test
    public void testAddPoints() {
       System.out.println("addPoints");
        int points = 5;
        TileStack stack=new TileStack();
        stack.shuffledStuck();
        All7Player instance = new All7Player(stack,7);
        instance.addPoints(points);
        int expResult=5;
        int result=instance.getPoints();
        assertEquals(expResult,result);
        points=0;
        instance.addPoints(points);
        expResult=5;
        result=instance.getPoints(); 
        assertEquals(expResult,result);
        points=50;
        instance.addPoints(points);
        expResult=55;
        result=instance.getPoints(); 
        assertEquals(expResult,result);
        
    }


    /**
     * Test of newTileStack method, of class All7Player.
     */
    @Test
    public void testNewTileStack() {
        TileStack gameStack=new TileStack();
        gameStack.shuffledStuck();// We shuffle the stack
        All7Player instance = new All7Player(gameStack,7);
        gameStack=new TileStack();
        gameStack.shuffledStuck();
        instance.newTileStack(gameStack);
        ArrayList<Tile> expResult=new ArrayList<>();
        ArrayList<Tile> result=new ArrayList<>();
        for(int i=0;i<7;i++){
            expResult.add(instance.getTile(i));
        }
        instance.newTileStack(new TileStack ());
        for(int i=0;i<7;i++){
            result.add(instance.getTile(i));
        }
        assertNotEquals(expResult,result);
    }

    /**
     * Test of checkMaxDouble method, of class All7Player.
     */
    @Test
    public void testCheckMaxDouble() {
       TileStack stack=new TileStack();
        All7Player instance = new All7Player(stack,7);
        int expResult =6;// The starting stuck is unshuffled and to create the Players stack we remove from the end so the biggest double is 6
        int result = instance.checkMaxDouble();
        assertEquals(expResult, result);
    }

    /**
     * Test of handPoints method, of class All7Player.
     */
    @Test
    public void testHandPoints() {
         TileStack stack=new TileStack();//The stuck is sorted
        All7Player instance = new All7Player(stack,7);
        int expResult =69 ;
        int result = instance.handPoints();
        assertEquals(expResult, result);
    }

    /**
     * Test of tilePoints method, of class All7Player.
     */
    @Test
    public void testTilePoints() {
         TileStack stack=new TileStack();//The stack is sorted
        All7Player instance = new All7Player(stack,7);
        int expResult =12 ; // The list is unshuffled and the players stack starts removing from the end so the biggest is 6+6
        int result = instance.tilePoints();
        assertEquals(expResult, result);
    }



    /**
     * Test of drawTile method, of class All7Player.
     */
    @Test
    public void testDrawTile() {
        System.out.println("drawTile");
        TileStack startingStack = new TileStack();
        All7Player instance = new All7Player(startingStack,7);
        int expResult = 8;
        instance.drawTile(startingStack);
        int result = instance.GetTilesStack().size();
        assertEquals(expResult, result);
           }

    /**
     * Test of chooseSideRotate method, of class All7Player.
     */
    @Test
    public void testChooseSideRotate() {
         System.out.println("chooseSideRotate");
        int i = 0;
        Tile firsttile = new Tile(1,4);
        Tile lasttile = new Tile(4,6);
        TileStack stack=new TileStack();
        All7Player instance = new All7Player(stack,7);
        int expResult = 0;
        int result = instance.chooseSideRotate(1, firsttile, lasttile);
        assertEquals(expResult, result);
        firsttile = new Tile(4,3);
        lasttile = new Tile(0,2);
        stack=new TileStack();
        instance = new All7Player(stack,7);
        expResult = 1;
        result = instance.chooseSideRotate(1, firsttile, lasttile);
        assertEquals(expResult, result);
        firsttile = new Tile(2,3);
        lasttile = new Tile(0,5);
        stack=new TileStack();
        instance = new All7Player(stack,7);
        expResult = 10;
        result = instance.chooseSideRotate(1, firsttile, lasttile);
        assertEquals(expResult, result);
        firsttile = new Tile(4,5);
        lasttile = new Tile(0,1);
        stack=new TileStack();
        instance = new All7Player(stack,7);
        expResult = 11;
        result = instance.chooseSideRotate(1, firsttile, lasttile);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAvailableMoves method, of class All7Player.
     */
    @Test
    public void testCheckAvailableMoves() {
      System.out.println("checkAvailableMoves");
        ArrayList<Tile> table = new ArrayList<>();
        TileStack stack=new TileStack();
        All7Player instance = new All7Player(stack,7);
        table.add(new Tile(2,2));
        boolean result=instance.checkAvailableMoves(table,stack);
        boolean expResult=true;
        assertEquals(expResult,result);
        table.remove(0);
        table.add(new Tile(15,15));   // This tile doesn't exist on any stack
        expResult = false;
        result=instance.checkAvailableMoves(table,null);
        assertEquals(expResult, result);
    }
    
    
    
}
