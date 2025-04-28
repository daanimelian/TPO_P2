package inout;

import java.util.Scanner;

public class InOut {
	private Scanner scanner = new Scanner(System.in); 
	
	public String MenuPrincipal() {
		String opcion;
		System.out.println("----- Bienvenido al Ejercicio 8 -----\n");
		System.out.println("Opciones");
		System.out.println("1.Cargar un mapeo con notas de una materia.");
		System.out.println("2.Mostrar el último mapeo cargado.");
		System.out.println("3.Agregar el último mapeo cargado al Diccionario general.");
		System.out.println("4.Agregar una nota para un DNI específico."); 
		System.out.println("5.Quitar una nota para un DNI específico."); 
		System.out.println("6.Quitar un alumno."); 
		System.out.println("7.Mostrar las notas de un alumno. "); 
		System.out.println("8.Mostrar todos los alumnos."); 
		System.out.println("9.Mostrar todos los alumnos y su promedio de notas."); 
		System.out.println("0.Salir."); 
		System.out.println("Ingrese una opcion: ");
		opcion = scanner.nextLine();
		return opcion;
	}

	public void MostrarMapeo(Object ultimoMapeo) {
		// TODO Auto-generated method stub
		
	}

	public Object PedirDni() {
		// TODO Auto-generated method stub
		return null;
	}

	public void MostrarNotas(Object getNotas) {
		// TODO Auto-generated method stub
		
	}

	public void MostrarAlumnos(Object getAlumnos) {
		// TODO Auto-generated method stub
		
	}

	public void MostrarAlumnosYPromedios(Object getAlumnosYPromedios) {
		// TODO Auto-generated method stub
		
	}
}
