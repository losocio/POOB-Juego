package mainJuego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.util.Arrays;

public class Seleccion_no_verdaderos extends JFrame implements ActionListener{
	
	private int numeroJugadoresVerdaderos = 0;
	private int seleccionCombo = 1;
	
	private JPanel panel= new JPanel();
	
	private JLabel texto;
	
	private Object[] jug = {1};
	private JComboBox comboBox;
	
	private JButton siguiente;
	
	public Seleccion_no_verdaderos(int jugadoresTotales) {
		setSize(500,300);
		setLocation(500,250);
		setTitle("Numero de jugadores verdaderos");
		panel.setLayout(new BorderLayout(65,65));
		
		texto= new JLabel("Seleccione el numero de jugadores verdaderos");
		panel.add(texto, BorderLayout.NORTH);
		
		for(int i = 2; i<=jugadoresTotales ;i++) {
			jug = Arrays.copyOf(jug, jug.length + 1);
			jug[jug.length - 1] = (Integer) i;
		}
		comboBox=new JComboBox(jug);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		panel.add(comboBox, BorderLayout.CENTER);
		
		siguiente = new JButton("Siguiente");
		siguiente.addActionListener(this);
		panel.add(siguiente, BorderLayout.SOUTH);
		
		panel.add(new JLabel(" "), BorderLayout.EAST);
		panel.add(new JLabel(" "), BorderLayout.WEST);
		
		add(panel);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}


	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if (source==siguiente) {
			numeroJugadoresVerdaderos=seleccionCombo;
			dispose();
		}
		
		if (source==comboBox) {
			seleccionCombo=(int)comboBox.getSelectedItem();
		}
		
		
	}
	
	public int getNumeroJugadoresVerdaderos() {
		return numeroJugadoresVerdaderos;
	}
}