package ejercicios;

import clases.ArrayDictionary;

public class MainPruebaArrayDictionary {
	public static void main(String[] args) {
        ArrayDictionary<String, String> diccionario = new ArrayDictionary<>();

        // Insertar valores
        diccionario.put("fruta", "manzana");
        diccionario.put("fruta", "banana");
        diccionario.put("animal", "perro");
        diccionario.put("animal", "gato");
        diccionario.put("color", "azul");

        // Tamaño y claves
        System.out.println("¿Está vacío? " + diccionario.isEmpty());
        System.out.println("Tamaño: " + diccionario.size());

        System.out.println("\nClaves:");
        for (String k : diccionario.keys()) {
            System.out.println(" - " + k);
        }

        // Obtener valores por clave
        System.out.println("\nValores asociados a 'animal':");
        for (String v : diccionario.get("animal")) {
            System.out.println(" - " + v);
        }

        // Eliminar un valor específico
        System.out.println("\nEliminando 'gato' de 'animal'");
        diccionario.remove("animal", "gato");

        System.out.println("Valores restantes en 'animal':");
        Iterable<String> animales = diccionario.get("animal");
        if (animales != null) {
            for (String a : animales) {
                System.out.println(" - " + a);
            }
        } else {
            System.out.println("No hay valores.");
        }

        // Eliminar una clave completa
        System.out.println("\nEliminando clave 'color'");
        diccionario.remove("color");

        System.out.println("Claves restantes:");
        for (String k : diccionario.keys()) {
            System.out.println(" - " + k);
        }
    }

}
