package Bruno;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import Alberto.GUI;
import Daniel.Avaliador;
import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;
 
public class Cliente {

	private AntiSpamFilterAutomaticConfiguration antiSpamAutoConfigurator;
	private  Avaliador avaliador;
	
	private GUI gui;
	
	private ArrayList<Rule> rules_cf;
	private ArrayList<Rule> rules_auto;
	private ArrayList<String[]> spam;
	private ArrayList<String[]> ham;
	
	private int falsos_pos_man;
	private int falsos_neg_man;
	
	/**
	 * inicializador do cliente
	 */
	public Cliente() {
		this.gui = new GUI(this);
		this.avaliador = new Avaliador();
		this.antiSpamAutoConfigurator = new AntiSpamFilterAutomaticConfiguration();
	}
	
	public void get_rules_list() {
		rules_cf = createRulesList();
	}
	
	public void createRulesAuto() {
		rules_auto = createRulesList();
	}
	
	/**
	 * metodo auxiliar para criação de uma lista de regras nova
	 * 
	 * @return ArrayList<Rule> 
	 */
	public ArrayList<Rule> createRulesList(){
		return File_Scanner.Scan_Rules_cf(gui.getRulespath());
	}

	public void get_ham_list() throws FileNotFoundException{
		ham = File_Scanner.Scan_Spam_or_Ham(gui.getHampath());
	}
	
	public void get_spam_list() throws FileNotFoundException{
		spam = File_Scanner.Scan_Spam_or_Ham(gui.getSpampath());
	}
	
	public void rules_cf_to_Jlist() throws FileNotFoundException{
		gui.model1.clear();
		for(int i = 0; i < rules_cf.size(); i++ ){
			gui.model1.addElement(rules_cf.get(i).getName());
		}
		gui.model2.clear();
		for(int i = 0; i < rules_auto.size(); i++ ){
			gui.model2.addElement(rules_auto.get(i).toDysplay());
		}
	}
	
	public void display_peso(ArrayList<Rule> list, int index){
//		System.out.println(index);
//		gui.setTextField_7("" + rules_cf.get(gui.getIndex()).getValor());
		gui.setTextField_7("" + list.get(index).getValor());
	}
	
	public void change_peso(int index, double valor){
		rules_cf.get(index).setValor(valor);
	}
	
	public void start_Avaliador(){
		avaliador.replaceFields(rules_cf, spam, true);
		falsos_pos_man = avaliador.avaliar();
		
		avaliador.replaceFields(rules_cf, ham, false);
		falsos_neg_man = avaliador.avaliar();
		
		gui.setTextField_3("" + falsos_pos_man);
		gui.setTextField_4("" + falsos_neg_man);
		
	}
	
	/**
	 * faz a configuração automática
	 */
	public void start_AutoConfig() {
		try {
			antiSpamAutoConfigurator.execute(this);
			
			rules_auto = File_Scanner.deciferResults(gui.getRulespath());
			
			double[] d = File_Scanner.serchBestConfig();
			gui.setTextField_5("" + d[0]);
			gui.setTextField_6("" + d[1]);
			rules_cf_to_Jlist();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Rule> getRules_cf(){
		return rules_cf;
	}
	
	public ArrayList<String[]> getHam(){
		return ham;
	}
	
	public ArrayList<String[]> getSpam(){
		return spam;
	}
	
	public ArrayList<Rule> getRules_auto() {
		return rules_auto;
	}
	
	public static void main(String[] arg) throws IOException  {
		Cliente c = new Cliente();
		c.getHam();
	}
}
