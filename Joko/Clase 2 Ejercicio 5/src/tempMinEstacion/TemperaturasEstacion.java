package tempMinEstacion;


public class TemperaturasEstacion {
	
	public float[] Temperaturas;
	
	public TemperaturasEstacion(int cantidad) {
		Temperaturas = new float [cantidad];
		for(int i = 0; i < cantidad; i++) {
			establecerTemperaturaMinima(i,0);
		}
	}
	
	public void establecerTemperaturaMinima(int indice,float temperatura) {
		if(indice >= 0 && indice < Temperaturas.length) {
			Temperaturas[indice] = temperatura;
		}
	}
	
	public float mayorTemperatura() {
		float max = 0;
		boolean bandera = true;
		
		for(int i = 0; i < Temperaturas.length; i++) {
			if(bandera || Temperaturas[i] > max) {
				max = Temperaturas[i];
				bandera = false;
			}
		}
		return max;
	}
	
	public float menorTemperatura() {
		float min = 0;
		boolean bandera = true;
		
		for(int i = 0; i < Temperaturas.length; i++) {
			if(bandera || Temperaturas[i] < min) {
				min = Temperaturas[i];
				bandera = false;
			}
		}
		return min;
	}
	
	public int posMenorTemperatura() {
			float min = 0;
			boolean bandera = true;
			int indice = 0;
			
			for(int i = 0; i < Temperaturas.length; i++) {
				if(bandera || Temperaturas[i] < min) {
					min = Temperaturas[i];
					indice = i;
					bandera = false;
				}
			}
			return indice;
	 }
	
	public float promedioTemperatura() {
		float acumulador = 0;
		int i;
		for(i = 0; i < Temperaturas.length; i++) {
			acumulador += Temperaturas[i];
		}
		return acumulador/(i+1);
	}
	
	public int cantidadHeladas() {
		int cantidadHeladas = 0;
		for(int i = 0; i < Temperaturas.length; i++) {
			if(Temperaturas[i] < 0) {
				cantidadHeladas++;
			}
		}
		return cantidadHeladas;
	}
	
	public boolean huboHeladas() {
		boolean huboHeladas = false;
		int i = 0;
		
		while(i < Temperaturas.length && !huboHeladas) {
			if(Temperaturas[i] < 0) {
				huboHeladas = true;
			}
			
			i++;
		}
		
		return huboHeladas;
	}
	
	public float primeroMayor(float temperatura) {
		int i = 0;
		float max = temperatura;
		while(i < Temperaturas.length && max == temperatura) {
			if(Temperaturas[i] > temperatura) {
				max = Temperaturas[i];				
			}
			i++;
		}
		return max;			
	}
	
	public boolean ordenadoCreciente() {
		boolean creciente = true;
		int i = 0;
		while(i < Temperaturas.length-1 && creciente) {
			if(Temperaturas[i] > Temperaturas[i+1]) {
				creciente = false;
			}
			i++;
		}
		return creciente;
	}
	
	public boolean todosPositivos() {
		int i = 0;
		boolean todosPositivos = true;
		while(i < Temperaturas.length && todosPositivos) {
			if(Temperaturas[i] < 0) {
				todosPositivos = false;
			}
			i++;
		}
		return todosPositivos;
	}
	
	public int contarCoincidencias(TemperaturasEstacion s) {
		int contador = 0;
		for(int i = 0; i < Temperaturas.length; i ++) {
			if(Temperaturas[i] == s.Temperaturas[i]) {
				contador++;
			}
		}		
		return contador;
	}
	
	public TemperaturasEstacion invertir() {
		TemperaturasEstacion invertida = new TemperaturasEstacion(Temperaturas.length);
		for(int i = 0; i < Temperaturas.length; i ++) {
			invertida.establecerTemperaturaMinima(i,Temperaturas[Math.abs(i-(Temperaturas.length-1))]);	
		}
		return invertida;
	}
	
	public void reemplazar(float val1,float val2) {
		for(int i = 0; i < Temperaturas.length; i ++) {
			if(Temperaturas[i] == val1) {
				Temperaturas[i] = val2;
			}
		}
	}
	
	public String intercambiar(int pos1,int pos2) {
		String msg = "";
		float aux;
		if(pos1 < Temperaturas.length && pos2 < Temperaturas.length) {
			aux = Temperaturas[pos1];
			Temperaturas[pos1] = Temperaturas[pos2];
			Temperaturas[pos2] = aux;
		}else {
			msg = "Error, no es tan grande el array para alcanzar esos indices";
		}
		
		return msg;
	}
	
	public void invertirMe() {
		
		float [] invertida = invertir().Temperaturas;
		
		for (int i = 0; i < Temperaturas.length ;i++) {
			establecerTemperaturaMinima(i,invertida[i]);
		}
	}
	
	public void ordenar() {
		float aux;
		for(int i=1;i<Temperaturas.length-1;i++) {
			for(int j = 0; j<Temperaturas.length -i;j++) {
				if(Temperaturas[j] < Temperaturas[j+1] ) {
					aux = Temperaturas[j];
					Temperaturas[j] = Temperaturas[j+1];
					 Temperaturas[j+1] = aux;
				}
			}
		}
	}
}
