package patch_1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import antiSpamFilter.AntiSpamFilterAutomaticConfiguration;
 
public class Cliente {

	private AntiSpamFilterAutomaticConfiguration antiSpamAutoConfigurator;
	private Avaliador avaliador;
	
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
	/**
	 * Método para guardar a Lista de regras nova
	 */
	public void get_rules_list() {
		rules_cf = createRulesList();
	}
	/**
	 * Método para guardar a lista de regras novas para a geração automatica
	 */
	public void createRulesAuto() {
		rules_auto = createRulesList();
	}
	
	/**
	 * metodo auxiliar para cria��o de uma lista de regras nova
	 * 
	 * @return ArrayList<Rule> 
	 */
	public ArrayList<Rule> createRulesList(){
		return File_Scanner.Scan_Rules_cf(gui.getRulespath());
	}
	/**
	 * Método auxiliar para fazer scan e receber a lista de ham
	 * @throws FileNotFoundException
	 */
	public void get_ham_list() throws FileNotFoundException{
		ham = File_Scanner.Scan_Spam_or_Ham(gui.getHampath());
	}
	/**
	 * Método auxiliar para fazer scan e receber a lista de spam
	 * @throws FileNotFoundException
	 */
	public void get_spam_list() throws FileNotFoundException{
		spam = File_Scanner.Scan_Spam_or_Ham(gui.getSpampath());
	} 
	/**
	 * Método auxiliar para fazer scan e receber a lista de regras
	 * @throws FileNotFoundException
	 */
	public void rules_cf_to_Jlist() throws FileNotFoundException{
		gui.getModel1().clear();
		for(int i = 0; i < rules_cf.size(); i++ ){
			gui.getModel1().addElement(rules_cf.get(i).toDisplay());
		}
		gui.getModel2().clear();
		for(int i = 0; i < rules_auto.size(); i++ ){
			gui.getModel2().addElement(rules_auto.get(i).toDisplay());
		}
	}
	/**
	 *  Mostrar peso da regra
	 * @param list
	 * @param index
	 */
	public void display_peso(ArrayList<Rule> list, int index){
//		System.out.println(index);
//		gui.setTextField_7("" + rules_cf.get(gui.getIndex()).getValor());
		gui.setTextField_7("" + list.get(index).getValor());
	}
	/**
	 * Mudar o peso da regra
	 * @param index
	 * @param valor
	 */
	public void change_peso(int index, double valor){
		try {
			rules_cf.get(index).setValor(valor);
			rules_cf_to_Jlist();
		} catch (FileNotFoundException e) {}
	}
	/**
	 * Começa a avaliar as regras
	 */
	public void start_Avaliador(){
		avaliador.replaceFields(rules_cf, spam, true);
		falsos_pos_man = avaliador.avaliar();
		
		avaliador.replaceFields(rules_cf, ham, false);
		falsos_neg_man = avaliador.avaliar();
		
		gui.setTextField_3("" + falsos_pos_man);
		gui.setTextField_4("" + falsos_neg_man);
		System.out.println("falsos_neg: " + falsos_neg_man);
		System.out.println("falsos_pos: " + falsos_pos_man);
		
	}
	
	/**
	 * faz a configura��o autom�tica
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
	
	/**
	 * salva a configura��o das regras num novo ficheiro
	 */
	public void save_conf_manual(){
		try {
			JFileChooser chooser = new JFileChooser();
			   int status = chooser.showSaveDialog(null);
			   
			   File file = chooser.getSelectedFile();
			   PrintWriter out = new PrintWriter(file);

			   if (status == JFileChooser.APPROVE_OPTION){ 
			      
				   for(int i = 0; i < rules_cf.size(); i++){
					   out.println(rules_cf.get(i).getName() + "	" + rules_cf.get(i).getValor());		           
				   }
			      out.close();
			   }  
			
		} catch (IOException e) {}
	}
	
	public void save_conf_auto(){
		try {
			JFileChooser chooser = new JFileChooser();
			   int status = chooser.showSaveDialog(null);
			   
			   File file = chooser.getSelectedFile();
			   PrintWriter out = new PrintWriter(file);

			   if (status == JFileChooser.APPROVE_OPTION){ 
			      
				   for(int i = 0; i < rules_auto.size(); i++){
					   out.println(rules_auto.get(i).getName() + "	" + rules_auto.get(i).getValor());		           
				   }
			      out.close();
			   }
			
		} catch (IOException e) {}
	}
	
	public void load_conf(){
		rules_cf = File_Scanner.Scan_Saved_Conf(gui.getLoadpath());
		rules_auto = rules_cf;
	}
	
	
	/**
	 * função que devolve as rules
	 * @return
	 */
	public ArrayList<Rule> getRules_cf(){
		return rules_cf;
	}
	 
	/**
	 * função que devolve o ham
	 * @return
	 */
	public ArrayList<String[]> getHam(){
		return ham;
	}
	/**
	 * função que devolve o spam
	 * @return
	 */
	public ArrayList<String[]> getSpam(){
		return spam;
	}
	/**
	 * função que devolve o rules
	 * @return
	 */
	public ArrayList<Rule> getRules_auto() {
		return rules_auto;
	}
	
	public GUI get_gui(){
		return gui;
	}
	
	public static void main(String[] arg) throws IOException  {
		Cliente c = new Cliente();
	}
	public int getFalsos_pos_man() {
		return falsos_pos_man;
	}
	public void setFalsos_pos_man(int falsos_pos_man) {
		this.falsos_pos_man = falsos_pos_man;
	}
	public int getFalsos_neg_man() {
		return falsos_neg_man;
	}
	public void setFalsos_neg_man(int falsos_neg_man) {
		this.falsos_neg_man = falsos_neg_man;
	}
}
