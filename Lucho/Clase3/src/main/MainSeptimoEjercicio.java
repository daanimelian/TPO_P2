package main;import java.util.LinkedList;

import Clases.LinkedStack;

public class MainSeptimoEjercicio {

	public static void main(String[] args) {
//		Ejercicio 7
//		Solicitar al usuario que ingrese una cadena de caracteres y validar si se cerraron
//		todos los paréntesis que se abrieron utilizando una LinkedStack, por ejemplo,
//		“Hola, (esto es (un ejemplo) correcto)” es verdadero, “Hola, (esto es (un ejemplo)
//		incorrecto porque falta cerrar un paréntesis” es falso.
		String primerCadena = "Hola, (esto es (un ejemplo) correcto)";
		String segundaCadena = "Hola, (esto es (un ejemplo)";
		
		
		System.out.println("----------Primer cadena----------");
		if(LinkedStack.validarParentesis(primerCadena)) {
			System.out.println("Se han cerrado todos los parentesis.");
		}else {
			System.out.println("NO se han cerrado todos los parentesis.");
		}
		System.out.println("----------Segunda cadena----------");
		if(LinkedStack.validarParentesis(segundaCadena)) {
			System.out.println("Se han cerrado todos los parentesis.");
		}else {
			System.out.println("NO se han cerrado todos los parentesis.");
		}
		
	}
	

}
