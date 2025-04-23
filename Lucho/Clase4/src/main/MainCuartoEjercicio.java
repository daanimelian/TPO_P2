package main;

import clases.ArrayQueue;
import clases.ArrayStack;

public class MainCuartoEjercicio {
	public static ArrayStack<ArrayQueue<Integer>> pout(ArrayStack<ArrayQueue<Integer>> p1, ArrayStack<ArrayQueue<Integer>> p2){
		int longitud = p1.size() + p2.size();
		ArrayStack<ArrayQueue<Integer>> pout = new ArrayStack<ArrayQueue<Integer>>(longitud);
		ArrayStack<ArrayQueue<Integer>> auxiliar = new ArrayStack<ArrayQueue<Integer>>(longitud);
		
		while(!p1.isEmpty() && !p2.isEmpty()) {
			if(p1.top().size() > p2.top().size()) {
				auxiliar.push(p1.pop());
			}else {
				auxiliar.push(p2.pop());
			}
		}
		
		while(!p1.isEmpty()) {
			auxiliar.push(p1.pop());
		}
		
		while(!p2.isEmpty()) {
			auxiliar.push(p2.pop());
		}
		
		for(int i = 0; i < longitud; i++) {
			pout.push(auxiliar.pop());
		}
		
			
		return pout;
		}
		
	
	
	
	public static void main(String[] args) throws Exception {
        // Crear las pilas P1 y P2
        ArrayStack<ArrayQueue<Integer>> p1 = new ArrayStack<>(3);
        ArrayStack<ArrayQueue<Integer>> p2 = new ArrayStack<>(5);

     // Crear y llenar colas para p1
        ArrayQueue<Integer> p1_q1 = new ArrayQueue<>(1); // tamaño 1
        p1_q1.enqueue(10);

        ArrayQueue<Integer> p1_q2 = new ArrayQueue<>(2); // tamaño 2
        p1_q2.enqueue(20);
        p1_q2.enqueue(30);

        ArrayQueue<Integer> p1_q3 = new ArrayQueue<>(3); // tamaño 3
        p1_q3.enqueue(40);
        p1_q3.enqueue(50);
        p1_q3.enqueue(60);

        // Apilar en orden correcto (menor tamaño en la base)
        p1.push(p1_q1); // tamaño 1
        p1.push(p1_q2); // tamaño 2
        p1.push(p1_q3); // tamaño 3

        // Crear y llenar colas para p2
        ArrayQueue<Integer> p2_q1 = new ArrayQueue<>(1); // tamaño 1
        p2_q1.enqueue(100);

        ArrayQueue<Integer> p2_q2 = new ArrayQueue<>(2); // tamaño 2
        p2_q2.enqueue(200);
        p2_q2.enqueue(210);

        ArrayQueue<Integer> p2_q3 = new ArrayQueue<>(3); // tamaño 3
        p2_q3.enqueue(300);
        p2_q3.enqueue(310);
        p2_q3.enqueue(320);

        ArrayQueue<Integer> p2_q4 = new ArrayQueue<>(4); // tamaño 4
        p2_q4.enqueue(400);
        p2_q4.enqueue(410);
        p2_q4.enqueue(420);
        p2_q4.enqueue(430);

        ArrayQueue<Integer> p2_q5 = new ArrayQueue<>(5); // tamaño 5
        p2_q5.enqueue(500);
        p2_q5.enqueue(510);
        p2_q5.enqueue(520);
        p2_q5.enqueue(530);
        p2_q5.enqueue(540);

        // Apilar en orden correcto (menor tamaño en la base)
        p2.push(p2_q1); // tamaño 1
        p2.push(p2_q2); // tamaño 2
        p2.push(p2_q3); // tamaño 3
        p2.push(p2_q4); // tamaño 4
        p2.push(p2_q5); // tamaño 5
        // Llamar al método pout
      
        ArrayStack<ArrayQueue<Integer>> pout = pout(p1, p2);
        System.out.println("La longitud actual del arreglo es de: " + pout.size() + " elementos.");
        System.out.println("El mayor elemento es: " + pout.top().size());
       
        System.out.println("----------------");
        // Mostrar los resultados
        System.out.println("Contenido de la pila Pout (de tope a base):");
        while (!pout.isEmpty()) {
            ArrayQueue<Integer> q = pout.pop();
            System.out.println("Cola (size " + q.size() + "): ");
            
        }
    }


}
