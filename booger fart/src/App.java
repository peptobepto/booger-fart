import itsc2214.*;
/**
 * TODO Write a one-sentence summary of your  here.
 * TODO Follow it with additional details about its purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author  TODO Put Your Name in the author tag
 * @version Jan 27, 2025
 */
public class App {
    public static void main(String[] args) throws Exception 
    {
        Project1 numCollection = new Project1(100);
        numCollection.addRandom(50);  // adds 50 numbers randomly selected
        System.out.println("Size = "+numCollection.size());
        System.out.println("Smallest = "+numCollection.getMinimum());
        System.out.println("Largest = "+numCollection.getMaximum());
        System.out.println("Range = "+numCollection.getRange());
        System.out.println("Average = "+numCollection.getAverage());
    
        int lastIndex = numCollection.getCapacity();
        try {
           numCollection.setValue(lastIndex+1, 25);
        }
        catch (IndexOutOfBoundsException x) {
           throw new IndexOutOfBoundsException("number too big you silly billy poopy woopy uuuhuhuhuhhh");
        } 
    }
}

