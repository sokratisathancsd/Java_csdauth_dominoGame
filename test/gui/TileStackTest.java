/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import gui.TileStack;
import gui.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Konstantinos Perrakis
 * @author Sokratis Athanasiadis
 */
public class TileStackTest {
    
    public TileStackTest() {
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
     * Constructor test of TileStack Class
     */
    @Test
    public void TileStack(){
        TileStack instance= new TileStack();
        int expResult=28;
        int result=instance.getStack().size();
        assertEquals(expResult,result);
    }
    /**
     * Test of getTile method, of class TileStack.
     */
    @Test
    public void testGetTile() {
        System.out.println("getTile");
        TileStack instance = new TileStack();
        Tile aTile = new Tile(6,6);
        int expResult1=aTile.get_side1();
        Tile result = instance.getTile();
        int result1=result.get_side1();
        assertEquals(expResult1, result1);
        int expResult2=aTile.get_side2();
        int result2=result.get_side2();
        assertEquals(expResult2,result2);
        
    }
    
}