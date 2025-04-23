package List;

import Interfaces.InterfaceList;
import Interfaces.MyException;


public class LinkedList <Generico> implements InterfaceList<Generico> {
	
	protected Node<Generico> head;
	protected int size;
	protected Node<Generico> current;
	
//  -----------Constructor -----------
	public LinkedList() {
		head = null;
		size = 0;
	}
	
//-----------Métodos -----------
	


	@Override
	public void addFirst(Generico elemento) {
		Node<Generico> nodo = new Node<Generico>(elemento);
		nodo.setNext(head);
		head = nodo;
		size ++;
		
	}

	@Override
	public void addLast(Generico elemento) {
		Node<Generico> nodo = new Node<Generico>(elemento);
		if (head == null) {
			head = nodo;
			
			
		}else {
			Node<Generico> aux = head;
			while(aux.getNext() != null) {
				aux = aux.getNext();
			}
			aux.setNext(nodo);
		}
		size ++;
		
	}

	@Override
	public void removeFirst() throws MyException {
		if (head == null) {
			throw new MyException("La lista está vacia, no hay un primer elemento que eliminar");
		}
		Node<Generico> aux = head.getNext();
		head.setNext(null);
		head = aux;
		size --;
		
	}

	@Override
	public void removeLast() throws MyException {
		if (head == null) {
			throw new MyException("La lista está vacia, no hay un primer elemento que eliminar");
		}
		
		if(size == 1) {
			head = null;
		}else {
			Node<Generico> aux = head;
			Node<Generico> sig = head.getNext();
			while(sig.getNext() != null) {
				aux = sig;
				sig = sig.getNext();
			}
			aux.setNext(null);
		}
		size--;
		
	}

	@Override
	public void remove(Generico elemento) throws MyException {
		if (head == null)
			throw new MyException("La lista está vacia, no se puede eliminar ningún elemento.");
		else if(head.getElement().equals(elemento)) {
			this.removeFirst();
		} else {
			Node<Generico> aux = head;
			while(aux != null && aux.getNext().getElement().equals(elemento)) {
				aux = aux.getNext();
				
			}
			if(aux == null) {
				throw new MyException("El elemento buscado no existe en la lista");
				
			}
			Node<Generico> elementoAEliminar = aux.getNext();
			aux.setNext(elementoAEliminar.getNext());
			elementoAEliminar.setNext(null);
		}
		size--;
	
		
	}
	
	public void cambiarValorExistente(int index, Generico elemento) {
		 if (index < 0 || index > this.getSize()) {
		        throw new MyException("Se ingresó un índice inválido en la lista.");
		    }
		
		

		Node<Generico> actual = head;
	    for (int i = 0; i < index; i++) {
	        actual = actual.getNext();
	    }

	    actual.setElement(elemento); 
	}
		
	   
	

	@Override
	public void First() throws MyException{
		if(head == null) {
			throw new MyException("La lista está vacia");
		}else {
		current = head;
		}
		
	}

	@Override
	public void advance() {
		if(current == null) {
			throw new MyException("Fuera de la lista");
			
		}else {
			current = current.getNext();
		}
		
	}

	@Override
	public Generico getCurrent() {
		return current.getElement();
	}

	@Override
	public boolean atEnd() {
		return current==null;
	}

	@Override
	public int getSize() {
		return size;
	}
}
