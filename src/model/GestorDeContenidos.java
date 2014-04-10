package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class GestorDeContenidos {
	
	private Usuario usuario;
	private Catalogo catalogo;
	private Collection<Reproduccion> reproducciones;
	
	public GestorDeContenidos(Usuario usuario, Catalogo catalogo){
		this.usuario=usuario;
		this.catalogo=catalogo;
		this.reproducciones = new ArrayList<Reproduccion>(); 
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}
	
	public Collection<Reproduccion> getReproducciones() {
		return reproducciones;
		
	}
	
	public Collection<Episodio> episodiosVistos() {	
		Collection<Episodio> episodios = new ArrayList<Episodio>();
		for (Iterator iterator = this.reproducciones.iterator(); iterator.hasNext();) {			
			Reproduccion act = (Reproduccion) iterator.next();
			if ( act.getReproducible().esEpisodio() ){
				episodios.add((Episodio) act.getReproducible());
			}			
		}
		return episodios;
	}
	
	public Collection<Pelicula>	peliculasVistas() {		
		Collection<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Iterator<Reproduccion> iterator = this.reproducciones.iterator(); iterator.hasNext();) {			
			Reproduccion act = (Reproduccion) iterator.next();
			if ( act.getReproducible().esPelicula() ){
				peliculas.add((Pelicula) act.getReproducible());
			}			
		}
		return peliculas;
	}
	
	public Collection<Episodio> episodiosSinVerDe(Temporada temporada){
		Collection<Episodio> sinver = new ArrayList<Episodio>();
		Collection<Episodio> vistos = this.episodiosVistos();
		for (Iterator<Episodio> iterator = temporada.getEpisodios().iterator(); iterator.hasNext();) {
			Episodio episodio = (Episodio) iterator.next();
			if ( !vistos.contains(episodio) )
				sinver.add(episodio);
		}
		return sinver;
	}
	
	public void registrarReproduccion(Reproducible reproducible, Date fecha,
			long tiempo) {
		if (this.puedeReproducir(reproducible))
			this.reproducciones.add(new Reproduccion(reproducible, fecha,
					tiempo));
	}

	public boolean puedeReproducir(Reproducible reproducible){
		return (reproducible.aptoPara(this.getUsuario()) && this.getUsuario().getSuscripcion().limiteDeReproducciones() < this.cantidadDeReproducciones() );
	}

	
	 
	private int cantidadDeReproducciones(){
		return this.reproducciones.size();
	}
	
	public Collection<Pelicula> peliculasAptas(){
		Collection<Pelicula> aptas = new ArrayList<Pelicula>();
		
		for (Iterator<Pelicula> iterator = this.catalogo.getPeliculas().iterator(); iterator.hasNext();) {
			Pelicula pelicula = (Pelicula) iterator.next();
			if (pelicula.aptoPara(getUsuario())) 
				aptas.add(pelicula);
		}
		return aptas;
	}


}
