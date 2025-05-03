package ejercicios;

import java.util.Scanner;

import clases.ArrayDictionary;
import clases.ArrayMap;

public class MainClase5 {

	
//	Ejercicio 7
//	Se poseen dos diccionarios simples (mapeos) M1 y M2 cuyas entradas tienen por
//	clave un número de dni, y por imagen la nota de una materia (0 a 10) (M1 tiene las
//	notas de una materia A y M2 de una materia B).
//	• Implementar un programa que permita al usuario cargar DNI y nota
//	completando ambos mapeos y luego visualizar todos los datos cargados.
//	Utilizar estructuras estáticas.
//	• Realice un comando llamado unir que reciba los dos mapeos M1 y M2 y
//	devuelva una lista L con TODOS aquellos elementos E1 de M1 y E2 de M2
//	que coincidan en la clave, pero tengan un valor diferente. Por ejemplo, si
//	E1= (DNI: 29303, Nota: 8) pertenece a M1 y E2= (DNI:29303, Nota: 7)
//	pertenece a M2, entonces E1 y E2 serán puestos en L.
	
	public static void ejercicio7() {
		
	}
	
	
//	Ejercicio 8
//	Extienda el ejercicio anterior para que sea posible cargar varios diccionarios
//	simples (map) y luego consolidarlos en un único diccionario múltiple sólo que en
//	este caso se utilizan estructuras dinámicas. El programa tiene un menú constante
//	que da al usuario las opciones:
//	• Cargar un mapeo con notas de una materia
//	• Mostrar el último mapeo cargado
//	• Agregar el último mapeo cargado al Diccionario general
//	• Agregar una nota para un DNI específico
//	• Quitar una nota para un DNI específico
//	• Quitar un alumno
//	• Mostrar las notas de un alumno
//	• Mostrar todos los alumnos
//	• Mostrar todos los alumnos y su promedio de notas

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayMap<Integer,Integer> arrayDicBiologia = new ArrayMap<Integer,Integer>();
		ArrayMap<Integer,Integer> arrayDicHistoria = new ArrayMap<Integer,Integer>();
		boolean continuar = true;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenid@ al Programa de carga de notas de materias!");
		System.out.println("-----------");
		while(continuar) {
			System.out.println("¿Desea sumar información de la matería de Biología o Historia?\n" +
								"Ingrese 1 para sumar información a Biología.\n" +
								"Ingrese 2 para sumar información a Historia.\n" +
								"Ingrese 3 para finalizar la carga de información."
					);
			String opcionElegida = scan.nextLine();
			switch(opcionElegida) {
//			---------Sumar info a Biologia---------
			case "1":
				System.out.println("Ingrese el número de DNI: ");
				String dniLeidoBio = scan.nextLine();
				Integer dni = Integer.parseInt(dniLeidoBio);
				System.out.println("Ingrese la nota de la materia: ");
				String notaLeidaBio = scan.nextLine();
				Integer nota = Integer.parseInt(notaLeidaBio);
				while(nota < 0 || nota > 10) {
					System.out.println("Solamente se admite la carga de notas entre 0 y 10. Por favor, vuelva a intentarlo: ");
					System.out.println("Ingrese la nota de la materia: ");
					notaLeidaBio = scan.nextLine();
					nota = Integer.parseInt(notaLeidaBio);
				}
				arrayDicBiologia.put(dni, nota);
				System.out.println("-----------");
				break;
				
			case "2":
//				---------Sumar info a Historia---------
				System.out.println("Ingrese el número de DNI: ");
				String dniLeido = scan.nextLine();
				Integer dni2 = Integer.parseInt(dniLeido);
				System.out.println("Ingrese la nota de la materia: ");
				String notaLeida = scan.nextLine();
				Integer nota2 = Integer.parseInt(notaLeida);
				while(nota2 < 0 || nota2 > 10) {
					System.out.println("Solamente se admite la carga de notas entre 0 y 10. Por favor, vuelva a intentarlo: ");
					System.out.println("Ingrese la nota de la materia: ");
					notaLeida = scan.nextLine();
					nota2 = Integer.parseInt(notaLeida);
				}
				arrayDicHistoria.put(dni2, nota2);
				System.out.println("-----------");
				break;
				
				
			case "3":
//				---------Terminar carga---------
				continuar = false;
				System.out.println("-----Finalizando------");
				
				break;

			}

	}
		
		System.out.println("---------Resultados Biologia---------");
		System.out.println(arrayDicBiologia.toString());
		System.out.println("---------Resultados Historia---------");
		System.out.println(arrayDicHistoria.toString());
		


	}
	}
