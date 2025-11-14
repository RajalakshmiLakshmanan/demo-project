package learnString;

import java.util.ArrayList;
import java.util.List;

public class CountVowels {
	
	    public static void main(String[] args) {
	        String str = "Hello World";
	        String inp = str.toLowerCase().replaceAll("\\s","");
	        char[] vowels = {'a','e','i','o','u'};
	        int count = 0;
	        int cons = 0;
	        List<Character> vlist = new ArrayList<Character>();
	        for(char c: vowels){
	            vlist.add(c);
	        }
	        for(int i=0; i<inp.length(); i++){
	            if(vlist.contains(inp.charAt(i))){
	                count++;
	            }else{
	                cons++;
	            }
	            
	        }
	        
	        System.out.println("vowels count: "+count);
	        System.out.println("consonants count: "+cons);
	    }
	

}
