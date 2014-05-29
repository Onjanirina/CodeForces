import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * */
public class C271A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {

    		Integer n=Integer.valueOf(reader.readLine().trim());
    		
    		Integer m=n+1;
    		while(!hasDifferentDigits(m))
    			m++;    			
    		
    		System.out.println(m);    		
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

	public static boolean hasDifferentDigits(int n){
		boolean[] digits=new boolean[10];
		
		String s=String.valueOf(n);
		int[] d=new int[4];
		for(int i=0;i!=4;i++){
			int iDigit=Integer.valueOf(s.substring(i, i+1));
			if(digits[iDigit])
				return false; 
			digits[iDigit]=true;
		}
		
		return true; 
	}
}
