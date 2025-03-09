public class Practice {
    Node head;
    int size;
    Practice(){
        size = 0;
    }
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            next = null;
            size++;
        }
    }

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
        if(head == null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
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

    public void deleteFirst(){
        if(head == null){
            return;
        }     
        head = head.next;
        size--;
    }

    public void deleteLast(){
        if(head == null){
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

    public void deleteMid(int elementToDelete){
        if(head == null || head.next == null){
            return;
        }
        Node prevNode = head;
        Node currNode = head.next;
        while(currNode != null){
            if(currNode.data == elementToDelete){
                prevNode.next = currNode.next;
                currNode.next = null;
            }
            prevNode = prevNode.next;
            currNode = currNode.next;
        }
    }

    public int getSize(){
        return size;
    }

    public void searchList(int searchElement){
        if(head == null){
            return;
        }
        Node currNode = head;
        for (int i = 0; i < getSize(); i++) {
            if(currNode.data == searchElement){
                System.out.println("Element "+ searchElement +" found at index: "+i);
            }
            currNode = currNode.next;
        }
    }

    public void showList(){
        if(head == null){
            System.out.println("List empty");
            return;
        }
        Node currNode = head;
        while(currNode != null){
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Practice list = new Practice();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        list.showList();
        System.out.println("Deleting mid");
        list.deleteMid(2);
        list.showList();
        // System.out.println("Deleting first");
        // list.deleteFirst();
        // list.showList();
        // System.out.println("Deleting last");
        // list.deleteLast();
        // list.showList();
        // System.out.println("Searching element..");
        // list.searchList(3);
        // System.out.println("Reversing");
        // list.reverseList();
        // list.showList();

    }
}
