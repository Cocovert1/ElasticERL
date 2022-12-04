/*
This executes our merge sort for the initial insertion of data into our data structure.
 */

public class SortingAlgorithm {

    //recursively halves the array and then merge them back together
    public static void mergeSort(String[] arr, int first, int sizeArray) {
        int bottomHalf = 0;
        int topHalf = 0;

        if(sizeArray > 1) {
            bottomHalf = sizeArray/2;
            topHalf = sizeArray-bottomHalf;

            mergeSort(arr, first, bottomHalf);
            mergeSort(arr, first + bottomHalf, topHalf);
        }

        merge(arr, first, bottomHalf, topHalf);
    }

    //sort the elements while merging them back
    private static void merge(String[] arr, int first, int bottomHalf, int topHalf)
    {
        //temp array of the size of original arr
        String[] temp = new String[bottomHalf + topHalf];
        int copied = 0;
        int copied1 = 0;
        int copied2 = 0;

        //compares the values of the different elements
        while ((copied1 < bottomHalf) && (copied2 < topHalf))
        {
            if (arr[first + copied1].compareTo(arr[first + bottomHalf + copied2]) < 0)
                temp[copied++] = arr[first + (copied1++)];
            else
                temp[copied++] = arr[first + bottomHalf + (copied2++)];
        }

        while (copied1 < bottomHalf)
            temp[copied++] = arr[first + (copied1++)];
        while (copied2 < topHalf)
            temp[copied++] = arr[first + bottomHalf + (copied2++)];

        for (int i = 0; i < copied; i++)
            arr[first + i] = temp[i];

    }


}

