import java.util.ArrayList;

public class CycleDetectionUndirected {
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) { //O(V+E)
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));
        
        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));
        
        graph[3].add(new Edge(3, 2));


        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));
    }

    public static boolean isCycle(ArrayList<Edge> graph[], boolean visited[], int curr, int par){
        visited[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(visited[e.dest] && par != e.dest){
                return true;
            }
            else if(!visited[e.dest]){
                if(isCycle(graph, visited, e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycle(graph, new boolean[V], 0, -1));
        
    }
}
