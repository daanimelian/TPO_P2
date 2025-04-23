package clases;

public class DNode<Elemento> {
	
	private Elemento element;
	private DNode<Elemento> next;
	private DNode<Elemento> previous;
	
//	----------Constructor----------
	
//	Vacio
	public DNode() {
		this.element = null;
		this.next = null;
		this.previous = null;
	}
	
	public DNode(Elemento elem) {
		this.element = elem;
		this.next = null;
		this.previous = null;
		
	}

	
//	Constructor para marcar el siguiente y el anterior al nodo.
	
	public DNode(Elemento element, DNode<Elemento> next, DNode<Elemento> previous) {
		this.element = element;
		this.next = next;
		this.previous = previous;
	}
	
	
//	----------Getters----------
	
	public Elemento getElement() {
		return element;
	}
	
	public DNode<Elemento> getNext() {
		return next;
	}
	
	public DNode<Elemento> getPrevious(){
		return previous;
	}
	
//	----------Setters----------
	public void setElement(Elemento element) {
		this.element = element;
	}
	
	public void setNext(DNode<Elemento> siguiente) {
		this.next = siguiente;
		
	}
	
	public void setPrevious(DNode<Elemento> anterior) {
		this.previous = anterior;
	}
	
	

}
