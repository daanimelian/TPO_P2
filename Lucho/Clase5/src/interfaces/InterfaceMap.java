package interfaces;

import clases.Entry;

public interface InterfaceMap<K extends Comparable<K>,V> {
	public int size();
	public boolean isEmpty();
	public V get(K k);
	public V put(K k, V v);
	public V remove(K k);
	public K[] keys();
	public V[] values();
	public Entry<K,V> entries();
	}
