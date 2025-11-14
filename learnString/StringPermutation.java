package learnString;

public class StringPermutation {
	public static void permute(String str, String prefix) {
		if(str.length()==0) {
			System.out.println(prefix);
		}
		for(int i=0; i<str.length();i++) {
			char ch = str.charAt(i);
			String rem = str.substring(0,i)+str.substring(i+1);
			permute(rem, prefix + ch);
			
		}
		
	}
	
	public static void main(String[] args) {
		String inp = "dog";
		permute(inp," ");
		
	}
	

}
