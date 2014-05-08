package model;


/**Subclase de Categoria, modela la categor�a "VIP" para una suscripci�n.*/

public class CategoriaVIP extends Categoria {

	
	private Long oId;
	
	public CategoriaVIP(){
		
		this.limiteReproducciones=500;
	}
	
	public CategoriaVIP(int limiteReproducciones){
		
		this.limiteReproducciones=limiteReproducciones;
	}
	

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

}
