package sextoEjercicio;

import List.LinkedList;

public class Main {

	public static void main(String[] args) {
		
//		TempMinEstacion estacion = new TempMinEstacion(5);
//		estacion.establecerTempMin(0, 3f);
//		estacion.establecerTempMin(1, 4f);
//		
//		estacion.establecerTempMin(2, 5f);
//		estacion.establecerTempMin(3, 6f);
//		estacion.establecerTempMin(4, 59f);
//		System.out.println(estacion.ordenadoCreciente());
		
		TemperaturasEstacion estacion1 = new TemperaturasEstacion(5);
		estacion1.establecerTempMin(0, 10);
		estacion1.establecerTempMin(1, 5);
		estacion1.establecerTempMin(2, 5);
		estacion1.establecerTempMin(3, 4);
		estacion1.establecerTempMin(4, 3);
		
//		TemperaturasEstacion estacion2 = new TemperaturasEstacion(5);
//		estacion2.establecerTempMin(1, 5);
//		estacion2.establecerTempMin(4, 3);
//		System.out.println(estacion1.contarCoincidencias(estacion2));
		
		TemperaturasEstacion invertida = estacion1.invertir();
//		invertida.reemplazar(5, -1);
//		invertida.recorrerLista();
//		System.out.println(estacion1.intercambiar(3, 1));
		estacion1.recorrerLista();
		System.out.println("-------------------------------");
		estacion1.invertirMe();
		estacion1.recorrerLista();

	}
		
		
	

}
