package tercerEjercicio;

import java.util.Random;
import java.util.Scanner;

public class Equipo {
	
//	En un campeonato de fútbol por cada partido ganado se obtienen 3 puntos y por cada
//	empate se logra 1. Cada equipo tiene un nombre, un capitán, una cantidad de partidos
//	ganados, otra de empatados y otra de perdidos, una cantidad de goles a favor y otra de
//	goles en contra. El capitán es un jugador que tiene un nombre, un año de nacimiento,
//	un número de camiseta, un número que representa la posición en la que juega, la
//	cantidad de partidos jugados y la cantidad de goles convertidos en el campeonato.
//	Para un jugador se desea calcular el promedio de goles de un jugador por partido y dado
//	otro jugador, cuál es el que hizo más goles. Para un equipo se desea calcular los partidos
//	jugados y los puntos obtenidos. Además, para otro equipo dado es necesario decidir cuál
//	es el equipo con mayor puntaje y cuál es el capitán con más goles. Si dos equipos tienen
//	los mismos puntos, se devuelve el que tiene mayor cantidad de goles a favor y si también
//	hay coincidencia se consideran los goles en contra. Si hay coincidencia se devuelve uno
//	cualquiera. 
//	
//	1. A partir del diagrama de clases en UML y la especificación de requerimientos
//	implemente dos clases en Java encapsulando atributos y comportamiento para
//	modelar la situación planteada. Incluya dentro del comportamiento los
//	comandos para modificar cada atributo y las consultas para devolver cada
//	atributo.
//	2. Elabore una clase que permita testear el modelo.
	
	//----------Atributos----------
	
	private String nombre;
	private Jugador capitan;
	private int partidosGanados;
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int golesAFavor;
	private int golesEnContra;
	
	//----------Constructor----------
	
	public Equipo (String nombre, Jugador capitan) {
		this.nombre = nombre;
		this.capitan = capitan;
	}
	
	//----------Getters----------
	
	public String getNombre() {
		return nombre;
	}
	
	public Jugador getCapitan() {
		return capitan;
	}
	
	public int getPartidosGanados() {
		return partidosGanados;
	}
	
	public int getPartidosEmpatados () {
		return partidosEmpatados;
	}
	
	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}
	
	public int getGolesAFavor() {
		return golesAFavor;
	}
	
	public int getGolesEnContra() {
		return golesEnContra;
	}
	
	public int getPuntajeTotal() {
		int puntajeTotal = (this.getPartidosGanados() * 3 + this.getPartidosEmpatados());
		return puntajeTotal;
	}
	
	//----------Comandos----------
	
	public void incrementarPartidosGanados(boolean jugoElCapitan) {
		Scanner input = new Scanner(System.in);
		int golesAFavor;
		int golesEnContra;
		int golesDelCapitan;
		System.out.println("¿Cuantos goles a favor hizo el equipo?: ");
		golesAFavor = input.nextInt();
		System.out.println("¿Cuantos goles en contra le hicieron el equipo?: ");
		golesEnContra = input.nextInt();
		this.aumentarGolesEnContra(golesEnContra);
		if (jugoElCapitan) {
			
			System.out.println("¿Cuantos goles a favor hizo el capitan?: ");
			golesDelCapitan = input.nextInt();
			this.aumentarGolesAFavor(golesAFavor, golesDelCapitan);
			
			this.capitan.aumentarUnPartido();
			
		} else {
			this.aumentarGolesAFavor(golesAFavor, 0);}
		
		this.partidosGanados ++;
		}
			
		
		
	public void incrementarPartidosEmpatados(boolean jugoElCapitan) {
		Scanner input = new Scanner(System.in);
		int golesAFavor;
		int golesEnContra;
		int golesDelCapitan;
		System.out.println("¿Cuantos goles a favor hizo el equipo?: ");
		golesAFavor = input.nextInt();
		System.out.println("¿Cuantos goles en contra le hicieron el equipo?: ");
		golesEnContra = input.nextInt();
		this.aumentarGolesEnContra(golesEnContra);
		if (jugoElCapitan) {
			
			System.out.println("¿Cuantos goles a favor hizo el capitan?: ");
			golesDelCapitan = input.nextInt();
			this.aumentarGolesAFavor(golesAFavor, golesDelCapitan);
			
			this.capitan.aumentarUnPartido();
			
		} else {
			this.aumentarGolesAFavor(golesAFavor, 0);}
		
		this.partidosEmpatados ++;}
		
		
	
	public void incrementarPartidosPerdidos(boolean jugoElCapitan) {
		Scanner input = new Scanner(System.in);
		int golesAFavor;
		int golesEnContra;
		int golesDelCapitan;
		System.out.println("¿Cuantos goles a favor hizo el equipo?: ");
		golesAFavor = input.nextInt();
		System.out.println("¿Cuantos goles en contra le hicieron el equipo?: ");
		golesEnContra = input.nextInt();
		this.aumentarGolesEnContra(golesEnContra);
		if (jugoElCapitan) {
			
			System.out.println("¿Cuantos goles a favor hizo el capitan?: ");
			golesDelCapitan = input.nextInt();
			this.aumentarGolesAFavor(golesAFavor, golesDelCapitan);
			
			this.capitan.aumentarUnPartido();
			
		} else {
			this.aumentarGolesAFavor(golesAFavor, 0);}
		
		this.partidosPerdidos ++;
				
	}
		
	public void aumentarGolesAFavor(int total, int golesDelCapitan) {
		golesAFavor += total;
		capitan.aumentarGoles(golesDelCapitan);
	}
	
	public void aumentarGolesEnContra(int total) {
		golesEnContra += total;
	}

	
	
	//----------Consultas----------
	
	public int partidos() {
		int totalPartidos = this.getPartidosEmpatados() + this.getPartidosGanados() + this.partidosPerdidos;
		return totalPartidos;
	}
	
	public Jugador capitanConMasGoles(Jugador otroJugador) {
		Jugador goleador =this.capitan.jugadorConMasGoles(otroJugador);
		return goleador;
	}
	
	public Equipo mejorPuntaje(Equipo competidor) {
		Equipo equipoMejorPuntaje;
		if (this.getPuntajeTotal() > competidor.getPuntajeTotal()) {
			equipoMejorPuntaje = this;
			
		} else if(this.getPuntajeTotal() < competidor.getPuntajeTotal()) {
			equipoMejorPuntaje = competidor;
		} else {
			if(this.getGolesAFavor() > competidor.getGolesAFavor()){
				equipoMejorPuntaje = this;
			} else if (this.getGolesAFavor() < competidor.getGolesAFavor()) {
				equipoMejorPuntaje = competidor;
			} else {
				Random rand = new Random();
		        int numeroAleatorio = rand.nextInt(2) + 1;
		        if (numeroAleatorio == 1) {
		        	equipoMejorPuntaje = this;
		        } else{
		        	equipoMejorPuntaje = competidor;
		        }
			}
					
		}
		
		return equipoMejorPuntaje;
	}
	
	
	
	
	
	
	
}












