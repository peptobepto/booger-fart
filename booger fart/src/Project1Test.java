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

    /**
     * setup() method, runs before each of your test methods.
     * Use this method to recreate the objects needed for
     * testing your class.
     */
    @Before
    public void setup() {
        runner = new Project1(5); // Initialize with a capacity of 5
    }

    /**
     * Test Constructor with valid and invalid inputs.
     */
    @Test
    public void testConstructor() {
        // Test valid constructor
        Project1 validRunner = new Project1(10);
        assertEquals("Capacity should be 10", 10, validRunner.getCapacity());

        // Test invalid constructor
        try {
            Project1 invalidRunner = new Project1(0);
            fail("Expected IllegalArgumentException for capacity <= 0.");
        } catch (IllegalArgumentException e) {
            assertEquals("Capacity must be greater than 0.", e.getMessage());
        }
    }

    /**
     * Test adding a value to the array.
     */
    @Test
    public void testAddValue() {
        runner.addValue(10);
        runner.addValue(20);
        assertEquals("Size should be 2 after adding two values.", 2, runner.size());
        assertEquals("Value at index 0 should be 10.", 10, runner.getValue(0));
        assertEquals("Value at index 1 should be 20.", 20, runner.getValue(1));

        // Test overflow
        try {
            runner.addValue(30);
            runner.addValue(40);
            runner.addValue(50);
            runner.addValue(60); // This should throw an exception
            fail("Expected IllegalStateException for adding value to a full array.");
        } catch (IllegalStateException e) {
            assertEquals("Array is full.", e.getMessage());
        }
    }

    /**
     * Test getting the minimum value from the array.
     */
    @Test
    public void testGetMinimum() {
        runner.addValue(5);
        runner.addValue(15);
        runner.addValue(10);
        assertEquals("Minimum value should be 5.", 5, runner.getMinimum());

        // Test empty array
        runner = new Project1(5); // Reset to a new, empty array
        assertEquals("Minimum value for an empty array should be Integer.MIN_VALUE.",
                Integer.MIN_VALUE, runner.getMinimum());
    }

    /**
     * Test getting the maximum value from the array.
     */
    @Test
    public void testGetMaximum() {
        runner.addValue(5);
        runner.addValue(15);
        runner.addValue(10);
        assertEquals("Maximum value should be 15.", 15, runner.getMaximum());

        // Test empty array
        runner = new Project1(5); // Reset to a new, empty array
        assertEquals("Maximum value for an empty array should be Integer.MAX_VALUE.",
                Integer.MAX_VALUE, runner.getMaximum());
    }

    /**
     * Test setting a value in the array.
     */
    @Test
    public void testSetValue() {
        runner.addValue(5);
        runner.addValue(10);
        assertEquals("Old value at index 1 should be 10.", 10, runner.setValue(1, 20));
        assertEquals("New value at index 1 should be 20.", 20, runner.getValue(1));

        // Test out-of-bounds
        try {
            runner.setValue(5, 30);
            fail("Expected IndexOutOfBoundsException for invalid index.");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index is out of bounds.", e.getMessage());
        }
    }

    /**
     * Test checking if the array is empty or full.
     */
    @Test
    public void testIsEmptyAndIsFull() {
        assertTrue("Array should be empty initially.", runner.isEmpty());
        runner.addValue(10);
        assertFalse("Array should not be empty after adding a value.", runner.isEmpty());

        for (int i = 0; i < 5; i++) {
            if (!runner.isFull()) {
                runner.addValue(i);
            }
        }
        assertTrue("Array should be full after filling all slots.", runner.isFull());
    }

    /**
     * Test for checking duplicates in the array.
     */
    @Test
    public void testHasDuplicates() {
        runner.addValue(10);
        runner.addValue(20);
        runner.addValue(10);
        assertTrue("Array should have duplicates.", runner.hasDuplicates());

        runner = new Project1(5); // Reset to a new array
        runner.addValue(10);
        runner.addValue(20);
        assertFalse("Array should not have duplicates.", runner.hasDuplicates());
    }
}
