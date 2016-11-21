package ds.graphs;

public abstract class BaseGraph<V> {
	
	int numVertices;
	int numEdges;

	public int getNumVertices() {
		return numVertices;
	}

	public int getNumEdges() {
		return numEdges;
	}
 
	public abstract void addVertex(V v) ;
	
	public abstract void addEdge(V v,V w) ;
	

}
