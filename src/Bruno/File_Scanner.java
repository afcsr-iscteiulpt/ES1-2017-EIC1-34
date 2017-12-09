package Bruno;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class File_Scanner {

	
	/**
	 * este mï¿½todo faz o scan do ficheiro das regras
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
	 * este mï¿½todo faz o scan dos ficheiros de ham e spam
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
	 * este mï¿½todo faz o scan do ficheiro da configuração previamente salvada
	 * @param path
	 * @return
	 */
	public static ArrayList<Rule> Scan_Saved_Conf(String path){
		ArrayList<Rule> saved_conf = new ArrayList<Rule>();
		try {
			Scanner sc;
			sc = new Scanner(new File(path));
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] parts = line.split("	");
				String Nome = parts[0];
				Double Valor = Double.parseDouble(parts[1]);
				Rule rule = new Rule(Nome, Valor);
				saved_conf.add(rule);
				
			}
			sc.close();
		} catch (FileNotFoundException e) {}
		
		return saved_conf;
	}
	
	
	/**
	 * avalia os resultados do JMetal
	 * @throws FileNotFoundException 
	 */
	@SuppressWarnings("resource")
	public static ArrayList<Rule> deciferResults(String rules_path) throws FileNotFoundException {
		//-----------------------------------------------------------------------------------------------------------
		//distinguir qual ï¿½ a melhor configuraï¿½ï¿½o das obtidas
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
		//cria a lista de regras actualizada com os pesos da melhor configuraï¿½ï¿½o
		
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
	 * retorna a melhor configuraï¿½ï¿½o encontrada
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

	
}