import java.io.*;

/**
 * */
public class C208A {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN
	    	
	    	String s=reader.readLine();
	    	s=s.replaceAll("WUB", " ").trim(); 
	    	s=s.replaceAll("(\\s)+", " "); 
	    	System.out.println(s);
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
