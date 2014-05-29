import java.io.*;
import java.util.*;

/**
 * */
public class C255A {


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try{

			BufferedReader reader =new BufferedReader(
					new InputStreamReader(System.in));
			
			int n=Integer.valueOf(reader.readLine().trim()); 
			int[] r=new int[n];
			String[] s=reader.readLine().trim().split(" ", n); 
			for(int i=0;i!=n;i++)
				r[i]=Integer.valueOf(s[i].trim());
			
			int[] counts=new int[3];
			for(int i=0;i!=n;i++)
				counts[i%3]+=r[i];
			
			System.out.println(
					((counts[0]>counts[1])&&(counts[0]>counts[2]))?"chest": 
						((counts[1]>counts[0])&&(counts[1]>counts[2]))?"biceps":"back");

			reader.close();			
		}catch(Exception e){}
	}

}
