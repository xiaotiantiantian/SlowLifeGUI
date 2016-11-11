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
     * Testing that backup still works correctly when the _backupCells array is
     * initially empty
     */
    @Test
    public void backupEmptyTest() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Field BackupCell = mainpanel.getClass().getDeclaredField("_backupCells");
        BackupCell.setAccessible(true);
        boolean[][] before = (boolean[][]) BackupCell.get(mainpanel);
        mainpanel.backup();
        boolean[][] after = (boolean[][]) BackupCell.get(mainpanel);
        assertNotEquals(before, after);

    }

}
