import java.io.*;
import java.util.*;

/**
 * */
public class C215A {
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	// Solution solution=new Solution();
	    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN

	    	Integer n=Integer.valueOf(reader.readLine().trim());
	    	String[] ns=reader.readLine().trim().split(" ",n);
	    	Integer[] rn=new Integer[n];
	    	for(int i=0;i!=n;i++)
	    		rn[i]=Integer.valueOf(ns[i].trim());
	    	
	    	Integer m=Integer.valueOf(reader.readLine().trim());
	    	String[] ms=reader.readLine().trim().split(" ",m);
	    	Integer[] rm=new Integer[m];
	    	for(int i=0;i!=m;i++)
	    		rm[i]=Integer.valueOf(ms[i].trim());
	    	
	    	Integer max=0;
	    	Map<Integer,Integer> map=Collections.synchronizedMap(new HashMap<Integer,Integer>());
	    	for(int in=0;in!=n;in++){
	    		for(int im=0;im!=m;im++){
	    			if((rm[im]%rn[in])==0){
	    				Integer v=rm[im]/rn[in];
	    				max=Math.max(max,v);
	    				if(!map.containsKey(v))
	    					map.put(v, 1);
	    				else map.put(v,map.get(v)+1); 
	    			}
	    		}
	    	}
	    		    	
	    	System.out.println(map.get(max));
	    	
	    	reader.close();
		    }catch(Exception e){
		    	
		    	e.printStackTrace(System.err);
		}
	}
}
