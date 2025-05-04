package practica4;

public class LinkedQueue<T> implements Queue<T> {
	 private int size;
	 private Node <T> front;
	 private Node <T> tail;
	 public LinkedQueue (){
		 front = null;
		 tail = null;
		 size = 0;
	 }
	 public void enqueue(T t){
		 Node <T> nuevo = new Node <T>(t);
		 if(size == 0) {
			 front= nuevo;
			 tail = nuevo;
		 }
		 else {
			 
			 tail.setNext(nuevo);
			 tail = nuevo;
		 }
		 size ++;
		 
	 }
	 public T dequeue() { //Elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía se produce un error.
		 if(size <= 0)
			 throw new MyException("La cola esta vacia");
		 T frente = front.getData();
		 front = front.getNext();
		 size--;
		 return frente;
	 }
	 public T front(){
		 // Retorna el elemento del frente de la cola. Si la cola está vacía se produce un error.
		 if(size <= 0)
			 throw new MyException("La cola esta vacia");
		 return front.getData();
	 }
	 public boolean isEmpty() {
		 return size == 0;//Retorna verdadero si la cola no tiene elementos y falso en caso contrario
	 }
	 public int size() {
		 return size;// Retorna la cantidad de elementos de la cola
	 }
}

