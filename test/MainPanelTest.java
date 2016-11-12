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

    /**
     * Testing that backup is worked, the backed up result matches the expected
     * value of cells, if not same, the test would be fail.
     */
    @Test
    public void backupNewNotEmptyTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("backupNewNotEmpty");
        Field sizeField = mainpanel.getClass().getDeclaredField("_size");
        sizeField.setAccessible(true);

        int size = (int) sizeField.get(mainpanel);

        Field BackupCell = mainpanel.getClass().getDeclaredField("_cells");
        BackupCell.setAccessible(true);
        Cell[][] current_cells = (Cell[][]) BackupCell.get(mainpanel);
        mainpanel.backup();

        Field BackupCell2 = mainpanel.getClass().getDeclaredField("_cells");
        BackupCell2.setAccessible(true);
        Cell[][] current_backup = (Cell[][]) BackupCell2.get(mainpanel);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (current_cells[i][j].getAlive() != current_backup[i][j].getAlive()) {
                    fail("backup didn't match");
                }
            }
        }
    }

    /**
     * Testing that backup is worked stable. It means: I would give same input
     * to run the backup function twice and the result would be the same.
     */
    @Test
    public void backupStableTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        System.out.println("backupStable");
        Field sizeField = mainpanel.getClass().getDeclaredField("_size");
        sizeField.setAccessible(true);
        int size = (int) sizeField.get(mainpanel);
        
        MainPanel testPanel = new MainPanel(size);
        MainPanel testPanel2 = new MainPanel(size);
        Cell[][] cells = new Cell[size][size];
        Cell[][] cells2 = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                cells[i][j] = new Cell(true);
                cells2[i][j] = new Cell(true);

            }
        }
        testPanel.setCells(cells);
                testPanel.run();
        testPanel.undo();
        testPanel2.setCells(cells2);
        testPanel2.run();
        testPanel2.undo();

        assertEquals(testPanel.toString(), testPanel2.toString());
    }

}
