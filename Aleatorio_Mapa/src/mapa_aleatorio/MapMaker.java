package mapa_aleatorio;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import Mapa.Coordenada;

public class MapMaker {
	
	public static void inicia(int[][] m, int a) {
		int i, j;
		for (i = 0; i < 32; i ++) {
			for(j = 0; j < 14; j++) {
				if((i == 0) || (j == 0)) {
					m[i][j] = 0;
					
				}
				else if(i == 31) {
					m[i][j] = 0;
				}
				else {
					m[i][j] = 1;
				}
			}
		}
		
		m[13][13] = 0;
		m[14][13] = 0;
		m[15][13] = 0;
		m[16][13] = 0;
		m[13][12] = 0;
		m[14][12] = 0;
		m[15][12] = 0;
		m[16][12] = 0;
		m[13][11] = 0;
		m[14][11] = 0;
		m[15][11] = 0;
		m[16][11] = 0;
		
		switch(a) {
		
		case 1:{
			m[11][0] = 1;
			m[19][0] = 1;
		}
		default:{
			m[15][0] = 1;
		}
		}
		
		
	}
	
	public static void inicia(ArrayList<Integer> i) {
		i.clear();
		i.add(0);
		i.add(1);
		i.add(2);
	}
	
	public static void duplica(int mat[][]) {
		int i, j, aux;
		for (i = 0; i < 32; i ++) {
			aux = 1;
			for(j = 14; j < 28; j++) {
				mat[i][j] = mat[i][14 - aux];
				aux++;
			}
		}
	}
	
	public static void preenche(int matriz[][], int x, int y) {
		int i, j, a;
		Random aux = new Random();
		ArrayList<Integer> rdm = new ArrayList<Integer>();
		formas f;
		
		f = null; 
		for (i = 0; i < x; i ++) {
			for(j = 0; j < y; j++) {
				if(matriz[i][j] != 0) {
					inicia(rdm);
					while(rdm.size()  > 0) {
						a = aux.nextInt(rdm.size());
						f = null;
						if(rdm.get(a) == 0) {
							f = new forma1(new Coordenada(i, j), matriz);
						}
						else if(rdm.get(a) == 1) {
							f = new forma2(new Coordenada(i, j), matriz);
							
						}
						else if(rdm.get(a) == 2) {
							f = new forma3(new Coordenada(i, j), matriz);
							
						}
						
						
						if(f.testa(matriz)) {
							f.set(matriz);
							
							f = null;
							break;
						}
						else {
							rdm.remove(a);
						}
					}
				}
			}
		}
		
	}
	
	public static void lacunas(int matriz[][]) {
		int i, j;
		formas f;
		for (i = 0; i < 32; i++) {
			for (j = 13; matriz[i][j - 1] == 1; j--) {
				f = new forma4(new Coordenada(i, j));
				if(f.testa(matriz)) {
					f.set(matriz);
					f = null;
					}
				else {break;}
				
			}
			
		}
	}
	
	public static void save(int matriz[][], String a) throws IOException {
		int i,j;
		FileWriter arq = new FileWriter(a);
		PrintWriter gravarArq = new PrintWriter(arq);
		
		for (i = 0; i < 2; i ++) {
			for(j = 0; j < 28; j++) {
				gravarArq.print("0");
			}
			gravarArq.println();
		}
		
		for (i = 0; i < 32; i ++) {
			for(j = 0; j < 28; j++) {
				gravarArq.print(matriz[i][j]);
			}
			gravarArq.println();
		}
		
		for (i = 0; i < 2; i ++) {
			for(j = 0; j < 28; j++) {
				gravarArq.print("0");
			}
			gravarArq.println();
		}
		
		arq.close();
		
	}
	
	public static void MakeMap(String arq) throws IOException {
		int[][] matriz = new int[32][28];
		Random aux = new Random();
		inicia(matriz, 1 + aux.nextInt(2));
		preenche(matriz, 32, 14);
		lacunas(matriz);
		duplica(matriz);
		save(matriz, arq);
		
		
	}
	
	
}
