//Make a Linked List & add the following elements to it : (1, 5, 7, 3 , 8, 2, 3). Search for the number 7 & display its index.
public class LL_Problem1 {
    Node head;
    int size;
    int index;
    LL_Problem1(){
        size = 0;
    }
    class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            next = null;
            size++;
        }
    }

    //Add to list - at the first location
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){ //If the list is empty
            head = newNode;
            return;
        }
        Node lastNode = head;
        while(lastNode.next != null){
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }

    public void deleteFirst(){
        if(head == null){
            System.out.println("list is empty");
            return;
        }
        head = head.next;
        size--;
    }

    public void deleteLast(){
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        size--;
        if(head.next == null){
            System.out.println("List has only one item, deleting it now..");
            head = null;
            return;
        }

        Node secondLastNode = head;
        Node lastNode = head.next;
        while(lastNode.next != null){
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
        }
        secondLastNode.next = null;
    }

    public void searchList(int searchElement){
        if(head == null){
            System.out.println("List is empty, cannot search");
        }
        Node currNode = head;
        
        for(int i=0; i<size; i++){
            if(currNode.data == searchElement){
                System.out.println("Element "+ searchElement +" found at index "+i);
            }
            currNode = currNode.next;
        }
    }

    public void printList(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public int getSize(){
        return size;
    }
    
    public static void main(String[] args) {
        LL_Problem1 list = new LL_Problem1();
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(4);
        list.printList();
        System.out.println("Searching now..");
        list.searchList(3);
    }
}
