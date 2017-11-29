package Bruno;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ListModel;

import Alberto.GUI;
import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;

public class Cliente {

	private static File_Scanner scanner = new File_Scanner();
	private static AntiSpamFilterAutomaticConfiguration a = new AntiSpamFilterAutomaticConfiguration();
	
	private static GUI gui = new GUI();
	private static ArrayList<Rule> rules_cf;
	private static ArrayList<String[]> spam;
	private static ArrayList<String[]> ham;
	
	private static void get_rules_lists() throws FileNotFoundException{
		rules_cf = scanner.Scan_Rules_cf("C://Users/bruno/Desktop/rules.cf");
		spam = scanner.Scan_Spam_Ham("C://Users/bruno/Desktop/spam.log.txt");
		ham = scanner.Scan_Spam_Ham("C://Users/bruno/Desktop/ham.log");
	}
	
	//poe  alista das rules.cf na jlist 
	private void list_to_model(ArrayList<Rule> list) throws FileNotFoundException{
		get_rules_lists();		
		list = rules_cf;
		for(int i = 0; i < list.size(); i++ ){
			gui.model1.addElement(list.get(i).getName());
		
		}
		
	}
	
	
	//main ainda não terminado
	public static void main(String[] arg) throws IOException  {
		Cliente c = new Cliente();
		c.list_to_model(rules_cf);
//		list_to_model(rules_cf);
		
		
	}
	
}
