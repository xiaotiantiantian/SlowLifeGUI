/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhirun Tian
 */
public class MainPanelTest {
    
    public MainPanelTest() {
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
     * Test of getCellsSize method, of class MainPanel.
     */
    @Test
    public void testGetCellsSize() {
        System.out.println("getCellsSize");
        MainPanel instance = null;
        int expResult = 0;
        int result = instance.getCellsSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCells method, of class MainPanel.
     */
    @Test
    public void testSetCells() {
        System.out.println("setCells");
        Cell[][] cells = null;
        MainPanel instance = null;
        instance.setCells(cells);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCells method, of class MainPanel.
     */
    @Test
    public void testGetCells() {
        System.out.println("getCells");
        MainPanel instance = null;
        Cell[][] expResult = null;
        Cell[][] result = instance.getCells();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of backup method, of class MainPanel.
     */
    @Test
    public void testBackup() {
        System.out.println("backup");
        MainPanel instance = null;
        instance.backup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of debugPrint method, of class MainPanel.
     */
    @Test
    public void testDebugPrint() {
        System.out.println("debugPrint");
        MainPanel instance = null;
        instance.debugPrint();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class MainPanel.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        MainPanel instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class MainPanel.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        MainPanel instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of runContinuous method, of class MainPanel.
     */
    @Test
    public void testRunContinuous() {
        System.out.println("runContinuous");
        MainPanel instance = null;
        instance.runContinuous();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stop method, of class MainPanel.
     */
    @Test
    public void testStop() {
        System.out.println("stop");
        MainPanel instance = null;
        instance.stop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertToBoolean method, of class MainPanel.
     */
    @Test
    public void testConvertToBoolean() {
        System.out.println("convertToBoolean");
        Cell[][] cells = null;
        MainPanel instance = null;
        boolean[][] expResult = null;
        boolean[][] result = instance.convertToBoolean(cells);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of undo method, of class MainPanel.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MainPanel instance = null;
        instance.undo();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clear method, of class MainPanel.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MainPanel instance = null;
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of load method, of class MainPanel.
     */
    @Test
    public void testLoad() {
        System.out.println("load");
        ArrayList<String> lines = null;
        MainPanel instance = null;
        instance.load(lines);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
