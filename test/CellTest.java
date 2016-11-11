/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zhirun Tian
 */
public class CellTest {

    public CellTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Cell. When the cell is alive, the
     * toString method should return "X".
     */
    @Test
    public void testToStringAlive() {
        System.out.println("toStringAlive");
        Cell testCellAlive = new Cell();
        testCellAlive.setText("X");
        assertEquals(testCellAlive.toString(), "X");

    }

    /**
     * Test of toString method, of class Cell. When the cell is dead, the
     * toString method should return ".".
     */
    @Test
    public void testToStringDead() {
        System.out.println("toStringDead");
        Cell testCellAlive = new Cell();
        testCellAlive.setText(".");
        assertEquals(testCellAlive.toString(), ".");

    }

    /**
     * Test of toString method, of class Cell. When the cell is alive in a
     * 2-dimension , the toString method should return ".".
     */
    @Test
    public void testToStringAlive2D() {
        System.out.println("toStringDead");
        Cell[][] testCellAlive2D = new Cell[10][10];
        testCellAlive2D[2][3] = new Cell();
        testCellAlive2D[2][3].setText("X");
        testCellAlive2D[2][3].setText("X");
        assertEquals(testCellAlive2D[2][3].toString(), "X");

    }

    //test constructor with/without "super" function
    /**
     * Test of constructor method, of class Cell. When the cell is built
     * in constructor without constructor ,then set it dead,  the toString method should return ".".
     */
    @Test
    public void testConstructorWithoutParameter() {
        System.out.println("ConstructorWithoutParameter");
        Cell testCell = new Cell();
        testCell.setText(".");
        assertEquals(testCell.toString(), ".");

    }

    
    /**
     * Test of constructor method, of class Cell. When the cell is built
     * in constructor with an parameter "true" then the method should return "X".
     */
    @Test
    public void testConstructorAliveWithParameter() {
        System.out.println("ConstructorWithParameterAlive");
        Cell testCell = new Cell(true);
        assertEquals(testCell.toString(), "X");

    }
    
        /**
     * Test of constructor method, of class Cell. When the cell is built
     * in constructor with an parameter "false" then the method should return " ".
     */
    @Test
    public void testConstructorDeadWithParameter() {
        System.out.println("ConstructorWithParameterDead");
        Cell testCell = new Cell(false);
        assertEquals(testCell.toString(), " ");

    }
}
