package E3_W2_U1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex2_Runnable {
    private static Map<String, Integer> parts = new HashMap<String, Integer>();
    public static void main(String[] args) {
        // creating an ArrayList of 3000 random int numbers
        List<Integer> myList = provideArrayList();

        // splitting the previous ArrayList into a LinkedList of 3 ArrayList, each one containing 1000 int numbers
        List<List<Integer>> partitionedList = splitInEqual(myList);

        // Starting to create the 3 differents threads from class that extends thread
        Ex2_Thread T1 = new Ex2_Thread("T-One", partitionedList.get(0));
        Ex2_Thread T2 = new Ex2_Thread("T-Two", partitionedList.get(1));
        Ex2_Thread T3 = new Ex2_Thread("T-Three", partitionedList.get(2));

        // Invoking run() method on each Thread and starting to count
        T1.start();
        T2.start();
        T3.start();

        // To add at Map each result, each thread must be terminated
        try {
            T1.join();
            T2.join();
            T3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Add the result of each thread to the Map
        addToParts(T1);
        addToParts(T2);
        addToParts(T3);

        System.out.print("\nPartials:");
        System.out.println(parts);

        System.out.println("\nThe sum of the 3000 random ints is: " + getTheSum());

    }

    public static List<Integer> provideArrayList() {
        List<Integer> newList = new ArrayList<Integer>();
        int i = 0;
        while (i < 3000) {
            int randomNumber = (int)(Math.random() * 100) + 1;
            newList.add(randomNumber);
            i++;
        }
        return newList;
    }

    public static List<List<Integer>> splitInEqual(List<Integer> list) {
        int partitionSize = 1000;
        List<List<Integer>> partitionsContainer = new ArrayList<List<Integer>>();
        for (int i = 0; i < list.size(); i += partitionSize) {
            partitionsContainer.add(list.subList(i, Math.min(i + partitionSize, list.size())));
        }
        return partitionsContainer;
    }

    public static void addToParts(Ex2_Thread t) {
        parts.put(t.t_name, t.partitionSum);
    }

    public static int getTheSum() {
        int totalAmount = 0;
        for (int v : parts.values()) {
            totalAmount += v;
        }
        return totalAmount;
    }
}
