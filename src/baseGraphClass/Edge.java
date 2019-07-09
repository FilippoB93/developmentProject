package baseGraphClass;



public class Edge{
	int key;
	int tag = Graph.UNEXPLORED;
	Node n1;
	Node n2;
	
	/*
	* Ritorna il nodo in posizione opposta a cur, rispetto all'arco this.
	*/
	public Node getEdgeOpposite(Node cur) {
		if (this.n1 == cur)
			return this.n2;
		if (this.n2 == cur)
			return this.n1;
		throw new RuntimeException("ERROR - Wrong invocation in getEdgeOpposite");
	}
	
	/*
	* Ritorna la chiave dell'arco this.
	*/
	public int getEdgeKey() {
		return this.key;
	}
	
	public int getEdgeTag(){
		return tag;
	}

	public void setEdgeTag(int tag){
		this.tag = tag;
	}

	public String toString() {
		return this.key + ":<" + this.n1 + this.n2 + ">";
	}
}

