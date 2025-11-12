package windowStuff;

import java.awt.event.*;

import javax.swing.*;

public class Window5 extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JButton btnTest;

	public static void main(String[] args) {
		Window5 frame = new Window5();
		frame.setVisible(true);
	}

	public Window5() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnTest = new JButton("Test");
		btnTest.setBounds(173, 114, 89, 23);
		contentPane.add(btnTest);
		btnTest.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnTest) {
			JOptionPane.showMessageDialog(contentPane, "Prueba de Cuadros de Diálogo", "Cuadro de Diálogo Mensaje",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
