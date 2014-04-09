package model;

public class CategoriaVIP extends Categoria {
	
	public CategoriaVIP(){
		
		this.limiteReproducciones=500;
	}
	
	public CategoriaVIP(int limiteReproducciones){
		
		this.limiteReproducciones=limiteReproducciones;
	}

}
