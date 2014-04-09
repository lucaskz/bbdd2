package model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
		 Calendar calendar = new GregorianCalendar();
		 Calendar calendar2 = new GregorianCalendar();
		 calendar2.setTime(this.fechaNacimiento);
		 if(calendar.MONTH >= calendar2.MONTH && calendar.DAY_OF_MONTH >= calendar.DAY_OF_MONTH) 
			 return (calendar.YEAR - calendar2.YEAR );
		 return (calendar.YEAR - calendar2.YEAR -1);
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
