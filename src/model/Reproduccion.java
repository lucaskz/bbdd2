package model;

import java.util.Date;

public class Reproduccion {
	
	private Date fecha;
	private long tiempo;
	private Reproducible reproducible;
	
	public Reproduccion(Reproducible reproducible, Date fecha, long tiempo){
		this.fecha=fecha;
		this.tiempo=tiempo;
		this.reproducible = reproducible;
	}
	
	public Reproducible getReproducible(){
		return this.reproducible;
	}

	public Date getFecha() {
		return fecha;
	}

	public long getTiempo() {
		return tiempo;
	}




}
