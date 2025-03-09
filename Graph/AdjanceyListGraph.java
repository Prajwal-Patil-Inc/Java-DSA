import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AdjanceyListGraph {

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

    //DFS - O(V+E)
    public static void DFS(ArrayList<Edge> graph[], int curr, boolean visited[]){
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

        //Print all neighbors of 2
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.weight+" ");
        }

        //BFS
        System.out.println();
        System.out.println("----BFS----");
        BFS(graph, Vertices);

        //DFS
        System.out.println();
        System.out.println("----DFS----");
        DFS(graph, Vertices, null);
    }
}