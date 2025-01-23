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
           System.out.println("Should throw Index out of bounds");
        } 
    }
}
