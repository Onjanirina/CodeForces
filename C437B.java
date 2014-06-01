import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C437B {

	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			Map<Integer,List<Integer>> map=Collections.synchronizedMap(new HashMap<Integer,List<Integer>>());
			for(int i=0;i<=16;i++){
				Integer lowBit=(int) Math.pow(2, i);
				map.put(lowBit, Collections.synchronizedList(new ArrayList<Integer>()));
			}				
			
			String[] s=reader.readLine().trim().split(" ", 2); 
			Integer sum=Integer.valueOf(s[0].trim());
			Integer limit=Integer.valueOf(s[1].trim()); 
			
			for(int i=1;i<=limit;i++){
				boolean b=false;
				int lowBit=(int) Math.pow(2, 16);
				while(!b&&(lowBit>1)){
					if((i%lowBit)==0){
						map.get(lowBit).add(i);
						b=true;
					}
					lowBit/=2; 
				}
				if(!b)
					map.get(1).add(i);
			}
			
			int maxSum=0;
			for(Integer lowBit:map.keySet())
				maxSum+=(lowBit*map.get(lowBit).size());
			
			if(sum>maxSum){
				System.out.println(-1);
			}else{
			
				Set<Integer> setResult=Collections.synchronizedSet(new HashSet<Integer>());
				
				int lowBit=(int) Math.pow(2, 16);
				while(sum>0){
					while((sum>0)&&(sum>=lowBit) && !map.get(lowBit).isEmpty()){
						setResult.add(map.get(lowBit).remove(0));
						sum-=lowBit;
					}
					lowBit/=2;
				}
				
				System.out.println(setResult.size());
				for(Integer result:setResult)
					System.out.print(result+" ");
				System.out.println();
			}
			
			reader.close(); 
		}catch(Exception e){}
	}

}
