package clases;

import interfaces.InterfaceMap;

public class LinkedMap<K extends Comparable<K>,V> implements InterfaceMap<K, V> {
	private DNode<Entry<K,V>> head;
	private DNode<Entry<K,V>> current;
	private DNode<Entry<K,V>> tail;
	private int size;

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public V get(K k) {
		if (size == 0 ) {
			return null;
		}
		
		DNode<Entry<K,V>> actual = head;
		while(actual != null && actual.getElement().getKey() != k) {
			actual = actual.getNext();
		}
		
		if(actual != null) {
			return actual.getElement().getValue();
		}else {
			return null;
		}
	}

	@Override
	public V put(K k, V v) {
		if(size == 0) {
			Entry<K,V> entrada = new Entry<K,V>(k,v);
			DNode<Entry<K,V>> nuevoNodo = new DNode<Entry<K,V>>(entrada,null,null);
			head = nuevoNodo;
			tail = nuevoNodo;
			size++;
			return null;
			
		}
		
		if(head.getElement().getKey() == k) {
			
			V dato = head.getElement().getValue();
			head.getElement().setValue(v);
			return dato;
		}
		
		DNode<Entry<K,V>> actual = head;
		while (actual.getNext() != null && actual.getNext().getElement().getKey() != k) {
			actual = actual.getNext();
		}
		
		if(actual.getNext() != null) {
			V valor = actual.getNext().getElement().getValue();
			actual.getNext().getElement().setValue(v);
			return valor;
		}
		else {
			Entry<K,V> nuevaEntrada = new Entry<K,V>(k,v);
			DNode<Entry<K,V>> nuevoNodo = new DNode<Entry<K,V>>(nuevaEntrada,null,tail);
			tail.setNext(nuevoNodo);
			tail = nuevoNodo;
			size++;
			return null;
		}
	}

	@Override
	public V remove(K k) {
		if(size==0) {
			return null;
		}
		
		if(head.getElement().getKey() == k) {
			V valor = head.getElement().getValue();
			head = head.getNext();
			head.setPrevious(null);
			size--;
			return valor;
		}
		
		DNode<Entry<K,V>> actual = head;
		while(actual != null && actual.getElement().getKey() != k) {
			actual = actual.getNext();
		}
		
		if(actual != null) {
			V valor = actual.getElement().getValue();
			actual.getPrevious().setNext(actual.getNext());
			if(actual.getNext() != null) {
				actual.getNext().setPrevious(actual.getPrevious());
			}
			else {
				tail = actual.getPrevious();
			}
			size--;
			return valor;
			}
		else {
		return null;}
			
	}

	@Override
	public K[] keys() {
		K[] claves = (K[]) new Object[size];
		DNode<Entry<K,V>> actual = head;
		int i = 0;
		while (actual!=null) {
			claves[i] = actual.getElement().getKey();
			actual = actual.getNext();
			i++;
		}
		return claves;
		
	}

	@Override
	public V[] values() {
		V[] valores = (V[]) new Object[size];
		DNode<Entry<K,V>> actual = head;
		int i =0;
		while(actual != null) {
			valores[i] = actual.getElement().getValue();
			actual = actual.getNext();
			i++;
		}
		return valores;
		
		
	}

	@Override
	public Entry<K, V>[] entries() {
		Entry<K,V>[] entradas = (Entry<K,V>[]) new Object[size];
		DNode<Entry<K,V>> actual = head;
		int i = 0;
		while(actual!=null) {
			entradas[i] = actual.getElement();
			actual = actual.getNext();
			i++;
		}
		return entradas;
	}

}
