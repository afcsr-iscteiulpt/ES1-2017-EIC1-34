package antiSpamFilter;

import java.util.ArrayList;
import java.util.List;

import org.uma.jmetal.problem.impl.AbstractDoubleProblem;
import org.uma.jmetal.solution.DoubleSolution;

import Bruno.Cliente;
import Bruno.Rule;
import Daniel.Avaliador;

public class AntiSpamFilterProblem extends AbstractDoubleProblem {
	
	private ArrayList<Rule> rules = new ArrayList<Rule>();
	private Cliente cliente;
	
//	public AntiSpamFilterProblem(Cliente cliente) {
//		// 10 variables (anti-spam filter rules) by default 
//		this(10, cliente);
//	}

	public AntiSpamFilterProblem(Cliente cliente) {
		
		this.cliente = cliente;
		rules = cliente.getRules_auto();
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

	public void evaluate(DoubleSolution solution){
		double[] fx = new double[getNumberOfObjectives()];
		
		//preenche os pesos da lista
		for (int i = 0; i < solution.getNumberOfVariables(); i++) {
			rules.get(i).setValor(solution.getVariableValue(i));
		}
		
		Avaliador a = new Avaliador();
		
		//fp
		ArrayList<String[]> fileReport = cliente.getHam();
		a.replaceFields(rules, fileReport, false);
		fx[0] = a.avaliar();
		
		//fn
		fileReport = cliente.getSpam();
		a.replaceFields(rules, fileReport, true);
		fx[1] = a.avaliar();
		
		solution.setObjective(0, fx[0]);
		solution.setObjective(1, fx[1]);
	}
}
