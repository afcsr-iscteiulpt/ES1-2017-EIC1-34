package Alberto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


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
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

import Bruno.Cliente;

import javax.swing.ListModel;

public class GUI{
	
	private JFrame frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public DefaultListModel<String> model1;
	public DefaultListModel<String> model2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	private int index;

	private String rulespath; 
	private String hampath;
	private String spampath;  		
	
	public GUI(Cliente c) {   
		
		frame = new JFrame("Spam Filter Configurator");
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 695, 690); 
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
		list.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e){
				textField_7.setText("");
				index = list.getSelectedIndex();
				c.display_peso(c.getRules_cf());
			}
		});
		
		
		JLabel lblValor = new JLabel("Peso:");
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		
		JButton btnGravar = new JButton("Gravar");
		btnGravar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index = list.getSelectedIndex();
				c.change_peso(index,  Double.parseDouble(textField_7.getText()));
				
			}
		});
		
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
		
		
//--------------------------------------------------------------------------------

		//PATH
		
		
		JButton btnNewButton = new JButton("Browse ");
		
		JButton button = new JButton("Browse ");
		
		JButton button_1 = new JButton("Browse ");
		

		
		btnNewButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser ruleschooser = new JFileChooser();
				  ruleschooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  ruleschooser.showOpenDialog(null);
				  textField.setText(ruleschooser.getSelectedFile().getAbsolutePath());
				  rulespath = textField_2.getText();
			  }
		});
		
		button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser hamchooser = new JFileChooser();
				  hamchooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  hamchooser.showOpenDialog(null);
				  textField_1.setText(hamchooser.getSelectedFile().getAbsolutePath());
				  hampath = textField_2.getText();
			  }
		});
		
		button_1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser pamchooser = new JFileChooser();
				  pamchooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				  pamchooser.showOpenDialog(null);
				  textField_2.setText(pamchooser.getSelectedFile().getAbsolutePath());
				  spampath = textField_2.getText();
			  }
		});
		
		JButton btnGravar_1 = new JButton("Gravar");
		
		
		// ORGANIZAÇÃO DO LAYOUT ----------------------------------------------------------
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
											.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 169, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(gravarConfigAUTO, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(gerarConfigAUTO, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
									.addGap(28))))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFalsosNegativos)
										.addComponent(lblFalsosPositivos)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnGravar, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
									.addGap(24)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(25)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(gravarConfigMANUAL, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addComponent(avaliarQualidadeMANUAL)))
										.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
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
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
									.addComponent(btnGravar_1, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
									.addGap(59))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 269, Short.MAX_VALUE)))))
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
						.addComponent(button)
						.addComponent(btnGravar_1, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPathSpamlog)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(avaliarQualidadeMANUAL)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(gravarConfigMANUAL)
								.addComponent(btnGravar))
							.addGap(44)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosPositivos)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosNegativos)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(gerarConfigAUTO)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(gravarConfigAUTO)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_1)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
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

	public void setTextField_7(String text) {
		textField_7.setText(text);
	}

	
	public int getIndex() {
		return index;
	}

	public void setIndex(int i) {
		this.index = i;
	}

	public String getRulespath() {
		return rulespath;
	}

	public void setRulespath(String rulespath) {
		this.rulespath = rulespath;
	}

	public String getHampath() {
		return hampath;
	}

	public void setHampath(String hampath) {
		this.hampath = hampath;
	}

	public String getSpampath() {
		return spampath;
	}

	public void setSpampath(String spampath) {
		this.spampath = spampath;

	}
}
