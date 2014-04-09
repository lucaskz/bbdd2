package model;

public abstract class Contenido {
	
	private String titulo;
	private int edadMinima;
	
	public	Contenido(String titulo,int	edadMinima){
		this.titulo=titulo;
		this.edadMinima=edadMinima;
	}

	public abstract boolean esPelicula();

	public abstract boolean esSerie();

}
