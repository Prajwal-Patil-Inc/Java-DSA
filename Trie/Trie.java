import java.util.Arrays;

public class Trie {
    static class Node{
        Node[] children;
        boolean eow;

        public Node(){
            children = new Node[26];
            Arrays.fill(children, null);
            eow = false;
        }
    }
    //Root is always empty
    static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for(int i=0; i<word.length(); i++){ //O(L) - L word length
            int idx = word.charAt(i) - 'a';
            
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            if(i == word.length()-1){
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    public static boolean search(String key){ //O(L) - Key length
        Node curr = root;
        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if(curr.children[idx] == null){
                return false;
            }
            if(i == key.length()-1 && curr.children[idx].eow == false){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static boolean wordBreak(String key){
        if(key.length() == 0)   return true;
        for(int i = 1; i <= key.length(); i++) {
            String firstPart = key.substring(0, i);
            String secPart = key.substring(i);
            if(search(firstPart) && wordBreak(secPart)){
                return true;
            }
        }
        return false;
    }

    public static boolean startsWith(String prefix){
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if(curr.children[idx] == null){
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static int countNode(Node root){
        if(root == null){
            return 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if(root.children[i] != null){
                count += countNode(root.children[i]);
            }
        }
        return count+1;
    }

    static String ans = "";

    public static void longestWord(Node root, StringBuilder temp){
        if(root == null)    return;
        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                temp.append((char)(i+'a'));
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                longestWord(root.children[i], temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }



    public static void main(String[] args) {
        //String[] words = {"the", "a", "there", "their", "any"};
        // String[] words = {"i","like","sam","samsung","mobile", "ice"};
        // String key = "ilikesung";
        // for(int i = 0; i < words.length; i++) {
        //     insert(words[i]);
        // }
        // System.out.println(wordBreak(key));
        // System.out.println("----STARTS WITH----");
        // String preString = "sam";
        // System.out.println(startsWith(preString));

        // System.out.println("----COUNT UNIQUE SUBSTRINGS----");
        
        // //Count unique substrings
        // String str = "ababa";

        // //get all the suffixes first
        // for (int i = 0; i < str.length(); i++) {
        //     String suffix = str.substring(i);
        //     //Generate a trie of those suffixes
        //     insert(suffix);
        // }
        // System.out.println(countNode(root));
        
        String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }
        longestWord(root, new StringBuilder(""));
        System.out.println(ans);
    }
    
}