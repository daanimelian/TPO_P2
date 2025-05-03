package clases;

import interfaces.*;

public class ArrayMap<K extends Comparable<K>,V> implements InterfaceMap<K,V> {
	
	private Entry<K,V>[] array;
	private int size;

	public ArrayMap() {
		array = (Entry<K,V>[]) new Entry[100];
		size = 0;
	}
	
	public ArrayMap(int cantidadEntradas) {
		array = (Entry<K,V>[]) new Entry[cantidadEntradas];
		size = 0;
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
	public V get(K k) {
		int i = 0;
		boolean encontrado = false;
		
		while(!encontrado && i<size) {
			if(array[i].getKey().equals(k)) {
				encontrado = true;
			}else {
				i++;
			}
			
		}
		if(encontrado == false) {
			return null;
		}else {
			return array[i].getValue();
		}
	}

	@Override
	public V put(K k, V v) throws MyException {
		int i = 0;
		boolean encontrado = false;
		
		while(i < size && !encontrado ) {
			if(array[i].getKey().equals(k)) {
				encontrado = true;
			}else {
				i++;
			}
		}
		if(!encontrado) {
			if(size < array.length) {
				array[size] = new Entry<K,V>(k,v);
				size++;
				return null;
				
			}else {
				throw new MyException("La lista está llena, no se puede agregar otro elemento.");
			}
		}else {
			V valorViejo = array[i].getValue();
			array[i].setValue(v);
			return valorViejo;
		}
	}

	@Override
	public V remove(K k)  {
		int i = 0;
		boolean encontrado = false;
		
		while(i < size && !encontrado) {
			if(array[i].getKey().equals(k)) {
				encontrado = true;
			}else {
				i++;
			}
		}
		
		if(encontrado) {
			V valorAEliminar = array[i].getValue();
			array[i] = array[size - 1];
			array[size - 1] = null;
			size--;
			return valorAEliminar;
		}else {
			return null;
		}
	}

	@Override
	public K[] keys() {
		K[] aux = (K[])new Object[size];
		for(int i = 0; i < size;i++) {
			aux[i] = array[i].getKey();
		}
		return aux;
		}

	@Override
	public V[] values() {
		V[] aux = (V[])new Object[size];
		for(int i = 0; i < size;i++) {
			aux[i] = array[i].getValue();
		}
		return aux;
	}

	@Override
	public Entry<K, V>[] entries() {
		Entry<K,V>[] aux =(Entry<K,V>[]) new Entry[size];
		for(int i = 0; i < size; i++) {
			aux[i] = new Entry<K,V>(array[i].getKey(),array[i].getValue());
		}
		return aux;
	}
	
	 @Override
	    public String toString() {
	    	String stringRetorno = "";
	    	if(size == 0) {
	    		return "La lista está vacía, no hay datos para mostrar";
	    	}
	    	for(int i = 0; i < size; i++) {
	    		stringRetorno = stringRetorno + "Clave: " + array[i].getKey() + " Valores: " + array[i].getValue() + "\n";
	    		
	    	}
	    	return stringRetorno;
	    }

}
