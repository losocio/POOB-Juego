package personajes2;

public abstract class Personaje extends seleccion_personaje{

	private int vida;
	private int ataque;
	private int def;
	private int velocidad;
	private String raza;
	
	public Personaje() {
		this.raza=getPersonaje()[getY()];
		this.vida=getVida_total();
		this.ataque=getAtaque_total();
		this.def=getDefensa_total();
		this.velocidad=getVelocidad_total();
	}
	
	
}
