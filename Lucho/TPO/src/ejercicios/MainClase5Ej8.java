package ejercicios;



import java.util.Scanner;

import clases.*;

public class MainClase5Ej8 {

    public static void cargarMap(ArrayStack<ArrayMap<Integer, Integer>> stackMapas) {
        boolean continuar = true;
        Scanner scan = new Scanner(System.in);

        while (continuar) {
            ArrayMap<Integer,Integer> arrayMap = new ArrayMap<Integer,Integer>();

            System.out.println("Ingrese el número de DNI: ");
            String dniLeido = scan.nextLine();
            Integer dni = Integer.parseInt(dniLeido);

            System.out.println("Ingrese la nota de la materia: ");
            String notaLeida = scan.nextLine();
            Integer nota = Integer.parseInt(notaLeida);

            while (nota < 0 || nota > 10) {
                System.out.println("Solamente se admite la carga de notas entre 0 y 10. Por favor, vuelva a intentarlo: ");
                System.out.println("Ingrese la nota de la materia: ");
                notaLeida = scan.nextLine();
                nota = Integer.parseInt(notaLeida);
            }

            arrayMap.put(dni, nota);
            stackMapas.push(arrayMap);

            System.out.println("Para continuar ingrese 1\nPara finalizar ingrese -1: ");
            String respuesta = scan.nextLine();
            if (respuesta.equals("-1")) {
                continuar = false;
                System.out.println("-----Finalizando la carga del Map------");
            }
        }
    }

    public static void mostrarUltimoMapeoCargado(ArrayStack<ArrayMap<Integer, Integer>> stackMapas) {
        if (stackMapas.size() == 0) {
            System.out.println("El stack de mapas está vacío, no hay nada para mostrar.");
            return;
        }
        System.out.println("Último mapeo cargado: ");
        System.out.println(stackMapas.top().toString());
    }

    public static void agregarUltimoMapeoDiccionario(ArrayStack<ArrayMap<Integer, Integer>> stackMapas, LinkedDictionary<Integer,Integer> diccionarioFinal) {
        if (stackMapas.size() == 0) {
            System.out.println("El stack de mapas está vacío, no hay nada para mostrar.");
            return;
        } else {
            Entry<Integer,Integer>[] entradas = stackMapas.pop().entries();

            for (int i = 0; i < entradas.length; i++) {
                diccionarioFinal.put(entradas[i].getKey(), entradas[i].getValue());
            }
            System.out.println("¡Pasaje del último mapeo a diccionario final exitoso!");
        }
    }

    public static void agregarNotaAUnDni(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni, Integer nota) {
        Iterable<Integer> dniABuscar = diccionarioFinal.get(dni);
        if (dniABuscar == null) {
            System.out.println("El DNI no se encuentra en el diccionario.");
            return;
        } else {
            diccionarioFinal.put(dni, nota);
            System.out.println("¡Nota cargada al DNI " + dni + " de manera exitosa!");
        }
    }

    public static void quitarNotaAUnDNI(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni, Integer nota) {
        Iterable<Integer> dniABuscar = diccionarioFinal.get(dni);
        if (dniABuscar == null) {
            System.out.println("El DNI no se encuentra en el diccionario.");
            return;
        } else {
            diccionarioFinal.remove(dni, nota);
            System.out.println("¡Nota eliminada al DNI " + dni + " de manera exitosa!");
        }
    }

    public static void quitarAlumno(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni) {
        Iterable<Integer> dniABuscar = diccionarioFinal.get(dni);
        if (dniABuscar == null) {
            System.out.println("El DNI no se encuentra en el diccionario.");
            return;
        } else {
            diccionarioFinal.remove(dni);
            System.out.println("¡Alumno de DNI " + dni + " eliminado de manera exitosa!");
        }
    }

    public static void mostrarNotasAlumno(LinkedDictionary<Integer,Integer> diccionarioFinal, Integer dni) {
        Iterable<Integer> dniABuscar = diccionarioFinal.get(dni);
        if (dniABuscar == null) {
            System.out.println("El DNI no se encuentra en el diccionario.");
            return;
        } else {
            System.out.print("Notas del alumno con DNI " + dni + ": ");
            for (Integer nota : dniABuscar) {
                System.out.print(nota + " ");
            }
            System.out.println(); // mejora aplicada
        }
    }

    public static void MostrarTodosLosAlumnos(LinkedDictionary<Integer,Integer> diccionarioFinal) {
        Iterable<Entry<Integer, Iterable<Integer>>> alumnos = diccionarioFinal.entries();
        for (Entry<Integer, Iterable<Integer>> alumno : alumnos) {
            Integer dni = alumno.getKey();
            System.out.print("Notas del alumno con DNI " + dni + ": ");
            for (Integer nota : alumno.getValue()) {
                System.out.print(nota + "-");
            }
            System.out.println(".\n");
        }
    }

    public static void MostrarTodosLosAlumnosyPromedios(LinkedDictionary<Integer,Integer> diccionarioFinal) {
        Iterable<Entry<Integer, Iterable<Integer>>> alumnos = diccionarioFinal.entries();
        for (Entry<Integer, Iterable<Integer>> alumno : alumnos) {
            Integer dni = alumno.getKey();
            System.out.print("Notas del alumno con DNI " + dni + ": ");
            double sumador = 0;
            int cantMaterias = 0;
            for (Integer nota : alumno.getValue()) {
                System.out.print(nota + "-");
                sumador += nota;
                cantMaterias++;
            }
            double promedio = sumador / cantMaterias;
            System.out.println("\nPromedio de notas: " + promedio + ".\n");
        }
    }

    public static void menu(ArrayStack<ArrayMap<Integer, Integer>> stackMapas, LinkedDictionary<Integer,Integer> diccionarioFinal) {
        boolean continuar = true;
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenid@ al Programa de carga de notas de materias!");
        while (continuar) {
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
                    "fin - Finalizar programa\n----------------------\n");

            String opcionElegida = scan.nextLine();
            while (!opcionElegida.matches("[1-9]|fin")) {
                System.out.println("Opción inválida. Ingrese una opción válida.\n");
                opcionElegida = scan.nextLine();
            }

            switch (opcionElegida) {
                case "1":
                    cargarMap(stackMapas);
                    break;
                case "2":
                    mostrarUltimoMapeoCargado(stackMapas);
                    break;
                case "3":
                    agregarUltimoMapeoDiccionario(stackMapas, diccionarioFinal);
                    break;
                case "4":
                    System.out.println("¿A cuál DNI le quiere agregar otra nota?");
                    Integer dni = scan.nextInt();
                    scan.nextLine();
                    System.out.println("¿Qué nota quiere cargar?");
                    Integer nota = scan.nextInt();
                    scan.nextLine();
                    agregarNotaAUnDni(diccionarioFinal, dni, nota);
                    break;
                case "5":
                    System.out.println("¿A cuál DNI le quiere quitar una nota?");
                    Integer dniQuitar = scan.nextInt();
                    scan.nextLine();
                    System.out.println("¿Qué nota quiere quitar?");
                    Integer notaQuitar = scan.nextInt();
                    scan.nextLine();
                    quitarNotaAUnDNI(diccionarioFinal, dniQuitar, notaQuitar);
                    break;
                case "6":
                    System.out.println("¿Cuál es el DNI del alumno que desea eliminar?");
                    Integer alumnoEliminar = scan.nextInt();
                    scan.nextLine();
                    quitarAlumno(diccionarioFinal, alumnoEliminar);
                    break;
                case "7":
                    System.out.println("¿Cuál es el DNI del alumno del cual quiere ver sus notas?");
                    Integer dniVisualizar = scan.nextInt();
                    scan.nextLine();
                    mostrarNotasAlumno(diccionarioFinal, dniVisualizar);
                    break;
                case "8":
                    MostrarTodosLosAlumnos(diccionarioFinal);
                    break;
                case "9":
                    MostrarTodosLosAlumnosyPromedios(diccionarioFinal);
                    break;
                case "fin":
                    System.out.println("-----------------------Finalizando-----------------------");
                    continuar = false;
                    break;
            }

            System.out.println("\n\n\n\n");
        }
    }

//    --------------------------------------------Main --------------------------------------------
    public static void main(String[] args) {
        ArrayStack<ArrayMap<Integer, Integer>> stackMapas = new ArrayStack<ArrayMap<Integer, Integer>>(100);
        LinkedDictionary<Integer,Integer> diccionarioFinal = new LinkedDictionary<Integer,Integer>();
        menu(stackMapas, diccionarioFinal);
    }
}

