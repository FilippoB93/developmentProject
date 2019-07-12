package gennaio_8_2019;

import java.util.Random;

// Gruppo di aloritmi riguardanti l'esercizio 2 di programmazione di alforitmi.

public class GraphServices {

	/*
	 * 2.1 08/01/2019
 	 * Dato un grafo g, rappresentato mediante matrice di adiacenze, ritornare il grafo g'
 	 * che e' uguale a g, ma e' rappresentato mediante lista di incidenze.
 	 * 
 	 * Realizzare una funzione/metodo mat2list che, data la matrice di adiacenze di un grafo diretto G, restituisce
	   la rappresentazione per lista di incidenze dello stesso grafo G. Si rammenta che la matrice di
       adiacenze è una matrice quadrata in cui ogni riga ed ogni colonna rappresentano un nodo del grafo. La
       cella hi; ji ha valore 1 se esiste un arco che connette i nodi i e j (in direzione da i verso j), 0 altrimenti. Si
       consiglia di utilizzare la funzione/metodo ausiliaria char_gen(int seed) per la generazione di caratteri
       pseudo-casuali, da assegnare come label ai nodi che verranno creati. Il Driver relativo a questo esercizio
       legge la matrice da standard input seguendo la seguente formattazione:
       – La prima riga contiene la dimensione n della matrice (quadrata);
       – Seguono n righe, ciascuna contenente n interi in f0; 1g.
	 */
	
	public static Graph mat2list(int[][] mat){
		
		/*DA IMPLEMENTARE*/
		return null;
	}

	/*
	 * 2.2 08/01/2019
	 * Dato un grafo in input, la funziona ritorna 1 se il grafo e' fortemente connesso, 0 altrimenti.
	 * 
	 * Realizzare una funzione/metodo is_strongly_connected che, dato un grafo diretto semplice G, stabilisce
       se G è fortemente connesso.
	 */
	public static int isStronglyConnected(Graph g){
		/*DA IMPLEMENTARE*/
		return 0;
	}

	/*
	 * 2.3 08/01/2019
 	 * Dato un grafo g, ritornare 1 se il grafo e' uguale alla sua chiusura transitiva, 0 altrimenti. 
 	 * 
 	 * Realizzare una funzione/metodo is_closed che, dato un grafo diretto semplice G, stabilisce se G è uguale
       alla sua chiusura transitiva.
	 */ 
	public static int isClosed(Graph g) {
		/*DA IMPLEMENTARE*/
		return 0;
	}
	
	@SuppressWarnings("unused")
	private static char char_gen() {
		Random rnd = new Random();
		int n = rnd.nextInt(26) + 65;
		return (char) n;
	}
}

