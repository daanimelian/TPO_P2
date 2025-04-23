package septimaClase;

import Interfaces.MyException;

public class Main {
    public static void main(String[] args) {
        try {
            DLinkedList<Integer> lista = new DLinkedList<>();

            // Agregar elementos al principio
            lista.addFirst(3);
            lista.addFirst(2);
            lista.addFirst(1);

            // Agregar elementos al final
            lista.addLast(4);
            lista.addLast(5);

            // Mostrar elementos desde el principio con advance()
            System.out.println("Recorrido hacia adelante:");
            lista.First();
            while (!lista.atEnd()) {
                System.out.print(lista.getCurrent() + " ");
                lista.advance();
            }
            System.out.println();

            // Mostrar elementos desde el final con back()
            System.out.println("Recorrido hacia atrás:");
            lista.Last();
            while (!lista.atEnd()) {
                System.out.print(lista.getCurrent() + " ");
                lista.back();
            }
            System.out.println();

            // Eliminar primero
            lista.removeFirst();

            // Eliminar último
            lista.removeLast();

            // Eliminar un elemento intermedio
            lista.remove(3);

            // Mostrar resultado final
            System.out.println("Lista final:");
            lista.First();
            while (!lista.atEnd()) {
                System.out.print(lista.getCurrent() + " ");
                lista.advance();
            }

        } catch (MyException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
