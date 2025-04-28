package cola;

public interface Queue<T> {
	public void enqueue(T element);
	public T dequeue() throws Exception;
	public T front() throws Exception;
	public boolean isEmpty();
	public int size();
}
