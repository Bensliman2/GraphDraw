package algorithme.graph;

/**
 * Created by sherxon on 2017-04-09.
 */

import algo.UnionFind;
import models.Edge1;
import models.WeightedGraph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
* This is another greedy algorithm to find Minimum Spanning Tree of a connected weighted Graph.
* The idea is choosing least weighted edge until all vertex are in the same connected component. In the beginning
* all vertices are considered as separate components and connect them by choosing least weighted edge.
* Union Find algorithm is used to keep track of connected components. Running time is O(E logE)
* */
public class Kruskal {

    private WeightedGraph graph;
    private UnionFind unionFind;
    public Kruskal(WeightedGraph graph) {
        this.graph = graph;
        this.unionFind=new UnionFind(graph.size());
    }

    public List<Edge1> getMST() {
        List<Edge1> list = new ArrayList<>();
        PriorityQueue<Edge1> q = new PriorityQueue<>(graph.getEdges());
        while (!q.isEmpty()){
            Edge1 minEdge=q.remove(); // remove min Edge1 and check if both vertices of this edge is connected
            if(!unionFind.connected(minEdge.getFrom(), minEdge.getTo())){
                list.add(minEdge);
                unionFind.union(minEdge.getFrom(), minEdge.getTo()); // make both vertices one component
            }
        }
        return list;
    }
}
