import java.io.*;

/**
 * */
public class C195A {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader( new InputStreamReader( System.in)); // STDIN
	    	
	    	String[] s=reader.readLine().split(" ", 3);
	    	Integer[] data=new Integer[3];
	    	for(int i=0;i!=data.length;i++)
	    		data[i]=Integer.valueOf(s[i].trim());
	    	
	    	Integer m=0;
	    	for(int i=0;i!=data[2];i++){
	    		int requiredData=(i+1)*data[0];
	    		int downloadedData=(i+1)*data[1];
	    		m=Math.max(m, requiredData-downloadedData);
	    	}
	    	Integer res=(m/data[1]);
	    	if ((m%data[1])>0)
	    		res+=1;
	    	System.out.println(res);
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
