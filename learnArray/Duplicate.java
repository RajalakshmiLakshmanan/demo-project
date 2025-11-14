package learnArray;

public class Duplicate {
	
	public static void main(String[] args) {
		int inp[] = {45,98,68,23,78,90,45};
		boolean flag = false;
		for(int i=0;i<inp.length;i++) {
			for(int j=i+1;j<inp.length;j++) {
				if(inp[i]==inp[j]) {
					flag= true;
				    break;
				} 
			}
			
		}
		if(flag) {
			System.out.println("duplicate present in the array");
			
			
		}else {
			
			System.out.println("Duplicate not present in the array");
		}
		
	}

}
