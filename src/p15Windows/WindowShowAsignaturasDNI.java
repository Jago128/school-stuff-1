package p15Windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.*;

import p15Controller.WindowController;
import p15Model.Asignatura;

public class WindowShowAsignaturasDNI extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JButton btnShow;
	private JComboBox<String> comboBox;
	private WindowController w;
	private JTextField textFieldDNI;
	private JLabel lblResult;

	public WindowShowAsignaturasDNI(JFrame parent, WindowController w) {
		this.w = w;
		setBounds(100, 100, 370, 200);
		getContentPane().setLayout(null);

		comboBox = new JComboBox<>();
		comboBox.setBounds(22, 61, 159, 22);
		getContentPane().add(comboBox);

		btnShow = new JButton("Mostrar asignaturas");
		btnShow.setBounds(219, 61, 129, 23);
		getContentPane().add(btnShow);
		btnShow.addActionListener(this);

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(131, 30, 149, 20);
		getContentPane().add(textFieldDNI);
		textFieldDNI.setColumns(10);

		JLabel lblDNI = new JLabel("Introduce el DNI:");
		lblDNI.setBounds(37, 33, 89, 14);
		getContentPane().add(lblDNI);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(141, 94, 207, 52);
		getContentPane().add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnShow) {
			String dni = textFieldDNI.getText();
			Map<Integer, Asignatura> asigs = w.showAsignaturasDNI(dni);
			for (Asignatura a : asigs.values()) {
				comboBox.addItem(a.getNom());
			}
		}
	}
}