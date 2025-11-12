package windowStuff2Windows;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class Window2 extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JRadioButton rdbtnOption1, rdbtnOption2, rdbtnOption3, rdbtnOption4;
	private JButton btnCheck, btnSiguientePregunta;
	private JLabel lblCorrectCount, lblQuestion, lblAnswerValidation;
	private String nameSend;

	public Window2(JFrame window1, String name) {
		super(window1, true);
		nameSend = name;
		setBounds(100, 100, 529, 246);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblName = new JLabel("Hola, " + name);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setBounds(92, 11, 138, 26);
			contentPanel.add(lblName);
		}

		rdbtnOption1 = new JRadioButton("Opcion 1");
		rdbtnOption1.setBounds(74, 107, 109, 23);
		contentPanel.add(rdbtnOption1);

		rdbtnOption2 = new JRadioButton("Opcion 2");
		rdbtnOption2.setBounds(179, 107, 109, 23);
		contentPanel.add(rdbtnOption2);

		rdbtnOption3 = new JRadioButton("Opcion 3");
		rdbtnOption3.setBounds(74, 156, 109, 23);
		contentPanel.add(rdbtnOption3);

		rdbtnOption4 = new JRadioButton("Opcion 4");
		rdbtnOption4.setBounds(179, 156, 109, 23);
		contentPanel.add(rdbtnOption4);

		btnCheck = new JButton("Comprobar");
		btnCheck.setBounds(368, 107, 89, 23);
		contentPanel.add(btnCheck);

		lblAnswerValidation = new JLabel("");
		lblAnswerValidation.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnswerValidation.setBounds(263, 209, 270, 52);
		contentPanel.add(lblAnswerValidation);

		lblCorrectCount = new JLabel("Numero de respuestas correctas: 0");
		lblCorrectCount.setBounds(259, 5, 222, 38);
		contentPanel.add(lblCorrectCount);

		lblQuestion = new JLabel("[PH]");
		lblQuestion.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuestion.setBounds(29, 48, 457, 52);
		contentPanel.add(lblQuestion);

		btnSiguientePregunta = new JButton("Siguiente pregunta");
		btnSiguientePregunta.setBounds(313, 156, 144, 23);
		contentPanel.add(btnSiguientePregunta);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int corrects = 0, question = 1;
		boolean error = false;
		boolean answered = false;

		if (e.getSource() == btnCheck) {
			error = false;
			if (!rdbtnOption1.isSelected() && !rdbtnOption2.isSelected() && !rdbtnOption3.isSelected()
					&& !rdbtnOption4.isSelected()) {
				error = true;
				lblAnswerValidation.setText("No has elegido una opcion.");
			}

			if (answered) {
				lblAnswerValidation.setText("Ya has respondido la pregunta.");
			}

			if (!error && !answered) {
				switch (question) {
				case 1:
					if (rdbtnOption3.isSelected()) {
						corrects++;
						lblAnswerValidation.setText("La respuesta elegida es correcta.");
					} else {
						lblAnswerValidation
								.setText("La respuesta elegida es incorrecta. La opcion correcta es [PH]la opcion 3.");
					}
					answered = true;
					break;

				case 2:
					if (rdbtnOption4.isSelected()) {
						corrects++;
						lblAnswerValidation.setText("La respuesta elegida es correcta.");
					} else {
						lblAnswerValidation
								.setText("La respuesta elegida es incorrecta. La opcion correcta es [PH]la opcion 4.");
					}
					answered = true;
					break;

				case 3:
					if (rdbtnOption1.isSelected()) {
						corrects++;
						lblAnswerValidation.setText("La respuesta elegida es correcta.");
					} else {
						lblAnswerValidation
								.setText("La respuesta elegida es incorrecta. La opcion correcta es [PH]la opcion 1.");
					}
					answered = true;
					break;

				case 4:
					if (rdbtnOption2.isSelected()) {
						corrects++;
						lblAnswerValidation.setText("La respuesta elegida es correcta.");
					} else {
						lblAnswerValidation
								.setText("La respuesta elegida es incorrecta. La opcion correcta es [PH]la opcion 2.");
					}
					answered = true;
					Window3 dialog = new Window3(Window2.this, nameSend, corrects);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
					break;
				}
				lblCorrectCount.setText("El numero de respuestas correctas son: " + corrects);
			}
		}

		if (e.getSource() == btnSiguientePregunta) {
			if (answered) {
				question++;
				answered = false;
				switch (question) {
				case 2:
					lblQuestion.setText("[PH]");
					rdbtnOption1.setText("[PH] Opcion 1");
					rdbtnOption2.setText("[PH] Opcion 2");
					rdbtnOption3.setText("[PH] Opcion 3");
					rdbtnOption4.setText("[PH] Opcion 4");
					break;

				case 3:
					lblQuestion.setText("[PH]");
					rdbtnOption1.setText("[PH] Opcion 1");
					rdbtnOption2.setText("[PH] Opcion 2");
					rdbtnOption3.setText("[PH] Opcion 3");
					rdbtnOption4.setText("[PH] Opcion 4");
					break;

				case 4:
					lblQuestion.setText("[PH]");
					rdbtnOption1.setText("[PH] Opcion 1");
					rdbtnOption2.setText("[PH] Opcion 2");
					rdbtnOption3.setText("[PH] Opcion 3");
					rdbtnOption4.setText("[PH] Opcion 4");
					break;
				}
			} else {
				lblAnswerValidation
						.setText("No has respondido a la pregunta, pulsa el boton una vez respondido la pregunta.");
			}
		}
	}
}
