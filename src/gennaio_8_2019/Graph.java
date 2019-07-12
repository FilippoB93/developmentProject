package gennaio_8_2019;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
* Grafo semplice diretto rappresentato mediante lista delle incidenze.
*/
public class Graph {

	/*
	* Etichette potenzialmente utili, associabili agli archi di un grafo.
	*/
	public static final int UNEXPLORED = 0;
	public static final int DISCOVERY = 1;
	public static final int BACK = 2;
	public static final int EXCLUDED = 3;
	
	private static int node_key = 0;
	private static int edge_key = 0;
	
	private LinkedList<Node> nodes;
	int nNodes;
	int nEdges;
	
	/*
	* Crea un nuovo grafo.
	*/
	public Graph() {
		nodes = new LinkedList<Node>();
	}
	
	/*
	* Ritorna la lista dei nodi del grafo.
	*/
	public List<Node> getNodes(){
		return nodes;
	}

	/*
	* Ritorna la prossima chiave da assegnare al nodo di un qualsiasi grafo. 
	*/
	public static int getNextNodeKey() {
		return node_key;
	}
	
	/*
	* Ritorna la prossima chiave da assegnare all'arco di un qualsiasi grafo.
	*/
	public static int getNextEdgeKey() {
		return edge_key;
	}
	
	/*
	* Ritorna la lista degli archi in entrata ad n.
	*/
	public List<Edge> getIncomingEdges(Node n){
		return n.incomingEdges;
	}
	
	/*
	 * Ritorna la lista degli archi in uscita da n.
	 */
	public List<Edge> getOutgoingEdges(Node n){
		return n.outgoingEdges;
	}
	
	/*
	* Aggiunge un nodo al grafo con la label specificata.
	*/
	public Node addNode(String label) {
		Node toPut = new Node();
		toPut.incomingEdges = new LinkedList<Edge>();
		toPut.outgoingEdges = new LinkedList<Edge>();
		toPut.key = node_key++;
		toPut.label = label;
		this.nodes.add(toPut);
		this.nNodes++;
		return toPut;
	}
	
	/*
	* Aggiunge al grafo un arco che collega i nodi n1 ed n2. In direzione n1 -> n2
	*/
	public void addEdge(Node n1, Node n2) {
		Edge toPut = new Edge();
		toPut.key = edge_key++;
		toPut.n1 = n1;
		toPut.n2 = n2;
		for(Node nd : this.nodes) {
			if(nd == n1) {
				for(Edge edg : nd.outgoingEdges) {
					if(edg.n2 == n2) {
						edge_key--;
						return; // arco gia' presente nel grafo
					}
				}
				nd.outgoingEdges.add(toPut);
				n2.incomingEdges.add(toPut);
			}
		}
		this.nEdges++;
	}
	
	/*
	*Rimuove dal grafo l'arco che collega i nodi v1 e v2.
	*/
	public void removeEdge(Node v1, Node v2) {
		for(Node nd : this.nodes) {
			if(nd == v1) {
				Iterator<Edge> it = nd.outgoingEdges.iterator();
				while(it.hasNext()) {
					Edge edg = it.next();
					if(edg.n2 == v2) {
						it.remove();
						this.nEdges--;
					}
				}
			}
			if(nd == v2) {
				Iterator<Edge> it = nd.incomingEdges.iterator();
				while(it.hasNext()) {
					Edge edg = it.next();
					if(edg.n1 == v1)
						it.remove();
				}
			}
		}
	}
	
	/*
	* Rimuove il nodo v dal grafo.
	*/
	public void removeNode(Node n) {
		Iterator<Node> it = this.nodes.iterator();
		while(it.hasNext()) {
			Node nd = it.next();
			if(nd == n) {
				Iterator<Edge> it2 = nd.outgoingEdges.iterator();
				while(it2.hasNext()) {
					it2.next();
					it2.remove();
					this.nEdges--;
				}
				it2 = nd.incomingEdges.iterator();
				while(it2.hasNext()) {
					it2.next();
					it2.remove();
					this.nEdges--;
				}
				it.remove();
			}
			else {
				Iterator<Edge> it2 = nd.outgoingEdges.iterator();
				while(it2.hasNext()) {
					Edge edg = it2.next();
					if(edg.n2 == n)
						it2.remove();
				}
				it2 = nd.incomingEdges.iterator();
				while(it2.hasNext()) {
					Edge edg = it2.next();
					if(edg.n1 == n)
						it2.remove();
				}
			}
		}
		this.nNodes--;
	}
	
	/*
	* Stampa a video una rappresentazione del grafo.
	*/
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(Node nd : this.nodes) {
			sb.append(nd.label + " <-- : ");
			for(Edge edg : nd.incomingEdges) {
				sb.append(edg.getEdgeOpposite(nd).label + " ");
			}
			sb.append("\n");
			sb.append("  --> : ");
			for(Edge edg : nd.outgoingEdges) {
				sb.append(edg.getEdgeOpposite(nd).label + " ");
			}
			sb.append("\n");
		}
		sb.append("n_nodes:" + this.nNodes + ", n_edges:" + this.nEdges);
		return sb.toString();
	}
}


