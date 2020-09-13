package algorithme.graph;

import models.Edge1;
import models.WeightedGraph;

import java.util.*;
import models.Graph1;

/**
 * Created by sherxon on 1/1/17.
 */

/**
 * This is traditional top-down approach to traverse graph. This is advantageous when the frontier is small
 */
public class BFS {

    protected Graph1 graph;

    
    List<Integer> path = new LinkedList<>();
    Queue<Integer> queue = new LinkedList<>();


    public BFS(Graph1 graph) {
        this.graph = graph;
    }


    public void search(Integer root) {
        if (root == null || !graph.getVertices().contains(root)) return;

        Set<Integer> visited = new HashSet<>();

        visited.add(root);
        
        queue.add(root);
        processVertex(root);
        

        while (!queue.isEmpty()) {

            Integer vertex = queue.peek();

            for (Integer neighbor : graph.getNeighbors(vertex))
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    
                    queue.add(neighbor);
                    processVertex(neighbor);
                }
            queue.remove();
        }
    }

    public void processVertex(Integer vertex) {
        path.add(vertex); 
        
    }


    public List<Integer> getPathFrom(Integer source) {
        if (source == null || !graph.getVertices().contains(source))
            return null;
        search(source);
        return path;
    }
    
    
}
