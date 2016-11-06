package io.github.satr.training.problems;

import io.github.satr.training.GraphHelper;
import io.github.satr.training.datastructures.GraphEx;
import io.github.satr.training.datastructures.GraphNodeEx;

public class GraphProblems {
    public static void searchNodeWithMinData()  {
        System.out.println("Search min node (one which has min data).");

        GraphEx<GraphNodeEx<Integer>> notDirectedGraph = GraphHelper.createGraph1n6(false);

        GraphNodeEx<Integer> minNode = null;

        for(GraphNodeEx<Integer> node: notDirectedGraph) {
            if(minNode == null || minNode.getData().compareTo(node.getData()) > 0)
                minNode = node;
        }

        System.out.printf("Min node: %s\n", minNode);
    }

    public static void checkIfPathExistsBetweenNodes() {
        System.out.println("Check if path exists between nodes.");

        GraphEx directedGraph = GraphHelper.createGraph1n6(true);

        GraphNodeEx<Integer>[] nodeArray = new GraphNodeEx[0];
        nodeArray = directedGraph.getNodeArray(nodeArray);
        GraphNodeEx<Integer> n1 = nodeArray[0];
        GraphNodeEx<Integer> n2 = nodeArray[nodeArray.length - 1];

        boolean hasPath1t2 = directedGraph.hasPath(n1, n2);
        System.out.printf("Path from %s to %s: %s exists.\n", n1, n2, hasPath1t2 ? "" : "not");

        boolean hasPath2t1 = directedGraph.hasPath(n2, n1);
        System.out.printf("Path from %s to %s: %s exists.\n", n1, n2, hasPath2t1 ? "" : "not");
    }
}
