package model;

public class Pelicula  extends Contenido implements Reproducible{
	
	public Pelicula(String titulo, int edadMinima, long duracion){
		super(titulo, edadMinima);
	}

	@Override
	public boolean esPelicula() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean esEpisodio() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getTitulo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getDuracion() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getEdadMinima() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean aptoPara(Usuario usuario) {
		return false;
	}

	@Override
	public boolean esSerie() {
		// TODO Auto-generated method stub
		return false;
	}

}
