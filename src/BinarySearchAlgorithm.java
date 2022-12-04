public class BinarySearchAlgorithm {
    public static int binarySearch(ArraySequence.Node[] arr, String search) {
        int bottomPointer = 0;
        int topPointer = arr.length - 1;
        int middle;

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
