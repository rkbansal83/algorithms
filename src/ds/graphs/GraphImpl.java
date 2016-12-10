package ds.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphImpl<V> extends BaseGraph<V>{
	
	private Map<V,List<V>> adjList ;
	
	
    public GraphImpl() {
			 adjList = new HashMap<V,List<V>>();
	}
	//add the vertex
	public void addVertex(V vertex) {
		if (adjList.containsKey(vertex)) return;
		adjList.put(vertex, new ArrayList<V>());
		this.numVertices++;
	}

	//add an edge from v to w
	public void addEdge(V v, V w) {
		//if vertices are not already there , add them in the graph
		this.addVertex(v);
		this.addVertex(w);
		adjList.get(v).add(w);
		this.numEdges++;
	}
	
	
	public String toString () {
        StringBuffer s = new StringBuffer();
        for (V v: adjList.keySet()) s.append("\n    " + v + " -> " + adjList.get(v));
        return s.toString();                
    }
	
	/**
     * True iff graph contains vertex.
     */
    public boolean contains (V vertex) {
        return adjList.containsKey(vertex);
    }

	/**
     * Remove an edge from the graph.  Nothing happens if no such edge.
     * @throws IllegalArgumentException if either vertex doesn't exist.
     */
    public void remove (V from, V to) {
        if (!(this.contains(from) && this.contains(to)))
            throw new IllegalArgumentException("Nonexistent vertex");
        adjList.get(from).remove(to);
    }
    
    public  ArrayList<V> dfs(V sourceVertex) {
        ArrayList<V> result = new ArrayList<V>();
        ArrayList<V> visited = new ArrayList<V>();
        Stack<V> stack = new Stack<V>();
        stack.push(sourceVertex);
        while(!stack.isEmpty()) {
            V elem = stack.pop();
            if(!visited.contains(elem)) {
                result.add(elem);
                for(V neighbor:adjList.get(elem))
                    stack.push(neighbor);
                      visited.add(elem);
            }
        }
        return result;
     }

    public static void main (String[] args) {
        // Create a Graph with Integer nodes
        GraphImpl<Integer> graph = new GraphImpl<Integer>(); 		
        graph.addEdge(0, 1); graph.addEdge(0, 2); graph.addEdge(0, 3);
        graph.addEdge(1, 2); graph.addEdge(1, 3); graph.addEdge(2, 3);
        graph.addEdge(2, 4); graph.addEdge(4, 5); graph.addEdge(5, 6);
        System.out.println(graph);
    }

}
