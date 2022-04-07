
import java.util.HashMap;
import java.util.Scanner;

public class Fraction {
	 static String fractionToDecimal(int numr, int denr)
	    {
	       
	        String res = "";
	 
	        
	        HashMap<Integer, Integer> mp = new HashMap<>();
	        mp.clear();
	 
	        int rem = numr % denr;
	 
	        
	        while ((rem != 0) && (!mp.containsKey(rem)))
	        {
	            
	            mp.put(rem, res.length());
	 
	        
	            rem = rem * 10;
	 
	         
	            int res_part = rem / denr;
	            res += String.valueOf(res_part);
	 
	           
	            rem = rem % denr;
	        }
	 
	        if (rem == 0)
	            return "";
	        else if (mp.containsKey(rem))
	            return res.substring(mp.get(rem));
	 
	        return "";
	    }
	 
	    
	    public static void main(String[] args)
	    {
	    	Scanner s= new Scanner(System.in);
	    	System.out.println("Enter numerator");
	        int numr = s.nextInt();
	        System.out.println("Enter denominator");
	        int denr = s.nextInt();
	        String res = fractionToDecimal(numr, denr);
	        
	        if (res == "")
	            System.out.print("No recurring sequence");
	        else
	            System.out.print("Recurring sequence is "
	                             + res);
	    }
}