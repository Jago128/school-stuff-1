package p15Windows;

import java.awt.event.*;
import java.util.Map;
import javax.swing.*;

import p15Controller.WindowController;
import p15Model.*;

public class WindowShowAlumnos extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton btnShow;
	private JComboBox<String> comboBox;
	private WindowController w;

	public WindowShowAlumnos(JFrame parent, WindowController w) {
		this.w = w;
		setBounds(100, 100, 340, 144);
		getContentPane().setLayout(null);

		comboBox = new JComboBox<>();
		comboBox.setBounds(75, 11, 159, 22);
		getContentPane().add(comboBox);

		btnShow = new JButton("Mostrar alumnos");
		btnShow.setBounds(105, 59, 129, 23);
		getContentPane().add(btnShow);
		btnShow.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnShow) {
			Map<String, Alumno> asigs = w.showAlumnos();
			for (Alumno a : asigs.values()) {
				comboBox.addItem(a.getNom());
			}
		}
	}
}
