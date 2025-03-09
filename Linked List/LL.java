public class LL{
    Node head;
    int size;
    LL(){
        size = 0;
    }
    class Node{
        String data;
        Node next;

        public Node(String data){
            this.data = data;
            next = null;
            size++;
        }
    }

    //Add to list - at the first location
    public void addFirst(String data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(String data){
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

    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;

        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
        }
        head.next = null;
        head = prevNode;
    }

    public Node reverseListRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
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
        LL list = new LL();
        list.addFirst("a");
        list.addFirst("is");
        list.addFirst("this");
        list.addLast("list");
        list.printList();
        System.out.println(list.getSize());

        // System.out.println("Deleting now");
        // list.deleteFirst();
        // list.printList();

        // System.out.println("Deleting last node");
        // list.deleteLast();
        // list.printList();
        // System.out.println(list.getSize());

        //list.reverseList();
        list.head = list.reverseListRecursive(list.head);
        list.printList();
    }
}