/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Athan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({gui.BotTest.class, gui.Solo1Test.class, gui.HungarianPlayerTest.class, gui.TileTest.class,  gui.All7Test.class, gui.All7PlayerTest.class, gui.TileStackTest.class, gui.HungarianModeTest.class, gui.BotAll7Test.class})
public class GuiSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
