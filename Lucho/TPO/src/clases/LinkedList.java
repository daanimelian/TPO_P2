package clases;

import java.util.Iterator;

import interfaces.*;
import interfaces.MyException;

public class LinkedList <Generico> implements InterfaceList<Generico>, Iterable<Generico> {
	
	protected DNode<Generico> head;
	protected int size;
	protected DNode<Generico> current;
	
//  -----------Constructor -----------
	public LinkedList() {
		head = null;
		size = 0;
	}
	
//-----------Métodos -----------
	


	@Override
	public void addFirst(Generico elemento) {
		DNode<Generico> nodo = new DNode<Generico>(elemento);
		nodo.setNext(head);
		head = nodo;
		size ++;
		
	}

	@Override
	public void addLast(Generico elemento) {
		DNode<Generico> nodo = new DNode<Generico>(elemento);
		if (head == null) {
			head = nodo;
			
			
		}else {
			DNode<Generico> aux = head;
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
		DNode<Generico> aux = head.getNext();
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
			DNode<Generico> aux = head;
			DNode<Generico> sig = head.getNext();
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
	    if (head == null) {
	        throw new MyException("La lista está vacía, no se puede eliminar ningún elemento.");
	    } else if (head.getElement().equals(elemento)) {
	        this.removeFirst();
	    } else {
	        DNode<Generico> aux = head;
	        // Recorremos hasta encontrar el elemento o el final de la lista
	        while (aux.getNext() != null && !aux.getNext().getElement().equals(elemento)) {
	            aux = aux.getNext();
	        }
	        // Si el siguiente es null, significa que no se encontró el elemento
	        if (aux.getNext() == null) {
	            throw new MyException("El elemento buscado no existe en la lista");
	        }
	        // Si se encontró, lo eliminamos
	        DNode<Generico> elementoAEliminar = aux.getNext();
	        aux.setNext(elementoAEliminar.getNext());
	        if (aux.getNext() != null) {
	            aux.getNext().setPrevious(aux); // Actualizamos el anterior del siguiente nodo
	        }
	        elementoAEliminar.setNext(null);
	        elementoAEliminar.setPrevious(null); // Desconectamos completamente el nodo
	    }
	    size--;
	}

	
	public void cambiarValorExistente(int index, Generico elemento) {
		 if (index < 0 || index > this.getSize()) {
		        throw new MyException("Se ingresó un índice inválido en la lista.");
		    }
		
		

		DNode<Generico> actual = head;
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

private class LinkedListIterator implements Iterator<Generico> {
		
		private DNode<Generico> current = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public Generico next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new MyException("No existe elemento siguiente");
			}
			Generico elem = current.getElement();
			current = current.getNext();
			return elem;
		}
		
	}

@Override
public Iterator<Generico> iterator() {
	return new LinkedListIterator();
}
}
