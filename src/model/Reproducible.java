package model;

/**Interfaz para la implementación de un reproducible ("episodio o "película")*/

public interface Reproducible {

	public boolean esPelicula();

	public boolean esEpisodio();

	public Long getoId();

	public void setoId(Long oId);

	public String getTitulo();

	public long getDuracion();

	public int getEdadMinima();

	public boolean aptoPara(Usuario usuario);

}
