import java.util.Scanner;

public class Stack<K> {
    private final LinkedList linkedList;
    static Scanner scanner = new Scanner(System.in);

    public Stack() {
        linkedList = new LinkedList();
    }

    // pushing elements  at top of stack
    public void push(int element) {
        linkedList.insertAtFirst(element);
    }

    //peak method returns top of stack
    public void peak(){
        linkedList.viewAtPosition(1);
    }

    // deletes top element of stack
    public void pop(){
        linkedList.deleteFirst();
    }

    // printing stack values
    public void printStack() {
        linkedList.viewList();
    }

    // main method
    public static void main(String[] args) {
        Stack stack = new Stack();

        boolean flag = true;
        while (flag) {
            int choice = stack.userConsole();
            switch (choice){
                case 1:
                    System.out.println("Enter the elements that you want to push in Stack : ");
                    Integer element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    stack.peak();
                    break;
                case 3:
                    stack.pop();
                    System.out.println("Successfully removed top element of stack !!!");
                    break;
                case 4:
                    stack.printStack();
                    break;
                case 5:
                    flag = false;
                    break;
            }
        }
    }

    public int userConsole(){
        System.out.println("Press 1 - to Push in stack");
        System.out.println("Press 2 - to Peak in stack");
        System.out.println("Press 3 - to Pop in stack");
        System.out.println("Press 4 - to Display stack elements");
        System.out.println("Press 5 - to EXIT ");

        return scanner.nextInt();
    }
}