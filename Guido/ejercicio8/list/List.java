package list;


public interface List <T> {
	public void addFirst(T newElement);
	public void addLast(T newElement);
	public void removeFirst();
	public void removeLast();
	public void remove(T element);
	public T getFirst();
	public T getLast();
	public void First();
	public void advance();
	public T getCurrent();
	public boolean atEnd();
	public int getSize();
}

