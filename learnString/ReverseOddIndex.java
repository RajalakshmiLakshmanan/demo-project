package learnString;

public class ReverseOddIndex {
	
	public static void main(String[] args) {
        String s = "rajalakshmi";
        StringBuilder res = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            if((i % 2 )!=0){
              c= Character.toUpperCase(c);
            }
           res.append(c);
        }
        
        
        
        
        System.out.println("Ouput: "+res.toString());
    }

}
