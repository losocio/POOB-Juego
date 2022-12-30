package mainJuego;

import personajes.Personaje;
import personajes.Seleccion_personaje;

public class Main {

	public static void main(String[] args) {
		/*
		Seleccion_no_jugadores seleccion_no_jugadores= new Seleccion_no_jugadores();
		seleccion_no_jugadores.setVisible(true);
		Seleccion_no_CPU seleccion_no_CPU= new Seleccion_no_CPU(seleccion_no_jugadores.getNumeroJugadores());
		seleccion_no_CPU.setVisible(true);
		//TODO pantallas seleccion jugadores
		//seleccion_no_CPU.getnumerojugadoresVerdaderos();
		
		int numerojugadoresVerdaderos = seleccion_no_CPU.getnumerojugadoresVerdaderos();
		*/
		int numerojugadoresVerdaderos = 1;
		Personaje jugadoresVerdaderos[] = new Personaje[numerojugadoresVerdaderos];
		
		int i = 0;
		while(i < numerojugadoresVerdaderos) {
			Seleccion_personaje seleccion_personaje = new Seleccion_personaje();
			seleccion_personaje.setVisible(true);
			
			jugadoresVerdaderos[i] = seleccion_personaje.getJugador();
			//TODO pausar ejecucion
			System.out.println("klk");
			System.out.println(jugadoresVerdaderos[i]);

			i++;
		}
	}

}
