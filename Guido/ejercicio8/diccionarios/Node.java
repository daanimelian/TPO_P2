package diccionarios;

public class Node <T> {
	
	//atributos
	private T data;
	private Node <T> next;
	private Node <T> tail;
	
	//constructors
	public Node (T data, Node <T> node, Node <T> nodeTail) {
		this.data = data;
		next = node;
		tail = nodeTail;
	}
	public Node(T data) {
		this.data = data;
		next = null;
		tail = null;
	}
	public Node() {
		data = null;
		next = null;
		tail = null;
	}
	
	//methods
	public T getData(){
		return data;
	}
	public Node<T> getNext(){
		return next;
	}
	public Node<T> getBefore(){
		return tail;
	}
	public void setElement(T newElement){
		data=newElement;
	}
	public void setNext(Node<T> n){
		next=n;
	}
	public void setTail(Node<T> n){
		tail=n;
	}
}
