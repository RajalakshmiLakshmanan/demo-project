package learnCollection;

import java.util.HashMap;
import java.util.Map;

public class CountChar {
	public static void countChar(String str) {
		
		Map<Character,Integer> charMap = new HashMap<Character,Integer>();
		char[] charArray = str.toCharArray();
		
		for(char c: charArray) {
			if(charMap.containsKey(c)) {
				charMap.put(c, charMap.get(c)+1);
				
			}else {
				charMap.put(c, 1);
				
			}
			
		}
		
		System.out.println( str +" : "+charMap);
		
	}
	public static void main(String args[]) {
		String str = "rajalakshmi";
		countChar(str);
		
		
	}
	

}
