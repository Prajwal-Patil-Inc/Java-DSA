import java.util.ArrayList;

public class BST {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //Left subtree
            root.left = insert(root.left, val);
        }
        else{
            //Right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root){
        if(root == null)    return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data > key){ //search left
            return search(root.left, key);
        }
        else if(root.data == key){
            return true;
        }
        else{ //search right
            return search(root.right, key);
        }
    }

    //Deleting a node
    public static Node delete(Node root, int val){
        //Searching the node
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        //Node found
        else{ //root.data == val
            //case1
            if(root.left == null && root.right == null){
                return null;
            }

            //case2
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            //case3
            Node IS = inOrderSuccessor(root.right); //left most in the right subtree
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root){
        while (root.left != null) { //left most in the right subtree
            root = root.left;
        }
        return root;
    }

    //Print in range
    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data+" ");
            printInRange(root.right, x, y);
        }
        else if(root.data >= y){
            printInRange(root.left, x, y);
        }
        else{
            printInRange(root.right, x, y);
        }
    }

    //Print path from root to leaf
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i)+"->");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);

        //leaf
        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
            //Non-leaf
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        int values[] = {8,5,3,1,4,6,10,11,14};
        Node root = null;
        
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        //Search
        int key = 3;
        System.out.println(search(root, key));

        //Delete
        // delete(root, 1);
        // inOrder(root);

        //Print in range
        printInRange(root, 3, 7);
        System.out.println();

        //Paths from root to leaf
        printRoot2Leaf(root, new ArrayList<>());
    }
}