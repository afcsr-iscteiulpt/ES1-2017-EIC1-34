package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import Bruno.File_Scanner;
import Bruno.Rule;
import Daniel.Avaliador;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {
	
	private ArrayList<Rule> rules = new ArrayList<Rule>();;
	
	public AntiSpamFilterProblem() {
		// 10 variables (anti-spam filter rules) by default 
		this(10);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public AntiSpamFilterProblem(Integer numberOfVariables) {
		
		rules = new File_Scanner().Scan_Rules_cf("rules.cf");
		setNumberOfVariables(rules.size());
		
		setNumberOfObjectives(2);
		setName("AntiSpamFilterProblem");

		List<Double> lowerLimit = new ArrayList<>(getNumberOfVariables()) ;
		List<Double> upperLimit = new ArrayList<>(getNumberOfVariables()) ;

		for (int i = 0; i < getNumberOfVariables(); i++) {
			lowerLimit.add(-5.0);
			upperLimit.add(5.0);
		}

		setLowerLimit(lowerLimit);
		setUpperLimit(upperLimit);
	}

	@SuppressWarnings({ "unchecked", "static-access" })
	public void evaluate(DoubleSolution solution){
		
		double[] fx = new double[getNumberOfObjectives()];
		
		//preenche os pessos da lista
		rules = new ArrayList<Rule>();
		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			rules.get(i).setValor(solution.getVariableValue(i));
		}
		
		//Objecto que retorna o numero de fp ou fn
		Avaliador a = new Avaliador();
		
		ArrayList<String[]> fileReport = new File_Scanner().Scan_Spam_Ham("ham.log.txt");
		a.replaceFields(rules, fileReport, false);		
		fx[0] = a.avaliar();
		
		fileReport = new File_Scanner().Scan_Spam_Ham("spam.log.txt");
		a.replaceFields(rules, fileReport, true);
		fx[1] = a.avaliar();
		
		solution.setObjective(0, fx[0]);
		solution.setObjective(1, fx[1]);
	}
}
