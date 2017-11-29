package Alberto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;
import javax.swing.ListModel;

public class GUI{
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public DefaultListModel<String> model1;
	private DefaultListModel<String> model2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI gui = new GUI();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		
		frame = new JFrame("Spam Filter Configurator");
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 488, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Path rules.cf");		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblPathHamlog = new JLabel("Path ham.log");
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblPathSpamlog = new JLabel("Path spam.log");
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		//--------------------------------------------------------------------------------
		JSeparator separator = new JSeparator();
		//--------------------------------------------------------------------------------

		//MANUAL
		
		model1 = new DefaultListModel<>();
		JScrollPane scrollPane = new JScrollPane();
		JList<String> list = new JList<String>(model1);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane.setViewportView(list);
		
		
		JLabel lblValor = new JLabel("Peso:");
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JButton avaliarQualidadeMANUAL = new JButton("Avaliar Qualidade");
		
		JButton gravarConfigMANUAL = new JButton("Gravar Configuração");
		
		JLabel lblFalsosPositivos = new JLabel("Falsos Positivos");
		textField_3 = new JTextField();
		textField_3.setBackground(new Color(152, 251, 152));
		textField_3.setColumns(10);
		
		JLabel lblFalsosNegativos = new JLabel("Falsos Negativos");
		textField_4 = new JTextField();
		textField_4.setBackground(new Color(255, 182, 193));
		textField_4.setColumns(10);
		
		//--------------------------------------------------------------------------------
		JSeparator separator_1 = new JSeparator();
		//--------------------------------------------------------------------------------

		//AUTO
		
		model2 = new DefaultListModel<>();
		JScrollPane scrollPane_1 = new JScrollPane();
		JList<String> list_1 = new JList<String>(model2);
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		scrollPane_1.setViewportView(list_1);
		
		JButton gerarConfigAUTO = new JButton("Gerar Configuração");
		
		JButton gravarConfigAUTO = new JButton("Gravar Configuração");
		
		JLabel label = new JLabel("Falsos Positivos");
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBackground(new Color(152, 251, 152));
		
		JLabel label_1 = new JLabel("Falsos Negativos");
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBackground(new Color(255, 182, 193));
		
		JButton btnNewButton = new JButton("Browse ");
		
		JButton button = new JButton("Browse ");
		
		JButton button_1 = new JButton("Browse ");
		
		
		JButton btnGravar = new JButton("Gravar");
		
		
		
		
		
	
		
		// ORGANIZAÇÃO DO LAYOUT ----------------------------------------------------------
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel)
										.addComponent(lblPathHamlog, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPathSpamlog, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textField)
										.addComponent(textField_1)
										.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
								.addComponent(separator, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 30, Short.MAX_VALUE))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
													.addComponent(lblFalsosPositivos)
													.addComponent(lblFalsosNegativos))
												.addGap(18)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(25)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(gravarConfigMANUAL, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addComponent(avaliarQualidadeMANUAL))
											.addGap(23))
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(gravarConfigAUTO, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(gerarConfigAUTO, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
									.addGap(23))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPathHamlog)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPathSpamlog)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(avaliarQualidadeMANUAL)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(gravarConfigMANUAL))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnGravar)))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblFalsosPositivos)
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblFalsosNegativos)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(gerarConfigAUTO)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gravarConfigAUTO)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(9))))
		);
	
		contentPane.setLayout(gl_contentPane);
	}

	//--------------------------------------------------------------------------------	
	
	public JTextField getTextField() {
		return textField;
	}

	public void setTextField(JTextField textField) {
		this.textField = textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public void setTextField_1(JTextField textField_1) {
		this.textField_1 = textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public DefaultListModel<String> getModel1() {
		return model1;
	}

	public void setModel1(DefaultListModel<String> model1) {
		this.model1 = model1;
	}

	public DefaultListModel<String> getModel2() {
		return model2;
	}

	public void setModel2(DefaultListModel<String> model2) {
		this.model2 = model2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = textField_3;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public void setTextField_4(JTextField textField_4) {
		this.textField_4 = textField_4;
	}

	public JTextField getTextField_5() {
		return textField_5;
	}

	public void setTextField_5(JTextField textField_5) {
		this.textField_5 = textField_5;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public void setTextField_6(JTextField textField_6) {
		this.textField_6 = textField_6;
	}

	public JTextField getTextField_7() {
		return textField_7;
	}

	public void setTextField_7(JTextField textField_7) {
		this.textField_7 = textField_7;
	}
}
