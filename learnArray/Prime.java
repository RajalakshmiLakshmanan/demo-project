package learnArray;

public class Prime {
	
	public static void main(String[] args) {
		int inp = 1;
		int rem;
		boolean flag = false;
		for(int i=2; i< inp;i++) {
			rem = inp % 2;
			if(rem==0) {
				flag = true;
				break;
			}
			
		}
		if(flag) {
			System.out.println("given number"+inp+ " is not a prime");
			
		}else {
		
			System.out.println("given number is a prime");
		
	}

}
}
