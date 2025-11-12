package windowStuff;

import java.awt.event.*;

import javax.swing.*;

public class Window8 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JLabel lblChoices;
	private JButton btnDialog;

	public static void main(String[] args) {
		Window8 frame = new Window8();
		frame.setVisible(true);
	}

	public Window8() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblChoices = new JLabel("No se ha elegido una opcion");
		lblChoices.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoices.setBounds(105, 43, 225, 59);
		contentPane.add(lblChoices);

		btnDialog = new JButton("Click");
		btnDialog.setBounds(172, 148, 89, 23);
		contentPane.add(btnDialog);
		btnDialog.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] options = { "1AS3", "2AS3", "1DW3", "2DW3", "1SM2", "2SM2" };
		if (e.getSource() == btnDialog) {
			int choice = JOptionPane.showOptionDialog(contentPane, "Prueba de Cuadros de Diálogo",
					"Cuadro de Diálogo con opciones personalizadas", JOptionPane.DEFAULT_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			if (choice != JOptionPane.CLOSED_OPTION) {
				lblChoices.setText("Se ha elegido la opcion " + options[choice]);
			} else {
				lblChoices.setText("Error, no se ha elegido un valor valido.");
			}
		}
	}
}
