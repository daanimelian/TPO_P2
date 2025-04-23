package clases;

import Excepciones.MyException;
import interfaces.InterfacePriorityQueue;

public class ArrayPriorityQueue<K extends Comparable<K>, V> implements InterfacePriorityQueue<K, V> {
	private Entry<K,V>[] arr;
	private int front;
	private int rear;
	private int size;
	
//	----------Constructor----------
	public ArrayPriorityQueue() {
		this.arr = (Entry<K,V>[])new Entry[10];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}
	
	public ArrayPriorityQueue(int cantidadElementos) {
		this.arr = (Entry<K,V>[])new Entry[cantidadElementos];
		this.front = 0;
		this.rear = 0;
		this.size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == rear;
	}

	@Override
	public Entry<K, V> min() throws MyException {
		if(size == 0) {
			throw new MyException("La lista está vacía.");
			
		}else {
			Entry<K,V> min = arr[front];
			return min;
		}
	}

	@Override
	public void insert(K key, V value) throws MyException {
		if(size == arr.length - 1) {
			throw new MyException("La listá está llena, no se pueden añadir más elementos.");
		}
		
		Entry<K,V> nuevoElemento = new Entry<K,V>(key,value);
		if(size == 0) {
			arr[rear] = nuevoElemento;
		} else {
			int i = rear - 1;
			if(rear > front) {
				while(i >= front && nuevoElemento.getKey().compareTo(arr[i].getKey()) < 0) {
					arr[(i + 1) % arr.length] = arr[i];
					i--;
				}
			}else {
				while(i >= 0 && nuevoElemento.getKey().compareTo(arr[i].getKey()) < 0) {
					arr[(i + 1) % arr.length] = arr[i];
					i--;
				}
				if(i < 0) {
					i = arr.length - 1;
					while (i >= front && nuevoElemento.getKey().compareTo(arr[i].getKey()) < 0) {
						arr[(i+1) % arr.length] = arr[i];
						i--;
					}
				}
			}
			arr[i+1] = nuevoElemento;
			
		}
		rear = (rear + 1) % arr.length;
		size++;
		
	}

	@Override
	public Entry<K, V> removeMin() throws MyException {
		Entry<K,V> min = arr[front];
		if(size == 0) {
			throw new MyException("La lista estác vacía, no se puede eliminar.");
		}else if(size == 1) {
			arr[front] = null;
			front = 0;
			rear = 0;
			
		}else{
			arr[front] = null;
			front = (front + 1) % arr.length;
			
			
		}
		size--;
		return min;
	}

}
