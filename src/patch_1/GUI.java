package patch_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.border.LineBorder;

public class GUI{
	
	private JFrame frame;
	private JPanel lblFalsosPositivosAuto;
	private JTextField tfRules;
	private JTextField tfHam;
	private JTextField tfSpam;
	private DefaultListModel<String> model1;
	private DefaultListModel<String> model2;
	private JTextField tfFalsosPositivosManual;
	private JTextField tfFalsosNegativosManual;
	private JTextField tfFalsosPositivosAuto;
	private JTextField tfFalsosNegativosAuto;
	private JTextField tfPesoManual;

	private int index;

	private String rulespath; 
	private String hampath; 
	private String spampath; 
	private String Loadpath;
	private JTextField tfLoadManual;
	
	public GUI(Cliente c) {    
		
		frame = new JFrame("Spam Filter Configurator");
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 692, 670); 
		lblFalsosPositivosAuto = new JPanel();
		lblFalsosPositivosAuto.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(lblFalsosPositivosAuto);
		
		JLabel lblPathRules = new JLabel("Path rules.cf");		
		tfRules = new JTextField();
		tfRules.setColumns(10);
		
		JLabel lblPathHamlog = new JLabel("Path ham.log");
		tfHam = new JTextField();
		tfHam.setColumns(10);
		
		JLabel lblPathSpamlog = new JLabel("Path spam.log");
		tfSpam = new JTextField();
		tfSpam.setColumns(10);
		 
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
				tfPesoManual.setText("");
				index = list.getSelectedIndex();
				c.display_peso(c.getRules_cf(), index);
			}
		});
		
		 
		JLabel lblValor = new JLabel("Peso:");
		tfPesoManual = new JTextField();
		tfPesoManual.setColumns(10);
		
		JButton btnGravarManual = new JButton("Gravar");
		btnGravarManual.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index = list.getSelectedIndex();
				c.change_peso(index,  Double.parseDouble(tfPesoManual.getText()));
		
				
			}
		});
		
		JButton avaliarQualidadeMANUAL = new JButton("Avaliar Qualidade");
		
		 avaliarQualidadeMANUAL.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  c.start_Avaliador();
				  
			  }
		});
		
		
		JButton gravarConfigMANUAL = new JButton("Gravar Configuração");
		gravarConfigMANUAL.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				c.save_conf();
			}
			
		});
		
		JLabel lblFalsosPositivosManual = new JLabel("Falsos Positivos");
		tfFalsosPositivosManual = new JTextField();
		tfFalsosPositivosManual.setBackground(new Color(152, 251, 152));
		tfFalsosPositivosManual.setColumns(10);
		
		JLabel lblFalsosNegativosManual = new JLabel("Falsos Negativos");
		tfFalsosNegativosManual = new JTextField();
		tfFalsosNegativosManual.setBackground(new Color(255, 182, 193));
		tfFalsosNegativosManual.setColumns(10);

		JButton btnLoadManual = new JButton("Browse ");
		btnLoadManual.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) { 
				  JFileChooser ruleschooser = new JFileChooser();
				  ruleschooser.showOpenDialog(null);
				  tfLoadManual.setText(ruleschooser.getSelectedFile().getAbsolutePath());
				  Loadpath = tfLoadManual.getText();
				  Loadpath = Loadpath.replaceAll("\\\\","/" );
				  Loadpath = Loadpath.replaceFirst("/","//" );
			  
				  try {
					  	c.load_conf();
						c.rules_cf_to_Jlist();
					} catch (FileNotFoundException e1) {}
				  
			  }
		});
		
		
		JLabel lblLoadManual = new JLabel("Load:");
		
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
		
		gerarConfigAUTO.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  c.start_AutoConfig();
			  }
		});
		
		JButton gravarConfigAUTO = new JButton("Gravar Configuração");
		gravarConfigAUTO.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				c.save_conf();
			}
			
		});
		
		JLabel label = new JLabel("Falsos Positivos");
		tfFalsosPositivosAuto = new JTextField();
		tfFalsosPositivosAuto.setColumns(10);
		tfFalsosPositivosAuto.setBackground(new Color(152, 251, 152));
		
		JLabel lblFalsosNegativosAuto = new JLabel("Falsos Negativos");
		tfFalsosNegativosAuto = new JTextField();
		tfFalsosNegativosAuto.setColumns(10);
		tfFalsosNegativosAuto.setBackground(new Color(255, 182, 193));
		
		
//--------------------------------------------------------------------------------

		//PATH
		
		
		JButton btnNewButton = new JButton("Browse ");
		
		JButton button = new JButton("Browse ");
		
		JButton button_1 = new JButton("Browse ");
		

		
		btnNewButton.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser ruleschooser = new JFileChooser();
				  ruleschooser.showOpenDialog(null);
				  tfRules.setText(ruleschooser.getSelectedFile().getAbsolutePath());
				  rulespath = tfRules.getText();
				  rulespath = rulespath.replaceAll("\\\\","/" );
				  rulespath = rulespath.replaceFirst("/","//" );
			  
				  try {
						c.get_rules_list();
						c.createRulesAuto();
						c.rules_cf_to_Jlist();
					} catch (FileNotFoundException e1) {}
				  
			  }
		});
		
		button.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser hamchooser = new JFileChooser();
				  hamchooser.showOpenDialog(null);
				  tfHam.setText(hamchooser.getSelectedFile().getAbsolutePath());
				  hampath = tfHam.getText();
				  hampath = hampath.replaceAll("\\\\","/" );
				  hampath = hampath.replaceFirst("/","//" );
			
				  try {
						c.get_ham_list();
					} catch (FileNotFoundException e1) {}
				  
			  }
		});
		
		button_1.addActionListener(new ActionListener() { 
			  public void actionPerformed(ActionEvent e) { 
				  JFileChooser pamchooser = new JFileChooser();
				  pamchooser.showOpenDialog(null);
				  tfSpam.setText(pamchooser.getSelectedFile().getAbsolutePath());
				  spampath = tfSpam.getText();
				  spampath = spampath.replaceAll("\\\\","/" );
				  spampath = spampath.replaceFirst("/","//" );
				  
				  try {
						c.get_spam_list();
					} catch (FileNotFoundException e1) {}
				  
			  }
		});
		
		tfLoadManual = new JTextField();
		tfLoadManual.setColumns(10);
		
		
		
//>>>>>>> branch 'master' of https://github.com/afcsr-iscteiulpt/ES1-2017-EIC1-34.git
		
		// ORGANIZAÇÃO DO LAYOUT ----------------------------------------------------------
		
		GroupLayout gl_lblFalsosPositivosAuto = new GroupLayout(lblFalsosPositivosAuto);
		gl_lblFalsosPositivosAuto.setHorizontalGroup(
			gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
										.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFalsosNegativosAuto, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
									.addGap(23)
									.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.TRAILING)
										.addComponent(tfFalsosNegativosAuto, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFalsosPositivosAuto, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_lblFalsosPositivosAuto.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 166, Short.MAX_VALUE)
									.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.TRAILING)
										.addComponent(gerarConfigAUTO, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
										.addComponent(gravarConfigAUTO, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE))
									.addGap(30))))
						.addComponent(separator, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
						.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
										.addComponent(lblFalsosNegativosManual)
										.addComponent(lblFalsosPositivosManual)
										.addComponent(tfPesoManual, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnGravarManual, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
									.addGap(24)
									.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
										.addComponent(tfFalsosPositivosManual, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addComponent(tfFalsosNegativosManual, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
											.addGap(25)
											.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.TRAILING)
												.addComponent(gravarConfigMANUAL, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
												.addComponent(avaliarQualidadeMANUAL)))))
								.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
									.addGap(26)
									.addComponent(lblValor, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
									.addGap(40)
									.addComponent(lblLoadManual, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(tfLoadManual, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnLoadManual, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)))
							.addGap(22))
						.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
						.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPathRules)
								.addComponent(lblPathHamlog, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPathSpamlog, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
							.addGap(26)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING, false)
								.addComponent(tfRules)
								.addComponent(tfHam)
								.addComponent(tfSpam, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
								.addComponent(button, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
								.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 266, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_lblFalsosPositivosAuto.setVerticalGroup(
			gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPathRules)
						.addComponent(tfRules, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPathHamlog)
						.addComponent(tfHam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPathSpamlog)
						.addComponent(tfSpam, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(button_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
							.addComponent(lblValor)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
								.addComponent(avaliarQualidadeMANUAL)
								.addComponent(tfPesoManual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGravarManual)
								.addComponent(gravarConfigMANUAL))
							.addGap(18)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosPositivosManual)
								.addComponent(tfFalsosPositivosManual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosNegativosManual)
								.addComponent(tfFalsosNegativosManual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblLoadManual)
							.addComponent(tfLoadManual, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnLoadManual)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
							.addGap(75)
							.addComponent(gerarConfigAUTO)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(gravarConfigAUTO)
							.addGap(33)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
								.addComponent(label)
								.addComponent(tfFalsosPositivosAuto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_lblFalsosPositivosAuto.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblFalsosNegativosAuto)
								.addComponent(tfFalsosNegativosAuto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_lblFalsosPositivosAuto.createSequentialGroup()
							.addGap(18)
							.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 218, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
	
		lblFalsosPositivosAuto.setLayout(gl_lblFalsosPositivosAuto);
	}

	//--------------------------------------------------------------------------------	
	
	public JTextField getTextField() {
		return tfRules;
	}

	public void setTextField(String X) {
		this.tfRules.setText(X);
	}

	public JTextField getTextField_1() {
		return tfHam;
	}

	public void setTextField_1(JTextField textField_1) {
		this.tfHam = textField_1;
	}

	public JTextField getTextField_2() {
		return tfSpam;
	}

	public void setTextField_2(JTextField textField_2) {
		this.tfSpam = textField_2;
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
		return tfFalsosPositivosManual;
	}

	public void setTextField_3(String text) {
		tfFalsosPositivosManual.setText(text);
	}

	public JTextField getTextField_4() {
		return tfFalsosNegativosManual;
	}

	public void setTextField_4(String text) {
		tfFalsosNegativosManual.setText(text);
	}

	public JTextField getTextField_5() {
		return tfFalsosPositivosAuto;
	}

	public void setTextField_5(String text) {
		this.tfFalsosPositivosAuto.setText(text);
	}

	public JTextField getTextField_6() {
		return tfFalsosNegativosAuto;
	}

	public void setTextField_6(String text) {
		this.tfFalsosNegativosAuto.setText(text);
	}

	public JTextField getTextField_7() {
		return tfPesoManual;
	}

	public void setTextField_7(String text) {
		tfPesoManual.setText(text);
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
	
	public String getLoadpath() {
		return Loadpath;
	}

	public void setLoadpath(String loadpath) {
		this.Loadpath = loadpath;
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
