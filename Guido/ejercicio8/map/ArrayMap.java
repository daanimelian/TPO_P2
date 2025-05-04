package map;

public class ArrayMap <K extends Comparable <K>, V> implements Map<K, V>{
	private Entrada<K, V> [] arreglo;
	private int longitudArreglo;
	private int size;
	public ArrayMap(int longitudArreglo){
		this.arreglo = (Entrada <K, V> []) new Entrada[longitudArreglo];
		size = 0;
		this.longitudArreglo = longitudArreglo;
		
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public V get(K k) {
		if(this.isEmpty())
			return null;
		V valor = null;
		int indice = this.indiceKey(k);
		if(indice>=0)
			valor = arreglo[indice].getValue();
		return valor;
	}
	public V put(K k, V v) {
		if(this.isEmpty()) {
			arreglo[size] = new Entrada(k, v);
			size++;
			return null;
		}
		V retorno = null;
		int indice = this.indiceKey(k);
		if(indice>=0) {
			retorno = arreglo[indice].getValue();
			arreglo[indice].setValue(v);
		}
		else {
			if(size>=longitudArreglo)
				throw new RuntimeException("arreglo lleno");
			else {
				arreglo[size] = new Entrada (k, v);
				size++;
			}
		}
		return retorno;
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
	public V remove(K k) {
		if(this.isEmpty()) {
			return null;
		}
		V retorno = null;
		int indice = this.indiceKey(k);
		if(indice>=0) {
			retorno = arreglo[indice].getValue();
			if(indice == size-1) {
				arreglo[--size] = null;
			}
			else
			{
				arreglo[indice] = arreglo[--size];
			}
			
		}
		return retorno;
	}
	public K [] keys() {
		K[] arregloKeys =(K[]) new Object[size];
		if(this.isEmpty()) {
			return arregloKeys;
		}
		for(int i = 0; i <size; i++) {
			arregloKeys[i] = arreglo[i].getKey();
		}
		return arregloKeys;
		
	}
	public V [] values(){
		V[] arregloValues =(V[]) new Object[size];
		if(this.isEmpty()) {
			return arregloValues;
		}
		for(int i = 0; i <size; i++) {
			arregloValues[i] = arreglo[i].getValue();
		}
		return arregloValues;
		
	}
	
	public Entry<K, V> [] entries(){
		Entry<K, V> [] arregloEntradas = (Entry <K, V> []) new Entrada[size];
		if(this.isEmpty())
			return arregloEntradas;
		for(int i = 0; i <size; i++) {
			arregloEntradas[i] = arreglo[i];
		}
		return arregloEntradas;
	}
}
