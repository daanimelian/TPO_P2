package clases;

import interfaces.InterfaceMap;

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
			if(array[i].getKey() == k) {
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
	public V put(K k, V v) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V remove(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K[] keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V[] values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Entry<K, V> entries() {
		// TODO Auto-generated method stub
		return null;
	}

}
