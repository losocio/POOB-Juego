package mainJuego;

import java.util.Random;
import java.util.Arrays;
import personajes.Personaje;

public class Emparejador {
	
	private Personaje[][] oponentes;
	private Personaje[] jugadores;
	private boolean[] yaEmparejados;
	
	public Emparejador(Personaje[] jugadores) {
		this.jugadores = jugadores;
		oponentes = new Personaje[2][jugadores.length/2];
		yaEmparejados = new boolean[jugadores.length];
		Arrays.fill(yaEmparejados, false);
		emparejar();
	}
	
	private void emparejar() {
		int random;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < jugadores.length/2; j++) {
				random = getRandom(0, jugadores.length - 1);
				if(!yaEmparejados[random]) {
					oponentes[i][j]=jugadores[random];
					yaEmparejados[random] = true;
				} else {
					j--;
				}
			}
		}
	}
	
	private int getRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public Personaje[][] getOponentes() {
		return oponentes;
	}
}
