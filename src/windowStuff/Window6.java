package windowStuff;

import java.awt.event.*;

import javax.swing.*;

public class Window6 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnChange;
	private JLabel lblAnon;

	public static void main(String[] args) {
		Window6 frame = new Window6();
		frame.setVisible(true);
	}

	public Window6() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblAnon = new JLabel("Anonimo");
		lblAnon.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnon.setBounds(37, 55, 358, 54);
		contentPane.add(lblAnon);

		btnChange = new JButton("Nombre");
		btnChange.setBounds(174, 124, 89, 23);
		contentPane.add(btnChange);
		btnChange.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnChange) {
			String name = (String) JOptionPane.showInputDialog(contentPane, "Introduzca su Nombre:",
					"Cuadro de Diálogo de Introducción de Datos", JOptionPane.QUESTION_MESSAGE, null, null,
					"Sin Nombre");
			if (name != null) {
				lblAnon.setText("Hola " + name);
			} else {
				lblAnon.setText("Error, no se ha introducido un valor valido");
			}
		}
	}
}
