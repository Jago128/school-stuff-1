package windowStuff2Windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Window3 extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private JButton btnExit;

	public Window3(JDialog window2, String name, int corrects) {
		super(window2, true);
		setBounds(100, 100, 333, 195);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblGreet = new JLabel("Gracias por jugar, " + name);
		lblGreet.setHorizontalAlignment(SwingConstants.CENTER);
		lblGreet.setBounds(66, 22, 167, 30);
		contentPanel.add(lblGreet);

		JLabel lblCorrects = new JLabel("Este es el numero de respuestas correctas: " + corrects);
		lblCorrects.setBounds(47, 52, 227, 30);
		contentPanel.add(lblCorrects);

		btnExit = new JButton("Salir");
		btnExit.setBounds(106, 93, 89, 23);
		contentPanel.add(btnExit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnExit) {
			dispose();
		}
	}
}
