package Bruno;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class File_Scanner {

	
	/**
	 * este método faz o scan do ficheiro das regras
	 * @param path
	 * @return
	 */
	public static ArrayList<Rule> Scan_Rules_cf(String path){
		ArrayList<Rule> rules_cf = new ArrayList<Rule>();
		try {
			Scanner sc;
			sc = new Scanner(new File(path));

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				rules_cf.add(new Rule(line,0));
			}
			sc.close();
		} catch (FileNotFoundException e) {}
	    return rules_cf;
	}
	
	/**
	 * este método faz o scan dos ficheiros de ham e spam
	 * @param path
	 * @return
	 */
	public static ArrayList<String[]> Scan_Spam_or_Ham(String path){
		ArrayList<String[]> list = new ArrayList<String[]>();
		try {
			Scanner sc;
			sc = new Scanner(new File(path));

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split("	");
				list.add(parts);
			}
			sc.close();
		} catch (FileNotFoundException e) {}
	    return list;
	}
	
	/**
	 * avalia os resultados do JMetal
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("resource")
	public static ArrayList<Rule> deciferResults(String rules_path) throws FileNotFoundException {
		//-----------------------------------------------------------------------------------------------------------
		//distinguir qual é a melhor configuração das obtidas
		Scanner scan = new Scanner(new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.rf"));
		ArrayList<double[]> config = new ArrayList<>();
		while(scan.hasNext()){
			double[] results = new double[2];
			results[0] = Double.parseDouble(scan.next());
			results[1] = Double.parseDouble(scan.next());
			config.add(results);
		}

		int best = 0;
		for (int i = 1; i < config.size(); i++) {
			if (config.get(i)[0] < config.get(best)[0] || (config.get(i)[0] == config.get(best)[0] && config.get(i)[1] < config.get(best)[1])) {
				best = i;
			}
		}
		//-----------------------------------------------------------------------------------------------------------
		scan = new Scanner(new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.rs"));
		for (int i = 0; i < best; i++) {
			scan.nextLine();			
		}
		//cria a lista de regras actualizada com os pesos da melhor configuração
		
		//ArrayList<Rule> finalConf = scan_Rules(rules_path);
		ArrayList<Rule> finalConf = Scan_Rules_cf(rules_path);
		String s = scan.nextLine();
		scan = new Scanner(s);
		for (int i = 0; i < finalConf.size(); i++) {
			finalConf.get(i).setValor(Double.parseDouble(scan.next()));
		}
		scan.close();
		
		return finalConf;
	}
	
	/**
	 * retorna a melhor configuração encontrada
	 * @return
	 * @throws FileNotFoundException
	 */
	public static double[] serchBestConfig() throws FileNotFoundException{
		Scanner scan = new Scanner(new File("experimentBaseDirectory/referenceFronts/AntiSpamFilterProblem.rf"));
		ArrayList<double[]> config = new ArrayList<>();
		while(scan.hasNext()){
			double[] results = new double[2];
			results[0] = Double.parseDouble(scan.next());
			results[1] = Double.parseDouble(scan.next());
			config.add(results);
		}

		int best = 0;
		for (int i = 1; i < config.size(); i++) {
			if (config.get(i)[0] < config.get(best)[0] || (config.get(i)[0] == config.get(best)[0] && config.get(i)[1] < config.get(best)[1])) {
				best = i;
			}
		}
		scan.close();
		return config.get(best); 
	}
	
	public static void main(String[] arg){
		try {
			deciferResults("rules.cf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}