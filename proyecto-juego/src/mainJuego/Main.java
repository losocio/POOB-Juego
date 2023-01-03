package mainJuego;

import personajes.*;
import armas.*;
import java.util.Arrays; 

public class Main {

	public static void main(String[] args) {
		Seleccion_no_jugadores seleccion_no_jugadores= new Seleccion_no_jugadores();
		seleccion_no_jugadores.setVisible(true);
		
		while(seleccion_no_jugadores.getNumeroJugadores() == 0) {
			System.out.println("");
		}
		
		int numeroJugadores = seleccion_no_jugadores.getNumeroJugadores();
		
		Seleccion_no_CPU seleccion_no_CPU= new Seleccion_no_CPU(numeroJugadores);
		seleccion_no_CPU.setVisible(true);
		
		while(seleccion_no_CPU.getNumeroJugadoresVerdaderos() == 0) {
			System.out.println("");
		}
		
		int numeroJugadoresVerdaderos = seleccion_no_CPU.getNumeroJugadoresVerdaderos();
		
		Personaje jugadoresVerdaderos[] = new Personaje[numeroJugadoresVerdaderos];
		Arma armasVerdaderos[] = new Arma[numeroJugadoresVerdaderos];
		
		int i = 0;
		while(i < numeroJugadoresVerdaderos) {
			Seleccion_personaje seleccion_personaje = new Seleccion_personaje();
			seleccion_personaje.setVisible(true);
			
			while(seleccion_personaje.getJugador() == null) {
				System.out.println("");
			}
			jugadoresVerdaderos[i] = seleccion_personaje.getJugador();
			
			Seleccion_arma seleccion_arma = new Seleccion_arma();
			seleccion_arma.setVisible(true);
			
			while(seleccion_arma.getArma() == null) {
				System.out.println("");
			}
			armasVerdaderos[i] = seleccion_arma.getArma();
			
			i++;
		}
		
		int numeroJugadoresCPU = numeroJugadores - numeroJugadoresVerdaderos;
		Personaje jugadoresCPU[] = new Personaje[numeroJugadoresCPU];
		Arma armasCPU[] = new Arma[numeroJugadoresCPU];
		
		i = 0;
		while(i < numeroJugadoresCPU) {
			Generador_CPU generador_CPU = new Generador_CPU();
			jugadoresCPU[i] = generador_CPU.getCPU();
			
			Generador_arma generador_arma = new Generador_arma();
			armasCPU[i] = generador_arma.getArmaCPU();
			
			i++;
		}
		
		Personaje jugadores[] = new Personaje[numeroJugadores];
		System.arraycopy(jugadoresVerdaderos, 0, jugadores, 0, numeroJugadoresVerdaderos);  
		System.arraycopy(jugadoresCPU, 0, jugadores, numeroJugadoresVerdaderos, numeroJugadoresCPU);
		
		Arma armas[] = new Arma[numeroJugadores];
		System.arraycopy(armasVerdaderos, 0, armas, 0, numeroJugadoresVerdaderos);  
		System.arraycopy(armasCPU, 0, armas, numeroJugadoresVerdaderos, numeroJugadoresCPU);
		
		//while rondas
			Emparejador emparejador = new Emparejador(jugadores);
			Personaje[][] emparejamientos = emparejador.getOponentes();
			for(int i = 0; i < numeroJugadores; i++) {
				Batalla batalla = new Batalla();
			}
		
	}

}
