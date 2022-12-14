/*
This is our main ElasticERL algorithm.
 */

public class ElasticERL {
    static ArraySequence sequence = new ArraySequence();
    static ImportData data = new ImportData();
    static SortingAlgorithm sort = new SortingAlgorithm();
    static BinarySearchTree BST = new BinarySearchTree();
    static Stack stack = new Stack(data.nbroflines("EHITS_test_file1.txt"));

    public static void main(String[] args){
        //testing the different methods.
        int nbroflines = data.nbroflines("EHITS_test_file1.txt");
        String arr[] = new String[nbroflines];

        SetEINThreshold(nbroflines, arr);

        System.out.println("Printing the keys");
        //allKeys(nbroflines);

        System.out.println();
        System.out.println("Adding value");
        add(nbroflines, "12345678");
       // allKeys(nbroflines);

        System.out.println();
        System.out.println("Removing values");
        remove(nbroflines, "12345678");
       // allKeys(nbroflines);

        System.out.println();
        System.out.println("Next key");
        nextKey(nbroflines,"33240013");

        System.out.println();
        System.out.println("Previous key");
        prevKey(nbroflines,"33255593");

        System.out.println();
        System.out.println("Range of 2 keys");
        System.out.println(rangeKeys(nbroflines, "33255593", "33240013"));

        System.out.println();
        System.out.println("Generate random key");
        generate(nbroflines);
        BST.generate();
        //allKeys(nbroflines);



    }

    //selects the correct data structure
    public static void SetEINThreshold(int nbroflines, String[] arr){
        if(nbroflines <= 100000){
            data.addData(arr, "EHITS_test_file1.txt");
            sort.mergeSort(arr, 0, nbroflines);

            for(int i  = 0; i < arr.length; i++){
                stack.push(arr[i]);
            }

            sequence.initialInsert(arr);
        } else {
            data.addData(arr, "EHITS_test_file2.txt");

            for(int i  = 0; i < arr.length; i++){
                stack.push(arr[i]);
            }

            for(String s : arr){
                BST.insert(s);
            }
        }
    }

    //returns all of the keys in a ordered sequence
    public static void allKeys(int nbroflines){
        if(nbroflines <= 100000){
            for(ArraySequence.Node n : sequence.NodeArray){
                if(n == null){
                    break;
                }
                System.out.println(n.key);
            }
        } else {
            BST.inorder();
        }
    }

    //add a new key to the data structure
    public static void add(int nbroflines, String key){
        if(nbroflines <= 100000){
            sequence.add(key);
            stack.push(key);

        } else {
            BST.insert(key);
            stack.push(key);
        }
    }

    //removes a key from the data structure
    public static void remove(int nbroflines, String key){
        if(nbroflines <= 100000){
            sequence.remove(key);
        } else {
            BST.remove(key);
        }
    }

    //finds the next key in the sequence
    public static void nextKey(int nbroflines, String key){
        if(nbroflines <= 100000){
            System.out.println(sequence.next(key));
        } else {
            BST.findSuccessor(key);
            System.out.println(BST.suc);
        }
    }

    //finds the previous key in the sequence
    public static void prevKey(int nbroflines, String key){
        if(nbroflines <= 100000){
            System.out.println(sequence.prev(key));
        } else {
            BST.findSuccessor(key);
            System.out.println(BST.pre);
        }
    }

    //finds the range between two keys in a sequence
    public static int rangeKeys(int nbroflines, String key1, String key2){
        if(nbroflines <= 100000){
            int pos1 = sequence.get(key1);
            int pos2 = sequence.get(key2);

            if(pos1 > pos2){
                return pos1 - pos2;
            }else{
                return pos2 - pos1;
            }
        } else {
            BST.generate();
        }
        return -1;
    }

    public static void generate(int nbroflines){
        if(nbroflines <= 100000){
            sequence.generate();
        } else {
            String temp = BST.generate();
            BST.insert(temp);
        }
    }
}
