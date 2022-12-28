package ru.netology.graphs.topologycalculator;

import ru.netology.graphs.graph.Graph;

import java.util.*;

public class VertexReachabilityCalculator {

    private VertexReachabilityCalculator() {
    }

    public static List<Integer> getReachableVerticesPerVertex(Graph graph) {
        var graphComponents = getGraphComponents(graph);
        var reachableVerticesPerVertex = new ArrayList<Integer>();
        for (List<Integer> component : graphComponents) {
            var reachableVertices = component.size() - 1;
            for (int vertex = 0; vertex < component.size(); vertex++) {
                reachableVerticesPerVertex.add(reachableVertices);
            }
        }
        return reachableVerticesPerVertex;
    }

    private static List<List<Integer>> getGraphComponents(Graph graph) {
        var graphTopology = graph.getGraphTopology();
        Deque<Integer> searchQueue = new ArrayDeque<>();
        List<Integer> vertices = new ArrayList<>(graphTopology.keySet());
        List<List<Integer>> graphComponents = new ArrayList<>();
        while (vertices.iterator().hasNext()) {
            searchQueue.add(vertices.iterator().next());
            List<Integer> graphComponent = new ArrayList<>();
            while (!searchQueue.isEmpty()) {
                var vertex = searchQueue.removeFirst();
                if (!graphComponent.contains(vertex)) {
                    graphTopology.get(vertex).stream()
                            .filter(Objects::nonNull)
                            .filter(e -> !graphComponent.contains(e))
                            .forEach(searchQueue::add);
                    graphComponent.add(vertex);
                }
            }
            vertices.removeAll(graphComponent);
            graphComponents.add(graphComponent);
        }
        return graphComponents;
    }
}