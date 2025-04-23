package Clases;

public class Persona implements Comparable{
//	----------Atributos----------
	private int dni;
	private String nombre;
	private float peso;
	
//	----------Constructor----------

	public Persona(String n, float p, int d){
		dni=d; nombre=n; peso=p;
	}
//	----------Getters----------
	
	public int getDni() {
		return dni;
	}


	public String getNombre() {
		return nombre;
	}


	public float getPeso() {
		return peso;
	}


//	----------Setters----------
	
	public void setDni(int dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}


	
	
	
//	----------Métodos----------

	public int compareTo(Object o){
		Persona p= (Persona)o;
		return nombre.compareTo(p.getNombre());
		}
	
	
	
}




	