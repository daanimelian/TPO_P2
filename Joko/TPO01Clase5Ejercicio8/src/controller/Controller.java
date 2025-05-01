package controller;

import inout.InOut;
import list.List;
import map.Map;
import mapSimple.MapSimple;

public class Controller {
	private Map<String,Integer> MapPrincipal;
	private List<MapSimple<String,Integer>> ListaMapasSimple;
	private InOut inout = new InOut();
	
	public MapSimple<String,Integer> CrearMapa(){
		return null;
	}
	
	public void CargarMapeo(MapSimple<String,Integer> map) {
		ListaMapasSimple.addElementEnd(map);
	}

	public MapSimple<String,Integer> getUltimoMapeo() {
		return ListaMapasSimple.getAt(ListaMapasSimple.size()-1);
	}

	public void AgregarMapeo(MapSimple<String,Integer> ultimoMapeo) {
		String[] keys = ultimoMapeo.keys();
		for(int i = 0; i < keys.length; i++) {
			MapPrincipal.put(keys[i], ultimoMapeo.get(keys[i]));
		}
		
	}

	public void CargarNota(String Dni, int nota) {
		MapPrincipal.put(Dni, nota);
	}

	public void QuitarNota(String Dni, int nota) {
		MapPrincipal.remove(Dni, nota);
	}

	public void QuitarAlumno(String Dni) {
		MapPrincipal.remove(Dni);
	}

	public List<Integer> GetNotas(String Dni) {
		return MapPrincipal.get(Dni);
	}

	public List<String> GetAlumnos() {
		return MapPrincipal.keys();
	}

	public Object GetAlumnosYPromedios() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
