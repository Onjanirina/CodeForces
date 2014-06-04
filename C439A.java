import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C439A {

	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			String[] s=reader.readLine().trim().split(" ", 2);
			int n=Integer.valueOf(s[0].trim()).intValue();
			int d=Integer.valueOf(s[1].trim()).intValue();
			
			s=reader.readLine().trim().split(" ", n);
			int sumSongs=0;
			int[] songs=new int[n];
			for(int i=0;i!=n;i++){
				songs[i]=Integer.valueOf(s[i].trim()).intValue();
				sumSongs+=songs[i];
			}
			
			int min=sumSongs+(10*(n-1));
			if(min<=d){
				int minJokes=d-min; 
				System.out.println((minJokes/5)+(2*(n-1)));
			}else System.out.println(-1);
			reader.close(); 
		}catch(Exception e){}
	}

}
