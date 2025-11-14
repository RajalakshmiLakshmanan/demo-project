package learnArray;

public class Palindrome {
	
	public static boolean ispalindrome(int num) {
		boolean flag = false;
		int inp = num;
		int temp = 0;
		while(inp>0) {
			int rem = inp %10;
			temp = (temp*10)+rem;
			inp =inp/10;
			
		}
		if(temp==num) {
			flag=true;
			
		}
		return flag;
		
	}
	
	public static int countOfChars(String inp, char inpchar) {
		int count = 0;
		char[] inpArray = inp.toLowerCase().toCharArray();
		for(int i=0; i<inpArray.length;i++) {
			if(inpArray[i] == inpchar) {
				count++;
			}
			
		}
		return count;
		
	}
	
	public static boolean isSubstring(String inp, String sub) {
	   boolean flag = false;
	   if(inp.toLowerCase().contains(sub)) {
		   flag= true;
	   }
		
		return flag;
	}
	
	
	public static void main(String[] args) {
		int num = 100001;
		//System.out.println( "The given number is palindrome: "+ ispalindrome(num));
		String inp = "RajaLakshmi";
		String sub = "";
		char inpc = 'a';
		//System.out.println("the number of chars in the given input: "+ countOfChars(inp,inpc));
	   System.out.println("substring is present "+ isSubstring(inp,sub));   
	
	}
	

}
