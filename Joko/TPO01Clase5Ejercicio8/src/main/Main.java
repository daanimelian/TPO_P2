package main;

import inout.InOut;
import controller.Controller;

public class Main {
	public static void main (String[] args) {
		String opcion;
		String opcionCase1;
		InOut InOut = new InOut();
		Controller Controller = new Controller();
		do {
			opcion = InOut.MenuPrincipal();
			
			switch(opcion) {
			case "0":
				System.out.println("Saliendo.... "); 
				break;
				case "1":
					//Cargar un mapeo con notas de una materia 
					do {
						opcionCase1 = InOut.MenuCargaMapa();
						switch(opcionCase1) {
							case "1":
								
								break;
							case "0":
								System.out.println("Saliendo.... "); 
								break;
						}
					}while(!opcionCase1.equals("0"));
					
					Controller.CargarMapeo(Controller.CrearMapa());
					break;
				case "2":
					//Mostrar el último mapeo cargado 
					InOut.MostrarMapeo(Controller.getUltimoMapeo());
					break;
				case "3":
					//Agregar el último mapeo cargado al Diccionario general 
					Controller.AgregarMapeo(Controller.getUltimoMapeo());
					break;
				case "4":
					//Agregar una nota para un DNI específico
					Controller.CargarNota(InOut.PedirDni(),InOut.PedirNota());
					break;
				case "5":
					// Quitar una nota para un DNI específico 
					Controller.QuitarNota(InOut.PedirDni(),InOut.PedirNota());
					break;
				case "6":
					//Quitar un alumno
					Controller.QuitarAlumno(InOut.PedirDni());
					break;
				case "7":
					//Mostrar las notas de un alumno 
					InOut.MostrarNotas(Controller.GetNotas(InOut.PedirDni()));
					break;
				case "8":
					//Mostrar todos los alumnos 
					InOut.MostrarAlumnos(Controller.GetAlumnos());
					break;
				case "9":
					//Mostrar todos los alumnos y su promedio de notas 
					InOut.MostrarAlumnosYPromedios(Controller.GetAlumnosYPromedios());
					break;
				default:
					System.out.println("Opcion inexistente, intente nuevamente."); 
					break;
			}
		}while(!opcion.equals("0"));
	}
}
