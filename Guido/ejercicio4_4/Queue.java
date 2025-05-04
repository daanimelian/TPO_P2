package practica4;

public interface Queue <T> {
	 public void enqueue(T t);// Inserta el elemento e en el final (rear/tail) de la cola
	 public T dequeue(); //Elimina el elemento del frente de la cola y lo retorna. Si la cola está vacía se produce un error.
	 public T front();// Retorna el elemento del frente de la cola. Si la cola está vacía se produce un error.
	 public boolean isEmpty(); //Retorna verdadero si la cola no tiene elementos y falso en caso contrario
	 public int size(); // Retorna la cantidad de elementos de la cola

}
