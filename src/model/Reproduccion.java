package model;

import java.util.Date;

public class Reproduccion {
	
	private Long oId;
	private Date fecha;
	private long tiempo;
	private Reproducible reproducible;
	
	public Reproduccion () {
		
	}
	
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

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setTiempo(long tiempo) {
		this.tiempo = tiempo;
	}

	public void setReproducible(Reproducible reproducible) {
		this.reproducible = reproducible;
	}




}
