package model;

public class CategoriaInvitado extends Categoria {
	
	public CategoriaInvitado(){
		
		this.limiteReproducciones=10;
	}
	
	public CategoriaInvitado(int limiteReproducciones){
		
		this.limiteReproducciones=limiteReproducciones;
	}

}
