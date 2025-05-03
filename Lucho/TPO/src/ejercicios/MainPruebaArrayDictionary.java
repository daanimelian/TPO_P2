package ejercicios;

import clases.ArrayDictionary;
import clases.Entry;

public class MainPruebaArrayDictionary {
	public static void main(String[] args) {
        ArrayDictionary<String, Integer> dict = new ArrayDictionary<>();

        // Test 1: Agregar elementos nuevos
        dict.put("A", 1);
        dict.put("A", 2);
        dict.put("A", 3);
        dict.put("B", 10);
        dict.put("C", 100);
        dict.put("C", 200);

        // Mostrar claves y valores
        System.out.println("Claves:");
        for (String key : dict.keys()) {
            System.out.println("  " + key);
        }

        System.out.println("\nValores por clave:");
        for (String key : dict.keys()) {
            System.out.print("  " + key + ": ");
            for (Integer v : dict.get(key)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }

        // Test 2: remove(clave, valor) - eliminar un valor específico
        System.out.println("\nEliminando el valor 2 de la clave A:");
        dict.remove("A", 2);
        for (Integer v : dict.get("A")) {
            System.out.print("  " + v);
        }
        System.out.println();

        // Test 3: remove(clave) - eliminar todos los valores de una clave
        System.out.println("\nEliminando la clave C por completo:");
        Iterable<Integer> eliminados = dict.remove("C");
        System.out.println("  Valores eliminados: " + eliminados);

        System.out.println("Claves restantes:");
        for (String key : dict.keys()) {
            System.out.println("  " + key);
        }

        // Test 4: remove(clave, valor) - eliminar último valor
        System.out.println("\nEliminando 10 de B (único valor):");
        dict.remove("B", 10);

        System.out.println("Claves después de eliminar B:");
        for (String key : dict.keys()) {
            System.out.println("  " + key);
        }

        // Test 5: remove(clave, valor) - eliminar valor inexistente
        System.out.println("\nIntentando eliminar 999 de A:");
        Integer result = dict.remove("A", 999);
        System.out.println("  Resultado: " + result); // Debería ser null

        // Test 6: get(clave) inexistente
        System.out.println("\nIntentando acceder a clave inexistente Z:");
        Iterable<Integer> resultZ = dict.get("Z");
        System.out.println("  Resultado: " + resultZ); // Debería ser null

        // Test 7: entries
        System.out.println("\nEntradas:");
        for (Entry<String, Iterable<Integer>> entry : dict.entries()) {
            System.out.print("  " + entry.getKey() + ": ");
            for (Integer v : entry.getValue()) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

}
