package learnString;

public class LengthOfLastword {
	
	public static int lengthOfLastWord(String s)
	{
		// write your code here
      String[] strArray = s.split(" ");
      String lastStr = strArray[strArray.length-1];
      int length = lastStr.length();
      return length;
      
	}
	
	public static String longestCommonPrefix(String[] strs)
	{
		// write your code here
      String comPrefix = "";
      boolean flag = false;
      
 for(int i=0; i< strs.length; i++)
 {
   for(int j=i+1; j<strs.length;j++){
  if(strs[i].charAt(i) == strs[j].charAt(i)){
    flag = true;
  }
   }
   if(flag){
     comPrefix += strs[i].charAt(i);
     
   }
   
 }
      return comPrefix;
	}
	
	
	public static void main(String args[]) {
		String[] strs = {"pug","pup","puppy"};
		
		System.out.println(longestCommonPrefix(strs));
		
		
		
		
	}
	

}
