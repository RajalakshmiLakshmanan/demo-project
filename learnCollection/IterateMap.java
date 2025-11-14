package learnCollection;
import java.util.*;
public class IterateMap {


	    public static void main(String[] args) {
	        
	        HashMap<String,Integer> map = new HashMap<String,Integer>();
	        map.put("hanu", 23);
	        map.put("manu",45);
	        map.put("nani",50);
	        
	    //Iterate over KeySet()
	    Iterator<String> it = map.keySet().iterator();
	    
	    while(it.hasNext()){
	        String key = it.next();
	        int age = map.get(key);
	        System.out.println("Key: "+ key+ "Value: "+age);
	    
	    }
	     // Iterate using lambda
	      
	      map.forEach((k,v) -> System.out.println("key : "+k +"Value: "+v));
	      
	      
	       // Iterate over entrySet()
	       Iterator<Map.Entry<String,Integer>> it1 = map.entrySet().iterator();
	       while(it1.hasNext()){
	          Map.Entry<String,Integer> entry = it1.next();
	           System.out.println("Key: "+entry.getKey()+" Value:"+entry.getValue());
	       }
	      
	        
	       
	    }
	

}
