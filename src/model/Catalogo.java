package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Modela el cat�logo de reproducciones y diversos m�todos para su procesamiento*/

public class Catalogo {
	
	
	private Long oId;
	private Collection <Contenido> contenidos;
	
	public Catalogo(){
		this.contenidos=new HashSet <Contenido> () ;
	}
	
	public Collection <Contenido> getContenidos () {
		return contenidos;
	}
	
	public Collection<Pelicula> getPeliculas () {
		
		Collection<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Iterator<Contenido> iterator = this.contenidos.iterator(); iterator.hasNext();) {			
			Contenido act = (Contenido) iterator.next();
			if ( act.esPelicula() ){
				peliculas.add((Pelicula)act);
			}			
		}
		return peliculas;
		
	}
	

	public Collection<Serie> getSeries () {
		
		Collection<Serie> series = new ArrayList<Serie>();
		for (Iterator<Contenido> iterator = this.contenidos.iterator(); iterator.hasNext();) {			
			Contenido act = (Contenido) iterator.next();
			if ( act.esSerie() ){
				series.add((Serie)act);
			}			
		}
		return series;
		
	}
	
	public void agregar (Contenido contenido) {
		if(!this.contenidos.contains(contenido))
			this.contenidos.add(contenido);
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public void setContenidos(Collection<Contenido> contenidos) {
		this.contenidos = contenidos;
	}



}
