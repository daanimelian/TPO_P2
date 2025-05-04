package diccionarios;

import java.util.Arrays;
import list.List;
import list.LinkedList;

public class LinkedDiccionario <K extends Comparable <K>, V> implements DiccionarioMultiple <K, V> {
	private int size;
	protected Node<Entrada<K, List<V>>> head;
	protected Node<Entrada<K, List<V>>> tail;
	public LinkedDiccionario(){
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
	 public Iterable<V> get(K k){
		if(this.isEmpty())
				return null;
		
		Node<Entrada<K, List<V>>> aux = head;
		while(aux != null && aux.getData().getKey().compareTo(k) != 0) {
			aux = aux.getNext();
		}
		if(aux != null) {
			LinkedList <V> copiaValores = new LinkedList<V>();
			List <V> valores = aux.getData().getValue();
			valores.First();
			while(!valores.atEnd()) {
				copiaValores.addLast(valores.getCurrent());
				valores.advance();
			}
			return copiaValores;	
		}
		return null;
	 }
	 
	 public void put(K k, V v) {
		 if(this.isEmpty()) {
			LinkedList <V> valores = new LinkedList<V>();
			valores.addFirst(v);
			head = new Node<Entrada<K, List<V>>>(new Entrada<K, List<V>>(k, valores));
			tail = head;
			size++;
			return;
		 }
		 if(head.getData().getKey().compareTo(k) == 0) {
			 head.getData().getValue().addLast(v);
		 }
		 else {	
			 Node<Entrada<K, List<V>>> aux = head;
			 while(aux != null && aux.getData().getKey().compareTo(k)!= 0 ) {
				 aux = aux.getNext();
			 }
			 if(aux!=null) {
				 aux.getData().getValue().addLast(v);
			 }
			 else {
				 LinkedList <V> valores = new LinkedList<V>();
				 valores.addFirst(v);
				 aux = new Node<Entrada<K, List<V>>>(new Entrada<K, List<V>>(k, valores), null, tail);
				 tail.setNext(aux);
				 tail = aux;
				 size++;
			 }
		 }
	 }
	 public Iterable<V> remove(K k){
		 if(this.isEmpty())
			 return null;
		 else {
			 Node<Entrada<K, List<V>>> aux = head;
			 while(aux.getData().getKey().compareTo(k)!= 0 && aux != null) {
				 aux = aux.getNext();
			 }
			 if (aux == null) 
				 return null;
	    	 LinkedList <V> valores = new LinkedList<V>();
	    	 List <V> copiaValores = aux.getData().getValue();
	    	 copiaValores.First();
	    	 while (!copiaValores.atEnd()) {
	    		 valores.addLast(copiaValores.getCurrent());
	    		 copiaValores.advance();
	    	 }
	    	 if (aux == head && aux == tail) {
	             // If it's the only node in the list
	             head = null;
	             tail = null;
	         } else if (aux == head) {
	             // If it's the head node
	             head = head.getNext();
	             if (head != null) {
	                 head.setTail(null);
	             }
	         } else if (aux == tail) {
	             // If it's the tail node
	             tail = tail.getBefore();
	             if (tail != null) {
	                 tail.setNext(null);
	             }
	         } else {
	             // If it's a middle node
	             aux.getBefore().setNext(aux.getNext());
	             aux.getNext().setTail(aux.getBefore());
	         }
	         
	         size--;
	         return valores;
		     }
	 }
	 public V remove(K k, V v) {
		 if(this.isEmpty())
				return null;
		 else {
			 Node<Entrada<K, List<V>>> aux = head;
			 while(aux != null && aux.getData().getKey().compareTo(k)!= 0 ) {
				 aux = aux.getNext();
			 }
			 if (aux == null) 
				 return null;
		     else {
		    	 List <V> copiaValores = aux.getData().getValue();
		    	 if (copiaValores.getSize() == 0) {
		             return null;
		         }
		    	 copiaValores.First();
		    	 while (!copiaValores.atEnd()) {
		    		 if(copiaValores.getCurrent().equals(v)) {
		    			 V removedValue = copiaValores.getCurrent();
		    			 copiaValores.remove(v);
		    			   if (copiaValores.getSize() == 0) {
		    	                 // Remove node from linked list based on its position
		    	                 if (aux == head && aux == tail) {
		    	                     // If it's the only node in the list
		    	                     head = null;
		    	                     tail = null;
		    	                 } else if (aux == head) {
		    	                     // If it's the head node
		    	                     head = head.getNext();
		    	                     if (head != null) {
		    	                         head.setTail(null);
		    	                     }
		    	                 } else if (aux == tail) {
		    	                     // If it's the tail node
		    	                     tail = tail.getBefore();
		    	                     if (tail != null) {
		    	                         tail.setNext(null);
		    	                     }
		    	                 } else {
		    	                     // If it's a middle node
		    	                     aux.getBefore().setNext(aux.getNext());
		    	                     aux.getNext().setTail(aux.getBefore());
		    	                 }
		    	                 
		    	                 size--;
		    	             }
		    				 return removedValue;
		    	         }
		    	 }
		     }
		 }
		return null;
	 }
	 public Iterable<K> keys(){
		 if(this.isEmpty())
				return null;
		
		 else {
			LinkedList<K> claves = new LinkedList<K>();
			Node<Entrada<K, List<V>>> actual = head;
			while (actual != null) {
				claves.addLast(actual.getData().getKey());
				actual = actual.getNext();
			}
		    return claves;
		 }
	 }
	 public Iterable <Entry<K, Iterable<V>>> entries(){
		 if(this.isEmpty())
				return null;
		 else {
			 	LinkedList<Entry<K, Iterable<V>>> entradas = new LinkedList<Entry<K, Iterable<V>>>();
				Node<Entrada<K, List<V>>> actual = head;
				while (actual != null) {
					List<V> listaValores = actual.getData().getValue();
					LinkedList<V> copiaValores = new LinkedList<V>();
					listaValores.First();
					while (!listaValores.atEnd()) {
						copiaValores.addLast(listaValores.getCurrent());
						listaValores.advance();
					}
					entradas.addLast(new Entrada<K, Iterable<V>>(actual.getData().getKey(), copiaValores));
					actual = actual.getNext();
				}
				return entradas;
		 }
	 }
}
