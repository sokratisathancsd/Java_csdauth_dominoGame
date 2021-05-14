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
public class HungarianModeTest {
    
    public HungarianModeTest() {
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
     * Test of checkMoves method, of class HungarianMode.
     */
    @Test
    public void testCheckMoves() {
        System.out.println("checkMoves");
        TileStack gameStack=new TileStack();
        HungarianMode instance = new HungarianMode(gameStack,2);;
        boolean expResult = true;
        boolean result = instance.checkMoves();
        assertEquals(expResult, result);
        instance.getTable().add(new Tile(7,8));//this Tile does not exists!
        expResult=false;
        result = instance.checkMoves();
        assertEquals(expResult, result);

    }

    /**
     * Test of newRound method, of class HungarianMode.
     */
    @Test
    public void testNewRound() {
       
        TileStack gameStack=new TileStack();
        gameStack.shuffledStuck();
        HungarianMode instance = new HungarianMode(gameStack,2);
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
     * Test of startingPlayer method, of class HungarianMode.
     */
    @Test
    public void testStartingPlayer() {
        TileStack temp=new TileStack();//The stack is sorted
        HungarianMode instance = new HungarianMode(temp,2);
        int expResult = 0;
        int result = instance.startingPlayer();
        assertEquals(expResult, result);
    }

    

   

    /**
     * Test of checkPoints method, of class HungarianMode.
     */
    @Test
    public void testCheckPoints() {
        HungarianMode instance = new HungarianMode(new TileStack(),2);
        int result = instance.checkPoints();
        assertEquals(-1, result);
        instance.addPoints();
        instance.addPoints();
        result=instance.checkPoints();
        assertEquals(1,result);
        
    }
 

    

    /**
     * Test of playermoves method, of class HungarianMode.
     */
    @Test
    public void testPlayermoves() {
     /**
      * This method uses other methods which are already tested
      */
    }

    /**
     * Test of botMoves method, of class HungarianMode.
     */
    @Test
    public void testBotMoves() {
       /**
        * This method uses other methods which are already tested.
        */
    
    }
}
