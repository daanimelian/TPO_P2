package quintoEjercicio;

import Interfaces.InterfaceTemperaturasEstacion;

public class TemperaturasEstacion extends TempMinEstacion implements InterfaceTemperaturasEstacion {

	public TemperaturasEstacion(int cantidadTemperaturas) {
		super(cantidadTemperaturas);
		// TODO Auto-generated constructor stub
	}
	
	//setter
	

	@Override
	public float menorTemperatura() {
		
		float menorTemp = this.listaTemperaturas[0];
		for (int i = 0; i < this.listaTemperaturas.length; i++) {
			if(listaTemperaturas[i] < menorTemp) {
				menorTemp = listaTemperaturas[i];
			
			}
		}
		return menorTemp;
	}

	@Override
	public int posMenor() {
		int menorTempPos = 0;
		float menorTemp = this.listaTemperaturas[0];
		for (int i = 0; i < this.listaTemperaturas.length; i++) {
			if(listaTemperaturas[i] < menorTemp) {
				menorTemp = listaTemperaturas[i];
				menorTempPos = i;
			
			}
		}
		return menorTempPos;
	}

	@Override
	public boolean todosPositivos() {
		boolean sonTodosPositivos = true;
		int i = 0;
		while(sonTodosPositivos && i < listaTemperaturas.length) {
			if(listaTemperaturas[i] < 0) {
				sonTodosPositivos = false;
			}
			i++;
		}
		return sonTodosPositivos;
	}

	@Override
	public int contarCoincidencias(TemperaturasEstacion otraEstacion) {
		int coincidencias = 0;
		try {
			float[] temperaturasOtraEstacion = otraEstacion.getListaTemperaturas();
			for (int i = 0; i < listaTemperaturas.length; i++) {
			
				if(temperaturasOtraEstacion[i] == listaTemperaturas[i]) {
					coincidencias++;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException ex) {
			System.out.println("Las dos estaciones deben contar con la misma cantidad de dias y temperaturas para poder compararlas.");
		}
		return coincidencias;
	}

	@Override
	public TemperaturasEstacion invertir() {
		TemperaturasEstacion inverso = new TemperaturasEstacion(this.getListaTemperaturas().length);
		int indice = 0;
		float[] listaOriginal =this.getListaTemperaturas();
		
		for (int i = listaTemperaturas.length - 1; i >= 0; i--) {
			inverso.establecerTempMin(indice, listaOriginal[i]);
			indice++;
			
		}
		return inverso;
	}

	@Override
	public void reemplazar(float val1, float val2) {
		for (int i = 0; i < this.getListaTemperaturas().length;i++) {
			if (this.getListaTemperaturas()[i] == val1) {
				this.establecerTempMin(i, val2);
				
			}
		}
		
	}

	@Override
	public String intercambiar(int pos1, int pos2) {
		String respuesta = "";
		float[] lista = this.getListaTemperaturas();
		int largoLista = this.getListaTemperaturas().length;
		if((0 <= pos1 && pos1 <= largoLista) && (0 <= pos2 && pos2 <= largoLista)) {
			float aux = lista[pos1];
			this.establecerTempMin(pos1, lista[pos2]);
			this.establecerTempMin(pos2, aux);
			
		}else {
			respuesta = "No es posible intercambiar los valores ya que uno de los índices indicados no existe.";
		}
		
		
		return respuesta;
	}

	@Override
	public void invertirMe() {
		int pos1 = 0;
		int pos2 = this.getListaTemperaturas().length - 1;
		while(pos1 < pos2) {
			this.intercambiar(pos1, pos2);
			pos1++;
			pos2--;
		}
		
	}



	@Override
	public void ordenarBubble() {
		float[] lista = this.getListaTemperaturas();
		int ultimoIndice = this.getListaTemperaturas().length - 1;
		
		for(int i = 0;i < ultimoIndice ; i++) {
			for(int j = 0; j < ultimoIndice - i ; j++) {
				if(lista[j] > lista[j+1]) {
					float aux = lista[j];
					lista[j] = lista[j+1];
					lista[j+1] = aux;
					
				}
			}
		}
		
		
	}

	
	@Override
	public int busquedaBinaria(float objetivo) {
		int izquierda = 0;
		
		int derecha = this.getListaTemperaturas().length - 1;
		
		while (izquierda <= derecha) {
			int medio =  izquierda + (derecha - izquierda)/2;
			if(this.getListaTemperaturas()[medio] == objetivo) {
				return medio;
			}else if(this.getListaTemperaturas()[medio] < objetivo) {
				izquierda = medio + 1;
			} else {
				derecha = medio - 1;
			}
		}
		
		return -1;
	}

	
	

	

}





