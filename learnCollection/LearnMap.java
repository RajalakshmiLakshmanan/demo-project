package learnCollection;

import java.util.Map;
import java.util.HashMap;



public class LearnMap {
	
	
	    public static void main(String[] args) {
	        String[] str = {"ace","jack","king","queen","ace","jack"};
	        int count = 1;
	        Map<String,Integer> map = new HashMap<String, Integer>();
	        for(String s : str){
	            if(map.containsKey(s)){
	                map.put(s, ++count);

	            }else{
	                map.put(s, count);
	            }
	            
	        }
	        
	        for(Map.Entry<String,Integer> entry : map.entrySet()){
	            if(!((entry.getValue()).equals(1))){
	                System.out.println(entry.getKey());
	            }
	        }
	        
	        
	    }
	

}
