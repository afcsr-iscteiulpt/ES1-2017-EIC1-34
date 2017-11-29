package Bruno;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class File_Scanner {

	
	public static ArrayList Scan_Rules_cf(String path) throws FileNotFoundException{
		ArrayList<Rule> rules_cf = new ArrayList<Rule>();
	    Scanner sc = new Scanner(new File(path));

	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	        rules_cf.add(new Rule(line,0));
	    }
	    sc.close();
	    return rules_cf;
	}
	
	//Isto faz o scanner do ham ou do spam 
	public static ArrayList Scan_Spam_Ham(String path) throws FileNotFoundException{
		ArrayList<String[]> list = new ArrayList<String[]>();
	    Scanner sc = new Scanner(new File(path));

	    while (sc.hasNextLine()) {
	        String line = sc.nextLine();
	        String[] parts = line.split("	");
	        list.add(parts);
	    }
	    sc.close();
	    return list;
	}

	
}