package mainJuego;

import personajes.Personaje;

public class Emparejador {
	
	private Personaje oponente1, oponente2;
	private Personaje[] jugadoresVerdaderos;
	private Personaje[] jugadoresCPU;
	
	public Emparejador(Personaje[] jugadoresVerdaderos, Personaje[] jugadoresCPU) {
		this.jugadoresVerdaderos = jugadoresVerdaderos;
		this.jugadoresCPU = jugadoresCPU;
	}
	
	
	
	public Personaje getOponente1() {
		return oponente1;
	}
	
	public Personaje getOponente2() {
		return oponente2;
	}
}
