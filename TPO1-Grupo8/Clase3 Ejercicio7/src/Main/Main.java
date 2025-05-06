package Main;
import java.util.Scanner;


import PilaEnlazada.Pila;

public class Main {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			String texto = scanner.nextLine();
			char[] textoArray = texto.toCharArray();
			Pila<Character> pilaCerrados = new Pila<Character> () ;
			Pila<Character> pilaAbiertos = new Pila<Character> () ;
			
			for(int i = 0; i<textoArray.length; i++) {
				if(textoArray[i] == '(') {
					pilaAbiertos.push(textoArray[i]);
				}else if(textoArray[i] == ')') {
					pilaCerrados.push(textoArray[i]);
				}
			}
			
			System.out.println(pilaAbiertos.size() == pilaCerrados.size());
		}
		
	}

}
