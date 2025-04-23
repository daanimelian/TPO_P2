package Interfaces;

import cuartoEjercicio.TempMinEstacion;
import quintoEjercicio.TemperaturasEstacion;

public interface InterfaceTemperaturasEstacion {
	
	public float menorTemperatura(); //Retornar la menor temperatura registrada
	public int posMenor();  //Retornar la posición de la menor temperatura
	public boolean todosPositivos(); // Determinar si todas las temperaturas son positivas
	public int contarCoincidencias(TemperaturasEstacion estacion); //Calcular en cuántos días dos estaciones meteorológicas coincidieron en la temperatura mínima, es decircuántas componentes coinciden en valor y posición respecto a un objeto de la misma clase recibido como parámetro. Se asume que se han registrado los valores de una misma cantidad de días
	public TemperaturasEstacion invertir(); //Generar un objeto de clase TemperaturasEstacion con las mismas componentes que la tabla que recibe el mensaje, pero almacenadas en orden inverso.
	public void reemplazar(float val1, float val2); //Reemplazar toda aparición del valor val1 por val2
	public String intercambiar(int pos1, int pos2); //Intercambiar las componentes de las posiciones pos1 y pos2, verificando que ambas existan. Si pudo hacer el ntercambio devuelve una cadenavacía, sino un mensaje de error.
	public void invertirMe(); // invierte los elementos de la tabla receptora del mensaje
	public void ordenarBubble(); //Ordena las temperaturas de mayor a menor. Investigar métodos de ordenamiento Bubble Sort, Quick Sort, Merge Sort y Búsqueda Binaria (implementar este último)
	public int busquedaBinaria(float objetivo);
	








}
