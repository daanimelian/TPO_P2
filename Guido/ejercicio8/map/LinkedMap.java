package map;

public class LinkedMap<K extends Comparable <K>, V> implements Map <K, V>{
	Node <Entrada<K, V>> head;
	Node <Entrada<K, V>> tail;
	private int size;
	public LinkedMap(){
		head = null;
		tail = null;
		size = 0;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public V get(K k) {
		if(this.isEmpty())
			return null;
		V valor = null;
		Node <Entrada<K, V>> nodo = this.nodeKey(k);
		if(nodo != null)
			valor = nodo.getData().getValue();
		return valor;
	}
	public V put(K k, V v) {
		if(this.isEmpty()) {
			head = new Node<>(new Entrada<>(k, v), null, null);
			tail = head;
			size++;
			return null;
		}
		V retorno = null;
		Node <Entrada<K, V>> nodo = this.nodeKey(k);
		if(nodo != null) {
			retorno = nodo.getData().getValue();
			nodo.getData().setValue(v);
		}
		else {
				tail.setNext(new Node<>(new Entrada<>(k, v), null, tail));
				tail = tail.getNext();
				size++;
		}
		return retorno;
	}
		
	
	
	public V remove(K k) {
		if(this.isEmpty()) {
			return null;
		}
		V retorno = null;
		Node <Entrada<K, V>> nodo = this.nodeKey(k);
		if(nodo != null) {
			retorno = nodo.getData().getValue();
			if(nodo == tail) {
				tail = nodo.getBefore();
				tail.setNext(null);
			}
			else if(nodo == head) {
				head = head.getNext();
				head.setTail(null);
			}
			else {
				Node <Entrada<K, V>> anterior = nodo.getBefore();
				anterior.setNext(nodo.getNext());
				nodo.getNext().setTail(anterior);
			}
			
			nodo = null;
			size --;
		}
		return retorno;
	}
	public K [] keys() {
		K[] arregloKeys =(K[]) new Object[size];
		if(this.isEmpty()) {
			return arregloKeys;
		}
		Node <Entrada <K, V>> aux = head;
		int i = 0;
		while (aux!=null) {
			arregloKeys[i] = aux.getData().getKey();
			i++;
			aux = aux.getNext();
		}
		return arregloKeys;
	}
	public V [] values(){
		V[] arregloValues =(V[]) new Object[size];
		if(this.isEmpty()) {
			return arregloValues;
		}
		Node <Entrada <K, V>> aux = head;
		int i = 0;
		while (aux!=null) {
			arregloValues[i] = aux.getData().getValue();
			i++;
			aux = aux.getNext();
		}
		return arregloValues;
		
	}
	
	public Entry<K, V> [] entries(){
	    Entry<K, V>[] arregloEntradas = (Entry<K, V>[]) new Entrada[size];
		if(this.isEmpty()) {
			return arregloEntradas;
		}
		Node <Entrada <K, V>> aux = head;
		int i = 0;
		while (aux!=null) {
			arregloEntradas[i] = aux.getData();
			i++;
			aux = aux.getNext();
		}
		return arregloEntradas;
		
	}
	private Node <Entrada<K, V>> nodeKey(K k) { 
		/*Funcion para encontrar el indice especifo de una key en particular.
		 La implemento debido a que en varias partes de la Clase utilizo esta logica*/
		
		Node <Entrada<K, V>> aux = head;
		boolean noEncontrado = true;

		while(aux != null && noEncontrado) {
			if(aux.getData().getKey().equals(k)) {
				noEncontrado = false;
			}
			else
				aux = aux.getNext();
		}
		
		return aux;
	}

}
