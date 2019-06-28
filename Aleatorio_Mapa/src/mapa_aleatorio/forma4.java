package mapa_aleatorio;

import Mapa.Coordenada;

public class forma4 extends formas {
	
	
	public forma4(Coordenada i) {
		this.inicial = i;
		c = true;
	}
	

	@Override
	public boolean testa(int mat[][]) {
		int x, y;
		x = inicial.getX();
		y = inicial.getY() ;
		if (!c) {
			return false;
		}
		 
		if((!valido(x - 1,y - 1)) || (mat[x - 1][y - 1] != 1)) {
			return false;
		}
		
		if((!valido(x + 1 ,y - 1)) || (mat[x + 1][y - 1] != 1) ) {
			return false;
		}
		
		return true;
 
	}
	
	@Override
	public  void set(int mat[][]) {
		mat[inicial.getX()][inicial.getY()] = 0;
	
		
	}
	
	
}

