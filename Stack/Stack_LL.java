public class Stack_LL {

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Stack{
        public static Node head = null;
        
        public static boolean isEmpty(){
            return head == null;
        }

        public static void push(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        public static int pop(){
            if (isEmpty()) {
                return -1;
            }
            Node top = head;
            head = head.next;
            return top.data;
        }

        public static int peek(){
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
        
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        s.push(2);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    
}