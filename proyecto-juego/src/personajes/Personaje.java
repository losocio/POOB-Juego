package personajes;

public abstract class Personaje {

	private int vida;
	private int ataque;
	private int defensa;
	private int velocidad;
	private String raza;
	
	public Personaje(String raza, int vida, int ataque, int defensa, int velocidad) {
		this.raza=raza;
		this.vida=vida;
		this.ataque=ataque;
		this.defensa=defensa;
		this.velocidad=velocidad;
	}
	
	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	

	
	
}
