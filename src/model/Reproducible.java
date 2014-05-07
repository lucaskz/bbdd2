package model;

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
