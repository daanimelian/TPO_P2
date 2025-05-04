package list;
import java.util.Iterator;

import diccionarios.Node;
public class LinkedList <T> implements List <T> , Iterable<T>{
	private Node<T> head;
	private Node<T> tail;
	private Node<T> current;
	private int size;
	
	public LinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	public void addFirst(T newElement) {
		Node <T> n = new Node <T>(newElement);
		n.setNext(head);
		head = n;
		if (tail == null)
			tail = head;
		size++;
	}
	
	public void addLast(T newElement) {
		Node <T> n = new Node <T>(newElement);
		if (head == null) {
			addFirst(newElement);
		}
		else {
			tail.setNext(n);
			n.setTail(tail);
			tail = n;
			size++;
		}
		
	}
	public void removeFirst() {
		if(head == null)
			throw new RuntimeException("No hay elementos en la lista");
		if (size == 1) {
			head = null;
			tail = null;
		}
		else {
			head = head.getNext();
			head.setTail(null);
			size --;
		}
		
	}
	public void removeLast() {
		if(head == null)
			throw new RuntimeException("No hay elementos en la lista");
		if(size == 1){
            head = null;
            tail = null;
        } 
		else {
			tail.getBefore().setNext(null);
			tail = tail.getBefore();
			size --;
		}
		
	}
	public void remove(T element) {
		if(head == null)
			throw new RuntimeException("No hay elementos en la lista");
		else {
			if(head.getData().equals(element))
				removeFirst();
			else {
				Node <T> aux = head;
				Node <T> aux2 = head.getNext();
				while(!aux2.getData().equals(element)) {
					aux = aux2;
					if (aux2.getNext() == null) {
						throw new RuntimeException("Elemento no encontrado en la lista");
					}
					aux2 = aux2.getNext();
				}
				if(aux2 == tail) {
					tail = aux;
					aux.setNext(null);
				}
				else {
				aux.setNext(aux2.getNext());
				aux2.getNext().setTail(aux);
				}
				size --;
			}
		}
			
	}
	public int getSize() {
		return size;
	}
	
	public T getFirst() {
		return head.getData();
	}
	
	public T getLast() {
		return getNode(size).getData();
	}

	public Node<T> getNode(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Índice inválido: " + indice);
        }
        
        Node<T> current = head;
        for (int i = 0; i < indice; i++) {
            current = current.getNext();
        }
        return current;
    }
	public void First(){
		current=head;
	}
	public void advance(){
		if(current==null)
			throw new RuntimeException("Fuera de lista");
		else
			current=current.getNext();
	}
	public T getCurrent(){
		if(current==null)
			throw new RuntimeException("No se puede devolver el nodo actual porque es nulo");
		return current.getData();
	}
	public boolean atEnd(){
		return current==null;
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new LinkedListIterator();
	}
private class LinkedListIterator implements Iterator<T> {
		
		private Node<T> current = head;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			if (!hasNext()) {
				throw new RuntimeException("No existe elemento siguiente");
			}
			T elem = current.getData();
			current = current.getNext();
			return elem;
		}
		
	}
}
	

