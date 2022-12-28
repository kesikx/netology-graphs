package ru.netology.graphs;

import ru.netology.graphs.algorithm.VertexReachabilityCalculator;
import ru.netology.graphs.graph.Edge;
import ru.netology.graphs.graph.Graph;

import java.util.HashSet;
import java.util.Set;

public class Main {
    private static final Set<Edge> edges = new HashSet<>();

    static {
        edges.add(Edge.builder().headEnd(0).tailEnd(1).build());
        edges.add(Edge.builder().headEnd(1).tailEnd(2).build());
        edges.add(Edge.builder().headEnd(3).tailEnd(4).build());
    }
    public static void main(String[] args) {
        var graph = new Graph(6, edges);
        System.out.println(VertexReachabilityCalculator.getReachableVerticesPerVertex(graph));
    }
}