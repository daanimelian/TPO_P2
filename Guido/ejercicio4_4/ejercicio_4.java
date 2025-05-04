package practica4;

public class ejercicio_4 {

	public static void main(String[] args) {
	    }
	public static LinkedStack <LinkedQueue<Integer>> intercalado (LinkedStack <LinkedQueue<Integer>> cola1, LinkedStack <LinkedQueue<Integer>> cola2){
		 LinkedStack <LinkedQueue<Integer>> auxiliar= new LinkedStack <LinkedQueue<Integer>>();
		 LinkedStack <LinkedQueue<Integer>> intercalada= new LinkedStack <LinkedQueue<Integer>>();
		 int tamanioStack = cola1.size() + cola2.size();
		 
		for (int i = 0; i<tamanioStack;i++) {
			 if(cola1.isEmpty()) {
				 auxiliar.push(cola2.pop());
			 }
			 else if(cola2.isEmpty()) {
				 auxiliar.push(cola1.pop());
			 }
			 else if(cola1.top().size() > cola2.top().size()) {
				 auxiliar.push(cola1.pop());
			 }
			 else {
				 auxiliar.push(cola2.pop());
			 }
		 }
		for (int i = 0; i<tamanioStack;i++) {
			intercalada.push(auxiliar.pop());
		 }
		return intercalada;
		 
	 }

}
