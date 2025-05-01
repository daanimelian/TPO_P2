package mapSimple;

public class MapSimple<K extends Comparable<K>,V> {
	private int size;
	private Nodo<Entrada<K,V>> head;
	private Nodo<Entrada<K,V>> tail;
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public V get(K key) {
		Nodo<Entrada<K,V>> aux;
		V resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				resul = aux.getValue().getValue();
			}else {
				aux = aux.getNext();				
			}
		}
		return resul;
	}
	
	public V put(K key, V value) {
		Nodo<Entrada<K,V>> aux;
		V resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				resul = aux.getValue().getValue();
				aux.getValue().setValue(value);
			}else {
				aux = aux.getNext();				
			}
		}
		
		if (resul == null) {
			Entrada<K,V> nuevaEntry = new Entrada<K,V>(key, value);
		    Nodo<Entrada<K,V>> nuevoNodo = new Nodo<Entrada<K,V>>(nuevaEntry);

		    if (isEmpty()) {
		        head = tail = nuevoNodo;
		    } else {
		        tail.setNext(nuevoNodo);
		        tail = nuevoNodo;
		    }
		    size++;
		}
		return resul;
	}
	
	public V remove(K key) {
		Nodo<Entrada<K,V>> aux;
		V resul = null;
		aux = head;
		while(aux != null && resul == null) {
			if(aux.getValue().getKey().equals(key)) {
				resul = aux.getValue().getValue();
				
				if (aux.getNext() != null) {
	                aux.getNext().setPrev(aux.getPrev());
	            } else {
	                tail = aux.getPrev();
	            }
				
				if (aux.getPrev() != null) {
	                aux.getPrev().setNext(aux.getNext());
	            } else {
	                head = aux.getNext();
	            }
				
				size--;
			}else {
				aux = aux.getNext();				
			}
		}
				
		return resul;
	}
	
	public K[] keys(){
		Nodo<Entrada<K,V>> aux;
		K[] resul = (K[]) new Object[size];
		aux = head;
		int contador = 0;
		while(aux != null) {
			resul[contador] = aux.getValue().getKey();
			contador++;
			aux = aux.getNext();		
		}
		return resul;
	}
	
	public V[] values(){
		Nodo<Entrada<K,V>> aux;
		V[] resul = (V[]) new Object[size];
		aux = head;
		int contador = 0;
		while(aux != null) {
			resul[contador] =  aux.getValue().getValue();
			contador++;
			aux = aux.getNext();		
		}
		return resul;
	}
	
	public Entrada<K,V>[] entries(){
		Nodo<Entrada<K,V>> aux;
		Entrada<K,V>[] resul = (Entrada<K,V>[]) new Object[size];
		aux = head;
		int contador = 0;
		while(aux != null) {
			resul[contador] =  aux.getValue();
			contador++;
			aux = aux.getNext();		
		}
		return resul;
	}
}
