package main;

import Clases.ArrayStack;
import Clases.Persona;

public class MainQuintoEjercicio {
	public static void main(String[] args) {
//		Ejercicio 5
//		Suponiendo que posee la clase Persona (vista en clase). Implemente un método
//		Invertir( A ) que reciba un arreglo de personas y utilice la clase ArrayStack para
//		invertir el contenido del arreglo A
		
		
		Persona[] lista = new Persona[3];
		
		Persona perso1 = new Persona("Luciano", 60, 41666469);
		Persona perso2 = new Persona("Patricio", 78, 43699234);
		Persona perso3 = new Persona("Matias", 50, 92111123);
		
		lista[0] = perso1;
		lista[1] = perso2;
		lista[2] = perso3;	
		System.out.println("----------Sin invertir----------");
		for (int i = 0; i < lista.length; i++){
			System.out.println("Persona N°: " + (i+1) );
			System.out.println(lista[i].getNombre());
			System.out.println(lista[i].getDni());
			System.out.println(lista[i].getPeso());
		}
		
		
		
		ArrayStack.invertir(lista);
		System.out.println("----------Invertido----------");
		for (int i = 0; i < lista.length; i++){
			System.out.println("Persona N°: " + (i+1) );
			System.out.println(lista[i].getNombre());
			System.out.println(lista[i].getDni());
			System.out.println(lista[i].getPeso());
		}
	}
}
