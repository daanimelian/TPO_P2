package ejercicios;

import clases.TemperaturasEstacion;

public class MainClase2 {

	public static void main(String[] args) {
		
		
//		Extienda la definición de la clase TemperaturasEstacion presentada en clase
//		incorporando los siguientes servicios:
//		• float menorTemperatura(): Retornar la menor temperatura registrada
//		• int posMenorTemperatura(): Retornar la posición de la menor temperatura
//		• boolean todosPositivos(): Determinar si todas las temperaturas son positivas
//		• int contarCoincidencias(TemperaturasEstacion s): Calcular en cuántos días dos
//		estaciones meteorológicas coincidieron en la temperatura mínima, es decir
//		cuántas componentes coinciden en valor y posición respecto a un objeto de la
//		misma clase recibido como parámetro. Se asume que se han registrado los
//		valores de una misma cantidad de días.
//		• TemperaturasEstacion invertir(): Generar un objeto de clase
//		TemperaturasEstacion con las mismas componentes que la tabla que recibe el
//		mensaje, pero almacenadas en orden inverso.
//		• void reemplazar(float val1,val2): Reemplazar toda aparición del valor val1 por
//		val2
//		• String intercambiar(int pos1, pos2): Intercambiar las componentes de las
//		posiciones pos1 y pos2, verificando que ambas existan. Si pudo hacer el
//		intercambio devuelve una cadenavacía, sino un mensaje de error.
//		• void invertirMe(): invierte los elementos de la tabla receptora del mensaje
//		• OPCIONAL void ordenar(): Ordena las temperaturas de mayor a menor. Investigar
//		métodos de ordenamiento Bubble Sort, Quick Sort, Merge Sort y Búsqueda
//		Binaria (implementar este último).

		
		TemperaturasEstacion estacion1 = new TemperaturasEstacion(6);
		TemperaturasEstacion estacion2 = new TemperaturasEstacion(3);
		
//		--------------------------------------Asignaciones de temperaturas--------------------------------------

//		estacion2.establecerTempMin(0, 32);
//		estacion2.establecerTempMin(1, 1);
//		estacion2.establecerTempMin(2, 37);
//		estacion2.establecerTempMin(3, 54);
//		estacion2.establecerTempMin(4, -6);
//		
		// TODO Auto-generated method stub
		estacion1.establecerTempMin(0, 1f);
		estacion1.establecerTempMin(1, 102f);
		estacion1.establecerTempMin(2, 37.0f);
		estacion1.establecerTempMin(3, 4f);
		estacion1.establecerTempMin(4, -6f);
		estacion1.establecerTempMin(5, 32f);
		
		
//		--------------------------------------Pruebas de inversión--------------------------------------

//		TemperaturasEstacion estacion3 = estacion1.invertir();
//		System.out.println(estacion1.menorTemperatura());
//		System.out.println(estacion1.posMenor());
//		System.out.println(estacion1.todosPositivos());
//		
//		System.out.println(estacion1.contarCoincidencias(estacion2));
		
//		for (int i = 0; i<estacion3.getListaTemperaturas().length;i++) {
//			
//			System.out.println(estacion3.getListaTemperaturas()[i]);
//		
//	}
//		--------------------------------------Pruebas de reemplazo--------------------------------------
//		estacion1.reemplazar(32, 5);
//		for (int i = 0; i < estacion1.getListaTemperaturas().length; i++) {
//			System.out.println(estacion1.getListaTemperaturas()[i]);
//		}
		
		
//		--------------------------------------Pruebas de intercambio--------------------------------------

////		
//		estacion1.intercambiar(2, 4);
//		for (int i = 0; i < estacion1.getListaTemperaturas().length; i++) {
//			System.out.println(estacion1.getListaTemperaturas()[i]);
//		}
		
//		--------------------------------------Pruebas de ordenamiento--------------------------------------

		estacion1.ordenarBubble();
		for (int i = 0; i < estacion1.getListaTemperaturas().length; i++) {
			System.out.println(estacion1.getListaTemperaturas()[i]);
		}
		System.out.println("-----");
		
//		--------------------------------------Pruebas de búsqueda una vez ya ordenado--------------------------------------

		int posicion = estacion1.busquedaBinaria(-1f);
//		Devuelve -1 ya que no se encuentra el dato ingresado
		System.out.println(posicion);
		
		
		int posicion2 = estacion1.busquedaBinaria(4f);
		System.out.println(posicion2);
		

	}

	}


