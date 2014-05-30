
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C435A {

	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			String[] s=reader.readLine().split(" ", 2);
			int n=Integer.valueOf(s[0].trim()).intValue();
			int m=Integer.valueOf(s[1].trim()).intValue();
			
			s=reader.readLine().split(" ", n);
			int[] g=new int[n];
			for(int i=0;i!=n;i++)
				g[i]=Integer.valueOf(s[i].trim()).intValue();
			
			int bus=1;
			int currentCharge=0;
			for(int i=0;i!=n;i++){
				if((currentCharge+g[i])>m){
					currentCharge=g[i];
					bus++;
				}else currentCharge+=g[i];
			}
			System.out.println(bus);
			
			reader.close(); 
		}catch(Exception e){}
	}

}
