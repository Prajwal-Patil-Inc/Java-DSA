import java.util.ArrayList;

public class CycleDetection {
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
        
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 0));
       
    }

    public static boolean isCycleDirected(ArrayList<Edge> graph[], boolean visited[], int curr, boolean[] rec){
        visited[curr] = true;
        rec[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if(rec[e.dest]){ //cycle
                return true;
            }else if(!visited[e.dest]){
                if(isCycleDirected(graph, visited, e.dest, rec)){
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        System.out.println(isCycleDirected(graph, new boolean[V], 0, new boolean[V]));

        //For disconnected graph
        /*
         * boolean vis[] = new boolean[V];
         * boolean rec[] = new boolean[V];
         * for(int i=0; i<V; i++){
         * if(!vis[i])}{
         *  boolean isCycle = isCycleDirected(graph, vis, i, rec);
         * if(isCycle){
         *  sout(isCycle);
         *  break
         * }
         * }
         */
    }
}
