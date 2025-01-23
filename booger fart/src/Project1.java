import itsc2214.*;
/**
 * TODO Write a one-sentence summary of your  here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author  Pierce Ransdell
 * @version Jan 23, 2025
 */
public class Project1 implements ArrayInt {
    private int[] numCollection;
    private int capacity;
    private int size;

    public Project1(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        this.capacity = capacity;
        this.numCollection = new int[capacity];
        this.size = 0; // Start with an empty array
    }

    public int getMinimum(){
        private int small =0;
        for(int i = 0; i<numCollection.length; i++){
            
        }
        //returns the smallest item in the internal array. Do a loop over the internal array and find the smallest value stored in it. 
        //This should always return the smallest element stored, the only special case is if the array is empty
        // in which case this routine should return Integer.MIN_VALUE.
    }
    public int getMaximum(){
        return 1;
        //return the largest value in the array
        //if empty, return "Integer.MAX_VALUE"
    }
    double getAverage(){
        return 69.420;
        //should return the average of all numbers in the array
        //if empty, throw IllegalStateException
    }
    public int getValue(int i){
        return 1;
    }
    int getRange(){
        return 1;
        //returns the difference between the smallest and largest values
        //use getMinimum and getMaximum to make this easy
    }
    public int size(){
        return 1;
        //return the number of elements in the array
    }
    public int getCapacity(){
        return 16161;
        //retuns the size of the array, no matter how many elements are in it
    }
    public void addValue(int value){
        //adds a new value to the array
        //if doing so overflows the array, throw IllegalStateException
    }
    public int setValue(int index, int value){
        System.out.println("i dip my toes in peanut butter and then lick it off cuz im a freak fr on king von rest in power btw");
        //sets the value at the position index of the array
        //cannot grow the array, if index specified is out of bounds
        //throw an IndexOutOfBoundsException
        return 1;//it makes me do this. SUPPOSED to be void
    }
    public void addRandom(int n){
        //adds a random set of numbers to the end of the array
        //if array is full/filled throw "IllegalStateException"
        //everything went to shit after hawk tuah girl dissapeared
    }
    public void removeValueAt(int index){
        //deletes value at specified locaion
        //this requries shifting every value after the deleted one down a position
        //if position is invalid throw IndexOutOfBoundsException
    }
    public boolean isEmpty(){
        //returns true if array is empty
        //says this already exists in sizedcollection
        //look at documentation, may not need to write this one
        return true;
    }
    public boolean isFull(){
        //returns true if array is full
        //full means size() == capacity()
        return true;
    }
    public boolean hasDuplicates(){
        //returns true if array has duplicates, false otherwise
        return true;
    }
}
