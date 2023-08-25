package functional.ds.nonlinear.graph.directed.adjacency_matrix;
//https://www.youtube.com/watch?v=X1LdtRW88c0&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=164
public class Graph {
    int[][] matrix;

    Graph(int size){
        matrix = new int[size][size];
    }

    public void addNode(Node node){

    }
    public void addEdge(int src,int dst){
        matrix[src][dst] = 1;
    }

    public boolean checkEdge(int src,int dst){
        return matrix[src][dst] == 1;
    }
    public void print(){

        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix.length;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addNode(new Node('A'));
        g.addNode(new Node('B'));
        g.addNode(new Node('C'));
        g.addNode(new Node('D'));
        g.addNode(new Node('E'));

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,0);
        g.addEdge(4,2);
        g.print();
        System.out.println(g.checkEdge(1,2));

    }
}
class Node {
    char data;
    Node(char data){
        this.data = data;
    }
}
