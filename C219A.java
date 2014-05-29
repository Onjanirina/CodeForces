import java.io.*;
import java.util.*;

/**
 * */
public class C219A {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN

	    	Map<String,Integer> map=Collections.synchronizedMap(new HashMap<String,Integer>()); 
	    	Integer k=Integer.valueOf(reader.readLine().trim()); 
	    	String s=reader.readLine();
	    	for( int i=0;i!=s.length();i++){
	    		String ch=s.substring(i,i+1);
	    		if(!map.containsKey(ch))
	    			map.put(ch, 1); 
	    		else map.put(ch, map.get(ch)+1); 
	    	}
	    	
	    	boolean bResult=((s.length()%k)==0);
	    	Iterator<String> iter=map.keySet().iterator();
	    	while(iter.hasNext()&&bResult){
	    		String ch=iter.next();
	    		Integer iCh=map.get(ch);
	    		if((iCh%k)!=0)
	    			bResult=false;
	    	}
	    	
	    	if(bResult){
	    		String chUnit="";
	    		Iterator<String> iterCh=map.keySet().iterator();
	    		while(iterCh.hasNext()){
	    			String ch=iterCh.next();
	    			Integer iCh=map.get(ch)/k;
	    			for(int i=0;i!=iCh;i++)
	    				chUnit+=ch; 
	    		}
	    		String strResult="";
	    		for(int i=0;i!=k;i++)
	    			strResult+=chUnit; 
	    		System.out.println(strResult);
	    	}else{System.out.println("-1");}
	    	
	    	reader.close(); 
	    	
		    }catch(Exception e){
		    	
		    	e.printStackTrace(System.err);
		}
	}
}
