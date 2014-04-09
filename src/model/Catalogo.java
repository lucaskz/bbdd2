package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Catalogo {
	
	private Collection <Contenido> contenidos;
	
	public Catalogo(){
		this.contenidos=new ArrayList <Contenido> () ;
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
	
	public Collection<Serie> getEpisodios () {
		
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
		
		this.contenidos.add(contenido);
	}

}
