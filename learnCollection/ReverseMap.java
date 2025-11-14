package learnCollection;
import java.util.*;

public class ReverseMap {
	
	
	    public static void main(String[] args) {
	        TreeMap<Integer,String> map = new TreeMap<>(Comparator.reverseOrder());
	        map.put(101,"hari");
	        map.put(102,"raji");
	        map.put(103,"laksh");
	        map.put(104,"siva");
	        
	        System.out.println("Reverse order Map: "+map);
	        
	    }
	}
	

