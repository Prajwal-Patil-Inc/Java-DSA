//Take elements(numbers in the range of 1-50) of a Linked List as input from the user. Delete all nodes which have values greater than 25.

import java.util.Scanner;

public class LL_Problem2 {
    Node head;
    int size;
    int index;
    LL_Problem2(){
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

    public void searchListAndDelete(){
        if(head == null){
            System.out.println("List is empty, cannot search");
        }
        Node secondLastNode = head; 
        Node lastNode = head.next;
        int cap = 25;
        while(lastNode != null) {
            if(lastNode.data > cap){
                secondLastNode.next = lastNode.next;
                lastNode.next = null;
            }
            lastNode = lastNode.next;
            secondLastNode = secondLastNode.next;
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
        LL_Problem2 list = new LL_Problem2();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 elements to put into the linked list");
        int n = 5;
        for (int i = 0; i < n; i++) {
            list.addLast(sc.nextInt());
        }
        sc.close();
        list.printList();
        System.out.println("Now deleting the elements greater than 25");
        list.searchListAndDelete();
        list.printList();
    }
}
