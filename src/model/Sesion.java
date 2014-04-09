package model;

import java.util.Date;

public class Sesion {

	private Date fecha;
	private Reproduccion reproduccion;

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

}
