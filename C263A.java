import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * */
public class C263A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		Solution solution=new Solution(); */
    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {

    		int yRow=0;
    		int xColumn=0;
    		for(int i=0;i!=5;i++){
    			String[] s=reader.readLine().split(" ", 5);
    			for(int j=0;j!=5;j++){
    				Integer value=Integer.valueOf(s[j].trim());
    				if(value==1){
    					yRow=i;
    					xColumn=j; 
    				}
    			}
    		}
    		System.out.println(String.valueOf(Math.abs(yRow-2)+Math.abs(xColumn-2)));
    		
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
