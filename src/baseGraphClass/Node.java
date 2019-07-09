package baseGraphClass;

import java.util.List;

public class Node{
	int key;
	String label;
	int tag = Graph.UNEXPLORED;
	List<Edge> incomingEdges;
	List<Edge> outgoingEdges;
	
	/*
	* Ritorna la chiave del nodo this.
	*/
	public int getNodeKey() {
		return this.key;
	}
	
	/*
	* Ritorna la label del nodo this.
	*/
	public String getNodeLabel() {
		return this.label;
	}

	public int getNodeTag(){
		return tag;
	}

	public void setNodeTag(int tag){
		this.tag = tag;
	}
	
	public String toString() {
		return this.key + ":" + this.label;
	}
}
