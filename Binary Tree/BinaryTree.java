import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    static class binaryTree{
        static int index = -1;
        public static Node buildBinaryTree(int data[]){
            index++;
            if(data[index] == -1){
                return null;
            }
            Node newNode = new Node(data[index]);
            newNode.left = buildBinaryTree(data);
            newNode.right = buildBinaryTree(data);

            return newNode;
        }

        //O(n)
        public static void preOrder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }

        //O(n)
        public static void inOrder(Node root){
            if(root == null){
                return;
            }
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }

        //O(n)
        public static void postOrder(Node root){
            if(root == null){
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }

        public static void levelOrder(Node root){
            if(root == null)    return;
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node currNode = q.remove();
                if(currNode == null){
                    System.out.println();
                    if(q.isEmpty()){
                        break;
                    }
                    else{
                        q.add(null);
                    }
                }else{
                    System.out.print(currNode.data+" ");
                    if(currNode.left != null){
                        q.add(currNode.left);
                    }
                    if(currNode.right != null){
                        q.add(currNode.right);
                    }
                }
            }
        }

        //Count number of nodes in a binary tree - O(n).. every node traversed
        public static int countNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftCount = countNodes(root.left);
            int rightCount = countNodes(root.right);

            return leftCount + rightCount + 1;
        }

        //Sum of all nodes - O(n)
        public static int sumOfNodes(Node root){
            if(root == null){
                return 0;
            }
            int leftSum = sumOfNodes(root.left);
            int rightSum = sumOfNodes(root.right);

            return leftSum + rightSum + root.data;
        }

        //Height of tree - O(n)
        public static int heightOfTree(Node root){
            if(root == null){
                return 0;
            }
            int leftHeight = heightOfTree(root.left);
            int rightHeight = heightOfTree(root.right);

            int maxHeight = Math.max(leftHeight, rightHeight)+1;

            return maxHeight;
        }

        //Diameter of a tree - O(N^2)
        public static int diameter(Node root){
            if(root == null){
                return 0;
            }
            int diam1 = diameter(root.left);
            int diam2 = diameter(root.right);
            int diam3 = heightOfTree(root.left) + heightOfTree(root.right) + 1;
            return Math.max(diam3, Math.max(diam1, diam2));
        }

        static class TreeInfo{
            int height;
            int diam;
            TreeInfo(int height, int diam){
                this.height = height;
                this.diam = diam;
            }
        }

        //Diameter - optimized
        public static TreeInfo diameter2(Node root){
            if(root == null){
                return new TreeInfo(0, 0);
            }

            TreeInfo left = diameter2(root.left);
            TreeInfo right = diameter2(root.right);

            int myHeight = Math.max(left.height, right.height) + 1;

            int diam1 = left.diam;
            int diam2 = right.diam;
            int diam3 = left.height + right.height + 1;

            int myDiam = Math.max(Math.max(diam1, diam2), diam3);
            TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
            return myInfo;
        }

    }

    public static void main(String[] args) {
        int data[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        binaryTree tree = new binaryTree();
        Node root = tree.buildBinaryTree(data);
        //System.out.println(root.data); 
        //tree.preOrder(root);
        //tree.inOrder(root);
        //tree.postOrder(root);
        //tree.levelOrder(root);
        //System.out.println(tree.countNodes(root));
        //System.out.println(tree.sumOfNodes(root));
        //System.out.println(tree.heightOfTree(root));
        System.out.println(tree.diameter2(root).diam);
    }
    
}