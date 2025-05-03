package clases;

import interfaces.InterfaceDictionary;
import interfaces.MyException;
import interfaces.*;

public class LinkedDictionary<K,V> implements InterfaceDictionary<K,V> {
	private DNode<Entry<K,LinkedList<V>>> head;
	private DNode<Entry<K,LinkedList<V>>> tail;
	private int size;

	public LinkedDictionary() {
		head = null;
		tail = null;
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	private LinkedList<V> copiarListaValores(LinkedList<V> original) {
		LinkedList<V> copia = new LinkedList<V>();
		original.First();
		while (!original.atEnd()) {
			copia.addLast(original.getCurrent());
			original.advance();
		}
		return copia;
	}

	@Override
	public Iterable<V> get(K k) {
		if (size == 0) {
			return null;
		}
		DNode<Entry<K,LinkedList<V>>> actual = head;
		while (actual != null && !actual.getElement().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			return copiarListaValores(actual.getElement().getValue());
		}
		return null;
	}

	@Override
	public void put(K k, V v) {
		if (size == 0) {
			LinkedList<V> listaValores = new LinkedList<V>();
			listaValores.addFirst(v);
			Entry<K,LinkedList<V>> entrada = new Entry<K,LinkedList<V>>(k,listaValores);
			DNode<Entry<K,LinkedList<V>>> nuevoNodo = new DNode<>(entrada,null,null);
			head = nuevoNodo;
			tail = nuevoNodo;
			size++;
			return;
		}
		DNode<Entry<K,LinkedList<V>>> actual = head;
		while (actual != null && !actual.getElement().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual != null) {
			actual.getElement().getValue().addLast(v);
		} else {
			LinkedList<V> listaValores = new LinkedList<V>();
			listaValores.addFirst(v);
			Entry<K,LinkedList<V>> entrada = new Entry<K,LinkedList<V>>(k,listaValores);
			DNode<Entry<K,LinkedList<V>>> nuevoNodo = new DNode<>(entrada,null,tail);
			tail.setNext(nuevoNodo);
			tail = nuevoNodo;
			size++;
		}
	}

	@Override
	public Iterable<V> remove(K k) {
		if (size == 0) {
			return null;
		}
		DNode<Entry<K,LinkedList<V>>> actual = head;
		while (actual != null && !actual.getElement().getKey().equals(k)) {
			actual = actual.getNext();
		}
		if (actual == null) {
			return null;
		}

		LinkedList<V> copiaValores = copiarListaValores(actual.getElement().getValue());

		if (actual == head) {
			head = head.getNext();
			if (head != null) {
				head.setPrevious(null);
			}
			else {
				tail = null;
			}
		} else {
			actual.getPrevious().setNext(actual.getNext());
			if (actual.getNext() != null) {
				actual.getNext().setPrevious(actual.getPrevious());
			} else {
				tail = actual.getPrevious();
			}
		}
		size--;
		return copiaValores;
	}

	@Override
	public V remove(K k, V v) {
	    if (size == 0) {
	        return null;
	    }
	    DNode<Entry<K, LinkedList<V>>> actual = head;
	    while (actual != null && !actual.getElement().getKey().equals(k)) {
	        actual = actual.getNext();
	    }
	    if (actual != null) {
	        LinkedList<V> listaValores = actual.getElement().getValue();
	        try {
	            listaValores.remove(v); 
	            if (listaValores.getSize() == 0) {
	                if (actual == head && actual == tail) {
	                    head = null;
	                    tail = null;
	                } else if (actual == head) {
	                    head = head.getNext();
	                    if (head != null) {
	                    	head.setPrevious(null);
	                    }
	                } else if (actual == tail) {
	                    tail = tail.getPrevious();
	                    if (tail != null) {
	                    	tail.setNext(null);
	                    }
	                } else {
	                    actual.getPrevious().setNext(actual.getNext());
	                    actual.getNext().setPrevious(actual.getPrevious());
	                }
	                size--;
	            }
	            return v;
	        } catch (MyException e) {
	            return null;
	        }
	    } else {
	        return null;
	    }
	}

	@Override
	public Iterable<K> keys() {
		LinkedList<K> claves = new LinkedList<K>();
		DNode<Entry<K, LinkedList<V>>> actual = head;
		while (actual != null) {
			claves.addLast(actual.getElement().getKey());
			actual = actual.getNext();
		}
		return claves;
	}

	@Override
	public Iterable<Entry<K, Iterable<V>>> entries() {
		LinkedList<Entry<K, Iterable<V>>> entradas = new LinkedList<>();
		DNode<Entry<K, LinkedList<V>>> actual = head;
		while (actual != null) {
			LinkedList<V> copiaValores = copiarListaValores(actual.getElement().getValue());
			entradas.addLast(new Entry<K, Iterable<V>>(actual.getElement().getKey(), copiaValores));
			actual = actual.getNext();
		}
		return entradas;
	}
	
	
}
