package windowStuff2Windows;

import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Window1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldName;
	private JButton btnContinue, btnSalir;
	
	public Window1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 247);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Introduce tu nombre o apodo:");
		lblName.setBounds(140, 38, 153, 35);
		contentPane.add(lblName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(116, 73, 197, 28);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		btnContinue = new JButton("Siguiente");
		btnContinue.setBounds(116, 120, 89, 23);
		contentPane.add(btnContinue);
		btnContinue.addActionListener(this);
		
		btnSalir = new JButton("Salir");
		btnSalir.setBounds(225, 120, 89, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnSalir) {
			dispose();
		} else {
			String name=textFieldName.getText();
			Window2 dialog = new Window2(Window1.this, name);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		}
	}
}
