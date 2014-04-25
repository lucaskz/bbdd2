package model;

public abstract class Contenido {
	
	private String titulo;
	private int edadMinima;
	
	public Contenido () {
		
	}
	
	public	Contenido(String titulo,int	edadMinima){
		this.titulo=titulo;
		this.edadMinima=edadMinima;
	}

	public  boolean esPelicula(){
		return false;
	}

	public  boolean esSerie(){
		return false;
	}
	
	public String getTitulo(){
		return this.titulo;
	}
	
	public int getEdadMinima(){
		return this.edadMinima;
	}

}
