package sextoEjercicio;

import Interfaces.MyException;
import List.LinkedList;

public class TemperaturasEstacion extends TempMinEstacion {
	



//	
//	

//	
//	
//	• OPCIONAL void ordenar(): Ordena las temperaturas de mayor a menor. Investigar
//	métodos de ordenamiento Bubble Sort, Quick Sort, Merge Sort y Búsqueda
//	Binaria (implementar este último).
	


	public TemperaturasEstacion(int cantidadTemperaturas) {
		super(cantidadTemperaturas);
		// TODO Auto-generated constructor stub
	}
	
//	float menorTemperatura(): Retornar la menor temperatura registrada
	public float menorTemperatura() {
		lista.First();
		float tempMinima = lista.getCurrent();
		for(int i = 0;i < lista.getSize(); i++) {
			if(lista.getCurrent() < tempMinima) {
				tempMinima = lista.getCurrent();
			}
			lista.advance();
		}
		return tempMinima;
	}
	
//	• int posMenorTemperatura(): Retornar la posición de la menor temperatura
	
	public int posMenorTemperatura() {
		float tempMinima = menorTemperatura();
		int posMenor = 0;
		lista.First();
		while(lista.getCurrent() != tempMinima) {
			
			lista.advance();
			posMenor++;
		}
		
		return posMenor;
	}

//	• boolean todosPositivos(): Determinar si todas las temperaturas son positivas
	public boolean todosPositivos() {
		boolean todosPositivos = true;
		
		lista.First();
		while(todosPositivos && !lista.atEnd()) {
			if(lista.getCurrent() < 0) {
				todosPositivos = false;
			}
			lista.advance();

		}
		return todosPositivos;
	}
//	• int contarCoincidencias(TemperaturasEstacion s): Calcular en cuántos días dos
//	estaciones meteorológicas coincidieron en la temperatura mínima, es decir
//	cuántas componentes coinciden en valor y posición respecto a un objeto de la
//	misma clase recibido como parámetro. Se asume que se han registrado los
//	valores de una misma cantidad de días.
	
	public int contarCoincidencias(TemperaturasEstacion otraEstacion) throws MyException {
		if(lista.getSize() != otraEstacion.lista.getSize()) {
			throw new MyException("Para poder compararse, las dos estaciones deben tener el mismo número de temperaturas");
		}else {
			int coincidencias = 0;
			lista.First();
			otraEstacion.lista.First();
			for(int i = 0; i < lista.getSize(); i++) {
				if(lista.getCurrent().equals(otraEstacion.lista.getCurrent()) ) {
					coincidencias++;
				}
				lista.advance();
				otraEstacion.lista.advance();
			}return coincidencias;
			}
	}
	
//	• TemperaturasEstacion invertir(): Generar un objeto de clase
//	TemperaturasEstacion con las mismas componentes que la tabla que recibe el
//	mensaje, pero almacenadas en orden inverso.
	
	public TemperaturasEstacion invertir() {
		TemperaturasEstacion invertida = new TemperaturasEstacion(lista.getSize());
		int indice = lista.getSize() - 1;
		lista.First();
		for(int i = 0; i < lista.getSize(); i++) {
			invertida.establecerTempMin(indice, lista.getCurrent());
			indice--;
			lista.advance();
			
		}
		return invertida;
	}
	
//	• void reemplazar(float val1,val2): Reemplazar toda aparición del valor val1 por
//	val2
	
	public void reemplazar(float val1, float val2) {
		lista.First();
		for (int i = 0; i < lista.getSize(); i++) {
			if(lista.getCurrent().equals(val1)) {
				lista.cambiarValorExistente(i, val2);
			}
			lista.advance();
		}
	}
	
//	• String intercambiar(int pos1, pos2): Intercambiar las componentes de las
//	posiciones pos1 y pos2, verificando que ambas existan. Si pudo hacer el
//	intercambio devuelve una cadenavacía, sino un mensaje de error.
	public String intercambiar(int pos1, int pos2) {
		float primero = 0;
		float segundo = 0;
		
		String mensaje = "";
		if(pos1 < 0 || pos1 > lista.getSize() -1 || pos2 < 0 || pos2 > lista.getSize()) {
			mensaje = "No se pueden ingresar posiciones menores a 0 o mayores a " + (lista.getSize() - 1);
		}else { 
			
			lista.First();
			for(int i= 0; i < lista.getSize(); i++) {
				if(i == pos1) {
					primero = lista.getCurrent();
				} else if( i == pos2){
					segundo = lista.getCurrent();
					
				}
				lista.advance();
			}
			lista.cambiarValorExistente(pos1, segundo);
			lista.cambiarValorExistente(pos2, primero);
			
		}return mensaje;
		}
	
//	• void invertirMe(): invierte los elementos de la tabla receptora del mensaje
	public void invertirMe() {
		float[] invertidos = new float[lista.getSize()];
		lista.First();
		for(int i = lista.getSize() - 1; i >= 0; i--) {
			invertidos[i] = lista.getCurrent();
			lista.advance();
		}
		
		for(int i = 0; i < invertidos.length; i++) {
			lista.cambiarValorExistente(i, invertidos[i]);
		}
	}
}
