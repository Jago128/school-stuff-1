package examLastWindows;

import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.*;

import examLastController.LoginController;
import examLastModel.Empleado;

public class LoginWindow extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField textFieldDNI;
	private JPasswordField passwordField;
	private JLabel lblRemainingAttempts, lblCheck;
	private JButton btnLogin;
	private JPanel contentPane;
	private LoginController cont;
	private int attempts;

	public LoginWindow() {
		this.cont = new LoginController();
		setTitle("Muebles Tartanga: Inicio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDNI = new JLabel("DNI:");
		lblDNI.setBounds(131, 54, 46, 14);
		contentPane.add(lblDNI);

		JLabel lblPassword = new JLabel("Contraseña:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(101, 107, 86, 14);
		contentPane.add(lblPassword);

		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(197, 51, 86, 20);
		contentPane.add(textFieldDNI);
		textFieldDNI.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(197, 104, 86, 20);
		contentPane.add(passwordField);

		Random r = new Random();
		this.attempts = r.nextInt(3) + 1;

		lblRemainingAttempts = new JLabel("" + attempts);
		lblRemainingAttempts.setBounds(292, 78, 46, 23);
		contentPane.add(lblRemainingAttempts);

		btnLogin = new JButton("Login");
		btnLogin.setBounds(160, 150, 89, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		lblCheck = new JLabel("");
		lblCheck.setBounds(84, 201, 276, 38);
		contentPane.add(lblCheck);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			if (attempts == 0) {
				JOptionPane.showMessageDialog(this, "Te has quedado sin intentos.", "Sin intentos",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (cont.searchEmp(new Empleado(textFieldDNI.getText(), new String(passwordField.getPassword())))) {
					lblCheck.setText("Login correcto.");
					Empleado emp = cont.getEmpleado(textFieldDNI.getText());
					JOptionPane.showMessageDialog(this, "Has superado los 3 intentos.", "Inicio de sesión",
							JOptionPane.INFORMATION_MESSAGE);
					WindowVisualizar dialog = new WindowVisualizar(cont, emp);
					dialog.setVisible(true);
					this.dispose();
				} else {
					lblCheck.setText("Empelado no encontrado.");
					attempts--;
					lblRemainingAttempts.setText("" + attempts);
					JOptionPane.showMessageDialog(this, attempts, "Intentos de inicio de sesión disponibles:",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
}
