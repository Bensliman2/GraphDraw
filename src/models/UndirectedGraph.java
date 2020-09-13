package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 1/1/17.
 */
public class UndirectedGraph extends UnweightedGraph implements Graph1 {
    private Map<Integer, Set<Integer>> vertexMap = new HashMap<>();

    public UndirectedGraph(boolean Undirected) {
        super(Undirected);
    }


    @Override
    public boolean addVertex(Integer v) {
        vertexMap.put(v, new HashSet<>());
        return true;
    }


    @Override
    public Set<Integer> getVertices() {
        return new HashSet<>(vertexMap.keySet());
    }

    @Override
    public Set<Integer> getNeighbors(Integer ver) {
        return vertexMap.get(ver);
    }


    @Override
    public Double addEdge(Integer v1, Integer v2) {
        if (!vertexMap.containsKey(v1)) return -1d;
        if (!vertexMap.containsKey(v2)) return -1d;
        vertexMap.get(v1).add(v2);
        vertexMap.get(v2).add(v1);
                
        return 0d;
    }

    @Override
    public boolean addEdge(Integer v1, Integer v2, Double weight) {
        // not supported
        // use weighted graph
        return false;
    }

    @Override
    public boolean removeVertex(Integer v) {
        return false;
    }

    @Override
    public boolean removeEdge(Integer v1, Integer v2) {
        return false;
    }

    @Override
    public int size() {
        return vertexMap.size();
    }

}
