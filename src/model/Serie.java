package model;

import java.util.Collection;

public class Serie extends Contenido {
	
	private Collection<Temporada> temporadas;
	
	public Serie(String titulo, int edadMinima){
		
		super (titulo, edadMinima);
	}


	public boolean esSerie() {
		return true;
	}
	
	public boolean aptoPara(Usuario usuario) {
		return (this.getEdadMinima()>= usuario.edad());
	}
	
	public Collection<Temporada> getTemporadas(){
		return this.temporadas;
	}

}
