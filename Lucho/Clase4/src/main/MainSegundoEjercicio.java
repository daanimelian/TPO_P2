package main;

import Excepciones.MyException;
import clases.ArrayQueue;

public class MainSegundoEjercicio {

	public static void main(String[] args) {
        try {
            // Crear una cola de tamaño 5 (recuerda que se llena con 4 elementos por la lógica de size == q.length - 1)
            ArrayQueue<String> cola = new ArrayQueue<>(5);

            // Encolar elementos
            System.out.println("Encolando elementos...");
            cola.enqueue("A");
            cola.enqueue("B");
            cola.enqueue("C");
            cola.enqueue("D");

            // Mostrar elemento al frente
            System.out.println("Elemento al frente: " + cola.front());

            // Desencolar dos elementos
            System.out.println("Desencolando: " + cola.dequeue());
            System.out.println("Desencolando: " + cola.dequeue());

            // Mostrar el nuevo frente
            System.out.println("Nuevo elemento al frente: " + cola.front());

            // Encolar más elementos
            cola.enqueue("E");
            cola.enqueue("F"); // En este punto debería estar llena
            
        
            
            cola.dequeue();

            // Intentar encolar otro (debería lanzar excepción)
            
            cola.enqueue("G");
            
            System.out.println("Nuevo elemento al frente: " + cola.front());
            System.out.println(cola.size());
            
            
            System.out.println("Intentando encolar H...");
            cola.enqueue("H");
            System.out.println(cola.size());
            System.out.println("Intentando encolar I...");
            cola.enqueue("I");
            

        } catch (MyException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        try {
            // Crear una cola vacía y desencolar (para probar la excepción de dequeue)
        	ArrayQueue<Integer> colaVacia = new ArrayQueue<>(3);
            colaVacia.dequeue(); // Esto debe lanzar excepción
        } catch (MyException e) {
            System.out.println("Excepción atrapada al intentar desencolar de una cola vacía: " + e.getMessage());
        }
    }

}
