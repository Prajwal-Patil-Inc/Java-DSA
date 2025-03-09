import java.util.ArrayList;

public class PrintAllPathsFromSrcToDest {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
        graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    //Modified DFS - O(V^V) - bad tc
    public static void printPaths(ArrayList<Edge> graph[], boolean visited [], int curr, String path, int tar){
        if(curr == tar){
            System.out.println(path);
            return;
        }
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[curr] = true;
                printPaths(graph, visited, e.dest, path+e.dest, tar);
                visited[curr] = false;
            }
        }
    }

    public static void main(String[] args) {
        int Vertices = 7; //Nodes
        ArrayList<Edge> graph[] = new ArrayList[Vertices];
        createGraph(graph);

        int src = 0, tar = 5;
        printPaths(graph, new boolean[Vertices], src, ""+src, tar);
    }
}
