import java.io.*;

/**
 * */
public class C200B {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader( new InputStreamReader( System.in)); // STDIN
	    	
	    	Integer nDrinks=Integer.valueOf(reader.readLine().trim());
	    	Integer[] percentages=new Integer[nDrinks];
	    	Integer sum=0;
	    	String[] str=reader.readLine().trim().split(" ",nDrinks);
	    	for(int i=0;i!=str.length;i++){
	    		percentages[i]=Integer.valueOf(str[i].trim()); 
	    		sum+=percentages[i]; }
	    	System.out.println((double)sum/percentages.length);
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
