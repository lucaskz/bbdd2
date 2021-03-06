package model;

/**Subclase de Categoria, modela la categoría "invitado" para una suscripción.*/

public class CategoriaInvitado extends Categoria {
	
	private Long oId;
	
	public CategoriaInvitado(){
		
		this.limiteReproducciones=10;
	}
	
	public CategoriaInvitado(int limiteReproducciones){
		
		this.limiteReproducciones=limiteReproducciones;
	}
	

	public Long getoId() {
		return oId;
	}

	public void setoId(Long oId) {
		this.oId = oId;
	}

}
