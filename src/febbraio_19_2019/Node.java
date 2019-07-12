package febbraio_19_2019;

public	class Node<V> {

	public static enum Stato{
		UNEXPLORED, EXPLORING, EXPLORED;
	};
	
	private V element;
	public Stato stato;
	
	int map; // Usato da partition union e find
	
	public Node(V e) {
		element = e;
		stato = Stato.UNEXPLORED;
	}

	public V getElement() { return element; } 

	public String toString() {
		return element.toString();
	}
}