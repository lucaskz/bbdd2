package model;

public class Episodio implements Reproducible {

	private long duracion;
	private int numero;
	private String titulo;
	private int edadMinima;
	private Temporada temporada;

	public Episodio(long duracion, int numero, String titulo,
			Temporada temporada) {

		this.duracion = duracion;
		this.numero = numero;
		this.titulo = titulo;
		this.temporada = temporada;
	}

	public long getDuracion() {
		return duracion;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public Temporada getTemporada() {
		return temporada;
	}

	public boolean esPelicula() {

		return false;
	}

	public boolean esEpisodio() {

		return true;
	}

	

	public boolean aptoPara(Usuario usuario) {
		return (this.getEdadMinima()>= usuario.edad());
	}

}
