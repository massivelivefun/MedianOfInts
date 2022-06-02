import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

// This program reads a set of integers from a file and finds the median.
public class Program {
    public static void main(String[] args) {
        // Get the input file from the end user.
        Scanner scr = new Scanner(System.in);
        String fileName = null;
        System.out.print("Enter the input file relative to the pwd: ");
        try {
            fileName = scr.nextLine();
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        try {
            scr = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        int size = 0;
        try {
            size = scr.nextInt();
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        int pos = 0;
        int[] array = new int[size];
        try {
            while (scr.hasNextInt()) {
                array[pos++] = scr.nextInt();
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }

        scr.close();

        MedianOfInts.medianOfInts(array);

        double median;

        // Finding and printing out the median. In the case of an even number
        // of data items it averages the 2 in the middle.
        if (array.length % 2 != 0) {
            median = array[array.length / 2];
        } else {
            median = ((double) array[(array.length - 1) / 2]
                + array[(array.length + 1) / 2]) / 2;
        }

        System.out.println("The median is " + median + ".");
    }
}
