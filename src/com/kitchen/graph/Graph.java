package com.kitchen.graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
    private final int vertex;
    private final LinkedList<Integer>[] adjacencyLists;
    private final boolean directed;

    public Graph(int vertex, boolean directed){
        this.vertex = vertex;
        this.directed = directed;
        adjacencyLists = new LinkedList[vertex];
        for (int i=0; i<vertex; i++){
            adjacencyLists[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination){
        adjacencyLists[source].add(destination);
        if (directed) {
            adjacencyLists[destination].add(source);
        }
    }

    public void printGraph(){
        for (int i=0; i<vertex; i++){
            System.out.println("Vertice "+i+" is connected to : ");
            for (int j=0; j<adjacencyLists[i].size(); j++){
                System.out.print(adjacencyLists[i].get(j) + " ");
            }
        }
    }

    public void bfsTraversal(int source){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(source);
        while (!queue.isEmpty()){
            Integer vertice = queue.poll();
            visit(vertice);
            LinkedList<Integer> adjacencyList = adjacencyLists[vertice];
            adjacencyList.forEach(queue::add);
        }
    }

    public void dfsTraversal(int source){
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while(!stack.isEmpty()){
            Integer vertice = stack.pop();
            visit(vertice);
            LinkedList<Integer> adjacencyList = adjacencyLists[vertice];
            adjacencyList.forEach(stack::push);

        }
    }

    private void visit(Integer vertice) {
        System.out.println("Visiting vertice "+vertice+" ");
    }

}
