package Personagens;
import Mapa.Coordenada;

public abstract class Entidade {
	
	protected boolean vivo;
	protected Coordenada coordenada;
	
	public Entidade() {
		vivo = true;
	}
	
	public Coordenada getCoord() {
		return coordenada;
	}
	
	public abstract void move();
}
