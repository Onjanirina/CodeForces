import java.io.*;

/**
 * */
public class C197C {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {		    	
	    	
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN
	    	
	    	String str=reader.readLine().trim();
	    	String subsequence="";
	    	String alphabet="abcdefghijklmnopqrstuvwxyz";
	    	
	    	for(int i=alphabet.length()-1;i>=1;i--){
	    		char ch=alphabet.charAt(i);
	    		String pattern=alphabet.substring(0,i);	    		
	    		int last=str.lastIndexOf(ch);
	    		if(last>0){	    			
	    			String sub=str.substring(0, last);
	    			subsequence+=sub.replaceAll("["+pattern+"]", "");
	    			str=str.substring(last); }}
	    	subsequence+=str;
	    	System.out.println(subsequence);	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err); }}}
