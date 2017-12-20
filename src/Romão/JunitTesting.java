package Romão;

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

import Alberto.GUI;
import Bruno.Cliente;
import Bruno.File_Scanner;
import Bruno.Rule;
import Daniel.Avaliador;

public class JunitTesting {
	
	@Test
	public void avaliartesttrue() {
		ArrayList<Rule> rules = File_Scanner.Scan_Rules_cf("teste_file.cf");
		ArrayList<String[]> fileReport = File_Scanner.Scan_Spam_or_Ham("spam.log");
		boolean spam = true;
		Avaliador avaltest = new Avaliador(rules, fileReport, spam);
		int output = avaltest.avaliar();
		System.out.println("negative cima: " + avaltest.negative);
		System.out.println("positive cima: " + avaltest.positive);
			assertEquals(avaltest.negative, output);
			
	}
	@Test
	public void avaliartestfalse() {
		ArrayList<Rule> rules = File_Scanner.Scan_Rules_cf("teste_file.cf");
		ArrayList<String[]> fileReport = File_Scanner.Scan_Spam_or_Ham("spam.log");
		boolean spam = false;
		Avaliador avaltest = new Avaliador(rules, fileReport, spam);
		int output = avaltest.avaliar();
		System.out.println("negative baixo: " + avaltest.negative);
		System.out.println("positive baixo: " + avaltest.positive);
			assertEquals(avaltest.positive, output);	
	}
	

	
	@Test
	public void createRulesList_Test_Null(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro rules");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//		while(c.gui.getRulespath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		ArrayList<Rule> rules = c.createRulesList();
		assertNull(rules);
	}

	@Test
	public void createRulesList_Test_NotNull(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro rules");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//			while(c.gui.getRulespath() == null){
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
		ArrayList<Rule> rules = c.createRulesList();
		assertNotNull(rules);
	}
	
	@Test
	public void get_ham_list_test_NotNull(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro ham");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//			while(c.gui.getHampath() == null){
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
			try {
				c.get_ham_list();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertNotNull(c.getHam());
	}
	
	@Test
	public void get_ham_list_test_Null(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro ham");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//			while(c.gui.getHampath() == null){
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
			try {
				c.get_ham_list();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertNull(c.getHam());
	}
	
	@Test
	public void get_spam_list_test_Null(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro spam");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//			while(c.gui.getSpampath() == null){
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
			try {
				c.get_spam_list();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		assertNull(c.getSpam());
	}
	
	@Test
	public void get_spam_list_test_NotNull(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro spam");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//			while(c.gui.getSpampath() == null){
//				try {
//					Thread.sleep(10);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//		}
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
		assertEquals("0.0", c.gui.getTextField_7().getText());
	}
	
	@Test
	public void display_peso_test_2(){
		Cliente c = new Cliente();
		ArrayList<Rule> rules_array = File_Scanner.Scan_Rules_cf("rules.cf");
		c.display_peso(rules_array, 1);
		assertEquals("0.1", c.gui.getTextField_7().getText());
	}
	
	@Test
	public void change_peso_test(){
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
		c.gui.setTextField("rules.cf");
		c.get_rules_list();
//		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro rules");
//		while(c.gui.getRulespath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		ArrayList<Rule> rules = c.createRulesList();
		c.change_peso(1, 0.1);
		assertEquals(0.1, c.getRules_cf().get(1).getValor(), 0.0);
	}
	
	@Test
	public void change_peso_test_fail(){
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
		c.get_rules_list();
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha o ficheiro rules");
//		while(c.gui.getRulespath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		ArrayList<Rule> rules = c.createRulesList();
		c.change_peso(1, 0.2);
		assertEquals(0.1, c.getRules_cf().get(1).getValor(), 0.0);
	}


	@Test
	public void start_avaliador_test_true(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha os 3 ficheiros");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//		while(c.gui.getRulespath() == null || c.gui.getSpampath() == null || c.gui.getHampath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try { 
			c.get_spam_list();
			c.get_ham_list();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.get_rules_list();
		c.start_Avaliador();
		assertEquals(239, c.falsos_pos_man);
		assertEquals(0, c.falsos_neg_man);
	}
	
	@Test
	public void start_avaliador_test_false(){
			JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Ponha os 3 ficheiros");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
//		while(c.gui.getRulespath() == null || c.gui.getSpampath() == null || c.gui.getHampath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		try {
			c.get_spam_list();
			c.get_ham_list();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.get_rules_list();
		c.start_Avaliador();
		assertEquals(300, c.falsos_pos_man);
		assertEquals(2, c.falsos_neg_man);
	}
	
	
	@Test
	public void load_conf_test_not_null(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Faça load de uma configuração");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
		c.gui.setLoadpath("llo");
//		while(c.gui.getLoadpath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		c.load_conf();
		assertNotNull(c.rules_cf);
	}
	
	@Test
	public void load_conf_test_null(){
		JOptionPane panel = new JOptionPane();
//		panel.showMessageDialog(null, "Faça load de uma configuração");
		Cliente c = new Cliente();
		c.gui.setRulespath("rules.cf");
		c.gui.setHampath("ham.log");
		c.gui.setSpampath("spam.log");
		c.gui.setLoadpath("llo");
//		while(c.gui.getLoadpath() == null){
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		c.load_conf();
		assertNull(c.rules_cf);
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
	public void decifer_results_test_null(){
	File_Scanner scanner = new File_Scanner();
	try {
		assertNull(scanner.deciferResults("rules.cf"));
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
	public void serchBestConfig_tests_null(){
		File_Scanner scanner = new File_Scanner();
		try {
			assertNull(scanner.serchBestConfig());
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
			while(c.gui.getRulespath() == null){
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		c.save_conf();
	}
	
	@Test
	public void get_rulesauto_test_not_null(){
		Cliente c = new Cliente();
		assertNotNull(c.getRules_auto());
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
	
}
