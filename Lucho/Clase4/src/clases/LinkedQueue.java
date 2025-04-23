package clases;

import Excepciones.MyException;
import interfaces.InterfaceQueue;

public class LinkedQueue<E> implements InterfaceQueue<E> {
	private DNode<E> f;
	private DNode<E> r;
	private int size;
	
	//-----------Constructor-----------
	
	public LinkedQueue() {
		f = null;
		r = null;
		size = 0;
	}

	@Override
	public void enqueue(E elemento) throws MyException {
		if(size == 0) {
			DNode<E> nodo = new DNode<E>(elemento);
			this.f = nodo;
			this.r = nodo;
			size++;
			
		}else {
			DNode<E> nodo = new DNode<E>(elemento,null, r);
			r.setNext(nodo);
			r = nodo;
			size++;
		}
		
	}

	@Override
	public E dequeue() throws MyException {
		if(size == 0) {
			throw new MyException("La lista está vacía, no se puede desencolar.");
		}else {
			E elem = f.getElement();
			if(f.getNext() == null) {
				f = null;
				r = null;
				
			}else {
				
				DNode<E> aux = f;
				f = f.getNext();
				f.setPrevious(null);
				aux.setNext(null);
			}
			size--;
			return elem;
			}
		
	}

	@Override
	public E front() throws MyException {
		if(f == null) {
			throw new MyException("No hay elementos en la lista");
		}else {
		return f.getElement();}
	}

	@Override
	public boolean isEmpty() throws MyException {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
}
