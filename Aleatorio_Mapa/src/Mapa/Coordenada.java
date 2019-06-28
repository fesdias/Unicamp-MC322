package Mapa;
import java.util.Random;

enum Direcao {
	RIGHT,
	LEFT,
	UP,
	DOWN;
}
public class Coordenada {
	
	private int x;
	private int y;
	
	public Coordenada(int r, int s) {
		x = r;
		y = s;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean sameCoord(int x1, int y1) {
		if (this.x == x1 && this.y == y1) {
			return true;
		}
		
		return false;
	}
	
	public Coordenada gerarAleatorio() {

		Random gerador = new Random();
		
		/* Colocar dimensões da matriz */
		int r = gerador.nextInt(26);
		int s = gerador.nextInt(29);
		
		Coordenada coord = new Coordenada(r, s);
		
		return coord;
	}
	
	public Coordenada perseguir(Coordenada pacman) {
		
		Coordenada coord = new Coordenada (pacman.x - 5, pacman.y - 5);
		return coord;
	}
	
	public Coordenada AnguloParaCoordenada(Direcao d) {

		switch(d) {
		case RIGHT:
			Coordenada right = new Coordenada(1, 1);
			return right;
			
		case UP:
			Coordenada up = new Coordenada(1, 1);
			return up;
			
		case LEFT:
			Coordenada left = new Coordenada(-1, 1);
			return left;
			
		case DOWN:
			Coordenada down = new Coordenada(1, -1);
			return down;
			
		default:
			return null;
		}
	}
	
	
	
}