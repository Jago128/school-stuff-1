package p15Windows;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import p15Controller.WindowController;

public class WindowButtons extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnShowAlumnos;
	private JButton btnShowAsignaturas;
	private JButton btnShowAsignaturasDNI;
	private JButton btnModify;
	private JButton btnDelete;
	private WindowController w;

	public WindowButtons(WindowController w) {
		this.w = w;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 419, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnShowAlumnos = new JButton("Mostrar alumnos");
		btnShowAlumnos.setBounds(20, 11, 169, 57);
		contentPane.add(btnShowAlumnos);
		btnShowAlumnos.addActionListener(this);

		btnShowAsignaturas = new JButton("Mostrar asignaturas");
		btnShowAsignaturas.setBounds(215, 11, 164, 57);
		contentPane.add(btnShowAsignaturas);
		btnShowAsignaturas.addActionListener(this);

		btnShowAsignaturasDNI = new JButton("Mostrar asignaturas dado un DNI");
		btnShowAsignaturasDNI.setBounds(78, 79, 244, 57);
		contentPane.add(btnShowAsignaturasDNI);
		btnShowAsignaturasDNI.addActionListener(this);

		btnModify = new JButton("Modificar creditos asignatura");
		btnModify.setBounds(26, 147, 179, 57);
		contentPane.add(btnModify);
		btnModify.addActionListener(this);

		btnDelete = new JButton("Eliminar asignatura");
		btnDelete.setBounds(215, 147, 164, 57);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnShowAlumnos) {
			WindowShowAlumnos dialog = new WindowShowAlumnos(this, w);
			dialog.setVisible(true);
		} else if (e.getSource() == btnShowAsignaturas) {
			WindowShowAsignaturas dialog = new WindowShowAsignaturas(this, w);
			dialog.setVisible(true);
		} else if (e.getSource() == btnShowAsignaturasDNI) {
			WindowShowAsignaturasDNI dialog = new WindowShowAsignaturasDNI(this, w);
			dialog.setVisible(true);
		} else if (e.getSource() == btnModify) {

		} else if (e.getSource() == btnDelete) {

		}
	}
}
