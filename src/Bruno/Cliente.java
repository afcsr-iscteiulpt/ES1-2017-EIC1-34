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
	
	private GUI gui = new GUI(this);
	private static ArrayList<Rule> rules_cf;
	private static ArrayList<String[]> spam;
	private static ArrayList<String[]> ham;
	
	private void get_rules_lists() throws FileNotFoundException{
		rules_cf = scanner.Scan_Rules_cf(gui.getSpampath());
//		rules_cf = scanner.Scan_Rules_cf("C://Users/bruno/Desktop/rules.cf");
//		spam = scanner.Scan_Spam_Ham("C://Users/bruno/Desktop/spam.log.txt");
//		ham = scanner.Scan_Spam_Ham("C://Users/bruno/Desktop/ham.log");
	}
	
	//poe  alista das rules.cf na jlist 
	private void rules_cf_to_Jlist(ArrayList<Rule> list) throws FileNotFoundException{
		for(int i = 0; i < list.size(); i++ ){
			gui.model1.addElement(list.get(i).getName());
		}
	}
	
	public void display_peso(ArrayList<Rule> list){
		gui.setTextField_7("" + rules_cf.get(gui.getIndex()).getValor());
	}
	
	public void change_peso(int index, double valor){
		rules_cf.get(index).setValor(valor);
	}
	
	//main ainda não terminado
	public static void main(String[] arg) throws IOException  {
		Cliente c = new Cliente();
		c.get_rules_lists();		
		c.rules_cf_to_Jlist(rules_cf);		
		
	}
	
	public ArrayList<Rule> getRules_cf(){
		return rules_cf;
	}
	
}
