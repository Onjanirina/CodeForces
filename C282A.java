import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * */
public class C282A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		Solution solution=new Solution(); */
    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {

    		int nValue=0;
    		int nStatements=Integer.valueOf(reader.readLine().trim());    		
    		for(int i=0;i!=nStatements;i++){
    			String s=reader.readLine().trim();
    			nValue+=(s.contains("+"))?1:-1;
    		}
    		System.out.println(nValue);
    		
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
