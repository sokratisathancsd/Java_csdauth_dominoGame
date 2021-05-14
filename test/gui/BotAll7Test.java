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
public class BotAll7Test {
    
    public BotAll7Test() {
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
     * Test of searchtile method, of class BotAll7.
     */
    @Test
    public void testSearchtile() {
        ArrayList<Tile> table = new ArrayList<>();
        TileStack game=new TileStack();
        BotAll7 instance = new BotAll7(game,7);
        Tile expResult=new Tile(6,6);  //The list isn't shuffled and we know that the bot selects the 1st Tile at the beginning
        ArrayList<Integer> test;
        test=instance.searchtile(table);
        Tile result=instance.getTile(test.get(0));
        assertEquals(expResult.get_side1(),result.get_side1());
        assertEquals(expResult.get_side2(),result.get_side2());
        table.add(new Tile(2,2));
        test=instance.searchtile(table);
        expResult=new Tile(6,5);//We know that the first tile that fits is the 4th(because we haven't shuffled the list) and it should be reversed
        if (test.get(1)==1){
            instance.getTile(test.get(0)).swap_sides();
        }
        result=instance.getTile(test.get(0));
        assertEquals(expResult.get_side1(),result.get_side1());
        assertEquals(expResult.get_side2(),result.get_side2());
        Integer expResult1=0;  // The tile should be placed on the left side
        Integer result1=test.get(2);
        assertEquals(expResult1,result1);
        table=new ArrayList<>();// We empty the table
        table.add(new Tile(10,10));// This is a tile that doen't exist so no available moves should be found
        test=instance.searchtile(table);
        ArrayList<Integer> expResult2=null;
        assertEquals(expResult2,test);
    }

   
}
