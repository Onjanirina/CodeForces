import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * */
public class C263B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		Solution solution=new Solution(); */
    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {
    		
			String[] nk=reader.readLine().split(" ", 2); 
			int n=Integer.valueOf(nk[0].trim());
			int k=Integer.valueOf(nk[1].trim());
			
			String[] s=reader.readLine().split(" ", n);
			List<Integer> list=Collections.synchronizedList(new ArrayList<Integer>());
			for(int i=0;i!=n;i++)
				list.add(Integer.valueOf(s[i].trim())); 
			Collections.sort(list);
			
			if(n>k){
				
				int res=list.get(n-(k+1));
				System.out.println((res+1)+" "+(res+1));				
				
			}else if(n==k){
				
				System.out.println(1+" "+1);
			}else{
				
				System.out.println(-1);
			}
			
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
