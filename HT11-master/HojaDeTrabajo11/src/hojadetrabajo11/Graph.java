
package hojadetrabajo11;

import java.util.*;
import java.util.stream.Collectors;

public class Graph<E> {        
    private Set<String> vertices;
    private Map<String, Map<String, E>> adjList;
    public Graph(){
        vertices = new HashSet<String>();
        adjList = new HashMap<String, Map<String, E>>();
    }
    public void addEdge(String vertice1, String vertice2, E value){
        vertices.add(vertice1);
        vertices.add(vertice2);
        adjList.putIfAbsent(vertice1, new HashMap<String,E>());
        
        adjList.get(vertice1).put(vertice2, value);
    }
    public E getEdge(String vertice1, String vertice2){
       return adjList.get(vertice1).get(vertice2); 
    }
    public Set<String> getVertices(){
        return vertices;
    }
    public Map<String, Map<String, E>> getAdjList(){
        return adjList;
    }
}
    

