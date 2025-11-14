package learnString;

import org.testng.annotations.Test;

public class ReverseStringBuilder {
	

	public static void reverseEven(String str) {
		String[] s = str.split(" ");
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<s.length;i++) {
		StringBuilder sr = new StringBuilder(s[i]);
		if(i % 2 == 0) {
			
			sb.append(sr.reverse());
		}else {
			sb.append(sr);
		}
		
		sb.append(" ");
	}
	
	System.out.println(sb);
		}
  
	public static void main(String args[]) {
		String inp = "learn from java";
		reverseEven(inp);
		
	}
	
	
}
