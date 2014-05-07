package model;

public class Episodio implements Reproducible {
	
	private Long oId;
	private String reproducible;
	private long duracion;
	private int numero;
	private String titulo;
	private Temporada temporada;

	public Episodio() {
		
	}

	public Episodio(long duracion, int numero, String titulo,
			Temporada temporada) {

		this.duracion = duracion;
		this.numero = numero;
		this.titulo = titulo;
		this.temporada = temporada;
		this.temporada.agregarEpisodio(this);
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
		return this.temporada.getEdadMinima();
	}

	

	public Temporada getTemporada() {
		return temporada;
	}
	
	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public void setTemporada(Temporada temporada) {
		this.temporada = temporada;
	}


	public boolean esPelicula() {

		return false;
	}

	public boolean esEpisodio() {

		return true;
	}

	public boolean aptoPara(Usuario usuario) {

		return (this.getEdadMinima() <= usuario.edad());
	}

	public String getReproducible() {
		return reproducible;
	}

	public void setReproducible(String reproducible) {
		this.reproducible = reproducible;
	}


}
