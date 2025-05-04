package ejercicio_8;
import map.*;
import java.util.Scanner;
import list.*;
import diccionarios.LinkedDiccionario;
public class main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		LinkedMap<Integer, Integer> ultimoMap = new LinkedMap<>();
		LinkedDiccionario<Integer, Integer> diccionarioGeneral = new LinkedDiccionario<>();
		while (true) {
			System.out.println("1. Cargar un mapeo con notas de una materia ");
			System.out.println("2. Mostrar el último mapeo cargado ");
			System.out.println("3. Agregar el último mapeo cargado al Diccionario general ");
			System.out.println("4. Agregar una nota para un DNI específico ");
			System.out.println("5. Quitar una nota para un DNI específico ");
			System.out.println("6. Quitar un alumno ");
			System.out.println("7. Mostrar las notas de un alumno ");
			System.out.println("8. Mostrar todos los alumnos ");
			System.out.println("9. Mostrar todos los alumnos y su promedio de notas ");
			System.out.println("----------------------------------------------------------");
			System.out.println("Ingrese la opcion a ejecutar:");

			int opcion = teclado.nextInt();
			switch(opcion) {
				case 1: {
					ultimoMap=new LinkedMap<>();
					cargarMapeo(ultimoMap);
					break;
				}
				case 2:{
					mostrarMap(ultimoMap);
					break;

				}
				case 3:{
					cargarADiccionario(ultimoMap, diccionarioGeneral);
					break;
				}
				case 4:{
					System.out.println("Ingrese el DNI");
					int dni= teclado.nextInt();
					System.out.println("Ingrese la nota de la materia");
					int nota1= teclado.nextInt();
					diccionarioGeneral.put(dni, nota1);
					break;
				}
				case 5:{
					System.out.println("Ingrese el DNI");
					int dni= teclado.nextInt();
					System.out.println("Ingrese la nota de la materia");
					int nota1= teclado.nextInt();
					diccionarioGeneral.remove(dni, nota1);
					break;
				}
				case 6:{
					System.out.println("Ingrese el DNI");
					int dni= teclado.nextInt();
					diccionarioGeneral.remove(dni);
					break;
				}
				case 7:{
					 System.out.println("Ingrese el DNI");
	                    int dni = teclado.nextInt();
	                    Iterable<Integer> notas = diccionarioGeneral.get(dni);
	                    
	                    if (notas == null) {
	                        System.out.println("No existen notas para el DNI: " + dni);
	                    } else {
	                        List<Integer> lista = (List<Integer>) notas;
	                        if (lista.getSize() == 0) {
	                            System.out.println("El alumno no tiene notas registradas.");
	                        } else {
	                            System.out.println("Notas del alumno con DNI " + dni + ":");
	                            lista.First();
	                            while(!lista.atEnd()) {
	                                System.out.println(lista.getCurrent().toString());
	                                lista.advance();
	                            }
	                        }
	                    }
	                    break;
				}
				case 8:{
					List<Integer> lista =(List<Integer>) diccionarioGeneral.keys();
					lista.First();
					while(!lista.atEnd()) {
						System.out.println(lista.getCurrent().toString());
						lista.advance();
					}
					break;
				}
				case 9:{
					List<Integer> alumnos =(List<Integer>) diccionarioGeneral.keys();
					alumnos.First();
					while(!alumnos.atEnd()) {
						float promedio = promedio(alumnos.getCurrent(), diccionarioGeneral);
						System.out.println("Dni: " + alumnos.getCurrent().toString() + " con el promedio de " + promedio);
						alumnos.advance();
					}
					break;
				}
				default:{
					System.out.println("Ingrese una opcion correcta");
					break;
				}
			}
		}
		
	}
	public static List<Entry <Integer, Integer>> unir(ArrayMap<Integer, Integer> m1, ArrayMap<Integer, Integer> m2){
		Entry <Integer, Integer>[] entradasMateria1 = m1.entries();
		Entry <Integer, Integer>[] entradasMateria2 = m2.entries();
		LinkedList<Entry<Integer, Integer>> lista = new LinkedList();
		for(int i = 0; i <entradasMateria1.length;i++) {
			if(entradasMateria1[i].getKey().equals(entradasMateria2[i].getKey()) &&
					!entradasMateria1[i].getValue().equals(entradasMateria2[i].getValue())) {
				lista.addLast(entradasMateria1[i]);
				lista.addLast(entradasMateria2[i]);
			}
		}
		return lista;
	}
	public static void cargarMapeo(LinkedMap<Integer, Integer> map){
		Scanner teclado = new Scanner(System.in);
		System.out.println("Cuando desee frenar el ingreso de Notas ingrese -1");
		System.out.println("Ingrese el DNI");
		int dni= teclado.nextInt();
		boolean primerIngreso = false;
		while(dni != -1) {
			System.out.println("Ingrese la nota de la materia ");
			int nota1= teclado.nextInt();
			while(map.get(dni) != null) {
				System.out.println("el DNI "+ dni + " ya esta ingresado, ingrese uno nuevo: ");
				System.out.println("Ingrese el DNI");
				dni= teclado.nextInt();
				System.out.println("Ingrese la nota de la materia 1");
				nota1= teclado.nextInt();
			}
			map.put(dni, nota1);
			System.out.println("Ingrese el DNI");
			dni= teclado.nextInt();
		}
		
	}
	
	public static void mostrarMap(LinkedMap<Integer, Integer> map) {
		Entry<Integer, Integer>[] lista = map.entries();
		for(int j = 0; j<lista.length ; j++) {
			System.out.println(lista[j].toString());
		}
	}
	
	public static void cargarADiccionario(LinkedMap<Integer, Integer> ultimoMap, LinkedDiccionario<Integer, Integer> diccionarioGeneral) {
		Entry<Integer, Integer>[] lista = ultimoMap.entries();
		for(int i = 0; i<lista.length ; i++) {
			diccionarioGeneral.put(lista[i].getKey(), lista[i].getValue());
		}
	}
	
	public static float promedio(int alumno, LinkedDiccionario<Integer, Integer> diccionarioGeneral) {
		Iterable<Integer> notas = diccionarioGeneral.get(alumno);
        List<Integer> lista = (List<Integer>) notas;
        int accumulador = 0;
        float promedio = 0.0f;
            if (lista.getSize() == 0) {
                System.out.println("El alumno no tiene notas registradas.");
            } else {
                lista.First();
                while(!lista.atEnd()) {
	                accumulador += lista.getCurrent();
                    lista.advance();
                }
            }
        promedio = accumulador / lista.getSize();
		return promedio;
	}
}