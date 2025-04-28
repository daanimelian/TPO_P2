package map;

public interface Entry <K extends Comparable<K>,V> {
	public K getKey();
	public V getValue();
	public void setKey(K key);
	public void setValue(V value);
	public String toString();
}
