package model;

import java.util.ArrayList;
import java.util.Collection;

public class Temporada {
	
	private Long oId;
	private Collection<Episodio> episodios;
	private int numero;
	private Serie serie;
	
	public Temporada () {
		
	}
	
	public Temporada(Serie serie, int numero){
		this.numero=numero;
		this.episodios= new ArrayList<Episodio>();
		this.serie=serie;
		serie.getTemporadas().add(this);
	}
	
	public Collection<Episodio> getEpisodios(){
		return this.episodios;
	}
	
	public int getNumero(){
		return this.numero;
	}
	
	public void agregarEpisodio(Episodio episodio){
		this.episodios.add(episodio);
	}
	
	public int getEdadMinima(){
		return this.serie.getEdadMinima();
	}
	
	public Serie getSerie(){
		return (this.serie);
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}
	

}
