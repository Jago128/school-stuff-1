package guiStuffVista;

import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.*;

public class VentanaTres extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnExit;

	public VentanaTres(JDialog parent, String texto) {
		super(parent, true);
		setTitle("Tercera Ventana");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());

		JLabel lblText = new JLabel(texto);
		lblText.setBounds(55, 70, 330, 29);
		getContentPane().add(lblText);

		btnExit = new JButton("SALIR");
		btnExit.setBounds(172, 176, 85, 21);
		getContentPane().add(btnExit);
		btnExit.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			dispose();
		}
	}
}
