package model;

import java.util.Date;

public class Sesion {

	private Long oId;
	private Date fecha;
	private Reproduccion reproduccion;
	
	public Sesion () {
		
	}

	public Sesion(Reproduccion reproduccion, Date fecha) {

		this.fecha = fecha;
		this.reproduccion = reproduccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public Reproduccion getReproduccion() {
		return reproduccion;
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

}
