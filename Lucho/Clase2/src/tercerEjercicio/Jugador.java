package tercerEjercicio;

public class Jugador {
	
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
	private int numeroCamiseta;
	private int posicion;
	private int golesConvertidos;
	private int partidosJugados;
	
	
	//----------Constructor----------
	
	public Jugador (String nombre) {
		this.nombre = nombre;
	}
	
	//----------Getters----------
	
	public String getNombre () {
		return nombre;
	}
	
	public int getNumeroCamiseta() {
		return numeroCamiseta;
	}
	
	public int getPosicion() {
		return posicion;
	}
	
	public int getGolesConvertidos() {
		return golesConvertidos;
	}
	
	public int getPartidosJugados() {
		return partidosJugados;
	}
	
	//----------Setters----------
	
	public void setNombre (String nombre) {
		this.nombre = nombre;
	}
	
	public void setNumeroCamiseta(int numeroCamiseta) {
		this.numeroCamiseta = numeroCamiseta;
	}
	
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	//----------Comandos----------
	
	public void aumentarGoles(int goles) {
		this.golesConvertidos += goles;
	}
	
	public void aumentarUnPartido() {
		this.partidosJugados ++;
	}
	
	//----------Consultas----------

	public int promedioGolesPorPartido() {
		int promedio = (golesConvertidos/partidosJugados);
		return promedio;
	}
	
	public boolean masGoles(Jugador otrojugador) {
		if (this.getGolesConvertidos() > otrojugador.getGolesConvertidos()) {
			return true;
		}else {
			return false;
		}
	}
	
	public Jugador jugadorConMasGoles(Jugador otroJugador) {
		Jugador jugadorConMasGoles;
		if (this.masGoles(otroJugador) == true) {
			jugadorConMasGoles = this;
		} else {
			jugadorConMasGoles = otroJugador;
		}
		
		return jugadorConMasGoles;
	}
	
	public String aCadena() {
		String detallesJugador = ("Nombre: " + this.getNombre() + ". Jugó " + this.getPartidosJugados()
		+ " partidos en total, tiene " + this.getGolesConvertidos() +
		" goles convertidos en total y su promedio de goles por partido es de " + this.promedioGolesPorPartido());
		
		return detallesJugador;
				
				
	}









}