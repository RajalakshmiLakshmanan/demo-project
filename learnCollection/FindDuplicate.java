package learnCollection;
import java.util.*;
public class FindDuplicate {
	
	public static List<Character> findCommonCharacters(String[] stringArray) {
		List<Character> out = new ArrayList<>();
        List<Character> inp = new ArrayList<>();
      for(char c: stringArray[0].toCharArray()){
       inp.add(c); 
        
      }
      
      for(int i=1; i<stringArray.length; i++){
        char[] chars = stringArray[i].toCharArray();
        for(int j=0;j<chars.length;j++){ 
             if(inp.contains(chars[j])) {
            	 if(!out.contains(chars[j])) {
                  out.add(chars[j]);
               }
             }
          }
          
          }
          
          return out;
          }
	
	
	public static void main(String[] args) {
		String[] words = {"bella", "label","roller"};
		System.out.println(findCommonCharacters(words));
		
		
	}
	

}
