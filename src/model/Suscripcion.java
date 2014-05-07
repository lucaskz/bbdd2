package model;

import java.util.Date;

public class Suscripcion {
	
	private Long oId;
	private Date fechaSuscripcion;
	private Categoria categoria;

	
	public Suscripcion () {
		
	}
	
	
	public Suscripcion(Date fechaSuscripcion){
		
		this.fechaSuscripcion=fechaSuscripcion;
		this.categoria=new CategoriaInvitado();
		
	}
	
	public Date getFecha () {
		return fechaSuscripcion;
	}
	
	public Categoria getCategoria() {
		return categoria;
		
	}
	
	public void pasarANormal(){
		this.categoria = new Categoria();
	}
	
	public void pasarAVIP(){
		this.categoria = new CategoriaVIP();
	}
	
	public int limiteDeReproducciones(){
		return this.categoria.limiteDeReproducciones();
	}


	public Long getoId() {
		return oId;
	}


	public void setoId(Long oId) {
		this.oId = oId;
	}


	public Date getFechaSuscripcion() {
		return fechaSuscripcion;
	}


	public void setFechaSuscripcion(Date fechaSuscripcion) {
		this.fechaSuscripcion = fechaSuscripcion;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}	

}
