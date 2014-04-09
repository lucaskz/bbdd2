package model;

public class Serie extends Contenido {
	
	public Serie(String titulo, int edadMinima){
		
		super (titulo, edadMinima);
	}

	@Override
	public boolean esPelicula() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean esSerie() {
		// TODO Auto-generated method stub
		return false;
	}

}
