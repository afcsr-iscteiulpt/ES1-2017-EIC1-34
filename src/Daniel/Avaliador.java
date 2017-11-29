package Daniel;

import java.util.ArrayList;
import java.util.Scanner;

public class Avaliador {
	
	private ArrayList<Integer> weight;
	private ArrayList<String> rules;
	private ArrayList<String> fileReport;
	
	private int positive;
	private int negative;
	private Boolean spam;
	
	public Avaliador(ArrayList<Integer> weigth, ArrayList<String> fileReport, String rules_path, boolean spam) {
		lookupRules(rules_path);
		replaceFields(weigth, fileReport, spam);
	}
	
	/**
	 * Substitui os parâmetros para novas avaliações
	 * @param weigth
	 * @param fileReport
	 * @param spam
	 */
	private void replaceFields(ArrayList<Integer> weigth, ArrayList<String> fileReport, boolean spam) {
		this.weight = weigth;
		this.fileReport = fileReport;
		this.spam = spam;
	}

	/**
	 * scanner temporário das regras
	 * @param path
	 */
	private void lookupRules(String path) {
		Scanner scanner = new Scanner(path + "/rules.cf");
		rules.add(scanner.nextLine());
	}
	
	/**
	 * Este método avalia os falsos positivos e falsos negativos conforme se está a avaliar spam ou nao
	 * 
	 * retorna negative se esta a avaliar spam
	 * retorna positive se esta a avaliar ham
	 * 
	 * @return negative
	 * @return positive
	 */
	public int avaliar() {
		for (int i = 0, k = 0; i < fileReport.size(); i++, k = 0) {
			String [] rules_present = fileReport.get(i).split(" ");
			for (int j = 0; j < rules_present.length; j++)
				if (rules.contains(rules_present[j])) 
					k += weight.get(rules.indexOf(rules_present[j]));
			if (k >= 5) 
				positive++;
			else 
				negative++;
		}
		return spam ?  negative : positive;
	}
}
