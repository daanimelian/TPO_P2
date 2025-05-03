package clases;


import java.util.Arrays;

import interfaces.*;

public class ArrayDictionary<K, V> implements InterfaceDictionary<K, V> {

    private Entry<K, V[]>[] array;
    private int size;

    // ---------- Constructor ----------
    public ArrayDictionary() {
        array = (Entry<K, V[]>[]) new Entry[100];
        size = 0;
    }

    public ArrayDictionary(int tamanio) {
        array = (Entry<K, V[]>[]) new Entry[tamanio];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterable<V> get(K k) {
        int i = 0;
        while (i < size && !array[i].getKey().equals(k)) {
            i++;
        }
        if (i == size) {
            return null;
        } else {
            return Arrays.asList(copiarValores(array[i].getValue()));
        }
    }

    @Override
    public void put(K k, V v) {
        int i = 0;
        while (i < size && !array[i].getKey().equals(k)) {
            i++;
        }

        if (i == size) {
            if (size < array.length) {
                V[] valores = (V[]) new Object[100];
                valores[0] = v;
                array[size++] = new Entry<K, V[]>(k, valores);
            } else {
                throw new MyException("El arreglo de claves está lleno, no se puede agregar más");
            }
        } else {
            V[] valores = array[i].getValue();
            int j = 0;
            while (j < valores.length && valores[j] != null) {
                j++;
            }
            if (j < valores.length) {
                valores[j] = v;
            } else {
                throw new MyException("El arreglo de valores está lleno, no se puede agregar más");
            }
        }
    }

    @Override
    public Iterable<V> remove(K k) {
        int i = 0;
        while (i < size && !array[i].getKey().equals(k)) {
            i++;
        }
        if (i == size) {
            return null;
        } else {
            V[] copia = copiarValores(array[i].getValue());
            array[i] = array[size - 1];
            array[size - 1] = null;
            size--;
            return Arrays.asList(copia);
        }
    }

    @Override
    public V remove(K k, V v) {
        int i = 0;
        while (i < size && !array[i].getKey().equals(k)) {
            i++;
        }
        if (i == size) {
            return null;
        } else {
            V[] valores = array[i].getValue();
            int j = 0;
            while (j < valores.length && valores[j] != null && !valores[j].equals(v)) {
                j++;
            }
            if (j == valores.length || valores[j] == null) {
                return null;
            }

            int ultimoIndice = j;
            while (ultimoIndice < valores.length && valores[ultimoIndice] != null) {
            	ultimoIndice++;
            }
            valores[j] = valores[ultimoIndice - 1];
            valores[ultimoIndice - 1] = null;
            
//            Si se borra el único valor del arreglo de valores, borro la clave también

            if (ultimoIndice - 1 == 0) {
                array[i] = array[size - 1];
                array[size - 1] = null;
                size--;
            }

            return v;
        }
    }

    @Override
    public Iterable<K> keys() {
        K[] claves = (K[]) new Object[size];
        for (int i = 0; i < size; i++) {
            claves[i] = array[i].getKey();
        }
        return Arrays.asList(claves);
    }

    @Override
    public Iterable<Entry<K, Iterable<V>>> entries() {
        Entry<K, Iterable<V>>[] entradas = (Entry<K, Iterable<V>>[]) new Entry[size];
        for (int i = 0; i < size; i++) {
            entradas[i] = new Entry<>(array[i].getKey(), Arrays.asList(copiarValores(array[i].getValue())));
        }
        return Arrays.asList(entradas);
    }

    private V[] copiarValores(V[] valoresOriginales) {
        int contador = 0;
        while (contador < valoresOriginales.length && valoresOriginales[contador] != null) {
        	contador++;
        }
        V[] copia = (V[]) new Object[contador];
        for (int i = 0; i < contador; i++) {
            copia[i] = valoresOriginales[i];
        }
        return copia;
    }
    
    
   
    
}
