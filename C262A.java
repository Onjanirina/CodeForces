import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * */
public class C262A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/**
		Solution solution=new Solution(); */
    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {
    		
			String[] nk=reader.readLine().trim().split(" ", 2);
			int n=Integer.valueOf(nk[0].trim());
			int k=Integer.valueOf(nk[1].trim());

			int count=0;
			String[] strNumbers=reader.readLine().trim().split(" ", n);
			for(int i=0;i!=n;i++){
				strNumbers[i]=strNumbers[i].trim();				
				
				if(strNumbers[i].length()>=k){									
					
					char[] chars=strNumbers[i].toCharArray();
					int iK=0;					
					int c=0;					
					while((c<chars.length)&&(iK<=k)){
						if((chars[c]=='4')||(chars[c]=='7'))
							iK++;
						c++;
					}
					
					if(iK<=k)
						count++;
				}else{
					
					count++; 
				}
			}
			System.out.println(count);
			
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
