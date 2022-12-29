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

public class Seleccion_no_CPU extends JFrame implements ActionListener{
	
	private int numeroJugadoresVerdaderos = 1;
	
	private JPanel panel= new JPanel();
	
	private JLabel texto;
	
	private Object[] jug = {1};
	private JComboBox comboBox;
	
	private JButton siguiente;
	
	public Seleccion_no_CPU(int jugadoresTotales) {
		setSize(500,300);
		setLocation(500,250);
		setTitle("Numero de jugadores verdaderos");
		//panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setLayout(new BorderLayout(65,65));
		
		texto= new JLabel("Seleccione el numero de jugadores verdaderos");
		panel.add(texto, BorderLayout.NORTH);
		
		//panel.add(Box.createHorizontalStrut(1));
		
		for(int i = 2; i<=jugadoresTotales ;i++) {
			jug = Arrays.copyOf(jug, jug.length + 1);
			jug[jug.length - 1] = (Integer) i;
		}
		comboBox=new JComboBox(jug);
		comboBox.setSelectedIndex(0);
		comboBox.addActionListener(this);
		panel.add(comboBox, BorderLayout.CENTER);
		
		//panel.add(Box.createHorizontalStrut(1));
		
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
			dispose();
			//panel.setVisible(false);
			//setVisible(false);
		}
		
		if (source==comboBox) {
			numeroJugadoresVerdaderos=(int)comboBox.getSelectedItem();
		}
		
		
	}
	
	public int getNumeroJugadoresVerdaderos() {
		return numeroJugadoresVerdaderos;
	}
	
	public static void main(String[] args) {
		Seleccion_no_CPU ventana = new Seleccion_no_CPU(8);
		ventana.setVisible(true);
	}
}