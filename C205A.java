import java.io.*;

/**
 * */
public class C205A {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN

	    	Integer nCities=Integer.valueOf(reader.readLine().trim());
	    	String[] distances=reader.readLine().trim().split(" ",nCities);

	    	Integer[] nDistances=new Integer[nCities];
	    	Integer m=Integer.MAX_VALUE;
	    	for(int i=0;i!=nCities;i++){
	    		nDistances[i]=Integer.valueOf(distances[i].trim());
	    		m=Math.min(nDistances[i],m);
	    	}
	    	
	    	Integer nCount=0;
	    	int nId=0;
	    	if(m>0){	    		
	    		for(int i=0;i!=nCities;i++)
	    			if(nDistances[i].compareTo(m)==0){
	    				nCount++;
	    				nId=i+1; }}
	    	System.out.println(((nCount.compareTo(1)==0)&&(nId!=0))?nId:"Still Rozdil");
	    		    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
