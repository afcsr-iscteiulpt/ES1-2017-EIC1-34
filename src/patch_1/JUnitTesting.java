package patch_1;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.FileChooserUI;

import org.junit.Test;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import patch_1.GUI;
import patch_1.Cliente;
import patch_1.File_Scanner;
import patch_1.Rule;
import patch_1.Avaliador; 

public class JUnitTesting {

	@Test
	public void createRulesList_Test_NotNull(){
		Cliente c = new Cliente();
		c.get_gui().setRulespath("rules.cf");
		ArrayList<Rule> rules = c.createRulesList();
		assertNotNull(rules);
	}
	
	@Test
	public void get_ham_list_test_NotNull(){
		Cliente c = new Cliente();
		c.get_gui().setHampath("ham.log");
			try {
				c.get_ham_list();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertNotNull(c.getHam());
	}

	
	@Test
	public void get_spam_list_test_NotNull(){
		Cliente c = new Cliente();
		c.get_gui().setSpampath("spam.log");
			try {
				c.get_spam_list();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertNotNull(c.getSpam());
	}

	@Test
	public void display_peso_test(){
		Cliente c = new Cliente();
		ArrayList<Rule> rules_array = File_Scanner.Scan_Rules_cf("rules.cf");
		c.display_peso(rules_array, 1);
		assertEquals("0.0", c.get_gui().getTextField_7().getText());
	}
	
	@Test
	public void change_peso_test(){
		Cliente c = new Cliente();
		c.get_gui().setRulespath("rules.cf");
		c.get_gui().setTextField("rules.cf");
		c.get_rules_list();
		c.createRulesAuto();
		ArrayList<Rule> rules = c.createRulesList();
		c.change_peso(1, 0.1);
		assertEquals(0.1, c.getRules_cf().get(1).getValor(), 0.0);
	}


	@Test
	public void start_avaliador_test_true(){
		Cliente c = new Cliente();
		c.get_gui().setRulespath("rules.cf");
		c.get_gui().setHampath("ham.log");
		c.get_gui().setSpampath("spam.log");
		try { 
			c.get_spam_list();
			c.get_ham_list();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.get_rules_list();
		c.start_Avaliador();
		assertEquals(239, c.getFalsos_pos_man());
		assertEquals(0, c.getFalsos_neg_man());
	}
	
	
	@Test
	public void load_conf_test_not_null(){
		Cliente c = new Cliente();
		c.get_gui().setLoadpath("llo");
		c.load_conf();
		assertNotNull(c.getRules_cf());
	}
	
	
	@Test
	public void decifer_results_test(){
	File_Scanner scanner = new File_Scanner();
	try {
		assertNotNull(scanner.deciferResults("rules.cf"));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	
	@Test
	public void serchBestConfig_tests_not_null(){
		File_Scanner scanner = new File_Scanner();
		try {
			assertNotNull(scanner.serchBestConfig());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void save_conf_test(){
		JOptionPane panel = new JOptionPane();
		panel.showMessageDialog(null, "Ponha o ficheiro rules");
		Cliente c = new Cliente();
//		c.gui.setRulespath("rules.cf");
//		c.gui.setHampath("ham.log");
//		c.gui.setSpampath("spam.log");
//		c.gui.setLoadpath("llo");
			while(c.get_gui().getRulespath() == null){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {}
		}
		c.save_conf_manual();
		c.save_conf_auto();
	}
	
	@Test
	public void get_rulesauto_test_null(){
		Cliente c = new Cliente();
		assertNull(c.getRules_auto());
	}
	

	@Test
	public void main_test(){
		Cliente c = new Cliente();
			String[] lol = null;
			try {
				c.main(lol);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	@Test
	public void Scan_Saved_Conf_test(){
		File_Scanner s = new File_Scanner();
		s.Scan_Saved_Conf("llo");
		s.Scan_Saved_Conf("TesteCoverage/rules.cf");
	}
	
	@Test
	public void autoconfig_test(){
		Cliente c = new Cliente();
		c.get_gui().setRulespath("rules.cf");
		c.get_gui().setHampath("ham.log");
		c.get_gui().setSpampath("spam.log");
		c.get_gui().setLoadpath("llo");
		c.get_gui().setTextField("rules.cf");
		c.createRulesAuto();
		c.get_rules_list();
		try {
			c.get_ham_list();
			c.get_spam_list();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.start_AutoConfig();
	}
	
	@Test
	public void avaliar_test(){
		
		ArrayList<Rule> rules = File_Scanner.Scan_Rules_cf("rules.cf");
		
		Avaliador a = new Avaliador(rules, File_Scanner.Scan_Spam_or_Ham("spam.log"), true);
		assertEquals(File_Scanner.Scan_Spam_or_Ham("spam.log").size(), a.avaliar());
		
	}
		@Test
		public void avalir_test_(){
			ArrayList<Rule> rules = File_Scanner.Scan_Rules_cf("rules.cf");
			Avaliador a = new Avaliador(rules, File_Scanner.Scan_Spam_or_Ham("spam.log"), true);
		for (int i = 0; i < rules.size(); i++) {
			rules.get(i).setValor(6);
		}
		a.replaceFields(rules, File_Scanner.Scan_Spam_or_Ham("ham.log"), false);
		assertEquals(File_Scanner.Scan_Spam_or_Ham("ham.log").size(), a.avaliar());
	}
	
}
