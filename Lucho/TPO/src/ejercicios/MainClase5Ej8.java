package ejercicios;



import java.util.Scanner;

import clases.*;

public class MainClase5Ej8 {
	
	
	public static void cargarMap(ArrayStack<ArrayMap<Integer, Integer>> stackMapas) {
		ArrayMap<Integer,Integer> arrayMap = new ArrayMap<Integer,Integer>();
		boolean continuar = true;
		Scanner scan = new Scanner(System.in);
		
		while(continuar) {
		System.out.println("Ingrese el número de DNI: ");
		String dniLeido = scan.nextLine();
		Integer dni = Integer.parseInt(dniLeido);

		System.out.println("Ingrese la nota de la materia: ");
		String notaLeida = scan.nextLine();
		Integer nota = Integer.parseInt(notaLeida);
		while(nota < 0 || nota > 10) {
			System.out.println("Solamente se admite la carga de notas entre 0 y 10. Por favor, vuelva a intentarlo: ");
			System.out.println("Ingrese la nota de la materia: ");
			notaLeida = scan.nextLine();
			nota = Integer.parseInt(notaLeida);
		}
		arrayMap.put(dni, nota);
		stackMapas.push(arrayMap);
		System.out.println("Para continuar ingrese 1\n" +
							"Para finalizar ingrese -1: ");
		
		String respuesta = scan.nextLine();
		if(respuesta.equals("-1")) {
			continuar = false;
			System.out.println("-----Finalizando la carga del Map------");
		}
		}
	}
	
		
	public static void mostrarUltimoMapeoCargado(ArrayStack<ArrayMap<Integer, Integer>> stackMapas) {
		System.out.println("Últmo mapeo cargado: ");
		System.out.println(stackMapas.top().toString());
		
		
		
	}
	
	public static void agregarUltimoMapeoDiccionario(ArrayStack<ArrayMap<Integer, Integer>> stackMapas, LinkedDictionary<Integer,Integer> diccionarioFinal) {
		Entry<Integer,Integer>[] entradas = stackMapas.pop().entries();
		for(int i = 0; i < entradas.length; i ++) {
			diccionarioFinal.put(entradas[i].getKey(), entradas[i].getValue());
		}
		System.out.println("¡Pasaje del último mapeo a diccionario final exitoso!");
	};
	
	
	public static void agregarNotaAUnDni(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni, Integer nota) {
		diccionarioFinal.put(dni, nota);
		System.out.println("¡Nota cargada al DNI " + dni + " de manera exitosa!");
	}
	
	
	public static void quitarNotaAUnDNI(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni, Integer nota) {
		diccionarioFinal.remove(dni, nota);
		System.out.println("¡Nota eliminada al DNI " + dni + " de manera exitosa!");
		
	}
	
	public static void quitarAlumno(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni) {
		diccionarioFinal.remove(dni);
		System.out.println("¡Alumno de DNI " + dni + " eliminado de manera exitosa!");
	}
	
	public static void mostrarNotasAlumno(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni) {
		Iterable<Integer> notas = diccionarioFinal.get(dni);
		 System.out.print("Notas del alumno con DNI " + dni + ": ");
		    for (Integer nota : notas) {
		        System.out.print(nota + " ");
		    }
		    System.out.println();
	}
	
	public static void MostrarTodosLosAlumnos(LinkedDictionary<Integer,Integer> diccionarioFinal) {
		Iterable <Entry <Integer, Iterable <Integer>>>  alumnos = diccionarioFinal.entries();
		for(Entry <Integer, Iterable <Integer>> alumno : alumnos) {
			Integer dni = alumno.getKey();
			System.out.print("Notas del alumno con DNI " + dni + ": ");
			for(Integer nota : alumno.getValue()) {
				System.out.print(nota + "-");
			}
			System.out.println(".\n");
			
		}
	}
	
	public static void MostrarTodosLosAlumnosyPromedios(LinkedDictionary<Integer,Integer> diccionarioFinal) {
		Iterable <Entry <Integer, Iterable <Integer>>>  alumnos = diccionarioFinal.entries();
		for(Entry <Integer, Iterable <Integer>> alumno : alumnos) {
			Integer dni = alumno.getKey();
			System.out.print("Notas del alumno con DNI " + dni + ": ");
			double sumador = 0;
			int cantMaterias = 0;
			for(Integer nota : alumno.getValue()) {
				System.out.print(nota + "-");
				sumador += nota;
				cantMaterias ++;
			}
			double promedio = sumador/cantMaterias;
			System.out.println("\nPromedio de notas: "+ promedio + ".\n");
			
		}
	}
	
	public static void menu (ArrayStack<ArrayMap<Integer, Integer>> stackMapas, LinkedDictionary<Integer,Integer> diccionarioFinal) {
		boolean continuar = true;
		Scanner scan = new Scanner(System.in);
		System.out.println("Bienvenid@ al Programa de carga de notas de materias!");
		while(continuar) {
			
			System.out.println("-----------Opciones-----------");
			System.out.println("Elija el número de la opción para continuar: ");

			System.out.println("1 - Cargar un mapeo con notas de una materia\n" +
								"2 - Mostrar el último mapeo cargado \n" +
								"3 - Agregar el último mapeo cargado al Diccionario general\n" +
								"4 - Agregar una nota para un DNI específico\n" +
								"5 - Quitar una nota para un DNI específico\n" +
								"6 - Quitar un alumno\n" +
								"7 - Mostrar las notas de un alumno\n" +
								"8 - Mostrar todos los alumnos\n" +
								"9 - Mostrar todos los alumnos y su promedio de notas\n" + 
								"fin - Finalizar programa\n" +
								"----------------------\n");
			String opcionElegida = scan.nextLine();
			while(!opcionElegida.equals("1") && !opcionElegida.equals("2") &&  !opcionElegida.equals("3") && !opcionElegida.equals("4")
					&& !opcionElegida.equals("5") && !opcionElegida.equals("6") && !opcionElegida.equals("7") && !opcionElegida.equals("8")
					&& !opcionElegida.equals("9") && !opcionElegida.equals("fin")) {
				System.out.println("Opción inválida, por favor ingrese una de las opciones mencionadas.\n");
				System.out.println("1 - Cargar un mapeo con notas de una materia\n" +
						"2 - Mostrar el último mapeo cargado \n" +
						"3 - Agregar el último mapeo cargado al Diccionario general\n" +
						"4 - Agregar una nota para un DNI específico\n" +
						"5 - Quitar una nota para un DNI específico\n" +
						"6 - Quitar un alumno\n" +
						"7 - Mostrar las notas de un alumno\n" +
						"8 - Mostrar todos los alumnos\n" +
						"9 - Mostrar todos los alumnos y su promedio de notas\n" + 
						"fin - Finalizar programa\n" +
						"----------------------\n");
				opcionElegida = scan.nextLine();
			}
			switch(opcionElegida) {
			case("1"):
				cargarMap(stackMapas);
				break;
			case("2"):
				mostrarUltimoMapeoCargado(stackMapas);
				break;
			case("3"):
				agregarUltimoMapeoDiccionario(stackMapas, diccionarioFinal);
				break;
			case("4"):
				System.out.println("¿A cual DNI le quiere agregar otra nota?");
				Integer dni = (Integer) scan.nextInt();
				System.out.println("¿Que nota quiere cargar?");
				Integer nota = (Integer) scan.nextInt();
				agregarNotaAUnDni(diccionarioFinal, dni, nota);
				break;
			case("5"):
				System.out.println("¿A cual DNI le quiere quitar una nota?");
				Integer dniQuitar = (Integer) scan.nextInt();
				System.out.println("¿Que nota quiere cargar?");
				Integer notaQuitar = (Integer) scan.nextInt();
				quitarNotaAUnDNI(diccionarioFinal, dniQuitar, notaQuitar);
				break;
				
			case("6"):
				System.out.println("¿Cual es el DNI del alumno que desea eliminar?");
				Integer alumnoEliminar = (Integer) scan.nextInt();
				quitarAlumno(diccionarioFinal, alumnoEliminar);
				break;
			case("7"):
				System.out.println("¿Cual es el DNI del alumno del cual quiere ver sus notas?");
				Integer dniVisualizar = (Integer) scan.nextInt();
				mostrarNotasAlumno(diccionarioFinal, dniVisualizar);
				break;
			case("8"):
				MostrarTodosLosAlumnos(diccionarioFinal);
				break;
			case("9"):
				MostrarTodosLosAlumnosyPromedios(diccionarioFinal);
				break;
			case("fin"):
				System.out.println("-----------------------Finalizando-----------------------");
				continuar = false;
				break;
			}
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			

		}
	}

	
//	--------------------------------------Main--------------------------------------

	public static void main(String[] args) {
		ArrayStack<ArrayMap<Integer, Integer>> stackMapas = new ArrayStack<ArrayMap<Integer, Integer>>(100);
		LinkedDictionary<Integer,Integer> diccionarioFinal = new LinkedDictionary<Integer,Integer>();
		menu(stackMapas, diccionarioFinal);

}
}
