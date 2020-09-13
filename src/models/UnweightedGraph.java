/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author CSX101
 */
public class UnweightedGraph implements Graph1{
        private Map<Integer, Set<Integer>> vertexMap = new HashMap<>();
        
    private boolean Undirected = false;
    public UnweightedGraph(boolean Undirected){
        this.Undirected = Undirected;
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
         if(Undirected) {
            //
            vertexMap.get(v2).add(v1);
        }
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
       if(!Undirected) {
        if (!vertexMap.containsKey(v1)) return false;
        if (!vertexMap.containsKey(v2)) return false;
        vertexMap.get(v1).remove(v2);
        return true;
       } else{return false;}
        
    }
    
    public void resetgraph (){
        this.vertexMap.clear();
    }

    @Override
    public int size() {
        return vertexMap.size();
    }
}
