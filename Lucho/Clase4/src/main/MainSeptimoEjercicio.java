package main;

import Excepciones.MyException;
import clases.Entry;
import clases.LinkedPriorityQueue;

public class MainSeptimoEjercicio {
	 public static void main(String[] args) {
	        try {
	            LinkedPriorityQueue<Integer, String> lpq = new LinkedPriorityQueue<>();

	            System.out.println("Insertando elementos con diferentes prioridades:");
	            lpq.insert(5, "Cinco");
	            lpq.insert(2, "Dos");
	            lpq.insert(9, "Nueve");
	            lpq.insert(1, "Uno");
	            lpq.insert(4, "Cuatro");

	            System.out.println("\nTamaño actual de la cola: " + lpq.size());

	            System.out.println("\nElemento con menor clave (mínimo):");
	            Entry<Integer, String> min = lpq.min();
	            System.out.println(min.getKey() + " -> " + min.getValue());

	            System.out.println("\nEliminando elementos según prioridad:");
	            while (!lpq.isEmpty()) {
	                Entry<Integer, String> e = lpq.removeMin();
	                System.out.println("Removido: " + e.getKey() + " -> " + e.getValue());
	            }

	            System.out.println("\nTamaño final de la cola: " + lpq.size());
	        } catch (MyException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

}
