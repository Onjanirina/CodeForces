import java.io.*;

/**
 * */
public class C208D {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN

	    	Integer nPoints=Integer.valueOf(reader.readLine().trim());
	    	
	    	String[] szPoints=reader.readLine().trim().split(" ",nPoints);
	    	long[] rPoints=new long[nPoints];
	    	for(int i=0;i!=nPoints;i++){
	    		rPoints[i]=Long.valueOf(szPoints[i].trim());
	    	}
	    	
	    	String[] szPrizes=reader.readLine().trim().split(" ",5);
	    	long[] rPrizes=new long[5];
	    	long[] rCounts=new long[5];
	    	for(int i=0;i!=5;i++){
	    		rCounts[i]=0;
	    		rPrizes[i]=Long.valueOf(szPrizes[i].trim()); 
	    	}
	    	
	    	//
	    	Long sum=0L;
	    	for(int i=0;i!=rPoints.length;i++){
	    		sum+=rPoints[i];
	    		while(sum.compareTo((long)rPrizes[0])>=0){
	    			
	    			int j=4;
	    			while(j>=0){
	    				if(sum.compareTo((long)rPrizes[j])>=0){
	    					long c=(long) Math.floor((double) sum/rPrizes[j]);
    						rCounts[j]+=c;
    						sum-=(rPrizes[j]*c);
	    				}	    				
	    				j--;
	    			}
	    			
	    		}
	    	}
	    	
	    	String szResult="";
	    	for(int i=0;i!=5;i++)
	    		szResult+=rCounts[i]+" ";  
	    	System.out.println(szResult);
	    	System.out.println(sum);
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
