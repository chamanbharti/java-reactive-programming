package functional.ds.nonlinear.graph.undirected.adjacency_list;

import java.util.LinkedList;

//https://www.youtube.com/watch?v=Kd__dmFHoZo&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=165
//https://www.youtube.com/watch?v=nt8uN6pQrnw&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=166
//https://www.youtube.com/watch?v=6rDKLqFLfh0&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=167
public class Graph {
    private LinkedList<Integer>[] adj;
    private int V;
    private int E;

    public Graph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[nodes];
        for (int v=0;v<V;v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V+" vertices, "+E+" edges "+"\n");
        for (int v=0;v<V;v++){
            sb.append(v+": ");
            for (int w:adj[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        //g.print();
        System.out.println(g);
    }
}
