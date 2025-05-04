package practica4;

public class Node <T> {
	
	//atributos
	private T data;
	private Node <T> next;
	
	//constructors
	public Node (T data, Node <T> node) {
		this.data = data;
		next = node;
	}
	public Node(T data) {
		this.data = data;
		next = null;
	}
	public Node() {
		data = null;
		next = null;
	}
	
	//methods
	public T getData(){
		return data;
	}
	public Node<T> getNext(){
		return next;
	}
	public void setElement(T newElement){
		data=newElement;
	}
	public void setNext(Node<T> n){
		next=n;
	}
}
