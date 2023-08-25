package functional.ds.nonlinear.graph.directed.adjacency_list;

import java.util.ArrayList;
import java.util.LinkedList;
//https://www.youtube.com/watch?v=-VgHk7UMPP4&list=PLZPZq0r_RZON1eaqfafTnEexRzuHbfZX8&index=19
//https://www.youtube.com/watch?v=ee6zIj4J3-Y&list=PLZPZq0r_RZON1eaqfafTnEexRzuHbfZX8&index=21
public class Graph {
    ArrayList<LinkedList<Node>> list;

    Graph(){
        list = new ArrayList<>();
    }

    public void addNode(Node node){
        LinkedList<Node> currentList = new LinkedList<>();
        currentList.add(node);
        list.add(currentList);
    }
    public void addEdge(int src,int dst){
        LinkedList<Node> currentList = list.get(src);
        Node dstNode = list.get(dst).get(0);
        currentList.add(dstNode);
    }

    public boolean checkEdge(int src,int dst){
        LinkedList<Node> currentList = list.get(src);
        Node dstNode = list.get(dst).get(0);
        for (Node node:currentList){
            if(node == dstNode){
                return true;
            }
        }
        return false;
    }
    public void print(){
       for (LinkedList<Node>currentList:list){
           for (Node node:currentList){
               System.out.print(node.data+" -> ");
           }
           System.out.println();
       }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addNode(new Node('A'));
        g.addNode(new Node('B'));
        g.addNode(new Node('C'));
        g.addNode(new Node('D'));
        g.addNode(new Node('E'));

        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(2,4);
        g.addEdge(4,0);
        g.addEdge(4,2);
        g.print();
        System.out.println(g.checkEdge(4,2));

    }
}
class Node {
    char data;
    Node(char data){
        this.data = data;
    }
}
