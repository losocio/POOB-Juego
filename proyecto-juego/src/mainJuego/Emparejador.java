package mainJuego;

import personajes.Personaje;

public class Emparejador {
	
	private Personaje oponente1, oponente2;
	private Personaje[] jugadoresVerdaderos;
	private Personaje[] jugadoresCPU;
	private int numeroJugadores;
	
	public Emparejador(Personaje[] jugadoresVerdaderos, Personaje[] jugadoresCPU) {
		this.jugadoresVerdaderos = jugadoresVerdaderos;
		this.jugadoresCPU = jugadoresCPU;
		numeroJugadores = jugadoresVerdaderos.length + jugadoresCPU.length;
	}
	
	private void emparejar() {
		
	}
	
	public Personaje getOponente1() {
		return oponente1;
	}
	
	public Personaje getOponente2() {
		return oponente2;
	}
}
