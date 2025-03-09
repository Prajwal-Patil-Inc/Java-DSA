import java.util.ArrayList;

public class GraphDFS {
    static class Edge{
        int src;
        int dest;
        int weight;
        public Edge(int s, int d, int w){
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }
    
    public static void createGraph(ArrayList<Edge> graph[]){
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 2));

        graph[1].add(new Edge(1,2, 10));
        graph[1].add(new Edge(1,3, 0));

        graph[2].add(new Edge(2,0, 2));
        graph[2].add(new Edge(2,1, 10));
        graph[2].add(new Edge(2,3, -1));

        graph[3].add(new Edge(3,1, 0));
        graph[3].add(new Edge(3,2, -1));
    }
    //DFS - O(V+E)
    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]){
        if(visited[curr]){
            return;
        }
        //Print curr
        System.out.print(curr+" ");
        //Mark visited
        visited[curr] = true;
        //Go for neighbors
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            DFS(graph, e.dest, visited);
        }
    }
    public static void main(String[] args) {
        int Vertices = 4; //Nodes
        ArrayList<Edge> graph[] = new ArrayList[Vertices];
        createGraph(graph);
        DFS(graph, 0, new boolean[Vertices]);

        /*
         * For disconnected graph
         * in main
         * boolean visited[] = new boolea[Vertices]
         * for(0 to vertices){
         * if(visited[i] == false){
         * DFS(graph, i, visited)
         * }
         * }
         */
    }
}
