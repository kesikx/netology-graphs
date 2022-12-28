package ru.netology.graphs.graph;

import lombok.Getter;

import java.util.*;

@Getter
public class Graph {
    private final int vertexAmount;
    private final Set<Edge> edges;
    private final Map<Integer, List<Integer>> graphTopology;

    public Graph(int vertexAmount, Set<Edge> edges) {
        this.vertexAmount = vertexAmount;
        this.edges = edges;
        this.graphTopology = buildTopology();
    }

    private Map<Integer, List<Integer>> buildTopology() {
        Map<Integer, List<Integer>> topology = new HashMap<>();
        for (int vertexIndex = 0; vertexIndex < vertexAmount; vertexIndex++) {
            topology.put(vertexIndex, new ArrayList<>());
        }
        for (Edge edge: edges) {
            var headEnd = edge.getHeadEnd();
            var tailEnd = edge.getTailEnd();
            assert topology.containsKey(headEnd);
            assert topology.containsKey(tailEnd);
            var headEndNeighbors = topology.get(headEnd);
            headEndNeighbors.add(tailEnd);
            topology.put(headEnd, headEndNeighbors);
            var tailEndNeighbors = topology.get(tailEnd);
            tailEndNeighbors.add(headEnd);
            topology.put(tailEnd, tailEndNeighbors);
        }
        return topology;
    }
}
