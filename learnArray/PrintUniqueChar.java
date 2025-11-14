package learnArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PrintUniqueChar {
	
	public static void printChar(String inp) {
		char[] charArray = inp.toLowerCase().toCharArray();
		Set<Character> charSet = new HashSet<Character>();
		List<Character> dupSet = new ArrayList<Character>();
		for(char ch: charArray) {
			if(!(charSet.add(ch))) {
				dupSet.add(ch);
				
			}
			
		}
		charSet.removeAll(dupSet);
		System.out.println("Unique char: "+charSet);
		
		
	}
	
	public static void main (String args[]) {
		String inp = "rajalakshmi";
		printChar(inp);
		
	}
	

}
