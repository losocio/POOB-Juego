package armas;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import personajes.Personaje;

public class Seleccion_arma extends JFrame implements ActionListener{
	private JLabel linea[] = new JLabel[2];
	private JButton b[] = new JButton[3];
	private JPanel caja= new JPanel();
	private JPanel caja2= new JPanel();
	private JPanel caja3= new JPanel();
	private String arma[] = {"Arco","Daga","Espada","Lanza","Martillo"};
	private int arm=0;
	
	private Arma armas;
	
	public Seleccion_arma() {
		setSize(500,300);
		setLocation(500,250);
		for(int x=0;x<2;x++) {
			linea[x]= new JLabel();
		}
		linea[1].setSize(100,300);
		b[0]= new JButton("->");
		b[1]= new JButton("<-");
		b[2]= new JButton("Siguiente");
		linea[0].setText(arma[0]);
		linea[1].setText("Es mas efectivo contra los elfos");
		caja2.setLayout(new GridLayout(1,3));
		caja.setLayout(new GridLayout(1,1));
		caja3.setLayout(new GridLayout(1,1));
		super.add(caja2, BorderLayout.NORTH);
		super.add(caja, BorderLayout.CENTER);
		super.add(caja3, BorderLayout.SOUTH);
		caja2.add(b[1]);
		caja2.add(linea[0]);
		caja2.add(b[0]);
		caja3.add(b[2]);
		caja.add(linea[1]);
		b[0].addActionListener(this);
		b[1].addActionListener(this);
		b[2].addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {

		JButton clickedButton = (JButton) e.getSource();
		String buttonText = clickedButton.getText();
		
		switch(buttonText) {
		case "<-":
			if (arm==0) {
				arm=4;
			}else {
				arm--;
			}
			break;
			
		case "->":
			if (arm==4) {
				arm=0;
			}else {
				arm++;
			}
			break;
			
		case "Siguiente":
			switch(arma[arm]) {
			case "Arco":
				armas = new Arco();
				break;
			case "Daga":
				armas = new Daga();
				break;
			case "Espada":	
				armas = new Espada();
				break;
			case "Lanza":
				armas = new Lanza();
				break;
			case "Martillo":
				armas = new Martillo();
				break;
			}
			dispose();
			break;
		}
		switch(arma[arm]) {
		case "Arco":
			linea[1].setText("Es mas efectivo contra los elfos");
			break;
		case "Daga":
			linea[1].setText("Es mas efectivo contra los enanos");
			break;
		case "Espada":	
			linea[1].setText("Es mas efectivo contra los orcos");
			break;
		case "Lanza":
			linea[1].setText("Es mas efectivo contra los humanos");
			break;
		case "Martillo":
			linea[1].setText("Es mas efectivo contra los elementales");
			break;
		}
		linea[0].setText(arma[arm]);
	}

	public Arma getArma() {
		return armas;
	}
}
