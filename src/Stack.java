//Making a stack in Java

class Stack {

    private String stackArray[];
    private int top;
    private int maxStorage;

    Stack(int size) {
        // initialize the stack variables
        stackArray = new String[size];
        maxStorage = size;
        top = -1;
    }

    // push elements to the top of stack
    public void push(String x) {
        if (isFull()) {
            String[] temp = new String[(stackArray.length)*2];
            for (int i = 0; i < stackArray.length; i++){
                temp[i] = stackArray[i];
            }

            stackArray = temp;
        }

        // insert element on top of stack
        stackArray[++top] = x;
    }

    // pop elements from top of stack
    public String pop() {

        // no element to pop
        if (isEmpty()) {
            return "Stack Empty";
        }

        // pop element from top of stack
        return stackArray[top--];
    }

    // return size of the stack
    public int getSize() {
        return top + 1;
    }

    // check if the stack is empty
    public Boolean isEmpty() {
        return top == -1;
    }

    // check if the stack is full
    public Boolean isFull() {
        return top == maxStorage - 1;
    }

    // display elements of stack
    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stackArray[i] + ", ");
        }
    }
}