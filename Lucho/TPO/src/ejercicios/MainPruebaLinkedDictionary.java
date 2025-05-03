package ejercicios;

import clases.Entry;
import clases.LinkedDictionary;

public class MainPruebaLinkedDictionary {
    public static void main(String[] args) {
        LinkedDictionary<String, String> diccionario = new LinkedDictionary<>();

        System.out.println("¿Está vacío? " + diccionario.isEmpty()); // true

        // Agregar elementos
        diccionario.put("animal", "perro");
        diccionario.put("animal", "gato");
        diccionario.put("fruta", "manzana");
        diccionario.put("fruta", "banana");
        diccionario.put("color", "azul");

        System.out.println("Tamaño: " + diccionario.size()); // 3 claves

        // Mostrar valores de una clave
        System.out.println("Valores asociados a 'animal':");
        for (String valor : diccionario.get("animal")) {
            System.out.println(" - " + valor);
        }

        // Eliminar un valor específico
        System.out.println("\nEliminando 'gato' de 'animal'");
        diccionario.remove("animal", "gato");

        System.out.println("Valores actualizados de 'animal':");
        for (String valor : diccionario.get("animal")) {
            System.out.println(" - " + valor);
        }

        // Eliminar por clave
        System.out.println("\nEliminando clave 'color'");
        diccionario.remove("color");

        System.out.println("Tamaño actual: " + diccionario.size()); // 2 claves

        // Mostrar claves
        System.out.println("\nClaves actuales:");
        for (String clave : diccionario.keys()) {
            System.out.println(" - " + clave);
        }

        // Mostrar todas las entradas
        System.out.println("\nEntradas completas:");
        for (Entry<String, Iterable<String>> entrada : diccionario.entries()) {
            System.out.print(entrada.getKey() + " -> ");
            for (String val : entrada.getValue()) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}