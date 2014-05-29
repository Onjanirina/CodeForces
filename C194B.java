import java.io.*;

/**
 * */
public class C194B {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	    		    		    	
	    	Solution solution=new Solution();
	    	// LineNumberReader reader=new LineNumberReader(new FileReader(new File(args[ 0]))); // INPUTFILE
	    	BufferedReader reader =new BufferedReader( new InputStreamReader( System.in)); // STDIN
	    	
	    	Integer nTestCases=Integer.valueOf(reader.readLine().trim());
	    	String[] nSizes=reader.readLine().split(" ", nTestCases);
	    	for(int n=0;n!=nTestCases;n++){
	    		long nSize=Long.valueOf(nSizes[n].trim());
	    		long fullSize=4*nSize;
	    		long nSteps=fullSize;
	    		
	    		long s=nSize+1;
	    		if((s%4)==0){
	    			nSteps/=4;
	    			s/=4;
	    		}else if((s%2)==0){ 
	    			nSteps/=2;
	    			s/=2;}
	    		nSteps+=1;
	    		System.out.println(nSteps);}
	    	
		    }catch(Exception e){e.printStackTrace(System.err);}}}
