package ejercicios;

import clases.ArrayStack;
import clases.LinkedQueue;

public class MainClase4 {
	
	
	public static ArrayStack<LinkedQueue<Integer>> Ejercicio(ArrayStack<LinkedQueue<Integer>> p1, ArrayStack<LinkedQueue<Integer>> p2){
		
//		Creo la pila resultante de la unión de elementos de cada Cola de las pilas
		ArrayStack<LinkedQueue<Integer>> pout = new ArrayStack<LinkedQueue<Integer>>(p1.size() + p2.size());
			
//			Mientras que ninguna de las pilas esté vacía, voy a encolar los elementos de la pila 2 en la primera
			while(!p1.isEmpty() && !p2.isEmpty()) {
				while(!p2.top().isEmpty()) {
					p1.top().enqueue(p2.top().dequeue());
				}
//				A la pila resultante, le pusheo la nueva cola 
				pout.push(p1.pop());
//				Para el final del ciclo, se popean en p1 y en p2 el tope para que al volver a comenzar se evalúe si alguna quedó vacía
				p2.pop();
			}
//			En caso de que después del primer while, la pila 2 haya quedado vacía y la pila 1 no, solamente pusheo el resto a la pila pout
			while(!p1.isEmpty()) {
				pout.push(p1.pop());
			}
//			En caso de que después del primer while, la pila 1 haya quedado vacía y la pila 2 no, solamente pusheo el resto a la pila pout
			while(!p2.isEmpty()) {
				pout.push(p2.pop());
			}
//			Creo una nueva pila de colas que será la versión ordenada de menor a mayor de la pila pout
			ArrayStack<LinkedQueue<Integer>> poutOrdenado = ArrayStack.invertirStack(pout);
			return poutOrdenado;
			
	}
	
	public static void main(String[] args) {
		
		
		 ArrayStack<LinkedQueue<Integer>> p1 = new ArrayStack<LinkedQueue<Integer>>();
		    ArrayStack<LinkedQueue<Integer>> p2 = new ArrayStack<LinkedQueue<Integer>>();
		    
		    
//			 -----------------------------------PRUEBA PARA PILAS DE IGUAL TAMAÑO-----------------------------------


		    // PILA P1: colas de tamaños 2, 3, 5 (tope = más grande)
//		    LinkedQueue<Integer> colaP1_1 = new LinkedQueue<Integer>();
//		    colaP1_1.enqueue(1);
//		    colaP1_1.enqueue(2);
//
//		    LinkedQueue<Integer> colaP1_2 = new LinkedQueue<Integer>();
//		    colaP1_2.enqueue(10);
//		    colaP1_2.enqueue(11);
//		    colaP1_2.enqueue(12);
//
//		    LinkedQueue<Integer> colaP1_3 = new LinkedQueue<Integer>();
//		    colaP1_3.enqueue(20);
//		    colaP1_3.enqueue(21);
//		    colaP1_3.enqueue(22);
//		    colaP1_3.enqueue(23);
//		    colaP1_3.enqueue(24);
//
//		    p1.push(colaP1_1);
//		    p1.push(colaP1_2);
//		    p1.push(colaP1_3);
//
//		    // PILA P2: colas de tamaños 1, 4, 6
//		    LinkedQueue<Integer> colaP2_1 = new LinkedQueue<Integer>();
//		    colaP2_1.enqueue(99);
//
//		    LinkedQueue<Integer> colaP2_2 = new LinkedQueue<Integer>();
//		    colaP2_2.enqueue(50);
//		    colaP2_2.enqueue(51);
//		    colaP2_2.enqueue(52);
//		    colaP2_2.enqueue(53);
//
//		    LinkedQueue<Integer> colaP2_3 = new LinkedQueue<Integer>();
//		    colaP2_3.enqueue(70);
//		    colaP2_3.enqueue(71);
//		    colaP2_3.enqueue(72);
//		    colaP2_3.enqueue(73);
//		    colaP2_3.enqueue(74);
//		    colaP2_3.enqueue(75);
//
//		    p2.push(colaP2_1);
//		    p2.push(colaP2_2);
//		    p2.push(colaP2_3);
//
//		 System.out.println("La pila 1 tiene " + p1.size() + " elementos");
//		 System.out.println("La pila 2 tiene " + p2.size() + " elementos");
		 
		 
//		 -----------------------------------PRUEBA PARA PILAS DE DISTINTO TAMAÑO (P1 > P2)-----------------------------------
//		 // P1 tiene 4 colas
//		    LinkedQueue<Integer> p1_q1 = new LinkedQueue<Integer>();
//		    p1_q1.enqueue(1);
//		    p1_q1.enqueue(2);
//
//		    LinkedQueue<Integer> p1_q2 = new LinkedQueue<Integer>();
//		    p1_q2.enqueue(10);
//		    p1_q2.enqueue(11);
//		    p1_q2.enqueue(12);
//
//		    LinkedQueue<Integer> p1_q3 = new LinkedQueue<Integer>();
//		    p1_q3.enqueue(20);
//
//		    LinkedQueue<Integer> p1_q4 = new LinkedQueue<Integer>();
//		    p1_q4.enqueue(30);
//		    p1_q4.enqueue(31);
//		    p1_q4.enqueue(32);
//		    p1_q4.enqueue(33);
//
//		    p1.push(p1_q3); // base
//		    p1.push(p1_q1);
//		    p1.push(p1_q2);
//		    p1.push(p1_q4); // tope
//		------------------------------------------------------------------------------
//		    // P2 tiene 2 colas
//		    LinkedQueue<Integer> p2_q1 = new LinkedQueue<Integer>();
//		    p2_q1.enqueue(100);
//
//		    LinkedQueue<Integer> p2_q2 = new LinkedQueue<Integer>();
//		    p2_q2.enqueue(200);
//		    p2_q2.enqueue(201);
//
//		    p2.push(p2_q1); // base
//		    p2.push(p2_q2); // tope
		    
//		    -----------------------------------PRUEBA PARA PILAS DE DISTINTO TAMAÑO (P2 > P1)-----------------------------------
//		  P2 tiene 4 colas
		    LinkedQueue<Integer> p2_q1 = new LinkedQueue<Integer>();
		    p2_q1.enqueue(1);
		    p2_q1.enqueue(2);

		    LinkedQueue<Integer> p2_q2 = new LinkedQueue<Integer>();
		    p2_q2.enqueue(10);
		    p2_q2.enqueue(11);
		    p2_q2.enqueue(12);

		    LinkedQueue<Integer> p2_q3 = new LinkedQueue<Integer>();
		    p2_q3.enqueue(20);

		    LinkedQueue<Integer> p2_q4 = new LinkedQueue<Integer>();
		    p2_q4.enqueue(30);
		    p2_q4.enqueue(31);
		    p2_q4.enqueue(32);
		    p2_q4.enqueue(33);

		    p2.push(p2_q3); // base
		    p2.push(p2_q1);
		    p2.push(p2_q2);
		    p2.push(p2_q4); // tope
//		------------------------------------------------------------------------------
		    // P2 tiene 1 colas
		    LinkedQueue<Integer> p1_q1 = new LinkedQueue<Integer>();
		    p1_q1.enqueue(100);

		    LinkedQueue<Integer> p1_q2 = new LinkedQueue<Integer>();
		    p1_q2.enqueue(200);
		    p1_q2.enqueue(201);

		    p1.push(p1_q1); // base
		    p1.push(p1_q2); // tope
		    
		 System.out.println("La pila 1 tiene " + p1.size() + " elementos");
		 System.out.println("La pila 2 tiene " + p2.size() + " elementos");

	    // Ejecutar el método Ejercicio
	    ArrayStack<LinkedQueue<Integer>> resultado = Ejercicio(p1, p2);

	    // Imprimir la pila resultado (de tope a base)
	    System.out.println("La pila tiene " + resultado.size() + " colas");
	    while (!resultado.isEmpty()) {
	        LinkedQueue<Integer> cola = resultado.pop();
	        System.out.println("Cantidad de elementos de la cola: " + cola.size()); 
	    }
	}
	
	
	
}