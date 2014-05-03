package model;

import java.util.Date;

public class Categoria {
	
	private Long oId;
	protected Date fecha;
	
	protected int limiteReproducciones;
	
	public Categoria(){
		
		this.limiteReproducciones=100;
		
	}
	
	public Categoria(int limiteReproducciones){
		this.limiteReproducciones=limiteReproducciones;
	}
	
	public int limiteDeReproducciones () {
		
		return this.limiteReproducciones;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}
	
	

}
