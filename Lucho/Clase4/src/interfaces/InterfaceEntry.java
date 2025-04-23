package interfaces;

public interface InterfaceEntry<K extends Comparable <K>,V> {
	public K getKey();
	public V getValue();

}
