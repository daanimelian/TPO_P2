package clases;

import Excepciones.MyException;
import interfaces.InterfaceQueue;

public class ArrayQueue<Elemento> implements InterfaceQueue<Elemento> {
	private int f;
	private int r;
	private int size;
	private Elemento[] q;
	
	
	//-----------Constructor-----------
	
	public ArrayQueue(int tamanio) {
		f=0;
		r=0;
		size=0;
		q = (Elemento[]) new Object[tamanio];
		}
		
	


	@Override
	public void enqueue(Elemento elemento) throws MyException {
		if(size == q.length - 1) {
			throw new MyException("La cola está llena, no se pueden agregar mas elementos.");
		} else {
			q[r] = elemento;
			size++;
			r = (r+1) % q.length;
		}
		
	}


	@Override
	public Elemento dequeue() throws MyException {
		if(size == 0) {
			throw new MyException("La cola está vacia, no se puede desencolar ningún elemento");
		}else {
			Elemento temporal = q[f];
			size--;
			q[f] = null;
			f = (f+1) % q.length;
			return temporal;
		}
		
	}


	@Override
	public Elemento front() throws MyException {
		if(size == 0) {
			throw new MyException("La cola está vacía, no hayn ningún elemento");
		}else {
			return q[f];
		}
	}


	@Override
	public boolean isEmpty() {
		return f==r;
	}


	@Override
	public int size() {
		return size;
	}
	
	public void ordenarMenorAMayor() {
		
	}
}