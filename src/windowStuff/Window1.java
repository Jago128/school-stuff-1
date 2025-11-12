package windowStuff;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Window1 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnAcceptar;
	private JLabel lblResult;

	public static void main(String[] args) {
		Window1 frame = new Window1();
		frame.setVisible(true);
	}

	public Window1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblMensaje = new JLabel("Bienvenidos!");
		lblMensaje.setForeground(new Color(0, 255, 255));
		lblMensaje.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblMensaje.setBounds(136, 39, 138, 59);
		contentPane.add(lblMensaje);

		btnAcceptar = new JButton("Aceptar");
		btnAcceptar.setBounds(158, 128, 82, 23);
		contentPane.add(btnAcceptar);
		btnAcceptar.addActionListener(this);

		lblResult = new JLabel("");
		lblResult.setBounds(10, 187, 424, 74);
		contentPane.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAcceptar) {
			lblResult.setText("Acceso permitido.");
		}
	}
}
