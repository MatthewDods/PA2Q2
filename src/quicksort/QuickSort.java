/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksort;

/**
 * QuickSort, takes array and sorts using QuickSort. Times against QuickSort on unsorted vs already sorted.
 * @author Matthew Dods 420190038
 */
public class QuickSort {
    
    private CatalogueItem[] items;
    private int number;
    
    /**
     * sort, checks if array has items if does calls the QuickSort method.
     * @param values 
     */
    public void sort(CatalogueItem[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.items = values;
        number = values.length;
        
        quicksort(0, number - 1);
    }

    /**
     * quicksort, sorts array using QuickSort method.
     * @param low
     * @param high 
     */
    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = items[low + (high-low)/2].getItemId();

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (items[i].getItemId() < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (items[j].getItemId() > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }

    /**
     * exchange, takes two items in a list and swaps their placing.
     * @param i - first item being compared
     * @param j - second item being compared
     */
    private void exchange(int i, int j) {
        CatalogueItem temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

 
    /**
     * printArray, prints the array.
     * @param arr - list
     */
    void printArray(CatalogueItem arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(
                    "id: " + arr[i].getItemId() + " "
                    + "name: " + arr[i].getItemName() + " "
                    + "category: " + arr[i].getCategory() + "\n");
        System.out.println();
        System.out.println();
    }
    
    
    public static void main(String args[])
    {
        QuickSort ob = new QuickSort();
        
        CatalogueItem arr[] = {
            new CatalogueItem( 3, "Life of Pi","Books"),
            new CatalogueItem( 7, "Deelongie 4 way toaster","Home and Kitchen"),
            new CatalogueItem( 2, "Glorbarl knife set","Home and Kitchen"),
            new CatalogueItem( 4, "Diesorn vacuum cleaner","Appliances"),
            new CatalogueItem( 5, "Jennie Olivier sauce pan","Home and Kitchen"),
            new CatalogueItem( 6, "This book will save your life","Books"),
            new CatalogueItem( 9, "Kemwould hand mixer","Appliances"),
            new CatalogueItem( 1, "Java for Dummies","Books"),
        };
        System.out.println("The Unsorted array is");
        ob.printArray(arr);
        
        // apply sort on unsorted list
        long startTime = System.nanoTime();
        ob.sort(arr);
        long stopTime = System.nanoTime();
        long time = stopTime - startTime;
        
        System.out.println("The Quick Sorted array is");
        ob.printArray(arr);
        System.out.println("\nQuicksort took " + time + "ns long.");
        System.out.println("\nRunning sort again for testing...");
        
        // apply sort on now sorted list
        long startTime2 = System.nanoTime();
        ob.sort(arr);
        long stopTime2 = System.nanoTime();
        long time2 = stopTime2 - startTime2;
        System.out.println("\nSecond run of Quicksort on already sorted array took " + time2 + "ns long.");
    }
}
