package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sherxon on 1/7/17.
 */
public class WeightedGraph{
    Set<Edge1> edges = new HashSet<>();
    public boolean Undirected = false;
    private Map<Integer, Set<Edge1>> map = new HashMap<>();

    public WeightedGraph(boolean Undirected) {
        this.Undirected = Undirected;
    }

    public void addVertex(Integer v) {
        map.put(v, new HashSet<>());
    }

    public void addEdge(Integer v1, Integer v2, Double weight) {
        if(!map.containsKey(v1) || !map.containsKey(v2)) return;
        
        Edge1 edge = new Edge1(v1, v2, weight);
        
        map.get(v1).add(edge);
        edges.add(edge);
       
        if(Undirected) {
            Edge1 edge2 = new Edge1(v2, v1, weight);
            map.get(v2).add(edge2);
            edges.add(edge2);
        }
    }
    
    
   
    public boolean removeEdge(Integer v1, Integer v2,  double weight) {
        if(!Undirected) {
        if (!map.containsKey(v1)) return false;
        if (!map.containsKey(v2)) return false;
        Set<Edge1> connectedEdge1s = map.get(v1);
        Edge1 ed = new Edge1(v1, v2, weight);
       // map.get(v1).remove(edge);
        for(Edge1 edg : connectedEdge1s){
          if(edg.equals(ed)){
             map.get(v1).remove(edg);
          }
        }
        return true;
       } else{return false;}
        
        
    }


    public void removeVertex(Integer v) {

    }
    
    public void resetgraph (){
        this.map.clear();
        this.edges.clear();
        
    }


    public Set<Integer> getVertices() {
        return new HashSet<>(map.keySet());
    }

    public Set<Edge1> getEdges() {
        return edges;
    }

    public Set<Edge1> getEdges(Integer ver) {
        return map.get(ver);
    }

    public int size() {
        return map.size();
    }
}
