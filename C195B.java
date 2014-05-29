import java.io.*;
import java.util.*;

/**
 * */
public class C195B {

	public static Integer nBalls=0;
	public static Integer nBaskets=0;
	
	public class BasketComparator implements Comparator<Integer>{

		@Override
		public int compare(Integer arg0, Integer arg1) {
			Double c0=Math.abs((((double)nBaskets+1)/2)-(double) arg0);
			Double c1=Math.abs((((double)nBaskets+1)/2)-(double) arg1);
			return (c0.equals(c1))? arg0.compareTo(arg1):c0.compareTo(c1);
		}}
	public BasketComparator newBasketComparator(){
		return new BasketComparator();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	Solution solution=new Solution();
	    	BufferedReader reader =new BufferedReader( new InputStreamReader( System.in)); // STDIN
	    	
	    	String s[]=reader.readLine().split(" ", 2);
	    	nBalls=Integer.valueOf(s[0].trim());	    		    	
	    	nBaskets=Integer.valueOf(s[1].trim());
	    	
	    	List<Integer> list=Collections.synchronizedList(new ArrayList<Integer>(nBaskets));
	    	for(int i=1;i<=nBaskets;i++)
	    		list.add(i);
	    	Collections.sort(list, solution.newBasketComparator());
	    	
	    	for(int i=0;i!=nBalls;i++){
	    		System.out.println(list.get(i%list.size()));
	    	}
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
