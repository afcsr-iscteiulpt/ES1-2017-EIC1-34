package Bruno;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
 
public class File_Scanner {

	
	public static ArrayList Scan_Rules_cf(String path){
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
	
	//Isto faz o scanner do ham ou do spam 
	public static ArrayList Scan_Spam_or_Ham(String path){
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

	
}