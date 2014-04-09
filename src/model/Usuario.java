package model;

import java.util.Date;

public class Usuario {

	private Date fechaNacimiento;
	private String email;
	private Suscripcion suscripcion;
	private Catalogo catalogo;
	private GestorDeContenidos gestor;

	public Usuario(Date nacimiento, String email, Date fechaSuscripcion,
			Catalogo catalogo) {

		this.fechaNacimiento=nacimiento;
		this.email=email;
		this.suscripcion = new Suscripcion(fechaSuscripcion);
		this.catalogo=catalogo;
		
		
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int edad() {
		return 0;
	}

	public Suscripcion getSuscripcion() {
		return this.suscripcion;
	}

	public GestorDeContenidos getGestor() {
		return this.gestor;
	}
	

	public String getEmail() {
		return email;
	}

	public Catalogo getCatalogo() {
		return catalogo;
	}



}
