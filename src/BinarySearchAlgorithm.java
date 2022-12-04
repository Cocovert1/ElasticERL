/*
This will perform a binary search on our array of Nodes and will return the position of the node we want to find.
 */

public class BinarySearchAlgorithm {
    public static int binarySearch(ArraySequence.Node[] arr, String search) {
        //sets the pointers
        int bottomPointer = 0;
        int topPointer = arr.length - 1;
        int middle;

        //finds weather the key is in the top half or bottom half
        while (bottomPointer <= topPointer) {
            middle = (bottomPointer + topPointer) / 2;

            if(arr[middle] == null){
                return -1;
            }

            if (arr[middle].key.compareTo(search) < 0) {
                bottomPointer = middle + 1;
            } else if (arr[middle].key.compareTo(search) > 0) {
                topPointer = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}
