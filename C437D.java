import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class C437A {

	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			int[] lenChoices=new int[4];
			String[] choices=new String[4];
			for(int i=0;i!=choices.length;i++){
				choices[i]=reader.readLine().trim().substring(2);
				lenChoices[i]=choices[i].length();
			}
			
			Set<Integer> setResponses=Collections.synchronizedSet(new HashSet<Integer>());
			for(int i=0;i!=choices.length;i++){

				int min=Integer.MAX_VALUE;
				int max=Integer.MIN_VALUE;
				for(int j=0;j!=choices.length;j++){
					if(i!=j){
						int twiceShorter=lenChoices[j]/2;
						int twiceLonger=lenChoices[j]*2;
						min=Math.min(min, twiceShorter);
						max=Math.max(max, twiceLonger);
					}
				}
				
				if((lenChoices[i]<=min)||(lenChoices[i]>=max)){
					setResponses.add(i);
				}
			}
			
			if(setResponses.size()==1){
				String[] respChoices={"A","B","C","D"};
				System.out.println(respChoices[setResponses.iterator().next()]);
			}else System.out.println("C");
			
			reader.close(); 
		}catch(Exception e){}
	}

}
