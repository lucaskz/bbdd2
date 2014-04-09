package model;

public class Pelicula implements Reproducible{
	
	public Pelicula(String titulo, int edadMinima, long duracion){}

	@Override
	public boolean esPelicula() {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

}
