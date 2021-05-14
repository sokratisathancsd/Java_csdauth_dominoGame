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
public class Solo1Test {
    
    public Solo1Test() {
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
     * Test of moves method, of class Solo1.
     */
    @Test
    public void testMoves() {
        System.out.println("moves");
        int round = 1;
        Solo1 instance = new Solo1(new TileStack());//The stack is sorted
        ArrayList<Integer> position=new ArrayList<>();
        position.add(0);
        position.add(0);
        position.add(0);
        instance.moves(position,round);//It adds the tile |3|6| in the table
        int result1=instance.getPlayArea().get(0).get_side1();
        int result2=instance.getPlayArea().get(0).get_side2();
        int expResult1=3;
        int expResult2=6;
        assertEquals(expResult1,result1);
        assertEquals(expResult2,result2); 
        round=2;
        position=new ArrayList<>();
        position.add(1);//The tile is |2|3| because the stack is sorted
        position.add(0);
        position.add(0);
        instance.moves(position,round);//It adds the tile |3|6| in the table
        result1=instance.getPlayArea().get(0).get_side1();
        result2=instance.getPlayArea().get(0).get_side2();
        expResult1=2;
        expResult2=3;
        assertEquals(expResult1,result1);
        assertEquals(expResult2,result2);
        round=3;
        position=new ArrayList<>();
        position.add(2);//The tile is |1|1| because the stack is sorted
        position.add(1);
        position.add(1);
        boolean result =instance.moves(position,round);//This move can't be done so it should return false
        boolean expResult=false;
        assertEquals(expResult,result);
    }

    /**
     * Test of checkEmptyLines method, of class Solo1.
     */
    @Test
    public void testCheckEmptyLines() {
        System.out.println("checkEmptyLines");
        Solo1 instance = new Solo1(new TileStack());// The stack is sorted
        int expResult = 4;
        int result = instance.checkEmptyLines();
        assertEquals(expResult, result);
    }

    /**
     * Test of checkAvailableMoves method, of class Solo1.
     */
    @Test
    public void testCheckAvailableMoves() {
        System.out.println("checkAvailableMoves");
        int count = 4;
        Tile testTile=new Tile(13,7);
        Solo1 instance = new Solo1(new TileStack());// The stack is sorted
        instance.getPlayArea().add(testTile);
        boolean expResult = false;
        boolean result = instance.checkAvailableMoves(count);
        assertEquals(expResult, result);
    }

  
    
}
