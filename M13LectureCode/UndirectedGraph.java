import java.util.*;

/**
 * A class that implements the ADT undirected graph.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
public class UndirectedGraph<T> extends DirectedGraph<T> implements GraphInterface<T> {

	public UndirectedGraph() {
		super();
	} 

	public boolean addEdge(T begin, T end, double edgeWeight) {
		return super.addEdge(begin, end, edgeWeight) && super.addEdge(end, begin, edgeWeight);
		// Assertion: edge count is twice its correct value due to calling addEdge twice
	} 

	public boolean addEdge(T begin, T end) {
		return this.addEdge(begin, end, 0);
	} 

	public int getNumberOfEdges() {
		return super.getNumberOfEdges() / 2;
	} 

	public Stack<T> getTopologicalOrder() {
		throw new UnsupportedOperationException("Topological sort is illegal in an undirected graph.");
	} 
	
	@Override
	public boolean isCyclic() {
		// put all vertices into a white list
		List<T> whiteList = new ArrayList<>(vertices.keySet());
		List<T> greyList = new ArrayList<>();
		List<T> blackList = new ArrayList<>();
		
		// iterate through each vertices in the whiteMap
		while (!whiteList.isEmpty()) {
			Vertex<T> currVertex = vertices.get(whiteList.get(0));
			
			if (isCyclicHelper(currVertex, null, whiteList, greyList, blackList))
				return true;
		}
		
		// no cycle found reaching this point
		return false;
		
		
	}
	
	private boolean isCyclicHelper(Vertex<T> currVertex, Vertex<T> preVertex,List<T> whiteList, List<T >greyList, List<T> blackList) {
		// put currVertex from white to grey
		whiteList.remove(currVertex.getData());
		greyList.add(currVertex.getData());

		// iterate all neighbors of currVertex
		Iterator<Vertex<T>> neighbors = currVertex.getNeighborIterator();
		while (neighbors.hasNext()) {
			Vertex<T> neighbor = neighbors.next();
			if (neighbor.equals(preVertex) || blackList.contains(neighbor.getData())) {
				continue;
			}
			else if (greyList.contains(neighbor.getData())) {
				return true;
			}
			else if (isCyclicHelper(neighbor, currVertex, whiteList, greyList, blackList)) {
				return true;
			}
		}
		
		// all neighbors are not part of a cycle for currVertex, add currVertex to black list
		blackList.add(currVertex.getData());
		return false;
	}
} 
