package mainJuego;

import personajes.Personaje;
import personajes.Seleccion_personaje;
import armas.Arma;
import armas.Seleccion_arma;

public class Main {

	public static void main(String[] args) {
		
		Seleccion_no_jugadores seleccion_no_jugadores= new Seleccion_no_jugadores();
		seleccion_no_jugadores.setVisible(true);
		
		while(seleccion_no_jugadores.getNumeroJugadores() == 0) {
			System.out.println("");
		}
		
		Seleccion_no_CPU seleccion_no_CPU= new Seleccion_no_CPU(seleccion_no_jugadores.getNumeroJugadores());
		seleccion_no_CPU.setVisible(true);
		
		while(seleccion_no_CPU.getNumeroJugadoresVerdaderos() == 0) {
			System.out.println("");
		}
		
		int numerojugadoresVerdaderos = seleccion_no_CPU.getNumeroJugadoresVerdaderos();
		
		Personaje jugadoresVerdaderos[] = new Personaje[numerojugadoresVerdaderos];
		Arma armasEquipadas[] = new Arma[numerojugadoresVerdaderos];
		
		int i = 0;
		while(i < numerojugadoresVerdaderos) {
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
			armasEquipadas[i] = seleccion_arma.getArma();
			
			i++;
		}
	}

}
