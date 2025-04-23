package main;

import Excepciones.MyException;
import clases.LinkedQueue;

public class MainTercerEjercicio {
	public static void main(String[] args) {
        try {
            // Crear una cola de Strings
            LinkedQueue<String> cola = new LinkedQueue<>();

            System.out.println("¿La cola está vacía? " + cola.isEmpty());
            System.out.println("Encolando elementos...");

            cola.enqueue("Uno");
            cola.enqueue("Dos");
            cola.enqueue("Tres");

            System.out.println("Tamaño de la cola: " + cola.size());
            System.out.println("Elemento al frente: " + cola.front());

            System.out.println("Desencolando: " + cola.dequeue());
            System.out.println("Nuevo frente: " + cola.front());
            System.out.println("Tamaño actual: " + cola.size());

            System.out.println("Desencolando: " + cola.dequeue());
            System.out.println("Desencolando: " + cola.dequeue());

            // Verificar si está vacía luego de vaciarla
            System.out.println("¿Está vacía después de desencolar todo? " + cola.isEmpty());

            // Intentar desencolar de una cola vacía
            System.out.println("Intentando desencolar cuando está vacía...");
            cola.dequeue(); // Esto lanza excepción

        } catch (MyException e) {
            System.out.println("⚠️ Excepción atrapada: " + e.getMessage());
        }
    }

}
