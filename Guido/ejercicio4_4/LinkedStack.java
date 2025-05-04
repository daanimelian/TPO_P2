package practica4;

public class LinkedStack<T> implements Stack <T>{
	private Node <T> head;
	private int size;
	public LinkedStack() {
		head = null;
		size = 0;
	}
	
	
	 public void push(T item) {
			Node <T> nuevo = new Node<T>(item, head);
			head = nuevo;
			size++;
		 }
	 
	 public T pop() {
		 if (size == 0) {
			 throw new MyException("La Pila esta vacia");
		 }
		 T dataHead= head.getData();
		 head = head.getNext();
		 size--;
		 return dataHead;
		 
	 }
	 public T top() {
		 if (size == 0) {
			 throw new MyException("La Pila esta vacia");
		 }
		 return head.getData();
	 }
	 public boolean isEmpty() {
		 return size == 0;
		 
	 }
	 public int size() {
		 return size;
	 }
	 public boolean isCapicua(String misterio) {
		 int longitud = misterio.length();
		 int acc = 0;
		 LinkedStack <Character> invertida = new LinkedStack<Character>();
		 LinkedStack <Character> invertidaAux = new LinkedStack<Character>();
		 for (int i = 0; i <misterio.length();i++) {
			 invertida.push(misterio.charAt(i));
		 }
		 while(!invertida.isEmpty()) {
			 invertidaAux.push(invertida.pop());
		 }
		 for (int i = 0; i <misterio.length();i++) {
			 if(misterio.charAt(i) == invertidaAux.pop())
				 acc++;
		 }
			  
		 return acc == longitud;
	 }
	 
	 public boolean parentesisOk(String frase) {
		 int longitud = frase.length();
		 int acc = 0;
		 LinkedStack <Character> fraseStack = new LinkedStack<Character>();
		 for (int i = 0; i <longitud;i++) {
			 fraseStack.push(frase.charAt(i));
		 }
		 while(!fraseStack.isEmpty()) {
			 char aux = fraseStack.pop();
			 if(aux == ')') {
				 acc ++;
			 }
			 if (acc>0 && aux == '(')
				 acc--;
		 }
		 return acc == 0;
	 }
		 
}
		 
		 
