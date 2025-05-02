package clases;


import java.util.Arrays;

import interfaces.*;

public class ArrayDictionary<K,V> implements InterfaceDictionary<K,V>{
	
	private Entry<K,V[]>[] array;
	private int size;
	
//	----------Constructor----------
	public ArrayDictionary() {
		array = (Entry<K,V[]>[]) new Entry[100];
		size = 0;
	}
	
	public ArrayDictionary(int tamanio) {
		array = (Entry<K,V[]>[]) new Entry[tamanio];
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
public Iterable<V> get(K k) {
	int i = 0;
	boolean claveEncontrada = false;
	while(i < size && !claveEncontrada ) {
		if(array[i].getKey().equals(k)) {
			claveEncontrada = true;
		}else {
			i++;
		}
	}
	
	if(!claveEncontrada) {
		return null;
	}else {
		V[] valores = (V[]) new Object[array[i].getValue().length];
		for(int index = 0; index < valores.length; index++) {
			valores[index] = array[i].getValue()[index];
		}
		return Arrays.asList(valores);
	}
}

@Override
public void put(K k, V v) {
	int i = 0;
	boolean claveEncontrada = false;
	while(i < size && !claveEncontrada) {
		if(array[i].getKey().equals(k)) {
			claveEncontrada = true;
		}else {
			i++;
		}
	}
	
	if(!claveEncontrada) {
		if(size<array.length) {
			V[] valores = (V[]) new Object[100];
			valores[0] = v;
			array[size] = new Entry<K,V[]>(k,valores);
			size++;
		}else {
			throw new MyException("El arreglo de claves está lleno, no se puede agregar más");
		}
	}else {
		V[] valores = array[i].getValue();
		int j = 0;
		while (j < valores.length && valores[j] != null) {
			j++;
		}
		if(j<valores.length) {
			valores[j] = v;
		}else {
			throw new MyException("El arreglo de valores está lleno, no se puede agregar más");
		}
	}
	
}

@Override
public Iterable<V> remove(K k) {
	int i = 0;
	boolean claveEncontrada = false;
	while(!claveEncontrada && i<size) {
		if(array[i].getKey().equals(k)) {
			claveEncontrada = true;
		}else {
			i++;
		}
	}
	if(!claveEncontrada) {
		return null;
	}else {
		V[] valores = array[i].getValue();
		int sizeValores = 0;
		while(sizeValores < valores.length && valores[sizeValores] != null) {
			sizeValores++;
		}
		V[] copiaValores = (V[]) new Object[sizeValores];
		for(int j = 0; j < sizeValores;j++) {
			copiaValores[j] = valores[j];
		}
		array[i] = array[size-1];
		array[size-1] = null;
		size --;
		return Arrays.asList(copiaValores);
	}
}

@Override
public V remove(K k, V v) {
	int i = 0;
	boolean claveEncontrada = false;
	while(!claveEncontrada && i < size) {
		if(array[i].getKey().equals(k)) {
			claveEncontrada = true;
		}else {
			i++;
		}
	}
	if(!claveEncontrada) {
		return null;
	}else {
		V[] valores = array[i].getValue();
		int j = 0;
		boolean encontreValor = false;
		while(!encontreValor && j < valores.length && valores[j] != null) {
			if(valores[j].equals(v)) {
				encontreValor = true;
			}else {
				j++;
			}
		}
		if(!encontreValor) {
			return null;
		}else {
			int sizeValores = j;
			while(sizeValores < valores.length && valores[sizeValores] != null) {
				sizeValores++;
			}
			valores[j] = valores[sizeValores - 1];
			valores[sizeValores - 1] = null;
			if(sizeValores - 1 == 0) {
				array[i] = array[size-1];
				array[size - 1] = null;
				size--;
			}
			return v;
		}
	}
}

@Override
public Iterable<K> keys() {
	K[] aux = (K[]) new Object[size];
	for(int i = 0; i < size; i++) {
		aux[i] = array[i].getKey();
	}
	return Arrays.asList(aux);
}

@Override
public Iterable<Entry<K, Iterable<V>>> entries() {
	Entry<K, Iterable<V>>[] entradas = (Entry<K, Iterable<V>>[]) new Entry[size];
	for (int i = 0; i < size; i++) {
		V[] valores = array[i].getValue();
		int sizeValores = 0;
		while (sizeValores < valores.length && valores[sizeValores] != null) {
			sizeValores++;
		}
		V[] copiaValores = (V[]) new Object[sizeValores];
		for (int j = 0; j < sizeValores; j++) {
			copiaValores[j] = valores[j];
		}
		entradas[i] = new Entry<K, Iterable<V>>(array[i].getKey(), Arrays.asList(copiaValores));
	}
	return Arrays.asList(entradas);
}

	
}
