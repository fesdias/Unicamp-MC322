package Personagens;
import Mapa.Coordenada;

public class Perseguidor extends Fantasma {
	
	
	public void move(Pacman pac) {
		
		this.coordenada = perseguir(pac.getCoord());
		
	}
}
