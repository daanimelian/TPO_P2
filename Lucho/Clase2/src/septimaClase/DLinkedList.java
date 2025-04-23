package septimaClase;

import Interfaces.InterfaceList;
import Interfaces.MyException;


public class DLinkedList <Generico> implements InterfaceList<Generico> {
	protected DNode<Generico> head;
	protected DNode<Generico> current;
	protected DNode<Generico> tail;
	protected int size;
	
	
//  -----------Constructor -----------
	public DLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public void addFirst(Generico elemento) {
		DNode<Generico> nodo = new DNode<Generico>(elemento);
		nodo.setNext(head);
		nodo.setPrevious(null);
		if(head == null) {
			tail = nodo;
		}else {
			head.setPrevious(nodo);
		}
		
		head = nodo;
		size++;
	}
	

	@Override
	public void addLast(Generico elemento) {
		DNode<Generico> nodo = new DNode<Generico>(elemento);
		nodo.setNext(null);
		nodo.setPrevious(tail);
		
		if(tail == null) {
			head = nodo;
		}else {
			tail.setNext(nodo);
		}
		
		tail = nodo;
		size++;
	}

	@Override
	public void removeFirst() throws MyException {
		if(head == null) {
			throw new MyException("La lista está vacia, no se puede eliminar el primero");
		}
		
		
		if(head == tail) {
			tail = null;
			head = null;
		}else if(size > 1){
			head = head.getNext();
			head.setPrevious(null);
			
		}
		
		size--;
	}

	@Override
	public void removeLast() throws MyException {
		if(tail == null){
			throw new MyException("La lista está vacia, no se puede eliminar el último");
			
		}
		
		if(head == tail) {
			tail = null;
			head = null;
		}else if(size > 1) {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		
		size--;
		
	}

	@Override
	public void remove(Generico elemento) throws MyException {
		if(head == null) {
			throw new MyException("La lista está vacía, no se puede eliminar el elemento");
		}
		else if(head.getElement().equals(elemento)) {
			this.removeFirst();
		}else if(tail.getElement().equals(elemento)) {
			this.removeLast();
		}else {
			DNode<Generico> aux = head;
			while(aux != null && aux.getNext() != null &&  !aux.getNext().getElement().equals(elemento)) {
				aux = aux.getNext();
			}
			
			if(aux == null) {
				throw new MyException("El elemento elegido no está en la lista");
			}else {
				DNode<Generico> nodoAEliminar = aux.getNext();
				DNode<Generico> siguiente = nodoAEliminar.getNext();
				if(siguiente != null) {
					siguiente.setPrevious(aux);
				}
				aux.setNext(siguiente);
				nodoAEliminar.setNext(null);
				nodoAEliminar.setPrevious(null);
				size --;
			}
		}
	}

	@Override
	public void First() throws MyException  {
		if(head == null) {
			throw new MyException("La lista está vacia");
		}else {
			current = head;
		}
		
	}
	
	public void Last() throws MyException {
		if(tail == null) {
			throw new MyException("La lista está vacia");
		}else {
			current = tail;
		}
		
	}

	@Override
	public void advance()throws MyException {
		if(current == null) {
			throw new MyException("Fuera de la lista");
		}else {
			current = current.getNext();
		}
		
	}
	
	public void back()throws MyException {
		if(current == null) {
			throw new MyException("Fuera de la lista");
		}else {
			current = current.getPrevious();
		}
		
	}

	@Override
	public Generico getCurrent() {
		return current.getElement();
	}

	@Override
	public boolean atEnd() {
		return current == null;
	}

	@Override
	public int getSize() {
		return size;
	}

}
