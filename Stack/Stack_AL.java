import java.util.ArrayList;

public class Stack_AL {
    
    static class Stack{
        static ArrayList<Integer> list = new ArrayList<>();

        public void push(int data){
            list.add(data);
        }

        public boolean isEmpty(){
            return list.size() == 0;
        }

        public int pop(){
            if (isEmpty()) {
                return -1;
            }
            int top = list.remove(list.size() - 1);
            return top;
        }

        public int peek(){
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }
    
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(0);
        s.push(1);
        System.out.println(s.peek());
        s.push(2);
        System.out.println(s.pop());
    }
}
