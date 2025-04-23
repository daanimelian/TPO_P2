package interfaces;

import Excepciones.MyException;

public interface InterfaceQueue<E> {
	
//	Inserta el elemnto e en el final (rear/tail) de la cola
	public void enqueue (E elemento) throws MyException;
//	Elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía, lanza una excepción.
	public E dequeue () throws MyException;
//	Retorna el elemento de la cola. Si la cola está vacía, lanza una excepción.
	public E front() throws MyException;
//	Retorna verdadero si la cola no tiene elementos y falso en el caso contrario.
	public boolean isEmpty() throws MyException;
//	Retorna la cantidad de elementos de la cola.
	public int size();
}
