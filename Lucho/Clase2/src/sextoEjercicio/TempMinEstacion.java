package sextoEjercicio;

import List.LinkedList;

public class TempMinEstacion {
	
	 protected LinkedList <Float> lista;
	
	//----------Constructor----------
	
	public TempMinEstacion(int cantidadTemperaturas) {
		lista = new LinkedList<Float>();
		for(int i = 0;i < cantidadTemperaturas ;i++) {
			if(i==0) {
				lista.addFirst(0f);
		}else {
			
			lista.addLast(0f);
		}
	}
		
		
		
	

}
	//----------Comando----------
	public void establecerTempMin(int index, float elem) {
		
		 	lista.cambiarValorExistente(index, elem);
		
		
	}
	
	//----------Consulta----------
	
	
	public void recorrerLista() {
		lista.First();
		for (int i = 0; i < lista.getSize(); i++) {
			System.out.println(lista.getCurrent());
			lista.advance();
		}
	}
	
	public Float mayorTempMin() {
		lista.First();
		Float mayorTemp = lista.getCurrent();
		for(int i = 0; i < lista.getSize(); i++) {
			Float actual = lista.getCurrent();
			if(actual > mayorTemp) {
				mayorTemp = actual;
			}
			lista.advance();
		}
		return mayorTemp;
	}
	
	public Float promedioTempMin() {
		Float promedio = 0f;
		float suma = 0f;
		lista.First();
		for(int i = 0; i < lista.getSize(); i++) {
			suma = suma + lista.getCurrent();
			lista.advance();
			
			
		}
		promedio = suma / lista.getSize();
		
		
		return promedio;
	}
	
	public int cantHeladas() {
		int cantHeladas = 0;
		lista.First();
		for (int i = 0; i < lista.getSize(); i++) {
			if(lista.getCurrent() < 0) {
				cantHeladas++;
			}
			lista.advance();
		}
		
		return cantHeladas;
	}
	
	public boolean huboHeladas() {
		boolean hubo = false;
		lista.First();
		
		while(!hubo && !lista.atEnd()) {
			if(lista.getCurrent() < 0) {
				hubo = true;
			}
			lista.advance();
			
			
			
		}
		return hubo;
	}
	
	public Float primeroMayor(Float comparacion) {
		Float mayor = comparacion;
		lista.First();
		while(!lista.atEnd() && mayor == comparacion) {
			if (lista.getCurrent() > mayor ) {
				mayor = lista.getCurrent();
			} else {
				lista.advance();
			}
		}return mayor;
		
	}
	
	public boolean ordenadoCreciente() {
		boolean ordenado = true;
		lista.First();
		Float anterior = lista.getCurrent();
		lista.advance();
		while(!lista.atEnd() && ordenado) {
			if(anterior > lista.getCurrent()) {
				ordenado = false;
			} else {
				anterior = lista.getCurrent();
				lista.advance();
			}
			
		}
		return ordenado;
	}
	
	
}