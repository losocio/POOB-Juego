package personajes;

import java.util.Random;

public class Generador_CPU {
	private String raza[] = {"Elemental","Elfo","Enano","Humano","Orco"};
	private int vida=0;
	private int ataque=0;
	private int defensa=0;
	private int velocidad=0;
	
	private int vida_total=0;
	private int ataque_total=0;
	private int defensa_total=0;
	private int velocidad_total=0;
	
	private Personaje CPU;
	
	public Generador_CPU() {
		vida = getRandom(0, 50);
		ataque = getRandom(0, 50 - vida);
		defensa = getRandom(0, 50 - vida - ataque);
		velocidad = 50 - vida - ataque - defensa;
		
		switch(raza[getRandom(0, 4)]) {
			case "Elemental":
				vida_total=vida + 7;
				ataque_total=ataque + 19;
				defensa_total=defensa + 7;
				velocidad_total=velocidad + 7;
				CPU = new Elemental(vida_total, ataque_total, defensa_total, velocidad_total);
				break;
				
			case "Elfo":
				vida_total=vida + 7;
				ataque_total=ataque + 7;
				defensa_total=defensa + 7;
				velocidad_total=velocidad + 19;
				CPU = new Elfo(vida_total, ataque_total, defensa_total, velocidad_total);
				break;
				
			case "Enano":
				vida_total=vida + 7;
				ataque_total=ataque + 7;
				defensa_total=defensa + 19;
				velocidad_total=velocidad + 7;
				CPU = new Enano(vida_total, ataque_total, defensa_total, velocidad_total);
				break;
				
			case "Humano":
				vida_total=vida + 10;
				ataque_total=ataque + 10;
				defensa_total=defensa + 10;
				velocidad_total=velocidad + 10;
				CPU = new Humano(vida_total, ataque_total, defensa_total, velocidad_total);
				break;
				
			case "Orco":
				vida_total=vida + 19;
				ataque_total=ataque + 7;
				defensa_total=defensa + 7;
				velocidad_total=velocidad + 7;
				CPU = new Orco(vida_total, ataque_total, defensa_total, velocidad_total);
				break;
		}
		
	}
	
	private int getRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public Personaje getCPU() {
		return CPU;
	}
}
