package learnArray;

import java.util.ArrayList;
import java.util.List;

public class CountUnique {
	
	public static  int removeElement(int[] nums, int val){
	      List<Integer> list = new ArrayList<>();
	      for(int n: nums){
	       list.add(n); 
	        
	      }
	      list.remove(val);
	      return list.size();
	      
			
		}
	
	public static int sumOfUnique(int[] nums)
	{
      int count = 0;
		Set<Integer> set = new HashSet<>();
      for(int n: nums){
        set.add(n);
        
      }
      List<integer> list = new ArrayList<>(set);
      for(int n:list){
        count += n;
      }
      return count;
	}
	
	
	
	}
	

