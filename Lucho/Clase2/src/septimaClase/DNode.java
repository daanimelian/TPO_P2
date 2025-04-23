package septimaClase;

import List.Node;

public class DNode<Generico>{

	private Generico element;
    private DNode<Generico> next;
    private DNode<Generico> previous;
    
    
//  -----------Constructor -----------
    
//  -----------Constructor -----------
    
    
    public DNode() {
    	next = null;
    	previous = null;
    	element = null;
    }
    
    
    public DNode(Generico element) {
    	this.element = element;
    	next = null;
    	previous = null;
    }
    
    public DNode(DNode<Generico> next, DNode<Generico> prev, Generico element) {
    	this.element = element;
    	this.next = next;
    	this.previous = prev;
    }
    
    
//  -----------Setter -----------
    
    protected void setElement(Generico info) {
    	this.element = info;
    }
    
    protected void setNext(DNode<Generico> n) {
    	this.next = n;
    }
    
    protected void setPrevious(DNode<Generico> n) {
    	this.previous = n;
    }
    
    
//  -----------Getter -----------
    
    protected Generico getElement() {
    	return element;
    }
    
    protected DNode<Generico> getNext() {
    	return next;
    }
    
    protected DNode<Generico> getPrevious(){
    	return previous;
    }
    
}
