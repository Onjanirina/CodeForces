

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C443B {
	public static char p='.';
	
	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
						
			String s=reader.readLine().trim();
			int k=Integer.valueOf(reader.readLine().trim());
			for(int i=0;i!=k;i++)
				s+=String.valueOf(p);
			
			int r=(s.length()/2);
			boolean isTandem=false;
			while(!isTandem &&(r>0)){
				
				int len=r*2;
				// System.err.println("Len "+len);
				
				int u=0;
				while(!isTandem&&(u<=(s.length()-len))){
					String sub=s.substring(u,u+len);
					// System.err.println("Test "+sub);
					isTandem=isTandem(sub);
					u++;
				}
				
				if(!isTandem)
					r--;
			}			
			System.out.println(r*2);		
			
			reader.close(); 
		}catch(Exception e){}
	}

	public static boolean isTandem(String s){		
		char[] chars=s.toCharArray();
		int r=chars.length/2;
		if((chars.length%2)!=0)
			return false;
		int i=0;
		boolean isSame=true;
		while(isSame&&(i<r)){
			isSame=(chars[i]==chars[i+r])||(chars[i]==p)||(chars[i+r]==p); 
			i++;
		}
		return isSame;
	}
	
}
