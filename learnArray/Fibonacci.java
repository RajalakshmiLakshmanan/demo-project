package learnArray;

import java.util.Scanner;

public class Fibonacci {

	/*public static void main(String[] args) {
		int firstNum = 0;
		int secNum = 1;
		int result;
		System.out.print(firstNum+",");
		System.out.print(secNum+",");
		int i=1;
		while(i<15) {
		result= firstNum + secNum;
		System.out.print(result+",");
		firstNum = secNum;
		secNum = result;
		i++;
		
		}*/
		
		public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the maximum number for the Fibonacci sequence: ");
	        int maxNumber = scanner.nextInt();

	        int first = 0, second = 1;

	        System.out.println("Fibonacci sequence up to " + maxNumber + ":");

	        while (first <= maxNumber) {
	            System.out.print(first + " ");

	            int next = first + second;
	            first = second;
	            second = next;
	        }
		
		

	}

}
