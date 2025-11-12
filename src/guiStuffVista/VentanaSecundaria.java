package guiStuffVista;

import java.awt.FlowLayout;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;

public class VentanaSecundaria extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldText;
	private JButton btnSend;

	public VentanaSecundaria(JFrame parent) {
		super(parent, true);
		setTitle("Segunda Ventana");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setLayout(new FlowLayout());

		textFieldText = new JTextField();
		textFieldText.setBounds(157, 73, 96, 19);
		getContentPane().add(textFieldText);
		textFieldText.setColumns(10);

		btnSend = new JButton("Enviar");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSend.setBounds(168, 135, 85, 21);
		getContentPane().add(btnSend);
		btnSend.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSend) {
			String texto = textFieldText.getText();
			try {
				VentanaTres dialog = new VentanaTres(VentanaSecundaria.this, texto);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dispose();
				dialog.setVisible(true);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

}
