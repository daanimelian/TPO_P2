package cuartoEjercicio;

import java.util.Iterator;

public class TempMinEstacion {
//	Defina una clase TempMinEstacion que encapsule la representación de las temperaturas
//	mínimas registradas en una estación meteorológica y brinde operaciones para:
//	• Retornar la mayor temperatura registrada
//	• Calcular el promedio de las temperaturas
//	• Contar cuántos días heló
//	• Decidir si hubo heladas
//	• Retornar la primera temperatura mayor a una dada; si no existe devolver el
//	mismo valor recibido.
//	• Decidir si las temperaturas registradas se produjeron en orden creciente
	private float[] listaTemperaturas;
	
	//----------Constructor----------
	public TempMinEstacion(int cantidadTemperaturas) {
		this.listaTemperaturas = new float[cantidadTemperaturas];
		for(int i = 0; i<listaTemperaturas.length;i++) {
			listaTemperaturas[i] = 0;
		}
	}
	
	//----------Comando----------
	
	public void establecerTempMin(int indice, float elem) {
		this.listaTemperaturas[indice] = elem;
		
	}
	
	//----------Consultas----------
	
	public float mayorTempMin() {
		float mayorTemp = listaTemperaturas[0];
		
		for(int i = 0;i < this.listaTemperaturas.length; i++) {
			if (listaTemperaturas[i] > mayorTemp) {
				mayorTemp = listaTemperaturas[i];
			}
		}
		
		return mayorTemp;
	}
	
	public float promedioTempMin() {
		float cantidadTemperaturas = (float)listaTemperaturas.length;
		float sumaTemperaturas = 0;
		for(int i = 0;i < listaTemperaturas.length; i++) {
			sumaTemperaturas += listaTemperaturas[i];
		}
		float promedioTemp = sumaTemperaturas / cantidadTemperaturas;
		return promedioTemp;
	}
	
	public int cantHeladas() {
		int cantHeladas = 0;
		for (int i = 0; i < listaTemperaturas.length; i++) {
			if (listaTemperaturas[i] < 0) {
				cantHeladas++;
			}
		}
		return cantHeladas;
	}
	
	public boolean huboHeladas() {
		boolean huboHeladas = false;
		int i = 0;
		while(!huboHeladas && i < listaTemperaturas.length) {
			if(listaTemperaturas[i] < 0) {
				huboHeladas = true;
			}
			i++;
			}
		
		return huboHeladas;
		
	}

		
	public float primeroMayor(float temp) {
		float tempMayor = temp;
		int i = 0;
		while (tempMayor == temp && i < listaTemperaturas.length) {
			
			if (listaTemperaturas[i] > tempMayor) {
				tempMayor = listaTemperaturas[i];
				
			}
			i++;
		
	}
		return tempMayor;

	}
	
	
	public boolean ordenadoCreciente() {
		boolean ordenadoCreciente = true;
		int i = 1;
		while(ordenadoCreciente && i < listaTemperaturas.length){
			if(listaTemperaturas[i - 1] > listaTemperaturas[i]) {
				ordenadoCreciente = false;
			}
			i++;
		}
		return ordenadoCreciente;
	}
	
}


