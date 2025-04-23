package Clases;


public class Node <Generico>{

	private Generico element;
    private Node<Generico> next;
    
    
//  -----------Constructor -----------
    
    
    public Node() {
    	next = null;
    	element = null;
    }
    
    
    public Node(Generico element) {
    	this.element = element;
    	next = null;
    } 
    
    public Node(Generico element,Node<Generico> next) {
    	this.element = element;
    	this.next = next;
    }
    
    
//  -----------Setter -----------
    
    public void setElement(Generico info) {
    	this.element = info;
    }
    
    public void setNext(Node<Generico> n) {
    	this.next = n;
    }
    
    
//  -----------Getter -----------
    
    public Generico getElement() {
    	return element;
    }
    
    public Node<Generico> getNext() {
    	return next;
    }
    
}
