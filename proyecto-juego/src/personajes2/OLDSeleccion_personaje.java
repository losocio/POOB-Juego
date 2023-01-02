package personajes2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class OLDSeleccion_personaje extends JFrame implements ActionListener {
	
	private JLabel linea[] = new JLabel[7];
	private JButton b[] = new JButton[4];
	private JButton m[] = new JButton[8];
	private JLabel estadistica= new JLabel();
	private JPanel caja= new JPanel(); //TODO anyadi private
	
	private String personaje[] = {"Elemental","Elfo","Enano","Humano","Orco"};
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
	
	public OLDSeleccion_personaje() {
		for(int x=0;x<7;x++) {
			linea[x]= new JLabel();
		}
		b[0]= new JButton("->");
		b[2]= new JButton("<-");
		b[1]= new JButton("siguiente");
		b[3]= new JButton("anterior");		
		
		m[0]= new JButton("vida +");
		m[4]= new JButton("vida -");
		m[1]= new JButton("ataque +");
		m[5]= new JButton("ataque -");
		m[2]= new JButton("defensa +");
		m[6]= new JButton("defensa -");
		m[3]= new JButton("velocidad +");
		m[7]= new JButton("velocidad -");
		
		JButton enter= new JButton("Enter");
		JButton reset= new JButton("Reset");
		setSize(500,500);
		setLocation(700,200);
		setTitle("Estadisticas");
		caja.setLayout(new GridLayout(7,3));
		for(int x=0;x<2;x++) {
			caja.add(b[2+x]);
			caja.add(linea[x]);
			caja.add(b[x]);
		}
		for(int x=0;x<4;x++) {
			caja.add(m[4+x]);
			caja.add(linea[x+2]);
			caja.add(m[x]);
		}
		caja.add(estadistica);
		caja.add(reset);
		caja.add(enter);
		add(caja);
		linea[0].setText(dificultad[0]);
		linea[1].setText(personaje[0]);
		linea[2].setText("7");
		linea[3].setText("19");
		linea[4].setText("7");
		linea[5].setText("7");
		estadistica.setText("50");
		for(int x=0;x<4;x++) {
			b[x].addActionListener(this);
		}
		for(int x=0;x<8;x++) {
			m[x].addActionListener(this);
		}
		reset.addActionListener(this);
		enter.addActionListener(this);
	}



	public void actionPerformed(ActionEvent e) {
		
		String estadisticas_total="";
		JButton clickedButton= (JButton) e.getSource();
		String buttonText = clickedButton.getText();
		
		
		if (buttonText=="<-") {
			if (dif==0) {
				dif=2;
			}else {
				dif--;
			}
		}
		if (buttonText=="->") {
			if (dif==2) {
				dif=0;
			}else {
				dif++;
			}
		}
		
		if (buttonText=="anterior") {
			if (raz==0) {
				raz=4;
			}else {
				raz--;
			}
		}
		if (buttonText=="siguiente") {
			if (raz==4) {
				raz=0;
			}else {
				raz++;
			}
		}
		
		if (buttonText=="vida -") {
			if(vida>0) {
				vida--;
			}
		}
		if (buttonText=="vida +") {
			vida++;
		}
		
		if (buttonText=="ataque -") {
			if(ataque>0) {
				ataque--;
			}
		}
		if (buttonText=="ataque +") {
			ataque++;
		}
		
		if (buttonText=="defensa -") {
			if(defensa>0) {
				defensa--;
			}
		}
		if (buttonText=="defensa +") {
			defensa++;
		}
		
		if (buttonText=="velocidad -") {
			if(velocidad>0) {
				velocidad--;
			}
		}
		if (buttonText=="velocidad +") {
			velocidad++;
		}
		
		if (buttonText=="Reset") {
			vida=0;
			ataque=0;
			defensa=0;
			velocidad=0;
		}
		
		if (personaje[raz]=="Elemental") {
			vida_base=7;
			ataque_base=19;
			defensa_base=7;
			velocidad_base=7;
		}
		if (personaje[raz]=="Elfo") {
			vida_base=7;
			ataque_base=7;
			defensa_base=7;
			velocidad_base=19;
		}
		if (personaje[raz]=="Enano") {
			vida_base=7;
			ataque_base=7;
			defensa_base=19;
			velocidad_base=7;
		}
		if (personaje[raz]=="Humano") {
			vida_base=10;
			ataque_base=10;
			defensa_base=10;
			velocidad_base=10;
		}
		if (personaje[raz]=="Orco") {
			vida_base=19;
			ataque_base=7;
			defensa_base=7;
			velocidad_base=7;
		}
		if (dificultad[dif]=="Facil") {
			estadisticas=50;
		}
		if (dificultad[dif]=="Normal") {
			estadisticas=35;
		}
		if (dificultad[dif]=="Dificil") {
			estadisticas=20;
		}
		
		if (buttonText=="Enter") {
			if(0==(estadisticas-vida-ataque-defensa-velocidad)) {
				
				caja.setVisible(false);
				dispose();
			}
		}
		
		vida_total=vida_base+vida;
		ataque_total=ataque_base+ataque;
		defensa_total=defensa_base+defensa;
		velocidad_total=velocidad_base+velocidad;
		estadisticas_total=estadisticas-vida-ataque-defensa-velocidad+"";
		
		linea[0].setText(dificultad[dif]);
		linea[1].setText(personaje[raz]);
		linea[2].setText(vida_total+"");
		linea[3].setText(ataque_total+"");
		linea[4].setText(defensa_total+"");
		linea[5].setText(velocidad_total+"");
		estadistica.setText(estadisticas_total);
	}



	public String[] getPersonaje() {
		return personaje;
	}

	public int getRaz() {
		return raz;
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
	
}