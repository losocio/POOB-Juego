package armas;

public abstract class Arma {
	private String arma;
	private String efectividad;
	
	public Arma(String arma, String efectividad) {
		this.arma = arma;
		this.efectividad = efectividad;
	}

	public String getArma() {
		return arma;
	}
}
