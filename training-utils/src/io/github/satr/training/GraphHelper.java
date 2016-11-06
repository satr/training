package io.github.satr.training;

import io.github.satr.training.datastructures.GraphEx;
import io.github.satr.training.datastructures.GraphNodeEx;

public class GraphHelper {
    /*
    * ,/ is a directed link from up to down, if the graph is directed
    *
    *                n1
    *             ,/   \,
    *             n2   n3
    *           /' ,\ ,/  \,
    *          |   n5   n4
    *          \ ,/
    *           n6
    * */
    public static GraphEx createGraph1n6(boolean directedGraph) {
        int count = 0;
        GraphNodeEx<Integer> n1 = new GraphNodeEx<>(++count);
        GraphNodeEx<Integer> n2 = new GraphNodeEx<>(++count);
        linkNodes(directedGraph, n1, n2);
        GraphNodeEx n3 = new GraphNodeEx<>(++count);
        linkNodes(directedGraph, n1, n3);
        GraphNodeEx<Integer> n4 = new GraphNodeEx<>(++count);
        linkNodes(directedGraph, n3, n4);
        GraphNodeEx<Integer> n5 = new GraphNodeEx<>(++count);
        linkNodes(directedGraph, n2, n5);
        linkNodes(directedGraph, n4, n5);
        GraphNodeEx<Integer> n6 = new GraphNodeEx<>(++count);
        linkNodes(directedGraph, n5, n6);
        linkNodes(directedGraph, n6, n2);//link backward to n2 (in directed graph)
        GraphEx<GraphNodeEx<Integer>> graph = new GraphEx<>();
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);
        graph.add(n5);
        graph.add(n6);
        return graph;
    }

    private static void linkNodes(boolean directedGraph, GraphNodeEx<Integer> node1, GraphNodeEx node2) {
        if(directedGraph)
            node1.linkTo(node2);
        else
            node1.link(node2);
    }
}
