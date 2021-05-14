/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
public class TileTest {
    
    public TileTest() {
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
     * Test of swap_sides method, of class Tile.
     */
    @Test
    public void testSwap_sides() {
        System.out.println("swap_sides");
        Tile instance = new Tile(1,2);
        int expResultSide_1=instance.get_side1();
        int expResultSide_2=instance.get_side2();
        instance.swap_sides();
        int resultSide_1=instance.get_side1();
        int resultSide_2=instance.get_side2();
        assertEquals(expResultSide_1,resultSide_2);
        assertEquals(expResultSide_2,resultSide_1);
    }

    /**
     * Test of get_side1 method, of class Tile.
     */
    @Test
    public void testGet_side1() {
        System.out.println("get_side1");
        Tile instance = new Tile(1,2);
        int expResult=1;
        int result=instance.get_side1();
        assertEquals(expResult,result);
    }

    /**
     * Test of get_side2 method, of class Tile.
     */
    @Test
    public void testGet_side2() {
        System.out.println("get_side2");
        Tile instance = new Tile(1,2);
        int expResult=2;
        int result=instance.get_side2();
        assertEquals(expResult,result);
    }
    
}
