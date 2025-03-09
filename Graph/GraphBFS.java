import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphBFS {
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

    public static void BFS(ArrayList<Edge> graph[], int v){
        //Create Queue
        Queue<Integer> q = new LinkedList<>();
        //Create a visited array
        boolean visited[] = new boolean[v];
        //Add first 
        q.add(0); //src = 0

        while (!q.isEmpty()) {
            int curr = q.poll();
            if(!visited[curr]){
                System.out.print(curr+" ");
                visited[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).dest);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int Vertices = 4; //Nodes
        ArrayList<Edge> graph[] = new ArrayList[Vertices];
        createGraph(graph);

        //BFS
        System.out.println();
        System.out.println("----BFS----");
        BFS(graph, Vertices);

        //For disconnected graph
        // 1--2--3
        // 4--5
        // boolean visited[] = new boolean[Vertices];
        //for(i to Vertices)
        //if(visited[i] == false)
        //bfs(graph, Vertices, visited, i(starting point))
        //public void bfs(graph, int vertices, boolean visited[], int start){
        //rest same
        //q.add(start)
        //rest samee
       // }
    }
}
