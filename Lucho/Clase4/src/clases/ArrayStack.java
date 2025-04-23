package clases;

import Excepciones.MyException;
import interfaces.Stack;

public class ArrayStack<T> implements Stack<T> {
	
	private T[] lista;
	private int size;
	
	
//	----------Constructores----------+
	public ArrayStack(){
		lista = (T[]) new Object[10];
		size = 0;
		
	}
	
	private void resize(T[] lista) {
		T[] nuevaLista = (T[]) new Object[2 * lista.length];
		for(int i = 0; i < lista.length; i++) {
			nuevaLista[i] = lista[i];
		}
		
		
		this.lista = nuevaLista;
	}
	
	public ArrayStack(int cantidadDeElementos) {
		lista = (T[]) new Object[cantidadDeElementos];
		size = 0;
	}

	@Override
	public void push(T item) {
		if(size == lista.length) {
			this.resize(lista);
		} 
		
		lista[size] = item;
		size++;
		
		
	}

	@Override
	public T pop() {
		if(size == 0) {
			throw new MyException("No se puede eliminar, la lista está vacía.");
		}
		
		T top = lista[size - 1];
		size--;
		
		return top;
	}

	@Override
	public T top() {
		if(size == 0) {
			throw new MyException("La lista está vacía");
		}
		
		T top = lista[size -1];
		return top;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}
	
}