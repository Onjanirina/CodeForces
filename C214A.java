import java.io.*;

/**
 * */
public class C214A {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN
	    	
	    	String[] s=reader.readLine().trim().split(" ",2);
	    	int[] nm={Integer.valueOf(s[0].trim()),Integer.valueOf(s[1].trim())};
	    	int count=0;
	    	int m=(int)Math.sqrt(Math.max(nm[0], nm[1]));
	    	for(int i=0;i<=m;i++){
	    		for(int j=0;j<=m;j++){
	    			if((((i*i)+j)==nm[0])&&((i+(j*j))==nm[1]))
	    				count++;
	    		}
	    	}
	    	System.out.println(count);
	    	reader.close();
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
