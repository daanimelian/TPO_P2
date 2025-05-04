package diccionarios;

import java.util.Arrays;
import java.util.List;


public class DiccionarioEstatico <K extends Comparable <K>, V> implements DiccionarioMultiple <K, V>{
	private Entry<K, V []> [] arreglo;
	private int longitudArreglo;
	private int size;
	public DiccionarioEstatico(int longitudArreglo){
		this.arreglo = (Entry <K, V[]> []) new Entrada[longitudArreglo];
		size = 0;
		this.longitudArreglo = longitudArreglo;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	 public Iterable<V> get(K k){
		if(this.isEmpty())
				return null;
		
		V []  valor = (V[]) new Object [size];
		int indice = this.indiceKey(k);
		if(indice>=0)
			valor =  copiadoArray(arreglo[indice].getValue());
		return Arrays.asList(valor);
	 }
	 
	 public void put(K k, V v) {
		 if(this.isEmpty()) {
			 V[] valores = (V[]) new Object[100];
			 valores[0] =  v;
			 arreglo[size] = (Entry<K, V[]>) new Entrada <K, V[]>(k, valores);
			 size++;
		 }
		 else {
			 boolean encontrado= false;
			 for (int i = 0; i<size && !encontrado; i++) {
				 if(arreglo[i].getKey().compareTo(k) == 0) {
					 agregadoValor(arreglo[i].getValue(), v); 
					 encontrado = true;
					 return;
				 }
			 }
			 if(!encontrado) {
				 V[] valores = (V[]) new Object[100];
				 valores[0] =  v;
				 arreglo[size] = (Entry<K, V[]>) new Entrada <K, V[]>(k, valores);
				 size++;
			 }
		 }
		 
	 }
	 public Iterable<V> remove(K k){
		 if(this.isEmpty())
			 return null;
		 else {
			 boolean encontrado= false;
			 for (int i = 0; i<size && !encontrado; i++) {
				 if(arreglo[i].getKey().compareTo(k) == 0) {
					 V[] valores = arreglo[i].getValue();
					 arreglo[i] = arreglo[--size];
					 return Arrays.asList(valores);
				 }
			 }
		 }
		return null;
	 }
	 public V remove(K k, V v) {
		 if(this.isEmpty())
				return null;
		
		 else {
			 boolean encontrado= false;
			 V devolucion = null;
			 for (int i = 0; i<size && !encontrado; i++) {
				 if(arreglo[i].getKey().compareTo(k) == 0) {
					 int sizeValores =0;
					 V[] valores = arreglo[i].getValue();
					 while (sizeValores < valores.length && valores[sizeValores] != null) {
							sizeValores++;
						}
					 for (int j = 0; i<sizeValores; j++) {
						if(valores[j].equals(v)) {
							devolucion = valores[j];
							valores[j] = valores[sizeValores];
							valores[sizeValores]  = null;
							size--;
							return devolucion;
						}
					 }
					 encontrado = true;
				 }
			 }
		 }
		 return null;
	 }
	 public Iterable<K> keys(){
		 if(this.isEmpty())
				return null;
		
		 else {
			 K[] listaClaves = (K[]) new Object [size];
			 int i = 0;
			 for(Entry <K, V[]> entrada : arreglo) {
				 listaClaves[i] = entrada.getKey();
				 i++;
			 }
			 return Arrays.asList(listaClaves);
		 }
	 }
	 public Iterable<Entry<K, Iterable<V>>> entries(){
		 if(this.isEmpty())
				return null;
		
		 Entrada<K, Iterable<V>>[] entradas = (Entrada<K, Iterable<V>>[]) new Entrada[size];
		 for (int i = 0; i < size; i++) {
			V[] valores = arreglo[i].getValue();
			int sizeValores = 0;
			while (sizeValores < valores.length && valores[sizeValores] != null) {
				sizeValores++;
			}
			V[] copiaValores = (V[]) new Object[sizeValores];
			for (int j = 0; j < sizeValores; j++) {
				copiaValores[j] = valores[j];
			}
			entradas[i] = new Entrada<K, Iterable<V>>(arreglo[i].getKey(), Arrays.asList(copiaValores));
		}
		return Arrays.asList(entradas);
	 }
	 
	 private int indiceKey(K k) { 
			/*Funcion para encontrar el indice especifo de una key en particular.
			 La implemento debido a que en varias partes de la Clase utilizo esta logica*/
			
			int indice = -1;
			boolean noEncontrado = true;

			for(int i = 0; i<size && noEncontrado;i++) {
				if(arreglo[i].getKey().equals(k)) {
					noEncontrado = false;
					indice = i;
				}
			}
			return indice;
	}
	 private V[] copiadoArray(V [] aCopiar) {
		 int longitud = aCopiar.length;
		 V[] aux = (V[] ) new Object[longitud];
		 for (int i = 0; i<longitud; i++) {
			 aux[i] = aCopiar[i];
		 }
		 return aux;
	 }
	 
	 private void agregadoValor(V[] lista, V valor) {
		 boolean agregado = false;
		 for(int i = 0; i < lista.length; i++ ) {
			 if(lista[i] == null) {
				 lista[i] = valor;
				 agregado = true;
				 return;
			 }
		 }
		 if (!agregado) {
			 throw new RuntimeException("el arreglo de valores seleccionado esta lleno");
		 }
	 }
}
