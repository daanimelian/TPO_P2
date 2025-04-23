package clases;

import Excepciones.MyException;
import interfaces.InterfacePriorityQueue;

public class LinkedPriorityQueue<K extends Comparable<K>, V> implements InterfacePriorityQueue<K,V> {
	
	protected DNode<Entry<K,V>> head;
	protected DNode<Entry<K,V>> tail;
	protected int size;
	
	
	
//	---------Constructor---------
	public LinkedPriorityQueue(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}



@Override
public int size() {
	return size;
}



@Override
public boolean isEmpty() {
	return size == 0;
}



@Override
public Entry<K, V> min() throws MyException {
	if(isEmpty()) {
		throw new MyException("La lista está vacía.");
	}else {
		return head.getElement();
	}
}



@Override
public void insert(K key, V value) {
	Entry<K,V> nuevaEntrada = new Entry<K,V>(key,value);
	DNode<Entry<K,V>> nuevoNodo = new DNode<Entry<K,V>>(nuevaEntrada);
	
	if(size == 0 || head.getElement().getKey().compareTo(key) > 0) {
		nuevoNodo.setNext(head);
		head = nuevoNodo;
	}else {
		DNode<Entry<K,V>> actual = head;
		while(actual.getNext() != null && actual.getNext().getElement().getKey().compareTo(key) < 1) {
			actual = actual.getNext();
		}
		nuevoNodo.setNext(actual.getNext());
		actual.setNext(nuevoNodo);
	}
	size++;
}



@Override
public Entry<K, V> removeMin() throws MyException {
	if(isEmpty()) {
		throw new MyException("La lista está vacía");
	}else {
		Entry<K,V> salida = head.getElement();
		head = head.getNext();
		size--;
		return salida;
	}
	
}

}
