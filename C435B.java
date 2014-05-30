import java.io.BufferedReader;
import java.io.InputStreamReader;

public class C435B {

	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			String[] s=reader.readLine().split(" ", 2); 
			int swaps=Integer.valueOf(s[1].trim()).intValue();
			
			int[] n=new int[s[0].trim().length()];
			for(int i=0;i!=n.length;i++){
				n[i]=Integer.valueOf(s[0].substring(i, i+1)).intValue();
				// System.err.print(n[i]);				
			}
			// System.err.println();
			
			int p=0;
			while((swaps>0)&&(p<n.length)){
				// System.err.println("p="+p);
				if(n[p]<9){
					
					int[] sup=new int[10];
					for(int i=0;i!=sup.length;i++)
						sup[i]=-1;
					
					for(int i=(p+1);i<n.length;i++){
						if(sup[n[i]]==-1){
							sup[n[i]]=i;
							// System.err.println(n[i]+" "+sup[n[i]]);
						}							
					}
					
					//
					// System.err.println("Test");
					boolean bDone=false;
					int nSup=9;
					while(!bDone&&(nSup>n[p])){						
						if((sup[nSup]>0)&&((sup[nSup]-p)<=swaps)){
							
							// System.err.println("nSup="+nSup+" "+(sup[nSup]-p)+" "+swaps);
							
							// Swaps
							for(int j=sup[nSup];j>p;j--)
								n[j]=n[j-1];
							n[p]=nSup;
							
							swaps-=(sup[nSup]-p); 
							bDone=true;
						}
						
						nSup--; 
					}
					
				}
				
				p++;
			}
			
			/**/
			for(int i=0;i!=n.length;i++)
				System.out.print(n[i]);
			System.out.println(); 
			
			reader.close(); 
		}catch(Exception e){}
	}

}
