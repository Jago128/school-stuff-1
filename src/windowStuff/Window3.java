package windowStuff;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Window3 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnSi, btnNo, btnQuizas;
	private JLabel lblChoiceResult;

	public static void main(String[] args) {
		Window3 frame = new Window3();
		frame.setVisible(true);
	}

	public Window3() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\ltrabado\\Desktop\\descarga.jfif"));
		setTitle("Mi quinta Ventana");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitle = new JLabel("Aplicación de DAMi");
		lblTitle.setForeground(new Color(0, 128, 255));
		lblTitle.setFont(new Font("Source Serif Pro Light", Font.BOLD | Font.ITALIC, 17));
		lblTitle.setBounds(120, 25, 190, 50);
		contentPane.add(lblTitle);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(71, 108, 46, 14);
		contentPane.add(lblUser);

		JLabel lblPass = new JLabel("Password");
		lblPass.setBounds(71, 133, 96, 17);
		contentPane.add(lblPass);

		textField = new JTextField();
		textField.setBounds(188, 105, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(188, 130, 86, 20);
		contentPane.add(passwordField);

		btnSi = new JButton("SI");
		btnSi.setForeground(new Color(0, 128, 0));

		btnSi.setBounds(20, 186, 89, 23);
		contentPane.add(btnSi);

		btnNo = new JButton("NO");
		btnNo.setForeground(new Color(255, 0, 128));
		btnNo.setBounds(157, 186, 89, 23);
		contentPane.add(btnNo);

		btnQuizas = new JButton("Quizas");
		btnQuizas.setForeground(new Color(255, 128, 0));
		btnQuizas.setBounds(297, 186, 89, 23);
		contentPane.add(btnQuizas);

		lblChoiceResult = new JLabel("");
		lblChoiceResult.setBounds(48, 220, 338, 30);
		contentPane.add(lblChoiceResult);

		btnSi.addActionListener(this);
		btnNo.addActionListener(this);
		btnQuizas.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSi) {
			lblChoiceResult.setText("Bienvenido " + textField.getText());
		} else if (e.getSource() == btnNo) {
			if (new String(passwordField.getPassword()).equals("1234")) {
				lblChoiceResult.setText("ok");
			} else {
				lblChoiceResult.setText("NO ok");
			}
		} else if (e.getSource() == btnQuizas) {
			lblChoiceResult.setText("QUIZAS, QUIZAS, QUIZAS");
		}
	}
}
