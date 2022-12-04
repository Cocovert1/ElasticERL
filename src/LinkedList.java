//public class LinkedList {
//    //node class
//    class Node {
//        String key;
//        Node left, right;
//
//        //node constructor
//        Node(String key){
//            this.key = key;
//            left = null;
//            right = null;
//        }
//    }
//
//    //creating our node objects
//    private Node header;
//    private Node trailer;
//
//    //make the new node, add head to next
//    public void addFirst(String key){
//        if(isEmpty()) {
//            header = new Node(key);
//            trailer = header;
//            return;
//        }
//
//        Node newNode = new Node(key);
//        newNode.next = header;
//        header = newNode;
//    }
//
//    //make the new node, add the node to the next of the tail node
//    public void addLast(String key){
//        if(isEmpty()) {
//            header = new Node(key);
//            trailer = header;
//            return;
//        }
//
//        Node newNode = new Node(key);
//        trailer.next = newNode;
//        trailer = newNode;
//    }
//
//    //move to the position before where we want to insert, and fix the pointers
//    public void add(int pos, String key){
//        //validation
//        if( pos == 1 ){
//            addFirst(key);
//            return;
//        }
//
//        Node current = header;
//        int count = 1;
//
//        while(count < pos-1) {
//            count++;
//            current = current.next;
//        }
//
//        Node newNode = new Node(key);
//        newNode.next = current.next;
//        current.next = newNode;
//    }
//
//    //make the header point to the next and remove all the pointers the first had
//    public String deleteFirst(){
//        if(isEmpty()) {
//            throw new RuntimeException("List is Empty");
//        }
//
//        Node current = header;
//        header = header.next;
//        current.next = null;
//
//        if(isEmpty()) {
//            trailer = null;
//        }
//
//        return current.key;
//    }
//
//    //move to the before last node and last node and remove the pointers
//    public String deleteLast() {
//        if(isEmpty()) {
//            throw new RuntimeException("List is Empty");
//        }
//
//        if(header == trailer) {
//            String key = header.key;
//            header = null;
//            trailer = null;
//            return key;
//        }
//
//        Node current = header;
//        Node prev = null;
//
//        while (current.next != null){
//            prev = current;
//            current = current.next;
//        }
//
//        prev.next = null;
//        trailer = prev;
//        return current.key;
//    }
//
//    //move to the position just before, and jump the pointer to the current.next
//    public String delete(int pos){
//        if(isEmpty()) {
//            throw new RuntimeException("List is Empty");
//        }
//
//        if(pos == 1) {
//            deleteFirst();
//        }
//
//        Node current = header;
//        Node previous = null;
//        int count = 1;
//
//        while(count < pos) {
//            count++;
//            previous = current;
//            current = current.next;
//        }
//
//        previous.next = current.next;
//        current.next = null;
//        return current.key;
//    }
//
//    //searches for a value in the linked list
//    public boolean search(String key){
//        Node current = header;
//        while(current != null){
//            if(key.equals(current.key)) {
//                return true;
//            }
//            current = current.next;
//        }
//        return false;
//    }
//
//    public boolean isEmpty(){
//        return header == null ;
//    }
//
//
//    //prints the contents of the linked list
//    public void print(){
//        Node current = header;
//        while(current != null){
//            System.out.print(current.key +" -> ");
//            current = current.next;
//        }
//        System.out.println("NULL");
//    }
//}
