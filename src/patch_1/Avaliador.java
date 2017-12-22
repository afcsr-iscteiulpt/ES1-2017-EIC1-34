package patch_1;

import java.util.ArrayList;

public class Avaliador {

	public ArrayList<Rule> rules;
	private ArrayList<String[]> log;

	public int positive;
	public int negative;
	public Boolean spam;
	
	/**
	 * Construtor do avaliador sem parametros
	 */
	public Avaliador() {
	}
	/**
	 * Construtor do avaliador
	 * @param rules
	 * @param fileReport
	 * @param spam
	 */
	public Avaliador(ArrayList<Rule> rules, ArrayList<String[]> fileReport, boolean spam) {
		replaceFields(rules, fileReport, spam);
	}

	/**
	 * Substitui os parametros para novas avaliacoes
	 * @param weigth
	 * @param fileReport
	 * @param spam
	 */
	public void replaceFields(ArrayList<Rule> rules, ArrayList<String[]> fileReport, boolean spam) {
		this.rules = rules;
		this.log = fileReport;
		this.spam = spam;
		positive = 0;
		negative = 0;
	}


	/**
	 * Este metodo avalia os falsos positivos e falsos negativos conforme se esta a avaliar spam ou nao
	 * 
	 * retorna negative se esta a avaliar spam
	 * retorna positive se esta a avaliar ham
	 * 
	 * @return negative
	 * @return positive
	 */
	public int avaliar() {
		for (int i = 0, k = 0; i < log.size(); i++, k = 0) {
			String [] rules_present = log.get(i);
			for (int j = 0; j < rules_present.length; j++) {
				for (int j2 = 0; j2 < rules.size(); j2++) {
					if(rules.get(j2).getName().equals(rules_present[j]))
						k += rules.get(j2).getValor();
				}
			}
			if (k >= 5) 
				positive++;
			else 
				negative++;
		}
		return spam ? negative : positive;
	}
	
}
