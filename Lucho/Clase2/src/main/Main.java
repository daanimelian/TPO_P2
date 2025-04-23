package main;

import cuartoEjercicio.TempMinEstacion;
import primerEjercicio.CajaDeAhorro;
import segundoEjercicio.Flor;
import tercerEjercicio.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		--------------Ejercicio 1--------------
//		CajaDeAhorro primerCaja = new CajaDeAhorro(20);
//		CajaDeAhorro segundaCaja = new CajaDeAhorro();
//		
//		
//		System.out.println(primerCaja.getNumCaja());
//		System.out.println(segundaCaja.getNumCaja());
//		
//		System.out.println(primerCaja.getSaldo());
//		
//		primerCaja.setDeposito(20);
//		System.out.println(primerCaja.getSaldo());
//		
//		primerCaja.setExtraccion(50);
//		System.out.println(primerCaja.getSaldo());
		
		
//		--------------Ejercicio 2--------------
		
//		Flor primerFlor = new Flor();
//		System.out.println(primerFlor.getNombre());
//		System.out.println(primerFlor.getNumPetalos());
//		System.out.println(primerFlor.getPrecio());
//		
//		primerFlor.setNombre("Petunia");
//		primerFlor.setPrecio(50.0f);
//		primerFlor.setNumPetalos(25);
//		System.out.println(primerFlor.getNombre());
//		System.out.println(primerFlor.getNumPetalos());
//		System.out.println(primerFlor.getPrecio());

		
//		--------------Ejercicio 3--------------
		
////		Creación
//		Jugador messi = new Jugador("Messi");
//		Jugador ronaldo = new Jugador("Ronaldo");
//		
//		
//		Equipo chacarita = new Equipo("chacarita",messi);
//		Equipo boca = new Equipo("Boca", ronaldo);
//		
//		
////		Partidos
//		chacarita.incrementarPartidosGanados(false);
////		chacarita.incrementarPartidosGanados(true);
//		
//		chacarita.incrementarPartidosEmpatados(true);
//	
//		chacarita.incrementarPartidosPerdidos(true);
//		
//		
//		boca.incrementarPartidosEmpatados(true);
//		
//		boca.incrementarPartidosPerdidos(true);
//		
//		boca.incrementarPartidosGanados(true);
//		
//		
//		
//		
//		
//		//Resultados
//		
//		Jugador capitanConMasGoles = chacarita.capitanConMasGoles(ronaldo);
//		Equipo equipoMejorPunta = chacarita.mejorPuntaje(boca);
//		
//		System.out.println(capitanConMasGoles.aCadena());
//		System.out.println(equipoMejorPunta.getNombre());
//		
		
//		--------------Ejercicio 4--------------
		
		TempMinEstacion temperaturas = new TempMinEstacion(5);
		temperaturas.establecerTempMin(0, 17);
		temperaturas.establecerTempMin(1, -25);
		temperaturas.establecerTempMin(2, 32);
		temperaturas.establecerTempMin(3, 2);
		temperaturas.establecerTempMin(4, -2);
		
		System.out.println("La temperaturas mayor es: " + temperaturas.mayorTempMin());
		System.out.println("El promedio de temperatura es: " + temperaturas.promedioTempMin());
		System.out.println("¿Hubo heladas?: " + temperaturas.huboHeladas());
		if (temperaturas.huboHeladas()) {
			System.out.println("¿Cuantas heladas hubo?: " + temperaturas.cantHeladas());
		}
		
		System.out.println("La temperatura mayor a la dada (31) es: " + temperaturas.primeroMayor(31));
		System.out.println("¿La lista está ordenada de manera creciente?: " + temperaturas.ordenadoCreciente());
		
	}

}
