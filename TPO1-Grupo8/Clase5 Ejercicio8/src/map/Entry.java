package map;

import list.List;

public interface Entry <K extends Comparable<K>,V> {
	public K getKey();
	public List<V> getValue();
	public void setKey(K key);
	public void setValue(List<V> value);
	public String toString();
}
