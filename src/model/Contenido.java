package model;

/**Clase abstracta, modela los contenidos de un catálogo.*/

public abstract class Contenido {
	
	
	private Long oId;
	protected String titulo;
	
	protected int edadMinima;
	
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
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getEdadMinima(){
		return this.edadMinima;
	}
	
	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}


	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

}
