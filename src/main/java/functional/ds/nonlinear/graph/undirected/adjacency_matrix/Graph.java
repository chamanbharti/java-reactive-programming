package functional.ds.nonlinear.graph.undirected.adjacency_matrix;

public class Graph {
    private int V;
    private int E;
    private int[][] adjMatrix;

    Graph(int nodes){
        this.V = nodes;
        this.E = 0;
        this.adjMatrix = new int[nodes][nodes];
    }
    public void addEdge(int u,int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        E++;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V+" vertices, "+E+" edges "+"\n");
        for (int v=0;v<V;v++){
            sb.append(v+": ");
            for (int w:adjMatrix[v]){
                sb.append(w+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
    /*
    int[][] adjMatrix;
    public Graph(int nodes){
        this.adjMatrix = new int[nodes][nodes];
    }
    public void addEdge(int u,int v){
        this.adjMatrix[u][v] = 1;
        this.adjMatrix[v][u] = 1;
    }
    public void print(){

        for(int i=0;i< adjMatrix.length;i++){
            for(int j=0;j< adjMatrix.length;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    */

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
