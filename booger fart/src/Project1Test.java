import itsc2214.*;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit tests for Project1 class.
 * 
 * @author Pierce Ransdell
 * @version Jan 20, 2025
 */
public class Project1Test {
    private Project1 runner;

    @Before
public void setUp() {
    runner = new Project1(1);
}
    
    /**
     * Test adding a value to the array.
     * @author Pierce Ransdell
     */
    @Test
    public void testAddValue() {
        runner = new Project1(2);
        runner.addValue(10);
        runner.addValue(20);
        assertEquals(10, runner.getValue(0));
        assertEquals(20, runner.getValue(1));
    }

    /**
     * Testing exception thrown by adding too many values to an array.
     * @author Pierce Ransdell
     */
    @Test(expected = IllegalStateException.class)
    public void testAddValueExcpetion(){
        runner.addValue(1);
        runner.addValue(1);
    }

    /**
     * Test getting the minimum value from the array.
     * @author Pierce Ransdell
     */
    @Test
    public void testGetMinimum() {
        runner = new Project1(5);
        runner.addValue(17);
        runner.addValue(5);
        runner.addValue(15);
        runner.addValue(10);
        assertEquals("Minimum value should be 5.", 5, runner.getMinimum());

        // Test empty array
        runner = new Project1(5); // Reset to a new, empty array
        assertEquals(Integer.MIN_VALUE, runner.getMinimum());
    }

    /**
     * Test getting the maximum value from the array.
     * @author Pierce Ransdell
     */
    @Test
    public void testGetMaximum() {
        runner = new Project1(5);
        runner.addValue(5);
        runner.addValue(15);
        runner.addValue(10);
        assertEquals(15, runner.getMaximum());

        // Test empty array
        runner = new Project1(5); // Reset to a new, empty array
        assertEquals(Integer.MAX_VALUE, runner.getMaximum());
    }

    /**
     * Test setting a value in the array.
     * @author Pierce Ransdell
     */
    @Test
    public void testSetValue() {
        runner = new Project1(2);
        runner.addValue(5);
        runner.addValue(10);
        assertEquals(10, runner.setValue(1, 20));
        assertEquals(20, runner.getValue(1));

    }
    /**
     * Testing error handling for trying to change the value of an index that doesnt exist.
     * @author Pierce Ransdell
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testSetValueException(){
        runner = new Project1(1);
        runner.setValue(2,50);
    }
    
    /**
     * Test checking if the array is empty or full.
     * @author Pierce Ransdell
     */
    @Test
    public void testIsFull() {
        runner = new Project1(1);
        assertFalse(runner.isFull());
        runner.addValue(1);
        assertTrue(runner.isFull());
    }

    /**
     * Test for checking duplicates in the array.
     * @author Pierce Ransdell
     */
    @Test
    public void testHasDuplicates() {
        runner =new Project1(4);
        runner.addValue(10);
        runner.addValue(20);
        runner.addValue(10);
        assertTrue("Array should have duplicates.", runner.hasDuplicates());

        runner = new Project1(5); // Reset to a new array
        runner.addValue(10);
        runner.addValue(20);
        assertFalse("Array should not have duplicates.", runner.hasDuplicates());
    }

    /**
     * Test checking if GetAverage() returns the average in the arrayList.
     * @author Pierce Ransdell
     */
    @Test
    public void testGetAverage() {
        runner = new Project1(3);
        runner.addValue(1);
        runner.addValue(2);
        runner.addValue(3);
        assertTrue(runner.getAverage() == 2);
    }
    /**
     * Testing error handling for the average of an array with no values
     * @author Pierce Ransdell
     */
    @Test(expected = IllegalStateException.class)
    public void testGetAverageException(){
        runner = new Project1(1);
        runner.getAverage();
    }

    /**
     * Test checking if getRange() returns the range of the arrayList.
     * @author Pierce Ransdell
     */
    @Test
    public void testGetRange() {
        runner = new Project1(4);
        runner.addRandom(4);
        assertTrue(runner.getMaximum() - runner.getMinimum() == runner.getRange());
    }

    /**
     * Test checking if size() returns the size of the arraylist. NOT CAPACITY.
     * @author Pierce Ransdell
     */
    @Test
    public void testSize() {
        runner = new Project1(5);
        runner.addValue(1);
        assertTrue(runner.size() == 1);
    }

    /**
     * Test checking if getCapacity() returns the capacity of the arrayList.
     * @author Pierce Ransdell
     */
    @Test
    public void testCapacity() {
        runner = new Project1(8);
        assertTrue(runner.getCapacity() == 8);
    }

    /**
     * Test checking if getValue() returns the value associated to the index passed.
     * @author Pierce Ransdell
     */
    @Test
    public void testGetValue() {
        runner = new Project1(1);
        runner.addValue(5);
        assertTrue(runner.getValue(0) == 5);
    }
    /**
     * Test error handling for getting value at an index that doesnt exist. 
     * @author Pierce Ransdell
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetValueException(){
        runner = new Project1(1);
        runner.getValue(65);
    }

    /**
     * Test checking if addRandom() adds the specified random values to the arraylist.
     * @author Pierce Ransdell
     */
    @Test
    public void testAddRandom() {
        runner = new Project1(5);
        runner.addRandom(5);
        assertEquals(5, runner.size());
        for (int i = 0; i < runner.size(); i++) {
            assertTrue(runner.getValue(i) >= 0 && runner.getValue(i) <= 99);
        }
    }
    /**
     * Testing Errror handing for adding random values to out of bounds indexes. 
     * @author Pierce Ransdell
     */
    @Test(expected = IllegalStateException.class)
    public void testAddRandomException(){
        runner = new Project1(1);
        runner.addRandom(2);
    }

    /**
     * Test checking if removeValueAt() removes the specified value from the arraylist.
     * @author Pierce Ransdell
     */
    @Test
    public void testRemoveValueAt() {
        runner = new Project1(2);
        runner.addValue(7);
        runner.addValue(5);
        int initialSize = runner.size();
        runner.removeValueAt(1);
        assertEquals(initialSize, runner.size() + 1);
    }
    /**
     * Testing removing a value at an index that doesnt exist
     * @author Pierce Ransdell
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testRemoveValueAtException(){
        runner = new Project1(4);
        runner.removeValueAt(5);
    }
    /**
     * Test checking if isEmpty() returns the true state of an empty/full array.
     * @author Pierce Ransdell
     */
    @Test
    public void testIsEmpty() {
        runner = new Project1(1);
        assertTrue(runner.isEmpty());
        runner.addValue(9999);
        assertFalse(runner.isEmpty());
    }
}
