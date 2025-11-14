package learnArray;

import java.util.Arrays;

import org.testng.annotations.Test;

public class SwapArray {
	@Test(enabled=false)
	public void swapping() {
		int arr1[] = {3,4,8,6,4};
		int arr2[] = {1,2,5,9,0};
		System.out.println("before swap array1 "+ Arrays.toString(arr1) );
		System.out.println("before swap array2 "+ Arrays.toString(arr2) );
		for(int i=0;i< arr1.length;i++) {
			int temp= arr1[i];
			arr1[i] = arr2[i];
			arr2[i]= temp;
			
		}
		System.out.println("after swap array1 "+ Arrays.toString(arr1) );
		System.out.println("after swap array2 "+ Arrays.toString(arr2) );
		
	}
	@Test
	public void reverseString() {
		String inp = "kamal";
		char arry[] = inp.toCharArray();
		String  oup = "";
		for(int i = inp.length()-1; i>=0; i--) {
	     oup = oup + arry[i];
	     
	}
		System.out.println("reverse: "+oup);
	
	}
}
