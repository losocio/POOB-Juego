package personajes;

public abstract class Personaje {

	private int vida;
	private int ataque;
	private int defensa;
	private int velocidad;
	private String raza;
	private boolean isCPU;
	
	public Personaje(String raza, int vida, int ataque, int defensa, int velocidad, boolean isCPU) {
		this.raza=raza;
		this.vida=vida;
		this.ataque=ataque;
		this.defensa=defensa;
		this.velocidad=velocidad;
		this.isCPU=isCPU;
	}
	
	public int getVida() {
		return vida;
	}
	
	public int getAtaque() {
		return ataque;
	}
	
	public int getDefensa() {
		return defensa;
	}
	
	public int getVelocidad() {
		return velocidad;
	}
	
	public String getRaza() {
		return raza;
	}
	
	public boolean getIsCPU() {
		return isCPU;
	}
	
	/*
	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}
	*/
}
