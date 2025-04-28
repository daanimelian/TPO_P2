package Main;

import tempMinEstacion.TemperaturasEstacion;

public class Main {

	public static void main(String[] args) {
		TemperaturasEstacion test = new TemperaturasEstacion(6);
		TemperaturasEstacion test2 = new TemperaturasEstacion(6);
		TemperaturasEstacion test3;
		
		test2.establecerTemperaturaMinima(0,1);
		test2.establecerTemperaturaMinima(1,1);
		test2.establecerTemperaturaMinima(2,1);
		test2.establecerTemperaturaMinima(3,1);
		test2.establecerTemperaturaMinima(4,1);
		test2.establecerTemperaturaMinima(5,1);
		
		test.establecerTemperaturaMinima(0,1);
		test.establecerTemperaturaMinima(1,2);
		test.establecerTemperaturaMinima(2,3);
		test.establecerTemperaturaMinima(3,4);
		test.establecerTemperaturaMinima(4,5);
		test.establecerTemperaturaMinima(5,6);
		
		for(int i=0;i < test.Temperaturas.length;i++) {
			System.out.println(test.Temperaturas[i]);
			
		}
		System.out.println("////////");
		test3 = test.invertir();
		for(int i=0;i < test.Temperaturas.length;i++) {
			System.out.println(test3.Temperaturas[i]);
			
		}
		System.out.println("////////");
		System.out.println(test.mayorTemperatura());
		System.out.println("////////");
		System.out.println(test.menorTemperatura());
		System.out.println("////////");
		System.out.println(test.posMenorTemperatura());
		System.out.println("////////");
		System.out.println(test.promedioTemperatura());
		System.out.println("////////");
		System.out.println(test.cantidadHeladas()); 
		System.out.println("////////"); 
		System.out.println(test.huboHeladas()); 
		System.out.println("////////");  
		System.out.println(test.primeroMayor((float) -1.1)); 
		System.out.println("////////");  
		System.out.println(test.ordenadoCreciente()); 
		System.out.println("////////");  
		System.out.println(test.todosPositivos()); 
		System.out.println("////////");
		System.out.println(test.contarCoincidencias(test2)); 
		System.out.println("////////");
		test2.reemplazar(1, 2);
		for(int i=0;i < test2.Temperaturas.length;i++) {
			System.out.println(test2.Temperaturas[i]);
			
		}
		System.out.println("////////");
		test.intercambiar(1, 2);
		for(int i=0;i < test.Temperaturas.length;i++) {
			System.out.println(test.Temperaturas[i]);
			
		}
		System.out.println("////////");
		test.invertirMe();
		for(int i=0;i < test.Temperaturas.length;i++) {
			System.out.println(test.Temperaturas[i]);
			
		}
		System.out.println("////////");
		test.ordenar();
		for(int i=0;i < test.Temperaturas.length;i++) {
			System.out.println(test.Temperaturas[i]);
			
		}
		
	}

}
