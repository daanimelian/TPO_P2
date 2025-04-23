package main;

import Clases.LinkedStack;
import Interfaces.Stack;
import Excepciones.MyException;


public class MainTercerEjercicio {
    public static void main(String[] args) {
        // 1. Crear una pila de Strings
        Stack<String> pila = new LinkedStack<>();

        // 2. Probar isEmpty() y size() en pila vacía
        System.out.println("¿Está vacía? " + pila.isEmpty()); // true
        System.out.println("Tamaño: " + pila.size());         // 0

        // 3. Push de elementos
        System.out.println("\nApilando elementos...");
        pila.push("Hola");
        pila.push("Mundo");
        pila.push("!");

        System.out.println("Top actual: " + pila.top()); // "!"
        System.out.println("Tamaño: " + pila.size());   // 3

        // 4. Probar pop()
        System.out.println("\nDesapilando elementos...");
        System.out.println("Pop: " + pila.pop()); // "!"
        System.out.println("Pop: " + pila.pop()); // "Mundo"
        System.out.println("Pop: " + pila.pop()); // "Hola"

        // 5. Verificar estado después de vaciar
        System.out.println("\n¿Está vacía? " + pila.isEmpty()); // true
        System.out.println("Tamaño: " + pila.size());         // 0

        // 6. Probar top() y pop() en pila vacía (debe lanzar excepciones)
        System.out.println("\nIntentando top() en pila vacía:");
        try {
            System.out.println(pila.top());
        } catch (MyException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        System.out.println("\nIntentando pop() en pila vacía:");
        try {
            System.out.println(pila.pop());
        } catch (MyException e) {
            System.out.println("Excepción atrapada: " + e.getMessage());
        }

        // 7. Prueba con números (genéricos)
        System.out.println("\n----- Prueba con Integers -----");
        Stack<Integer> pilaNumeros = new LinkedStack<>();
        pilaNumeros.push(10);
        pilaNumeros.push(20);
        pilaNumeros.push(30);

        System.out.println("Top: " + pilaNumeros.top()); // 30
        System.out.println("Pop: " + pilaNumeros.pop()); // 30
        System.out.println("Pop: " + pilaNumeros.pop()); // 20
    }
}


