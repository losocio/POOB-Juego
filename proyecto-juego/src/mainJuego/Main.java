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
		
		Seleccion_no_verdaderos seleccion_no_verdaderos= new Seleccion_no_verdaderos(numeroJugadores);
		seleccion_no_verdaderos.setVisible(true);
		
		while(seleccion_no_verdaderos.getNumeroJugadoresVerdaderos() == 0) {
			System.out.println("");
		}
		
		int numeroJugadoresVerdaderos = seleccion_no_verdaderos.getNumeroJugadoresVerdaderos();
		
		Personaje jugadoresVerdaderos[] = new Personaje[numeroJugadoresVerdaderos];
		Arma armasVerdaderos[] = new Arma[numeroJugadoresVerdaderos];
		
		int i = 0;
		int ID =0;
		while(i < numeroJugadoresVerdaderos) {
			Seleccion_personaje seleccion_personaje = new Seleccion_personaje();
			seleccion_personaje.setVisible(true);
			
			while(seleccion_personaje.getJugador() == null) {
				System.out.println("");
			}
			jugadoresVerdaderos[i] = seleccion_personaje.getJugador();
			jugadoresVerdaderos[i].setID(ID);
			
			Seleccion_arma seleccion_arma = new Seleccion_arma();
			seleccion_arma.setVisible(true);
			
			while(seleccion_arma.getArma() == null) {
				System.out.println("");
			}
			armasVerdaderos[i] = seleccion_arma.getArma();
			
			ID++;
			i++;
		}
		
		int numeroJugadoresCPU = numeroJugadores - numeroJugadoresVerdaderos;
		Personaje jugadoresCPU[] = new Personaje[numeroJugadoresCPU];
		Arma armasCPU[] = new Arma[numeroJugadoresCPU];
		
		i = 0;
		while(i < numeroJugadoresCPU) {
			Generador_CPU generador_CPU = new Generador_CPU();
			jugadoresCPU[i] = generador_CPU.getCPU();
			jugadoresCPU[i].setID(ID);
			
			Generador_arma generador_arma = new Generador_arma();
			armasCPU[i] = generador_arma.getArmaCPU();
			
			ID++;
			i++;
		}
		
		Personaje jugadores[] = new Personaje[numeroJugadores];
		System.arraycopy(jugadoresVerdaderos, 0, jugadores, 0, numeroJugadoresVerdaderos);  
		System.arraycopy(jugadoresCPU, 0, jugadores, numeroJugadoresVerdaderos, numeroJugadoresCPU);
		
		Arma armas[] = new Arma[numeroJugadores];
		System.arraycopy(armasVerdaderos, 0, armas, 0, numeroJugadoresVerdaderos);  
		System.arraycopy(armasCPU, 0, armas, numeroJugadoresVerdaderos, numeroJugadoresCPU);
		
		int rondas=0;
		//int redimensionar=0;
		switch(numeroJugadores) {
		case 32:
			rondas=5;
			//redimensionar=16;
			break;
		case 16:
			rondas=4;
			//redimensionar=8;
			break;
		case 8:
			rondas=3;
			//redimensionar=4;
			break;
		case 4:
			rondas=2;
			//redimensionar=2;
			break;
		case 2:
			rondas=1;
			//redimensionar=1;
			break;
		}
		
		int numeroJugadoresRondas = numeroJugadores/2;
		while(rondas>0) {
			Emparejador emparejador = new Emparejador(jugadores);
			Personaje[][] emparejamientos = emparejador.getOponentes();
			jugadores = new Personaje[emparejamientos[0].length]; //TODO creo que esto esta bien. Sino usar redimensionar 
			
			for(int j = 0; j < numeroJugadoresRondas; j++) {
				Batalla batalla = new Batalla(emparejamientos[0][j], armas[emparejamientos[0][j].getID()], emparejamientos[1][j], armas[emparejamientos[1][j].getID()]);
				jugadores[j]=batalla.getGanador();
			}
			numeroJugadoresRondas = numeroJugadoresRondas/2;
			rondas--;
		}
		
		System.out.println("El ganador es el jugador " + jugadores[0].getID());
	}

}
