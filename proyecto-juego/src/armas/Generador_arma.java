package armas;

import java.util.Random;

public class Generador_arma {
	private String armas[] = {"Arco","Daga","Espada","Lanza","Martillo"};
	private Arma arma;
	
	private int getRandom(int min, int max) {
		Random random = new Random();
		return random.nextInt((max - min) + 1) + min;
	}
	
	public Arma getArmaCPU() {
		switch(armas[getRandom(0, 4)]) {
			case "Arco":
				arma = new Arco();
				break;
			case "Daga":
				arma = new Daga();
				break;
			case "Espada":	
				arma = new Espada();
				break;
			case "Lanza":
				arma = new Lanza();
				break;
			case "Martillo":
				arma = new Martillo();
				break;
		}
		return arma;
	}
}
