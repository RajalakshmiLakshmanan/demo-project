package learnArray;

public class StarPattern1 {
	public static void main(String[] args) {
        for(int i=0; i<=5;i++){
            for(int j=0; j<=i;j++){
                System.out.print("* ");
            }
           System.out.println(); 
        }
        for(int i=0;i<=4;i++){
            for(int j=4;j>=i;j--){
                System.out.print("* ");
            }
            System.out.println(); 
        }
    }


}

class Main {
    public static void main(String[] args) {
        int n=5;
        for(int i=1; i<=5; i++){
            for(int j=i;j<=5;j++){
                System.out.print(" ");
            }
            for(int k=1; k<=i; k++){
                System.out.print("* ");
            }
            System.out.println();
        }
       for(int i=1; i<=n-1;i++){
           for(int j=1; j<=i;j++){
               System.out.print(" ");
           }
           for(int k=i;k<=n-1;k++){
               System.out.print(" *");
           }
           System.out.println();
       }
    }
}
