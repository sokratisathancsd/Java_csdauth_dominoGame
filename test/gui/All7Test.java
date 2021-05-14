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
public class All7Test {
    
    public All7Test() {
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
     * Test of startingPlayer method, of class All7.
     */
    @Test
    public void testStartingPlayer() {
          TileStack temp=new TileStack();//The stack is sorted
        All7 instance = new All7(temp,2);
        int expResult = 0;
        int result = instance.startingPlayer();
        assertEquals(expResult, result);
    }

   

    
    /**
     * Test of checkMoves method, of class All7.
     */
    @Test
    public void testCheckMoves() {
       System.out.println("checkMoves");
        TileStack gameStack=new TileStack();
        All7 instance = new All7(gameStack,2);;
        boolean expResult = true;
        boolean result = instance.checkMoves();
        assertEquals(expResult, result);
        instance.getTable().add(new Tile(7,8));//this Tile does not exists!
        expResult=false;
        instance.getPlayers().get(1).removeTile(1);//We remove those 2 Tiles, because they are Wildcards(Ballader)
        instance.getPlayers().get(1).removeTile(3);
        result = instance.checkMoves();
        assertEquals(expResult, result);
    }

    /**
     * Test of newRound method, of class All7.
     */
    @Test
    public void testNewRound() {
        TileStack gameStack=new TileStack();
        gameStack.shuffledStuck();
        All7 instance = new All7(gameStack,2);
        ArrayList<ArrayList<Tile>> k=new ArrayList<>();
        for (int i=0;i<instance.getPlayers().size();i++){
            k.add(instance.getPlayers().get(i).GetTilesStack());
        }
        gameStack=new TileStack();
        gameStack.shuffledStuck();
        instance.newRound(gameStack);
        for (int i=0;i<k.size();i++){
        assertNotEquals(k.get(i),instance.getPlayers().get(i).GetTilesStack());
        }
        assertEquals(true,instance.getTable().isEmpty());
    }
    

    

   
   
    /**
     * Test of checkPoints method, of class All7.
     */
    @Test
    public void testCheckPoints() {
        All7 instance = new All7(new TileStack(),2);
        int result = instance.checkPoints();
        assertEquals(-1, result);
        instance.addPoints();
        instance.addPoints();
        result=instance.checkPoints();
        assertEquals(1,result);
    }

    
   
    

    

    /**
     * Test of PlayerAutoDraw method, of class All7.
     */
    @Test
    public void testPlayerAutoDraw() {
        System.out.println("PlayerAutoDraw");
        TileStack gameStack= new TileStack();
        All7 instance = new All7(gameStack,2);
        instance.getTable().add(new Tile(9,6));
        instance.PlayerAutoDraw();
        int expResult=9;//he will have to draw three times, because the first Tile is (2,2) obviously doesn't change the situation, but however the 2nd Tile (1,6) will make the round playable for him.
        int result=instance.getPlayers().get(0).GetTilesStack().size();
        assertEquals(expResult,result);
    }

    /**
     * Test of playermoves method, of class All7
     */
    @Test
    public void testPlayermoves() {
     /**
      * This method uses other methods which are already tested
      */
    }

    /**
     * Test of botMoves method, of class All7
     */
    @Test
    public void testBotMoves() {
       /**
        * This method uses other methods which are already tested.
        */
    
    }
}
