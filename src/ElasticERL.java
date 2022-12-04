
public class ElasticERL {
    static ArraySequence sequence = new ArraySequence();
    static ImportData data = new ImportData();
    static SortingAlgorithm sort = new SortingAlgorithm();
    static BinarySearchTree BST = new BinarySearchTree();

    public static void main(String[] args){
        int nbroflines = data.nbroflines("EHITS_test_file1.txt");
        String arr[] = new String[nbroflines];

        SetEINThreshold(nbroflines, arr);

        System.out.println("Printing the keys");
        allKeys(nbroflines);

    }

    public static void SetEINThreshold(int nbroflines, String[] arr){
        if(nbroflines <= 100000){
            data.addData(arr, "EHITS_test_file1.txt");
            sort.mergeSort(arr, 0, nbroflines);

            sequence.initialInsert(arr);
        } else {
            data.addData(arr, "EHITS_test_file3.txt");

            for(String s : arr){
                BST.insert(s);
            }
        }
    }

    public static void allKeys(int nbroflines){
        if(nbroflines <= 100000){
            for(ArraySequence.Node n : sequence.NodeArray){
                System.out.println(n.key);
            }
        } else {
            BST.inorder();
        }
    }
}
