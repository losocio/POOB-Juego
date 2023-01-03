package personajes;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Seleccion_personaje extends JFrame implements ActionListener {
	
	private JPanel caja= new JPanel();
	private JLabel dato[] = new JLabel[7];
	private JButton boton[] = new JButton[14];
	
	private String raza[] = {"Elemental","Elfo","Enano","Humano","Orco"};
	private String dificultad[] = {"Facil","Normal","Dificil"};
	
	private int dif=0;
	private int raz=0;
	
	private int vida=0;
	private int ataque=0;
	private int defensa=0;
	private int velocidad=0;
	
	private int vida_base=0;
	private int ataque_base=0;
	private int defensa_base=0;
	private int velocidad_base=0;
	
	private int vida_total=0;
	private int ataque_total=0;
	private int defensa_total=0;
	private int velocidad_total=0;
	
	private int estadisticas=0;
	private int estadisticas_total = 50;
	
	private Personaje jugador;
	
	public Seleccion_personaje() {
		
		for(int x=0;x<7;x++) {
			dato[x]= new JLabel();
		}
		
		boton[0]= new JButton("<-");
		boton[1]= new JButton("->");
		boton[2]= new JButton(" <- ");
		boton[3]= new JButton(" -> ");
		boton[4]= new JButton("Vida -");
		boton[5]= new JButton("Vida +");
		boton[6]= new JButton("Ataque -");
		boton[7]= new JButton("Ataque +");
		boton[8]= new JButton("Defensa -");
		boton[9]= new JButton("Defensa +");
		boton[10]= new JButton("Velocidad -");
		boton[11]= new JButton("Velocidad +");
		boton[12]= new JButton("Resetear");
		boton[13]= new JButton("Siguiente");
		
		setSize(500,500);
		setLocation(700,200);
		setTitle("Estadisticas");
		caja.setLayout(new GridLayout(7,3));
		
		for(int x=0; x<6; x++) {
			caja.add(boton[2*x]);
			caja.add(dato[x]);
			caja.add(boton[2*x+1]);
		}
		
		caja.add(dato[6]);
		caja.add(boton[12]);
		caja.add(boton[13]);
		
		add(caja);
		
		dato[0].setText(dificultad[0]);
		dato[1].setText(raza[0]);
		dato[2].setText("7");
		dato[3].setText("19");
		dato[4].setText("7");
		dato[5].setText("7");
		dato[6].setText("50");
		
		for(int x=0; x<14; x++) {
			boton[x].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent e) {

		JButton clickedButton = (JButton) e.getSource();
		String buttonText = clickedButton.getText();
		
		switch(buttonText) {
			case "<-":
				if (dif==0) {
					dif=2;
				}else {
					dif--;
				}
				break;
				
			case "->":
				if (dif==2) {
					dif=0;
				}else {
					dif++;
				}
				break;
				
			case " <- ":
				if (raz==0) {
					raz=4;
				}else {
					raz--;
				}
				break;
				
			case " -> ":
				if (raz==4) {
					raz=0;
				}else {
					raz++;
				}
				break;
				
			case "Vida -":
				if(vida>0) {
					vida--;
				}
				break;
				
			case "Vida +":
				if(estadisticas_total>0) {
					vida++;
				}
				break;
				
			case "Ataque -":
				if(ataque>0) {
					ataque--;
				}
				break;
				
			case "Ataque +": 
				if(estadisticas_total>0) {
					ataque++;
				}
				break;
				
			case "Defensa -":
				if(defensa>0) {
					defensa--;
				}
				break;
				
			case "Defensa +": 
				if(estadisticas_total>0) {
					defensa++;
				}
				break;
				
			case "Velocidad -":
				if(velocidad>0) {
					velocidad--;
				}
				break;
				
			case "Velocidad +": 
				if(estadisticas_total>0) {
					velocidad++;
				}
				break;
				
			case "Resetear":
				vida=0;
				ataque=0;
				defensa=0;
				velocidad=0;
				break;
				
			case "Siguiente":
				if((estadisticas-vida-ataque-defensa-velocidad) == 0) {
					switch(raza[raz]) {
						case "Elemental":
							jugador = new Elemental(vida_total, ataque_total, defensa_total, velocidad_total, false);
							break;
							
						case "Elfo":
							jugador = new Elfo(vida_total, ataque_total, defensa_total, velocidad_total, false);
							break;
							
						case "Enano":
							jugador = new Enano(vida_total, ataque_total, defensa_total, velocidad_total, false);
							break;
							
						case "Humano":
							jugador = new Humano(vida_total, ataque_total, defensa_total, velocidad_total, false);
							break;
							
						case "Orco":
							jugador = new Orco(vida_total, ataque_total, defensa_total, velocidad_total, false);
							break;
					}
					
					dispose();
				}
				break;
		}
		
		switch(raza[raz]) {
			case "Elemental":
				vida_base=7;
				ataque_base=19;
				defensa_base=7;
				velocidad_base=7;
				break;
				
			case "Elfo":
				vida_base=7;
				ataque_base=7;
				defensa_base=7;
				velocidad_base=19;
				break;
				
			case "Enano":
				vida_base=7;
				ataque_base=7;
				defensa_base=19;
				velocidad_base=7;
				break;
				
			case "Humano":
				vida_base=10;
				ataque_base=10;
				defensa_base=10;
				velocidad_base=10;
				break;
				
			case "Orco":
				vida_base=19;
				ataque_base=7;
				defensa_base=7;
				velocidad_base=7;
				break;
		}
		
		switch(dificultad[dif]) {
			case "Facil": 
				estadisticas=50;
				break;
				
			case "Normal": 
				estadisticas=35;
				break;
				
			case "Dificil": 
				estadisticas=20;
				break;
		}
		
		//TODO puede que haya que poner el boton Siguiente aqui
		
		vida_total=vida_base+vida;
		ataque_total=ataque_base+ataque;
		defensa_total=defensa_base+defensa;
		velocidad_total=velocidad_base+velocidad;
		estadisticas_total=estadisticas-vida-ataque-defensa-velocidad;
		
		dato[0].setText(dificultad[dif]);
		dato[1].setText(raza[raz]);
		dato[2].setText(vida_total+"");
		dato[3].setText(ataque_total+"");
		dato[4].setText(defensa_total+"");
		dato[5].setText(velocidad_total+"");
		dato[6].setText(estadisticas_total+"");
	}

	public Personaje getJugador() {
		return jugador;
	}
	/*
	public String getRaza() {
		return raza[raz];
	}

	public int getVida_total() {
		return vida_total;
	}

	public int getAtaque_total() {
		return ataque_total;
	}

	public int getDefensa_total() {
		return defensa_total;
	}

	public int getVelocidad_total() {
		return velocidad_total;
	}
	*/
}
