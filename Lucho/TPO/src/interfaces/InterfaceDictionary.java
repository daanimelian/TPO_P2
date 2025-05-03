package interfaces;

import clases.Entry;
import clases.LinkedList;

public interface InterfaceDictionary<K, V> {
	public int size();
	public boolean isEmpty();
	public Iterable<V> get(K k);
	public void put(K k, V v);
	public Iterable<V> remove(K k);
	public V remove(K k, V v);
	public Iterable<K> keys();
	public Iterable<Entry<K, Iterable<V>>> entries();
}