package examLastWindows;

import java.awt.event.*;

import javax.swing.*;

import examLastController.LoginController;
import examLastModel.*;

import java.util.*;

public class WindowVisualizar extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;

	private LoginController cont;
	private JLabel lblDNI;
	private JTextField textFieldNewPrice;
	private JComboBox<String> comboBoxMuebles;
	private JButton btnUpdate;

	public WindowVisualizar(LoginController cont, Empleado emp) {
		this.cont = cont;

		setTitle("Muebles Tartanga: Visualizar");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		JLabel lblTitleish = new JLabel("Ventas del empleado:");
		lblTitleish.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleish.setBounds(96, 11, 129, 28);
		getContentPane().add(lblTitleish);

		lblDNI = new JLabel(emp.getDni());
		lblDNI.setHorizontalAlignment(SwingConstants.CENTER);
		lblDNI.setBounds(235, 11, 94, 28);
		getContentPane().add(lblDNI);

		comboBoxMuebles = new JComboBox<String>();
		comboBoxMuebles.setBounds(121, 62, 170, 22);
		getContentPane().add(comboBoxMuebles);
		comboBoxMuebles.setSelectedIndex(-1);

		loadMuebles();

		JLabel lblNewPrice = new JLabel("Nuevo precio:");
		lblNewPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewPrice.setBounds(41, 153, 89, 20);
		getContentPane().add(lblNewPrice);

		textFieldNewPrice = new JTextField();
		textFieldNewPrice.setBounds(140, 153, 112, 20);
		getContentPane().add(textFieldNewPrice);
		textFieldNewPrice.setColumns(10);

		btnUpdate = new JButton("Actualizar");
		btnUpdate.setBounds(262, 152, 112, 23);
		getContentPane().add(btnUpdate);
		btnUpdate.addActionListener(this);

	}

	public void loadMuebles() {
		Map<Integer, Mueble> mu = cont.showMuebles();

		comboBoxMuebles.removeAllItems();
		if (!mu.isEmpty()) {
			for (Mueble m : mu.values()) {
				comboBoxMuebles.addItem(m.getId() + "-" + m.getNombre() + " - " + m.getPrecio());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] partes = comboBoxMuebles.getItemAt(comboBoxMuebles.getSelectedIndex()).split("-");
		if (e.getSource() == btnUpdate) {
			if (cont.updatePriceMueble(Double.parseDouble(textFieldNewPrice.getText()), Integer.parseInt(partes[0]))) {
				comboBoxMuebles.setSelectedIndex(-1);
				loadMuebles();
				JOptionPane.showMessageDialog(this, "El precio ha sido actualizado correctamente.", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(this, "El precio no ha podido actualizarse.", "Info",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
