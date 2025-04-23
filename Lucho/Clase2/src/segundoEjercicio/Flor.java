package segundoEjercicio;

public class Flor {
	
//	Implemente una clase Java llamada Flor que tenga tres atributos de tipo String, int
//	y float, que respectivamente representen el nombre de la flor, el número de
//	pétalos y precio. Se debe incluir un constructor que permita inicializar cada uno
//	de los atributos y un constructor que inicialice la flor por defecto con nombre
//	Margarita, número de pétalos igual a 10 y precio igual a 34.3. También se deben
//	proveer operaciones para modificar los atributos y obtener sus valores en
//	forma individual.
	
	private String nombre;
	private int numPetalos;
	private float precio;
	
	//--------------Constructores--------------
	public Flor() {
		nombre = "Margarita";
		numPetalos = 10;
		precio = 34.3f;
	}
	
	public Flor(String nombre, int numPetalos, float precio) {
		this.nombre = nombre;
		this.numPetalos = numPetalos;
		this.precio = precio;
		
	}
	
	//--------------Getters--------------
	
	public String getNombre() {
		return nombre;
	}
	
	public int getNumPetalos() {
		return numPetalos;
	}
	
	public float getPrecio() {
		return precio;
	}
	
	//--------------Setters--------------
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public void setNumPetalos(int numPetalos) {
		this.numPetalos = numPetalos;
	}
	


}
