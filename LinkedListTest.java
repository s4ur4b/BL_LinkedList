import java.util.Scanner;

class Node {
    private int data;
    private Node next;

    public Node() {
        data =0;
        next=null;
    }

    public Node(int d, Node n) {
        this.data = d;
        this.next = n;
    }

    public int getData() {
        return data;
    }

    public void setData(int d) {
        this.data = d;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node n) {
        this.next = n;
    }
}

class LinkedList {
    private int size;
    private Node start;

    public LinkedList() {
        size=0;
        start=null;
    }

    public void insertAtFirst(int val){
        Node n;
        n= new Node();
        n.setData(val);
        n.setNext(start);
        start=n;
        size++;
    }

    public void insertAtLast(int val){
        Node n,t;
        n= new Node();
        n.setData(val);
        t=start;
        if (t==null)
            start=n;
        else{
            while (t.getNext() != null)
                t= t.getNext();
                t.setNext(n);
        }
        size++;
    }

    public void inserAtPosition(int val,int pos){
        if (pos == 1)
            insertAtFirst(val);
        else if (pos == size+1)
            insertAtLast(val);
        else if (pos>1 && pos<=size){
            Node n,t;
            n=new Node(val,null);
            t=start;
            for (int i = 1; i < pos-1 ;i++)
                t=t.getNext();
            n.setNext(t.getNext());
            t.setNext(n);
            size++;
        }
        else
            System.out.println("Insertion is not possible at position"+pos);
    }

    public boolean isEmpty(){
        if (start==null)
            return true;
        else
            return false;
    }

    public int getListSize(){
        return size;
    }

    public void viewList(){
        Node t;
        if (isEmpty())
            System.out.println("List is empty");
        else {
            t=start;
            for (int i=1; i<=size; i++){
                System.out.println(" "+t.getData());
                t=t.getNext();
            }
        }
    }

    public void deleteFirst(){
        if (start == null)
            System.out.println("List is already empty");
        else {
            start = start.getNext();
            size--;
        }
    }

    public void deleteLast(){
        if (start == null)
            System.out.println("List is already empty");
        else  if(size == 1){
            start = null;
            size--;
        }
        else {
            Node t;
            t=start;
            for (int i = 1; i<=size-1 ;i++){
                t=t.getNext();
                t.setNext(null);
                size--;
            }
        }

    }

    public void delAtPos(int pos){
        if (start == null)
            System.out.println("List is already empty");
        else if (pos<1 || pos>size)
            System.out.println("Invalid position");
        else if (pos == 1)
            deleteFirst();
        else if (pos == size)
            deleteLast();
        else {
            Node t,t1;
            t=start;
            for (int i = 1; i<pos-1;i++)
                t=t.getNext();
            t1=t.getNext();
            t.setNext(t.getNext());
            size--;
        }
    }

}

public class LinkedListTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LinkedList list = new LinkedList();
        boolean flag = true;
        while (flag) {
            System.out.println("1. Add to start");
            System.out.println("2. Add to end");
            System.out.println("3. Add to a position");
            System.out.println("4. Delete at first");
            System.out.println("5. Delete at last");
            System.out.println("6. Delete at position");
            System.out.println("7. View list");
            System.out.println("8. exit");
            int choice = scan.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("Enter value");
                    int val = scan.nextInt();
                    list.insertAtFirst(val);
                    break;
                case 2 :
                    System.out.println("Enter value");
                    int value = scan.nextInt();
                    list.insertAtLast(value);
                    break;
                case 3 :
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    System.out.println("Enter value");
                    int value1 = scan.nextInt();
                    list.inserAtPosition(value1,pos);
                    break;
                case 4 :
                    list.deleteFirst();
                    break;
                case 5 :
                    list.deleteLast();
                    break;
                case 6 :
                    System.out.println("Enter position");
                    int position = scan.nextInt();
                    list.delAtPos(position);
                    break;
                case 7 :
                    list.viewList();
                    break;
                case 8 :
                    flag = false;
                    break;
                default :
                    System.out.println("Invalid choice");
            }
        }
    }
}
