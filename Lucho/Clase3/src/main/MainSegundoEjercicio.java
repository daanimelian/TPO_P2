package main;

import Clases.ArrayStack;
import Interfaces.Stack;

public class MainSegundoEjercicio {
    public static void main(String[] args) {
//        // 1. Crear una pila de enteros
//        System.out.println("----- Prueba de ArrayStack -----");
//        Stack<Integer> pila = new ArrayStack<>();
//
//        // 2. Probar isEmpty() y size() en pila vacía
//        System.out.println("¿Está vacía? " + pila.isEmpty()); // true
//        System.out.println("Tamaño: " + pila.size());         // 0
//
//        // 3. Push de elementos
//        System.out.println("\nApilando números del 1 al 15...");
//        for (int i = 1; i <= 15; i++) {
//            pila.push(i);
//            System.out.println("Push: " + i + " | Tamaño: " + pila.size());
//        }
//
//        // 4. Probar top()
//        System.out.println("\nTop actual: " + pila.top()); // Debe ser 15
//
//        // 5. Probar pop()
//        System.out.println("\nDesapilando 5 elementos...");
//        for (int i = 0; i < 5; i++) {
//            System.out.println("Pop: " + pila.pop() + " | Tamaño: " + pila.size());
//        }
//
//        // 6. Verificar estado después de pops
//        System.out.println("\nTop después de pops: " + pila.top()); // Debe ser 10
//        System.out.println("¿Está vacía? " + pila.isEmpty());       // false
//
//        // 7. Vaciar la pila completamente
//        System.out.println("\nVaciar la pila...");
//        while (!pila.isEmpty()) {
//            System.out.println("Pop: " + pila.pop());
//        }
//
//        // 8. Probar pop() y top() en pila vacía (debe lanzar excepciones)
//        System.out.println("\nIntentando pop() en pila vacía:");
//        try {
//            pila.pop();
//        } catch (MyException e) {
//            System.out.println("Excepción atrapada: " + e.getMessage());
//        }
//
//        System.out.println("\nIntentando top() en pila vacía:");
//        try {
//            pila.top();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.out.println("Excepción atrapada: " + e.getMessage());
//        }

        // 9. Prueba con cadenas (para demostrar genéricos)
        System.out.println("\n----- Prueba con Strings -----");
        Stack<String> pilaStrings = new ArrayStack<>(3); // Pila inicial de capacidad 3

        pilaStrings.push("Hola");
        pilaStrings.push("Mundo");
        pilaStrings.push("!");

        // Forzar redimensionamiento
        pilaStrings.push("Java");
        System.out.println("Push: 'Java' | Tamaño: " + pilaStrings.size()); // Tamaño 4

        System.out.println("\nContenido de la pila de strings:");
        while (!pilaStrings.isEmpty()) {
            System.out.println("Pop: " + pilaStrings.pop());
        }
    }
}

// Clase de excepción personalizada (asumiendo que existe)
class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}