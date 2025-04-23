package Interfaces;

public interface InterfaceList<Generico> {
	public void addFirst(Generico elemento);
	public void addLast(Generico elemento);
	public void removeFirst() throws MyException;
	public void removeLast() throws MyException;
	public void remove(Generico elemento) throws MyException;
	
	public void First();
	public void advance();
	public Generico getCurrent();
	public boolean atEnd();
	public int getSize();
	}

