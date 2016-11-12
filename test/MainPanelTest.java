/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
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

    MainPanel mainpanel;

    public MainPanelTest() {
    }

    @Before
    public void setUp() {
        mainpanel = new MainPanel(20);
    }

    @After
    public void tearDown() {
    }

    //firstly test the convertToInt method
    /**
     * Test of ConvertToInt method, of class MainPanel. If the input is a zero,
     * the return is also a zero
     */
    @Test
    public void testConvertToIntZero() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("ConvertToIntZero");
        Method method;
        try {
            Class[] argTypes = new Class[]{int.class};
            method = MainPanel.class.getDeclaredMethod("convertToInt", argTypes);
            method.setAccessible(true);
            Object returnValue = method.invoke(mainpanel, 0);
            int result = ((Integer) returnValue).intValue();
            assertEquals(0, result);
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of ConvertToInt method, of class MainPanel. If the input is a
     * positive 1, the return is also a positive 1
     */
    @Test
    public void testConvertToIntPositive() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("ConvertToIntPositiveOne");
        Method method;
        try {
            Class[] argTypes = new Class[]{int.class};
            method = MainPanel.class.getDeclaredMethod("convertToInt", argTypes);
            method.setAccessible(true);
            Object returnValue = method.invoke(mainpanel, 1);
            int result = ((Integer) returnValue).intValue();
            assertEquals(1, result);
        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }

    }

    /**
     * Test of ConvertToInt method, of class MainPanel. If the input is a
     * negative one, the return is also a negative one.
     */
    @Test
    public void testConvertToIntNegative() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        System.out.println("ConvertToIntNegative");
        Method method;
        try {
            Class[] argTypes = new Class[]{int.class};
            method = MainPanel.class.getDeclaredMethod("convertToInt", argTypes);
            method.setAccessible(true);
            Object returnValue = method.invoke(mainpanel, -1);
            int result = ((Integer) returnValue).intValue();
            assertEquals(-1, result);

        } catch (NoSuchMethodException e) {
            fail(e.getMessage());
        }

    }

    //then test the backup method
    /**
     * Testing that backup works when the _backupCells array is just constructed
     * and has nothing inside.
     */
    @Test
    public void backupBeforeAfterTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("backupBeforeAfter");

        Field BackupCell = mainpanel.getClass().getDeclaredField("_backupCells");
        BackupCell.setAccessible(true);
        boolean[][] before = (boolean[][]) BackupCell.get(mainpanel);
        mainpanel.backup();
        boolean[][] after = (boolean[][]) BackupCell.get(mainpanel);
        assertNotEquals(before, after);

    }

    /* Testing that backup matches the value of cells
		 * for a small board and backup
     */
    @Test
    public void backupNewNotEmptyTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("backupNewNotEmpty");

//        try {
        Field BackupCell = mainpanel.getClass().getDeclaredField("_cells");
        BackupCell.setAccessible(true);
        Cell[][] current_cells = (Cell[][]) BackupCell.get(mainpanel);
        mainpanel.backup();

        Field BackupCell2 = mainpanel.getClass().getDeclaredField("_cells");
        BackupCell2.setAccessible(true);
        Cell[][] current_backup = (Cell[][]) BackupCell2.get(mainpanel);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (current_cells[i][j].getAlive() != current_backup[i][j].getAlive()) {
                    fail("backup didn't match");
                }
            }
        }
//        } catch (Exception e) {
//            fail(e.toString());
//        }
    }

//    
//
//    /**
//     * Testing that backup works when it use cell as a unit or boolean as a unit
//     */
//    @Test
//    public void backupCellvsBoolean() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
//        Field _cell = mainpanel.getClass().getDeclaredField("_cells");
//        _cell.setAccessible(true);
//        Cell[][] before = (Cell[][]) _cell.get(mainpanel);
//        Cell[][] _backupCells;
//        int _size = 15;
//        _backupCells = new Cell[_size][_size];
//        for (int j = 0; j < _size; j++) {
//            for (int k = 0; k < _size; k++) {
//                _backupCells[j][k] = new Cell();
//                _backupCells[j][k].setAlive(before[j][k].getAlive());
//            }
//        }
//
//        mainpanel.backup();
//
//        Field BackupCell = mainpanel.getClass().getDeclaredField("_backupCells");
//        BackupCell.setAccessible(true);
//        boolean[][] after = (boolean[][]) BackupCell.get(mainpanel);
//        
//        
//
//    }
//
//}
