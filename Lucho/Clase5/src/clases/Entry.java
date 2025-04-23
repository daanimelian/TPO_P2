package clases;

import interfaces.InterfaceEntry;
public class Entry<K extends Comparable <K>,V> implements InterfaceEntry<K,V> {
	
	private K key;
	public V value;
	
	
//	--------Constructor--------
	public Entry() {
		this.key = null;
		this.value = null;
		
	}
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	
//	--------Getters--------
	@Override
	public K getKey() {
		// TODO Auto-generated method stub
		return this.key;
	}

	@Override
	public V getValue() {
		// TODO Auto-generated method stub
		return this.value;
	}
	
//	--------Setters--------
	
	public void setKey(K key) {
		this.key = key;
		
	}
	
	public void setValue(V value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "(" + getKey() + "," + getValue() + ")";
	}

}
