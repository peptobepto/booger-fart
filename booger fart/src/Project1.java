import itsc2214.*;
import java.util.Random;

/**
 * Class to manage a fixed-size array with operations like adding values,
 * computing stats, and managing capacity.
 * 
 * @author Pierce Ransdell
 * @version Jan 23, 2025
 */
public class Project1 implements ArrayInt {
    private int[] numCollection; // Internal array
    private int capacity;        // Fixed capacity of the array
    private int size;            // Current number of elements in the array

    // Constructor
    public Project1(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.numCollection = new int[capacity];
        this.size = 0; // Start with an empty array
    }

    
    public int getMinimum() {
        if (size == 0) {
            return Integer.MIN_VALUE; // Special case: empty array
        }
        int small = numCollection[0];
        for (int i = 1; i < size; i++) {
            if (numCollection[i] < small) {
                small = numCollection[i];
            }
        }
        return small;
    }

    
    public int getMaximum() {
        if (size == 0) {
            return Integer.MAX_VALUE; // Special case: empty array
        }
        int large = numCollection[0];
        for (int i = 1; i < size; i++) {
            if (numCollection[i] > large) {
                large = numCollection[i];
            }
        }
        return large;
    }

    
    public double getAverage() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty. Cannot compute average.");
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += numCollection[i];
        }
        return (double) sum / size;
    }

    
    public int getRange() {
        return getMaximum() - getMinimum();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void addValue(int value) {
        if (size >= capacity) {
            throw new IllegalStateException("Array is full.");
        }
        numCollection[size] = value;
        size++;
    }

    @Override
    public int getValue(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        return numCollection[index];
    }


    @Override
    public int setValue(int index, int value) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        int oldValue = numCollection[index]; // Store the old value
        numCollection[index] = value;       // Set the new value
        return oldValue;                    // Return the old value
    }

    @Override
    public void addRandom(int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            if (size >= capacity) {
                throw new IllegalStateException("Array is full.");
            }
            addValue(rand.nextInt(100)); // Add random values between 0 and 99
        }
    }

    @Override
    public void removeValueAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }
        for (int i = index; i < size - 1; i++) {
            numCollection[i] = numCollection[i + 1]; // Shift values down
        }
        size--;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public boolean hasDuplicates() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (numCollection[i] == numCollection[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
