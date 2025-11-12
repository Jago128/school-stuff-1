package windowStuff;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Window2 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnSi, btnNo;
	private JLabel lblResult;

	public static void main(String[] args) {
		Window2 frame = new Window2();
		frame.setVisible(true);
	}

	public Window2() {
		setTitle("Window 2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblPregunta = new JLabel("¿Quieres contestar?");
		lblPregunta.setFont(new Font("Algerian", Font.BOLD, 13));
		lblPregunta.setBounds(89, 28, 155, 28);
		contentPane.add(lblPregunta);

		btnSi = new JButton("SI");
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSi.setBounds(34, 74, 89, 23);
		contentPane.add(btnSi);
		btnSi.addActionListener(this);

		btnNo = new JButton("NO");
		btnNo.setBounds(163, 74, 89, 23);
		contentPane.add(btnNo);
		btnNo.addActionListener(this);

		JButton btnQuizas = new JButton("Quizas");
		btnQuizas.setBounds(293, 74, 89, 23);
		contentPane.add(btnQuizas);
		btnQuizas.addActionListener(this);

		lblResult = new JLabel("");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBounds(21, 174, 403, 76);
		contentPane.add(lblResult);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSi) {
			lblResult.setText("Si voy a contestar");
		} else if (e.getSource() == btnNo) {
			lblResult.setText("No voy a contestar");
		} else {
			lblResult.setText("Quizas, quizas, quizas");
		}
	}
}
