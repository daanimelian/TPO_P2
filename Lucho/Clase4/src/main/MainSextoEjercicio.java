package main;

import Excepciones.MyException;
import clases.ArrayPriorityQueue;
import clases.Entry;

public class MainSextoEjercicio {
	 public static void main(String[] args) throws MyException {
	        ArrayPriorityQueue<Integer, String> pq = new ArrayPriorityQueue<>(10);

	        System.out.println("Insertando elementos...");
	        pq.insert(5, "Cinco");
	        pq.insert(2, "Dos");
	        pq.insert(9, "Nueve");
	        pq.insert(1, "Uno");
	        pq.insert(4, "Cuatro");

	        System.out.println("\nTamaño actual: " + pq.size());

	        System.out.println("\nElemento con menor prioridad (clave más baja):");
	        System.out.println(pq.min().getKey() + " -> " + pq.min().getValue());

	        System.out.println("\nEliminando elementos según prioridad:");
	        while (!pq.isEmpty()) {
	            Entry<Integer, String> e = pq.removeMin();
	            System.out.println("Removido: " + e.getKey() + " -> " + e.getValue());
	        }

	        System.out.println("\nTamaño final: " + pq.size());
	    }

}
