package model;

import java.util.Date;

public class Suscripcion {
	
	private Date fechaSuscripcion;
	private Categoria categoria;

	
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

}
