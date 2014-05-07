package model;

public class Pelicula  extends Contenido implements Reproducible{
	
	private Long oId;
	private String reproducible;
	private long duracion;
	
	public Pelicula () {
		
	}
	
	public Pelicula(String titulo, int edadMinima, long duracion){
		super(titulo, edadMinima);
		this.duracion=duracion;
	}

	public boolean esPelicula() {
		return true;
	}

	public boolean esEpisodio() {
		return false;
	}


	public long getDuracion() {
		return this.duracion;
	}

	public boolean aptoPara(Usuario usuario) {
		return (this.getEdadMinima()<= usuario.edad());
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public void setDuracion(long duracion) {
		this.duracion = duracion;
	}

	public String getReproducible() {
		return reproducible;
	}

	public void setReproducible(String reproducible) {
		this.reproducible = reproducible;
	}

}
