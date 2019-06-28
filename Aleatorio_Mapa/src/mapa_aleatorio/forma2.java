package mapa_aleatorio;

import Mapa.Coordenada;

public class forma2 extends formas {
	private Coordenada x1, x2;
	
	
	public forma2(Coordenada i, int mat[][]) {
		this.inicial = i;
		if( (!valido(i.getX() , i.getY() + 1))  || (!valido(i.getX(), i.getY() + 2))){
			c = false;
		}
		else if((mat[i.getX()][i.getY()+1] == 0) || (mat[i.getX()][i.getY()+2] == 0)) {
			c = false;
		}
		else {
			 x1 = new Coordenada(i.getX() , i.getY() + 1);
			 x2 = new Coordenada(i.getX() , i.getY() + 2);
			 c = true;
		}
	}
	
	@Override
	public boolean testa(int mat[][]) {
		int x, y;
		x = inicial.getX() ;
		y = inicial.getY() ;
		if (!c) {
			return false;
		} 
		if((!valido(x,y - 1)) || (mat[x][y - 1] != 1)) {
			return false;
		}
		
		if((!valido(x - 1,y )) || (mat[x - 1][y ] != 1) ) {
			return false;
		}
		
		if((!valido(x + 1,y )) || (mat[x + 1][y ] != 1)  ) {
			return false;
		}
		
		if((!valido(x - 1,y - 1)) || (mat[x - 1][y -1] != 1)  ) {
			return false;
		}
		
		if((!valido(x + 1,y - 1)) || (mat[x + 1][y - 1] != 1)  ) {
			return false;
		}
		
		x = x2.getX() ;
		y = x2.getY() ;
		
		if((!valido(x,y + 1)) || (mat[x][y + 1] != 1)) {
			return false;
		}
		
		if((!valido(x - 1,y )) || (mat[x - 1][y] != 1)) {
			return false;
		}
		
		if((!valido(x + 1,y )) || (mat[x + 1][y] != 1)) {
			return false;
		}
		
		if((!valido(x - 1,y + 1)) || (mat[x - 1][y + 1] != 1)) {
			return false;
		}
		
		if((!valido(x + 1,y + 1)) || (mat[x + 1][y + 1] != 1)) {
			return false;
		}
		
		x = x1.getX() ;
		y = x1.getY();
		

		if((!valido(x - 1,y)) || (mat[x - 1][y] != 1))  {
			return false;
		}
		

		if((!valido(x + 1,y)) || (mat[x + 1][y] != 1)) {
			return false;
		}
		
		return true;
 
	}

	@Override
	public  void set(int mat[][]) {
		mat[inicial.getX()][inicial.getY()] = 0;
		mat[x1.getX()][x1.getY()] = 0;
		mat[x2.getX()][x2.getY()] = 0;
		
	}
	
	
}
