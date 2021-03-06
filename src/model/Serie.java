package model;

import java.util.ArrayList;
import java.util.Collection;

/**Subclase de Contenido, modela un contenido del tipo "serie".*/

public class Serie extends Contenido {
	
	private Long oId;
	private Collection<Temporada> temporadas;
	
	

	public Serie () {
		
	}
	
	public Serie(String titulo, int edadMinima){
		
		super (titulo, edadMinima);
		this.temporadas=new ArrayList<Temporada>();
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
	
	public void setTemporadas(Collection<Temporada> temporadas) {
		this.temporadas = temporadas;
	}
	
	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}




}
