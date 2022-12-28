package personajes;

public abstract class Personaje {

	private int vida;
	private int ataque;
	private int def;
	private int velocidad;
	private String raza;
	
	public Personaje(String raza, int vida, int ataque, int def, int velocidad) {
		this.raza=raza;
		this.vida=vida;
		this.ataque=ataque;
		this.def=def;
		this.velocidad=velocidad;
	}
	
	
}
