package main;

import java.util.Scanner;

import Clases.LinkedStack;

public class MainSextoEjercicio {
	public static void main(String[] args) {
//		Ejercicio 6
//		Solicitar al usuario que ingrese una cadena de caracteres y validar si la misma es
//		capicúa utilizando una LinkedStack, por ejemplo, “34543” es verdadero, “12332”
//		es falso. Recuerden que un String se puede recorrer como un arreglo de caracteres
//		utilizando charAt(i) para conocer el elemento en la posición i y length() para
//		obtener la longitud total de la cadena.
		Scanner input = new Scanner(System.in);
		System.out.println("Ingrese una cadena de caracteres para verificar si es capicúa: ");
		
		String cadena = input.nextLine();
		System.out.println(cadena);
		while (cadena.equals("")) {
			System.out.println("No se admiten cadenas vacías");
			System.out.println("Ingrese una cadena de caracteres para verificar si es capicúa: ");
			cadena = input.nextLine();
		}
		
		if(LinkedStack.esCapicua(cadena)) {
			System.out.println("Es capicúa.");
		}else {
			System.out.println("No es capicúa.");
		}
	}
	
		
	

}
