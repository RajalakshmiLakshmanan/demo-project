package learnSelinium;

public class SortString {
	public static void sort(String s) {
		String[] words = s.split(" ");
		String[] result = new String[words.length];
		
		for(String a: words) {
			int pos = a.charAt(a.length()-1)- '0';
			String orgWord = a.substring(0, a.length()-1);
			result[pos-1]= orgWord;
			
		}
		for(int i=0; i< result.length; i++) {
			System.out.print(result[i] +" ");
			
		}
		
		
	}
	
	
	public static void main(String args[]) {
		
		String s = "is2 sentence4 a3 This1";
		sort(s);
	}
	

}
