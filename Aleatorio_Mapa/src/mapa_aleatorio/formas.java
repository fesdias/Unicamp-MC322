package mapa_aleatorio;

import Mapa.Coordenada;

public abstract class formas {
	protected Coordenada inicial;
	protected boolean c;
	
	
	
	public abstract boolean testa(int mat[][]);
	public abstract void set(int mat[][]);
	
	public static boolean valido(int x, int y) {
		if((x > 31) || (x < 0))
			return false;
		if((y > 13) || (y < 0))
			return false;
		return true;
	}
	
}
