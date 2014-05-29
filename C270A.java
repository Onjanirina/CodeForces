import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class C270A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {

    		Integer nTestCases=Integer.valueOf(reader.readLine().trim());
    		for(int n=0;n!=nTestCases;n++){
    			Integer m=Integer.valueOf(reader.readLine().trim());
    			System.out.println(((360%(180-m))==0)?"YES":"NO");
    		}
			
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

	}

}
