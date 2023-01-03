package armas;

public abstract class Arma {
	private String arma;
	private String efectividad;
	private int ID;
	
	public Arma(String arma, String efectividad) {
		this.arma = arma;
		this.efectividad = efectividad;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
}
