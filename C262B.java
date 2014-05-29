import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * */
public class C262B {

	public class Income{
		public int value=0;
		public Integer absValue=0;
		
		public Income(int value){
			this.value=value;
			this.absValue=(int) Math.abs(this.value);
		}
		public String toString(){ return String.valueOf(this.value); }
	}
	public Income newIncome(int value){ return new Income(value); }

	public class IncomeComparator implements Comparator<Income>{
		public int compare(Income o1, Income o2) {
			return o1.absValue.compareTo(o2.absValue);
		}}
	public IncomeComparator newIncomeComparator(){ return new IncomeComparator(); }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		/***/
		C262B solution=new C262B();
    	BufferedReader reader =new BufferedReader(
    			new InputStreamReader(System.in)); // STDIN
    	
    	try {
    		
			String[] nk=reader.readLine().trim().split(" ", 2);
			int n=Integer.valueOf(nk[0].trim());
			int k=Integer.valueOf(nk[1].trim()); 
			
			String[] strIncomes=reader.readLine().split(" ", n);
			List<Income> listIncomes=Collections.synchronizedList(new ArrayList<Income>());			
			for(int i=0;i!=n;i++)
				listIncomes.add(solution.newIncome(Integer.valueOf(strIncomes[i].trim())));
			Collections.sort(listIncomes,solution.newIncomeComparator());
			
			int sum=0;
			int i=n-1;
			while(i>=0){
				if((k>0)&&(listIncomes.get(i).value<0)){
					sum+=listIncomes.get(i).absValue;
					k--;
				}else{
					sum+=listIncomes.get(i).value;
				}
				i--;
			}			
			
			if((k>0)&&((k%2)!=0))
				sum-=(2*listIncomes.get(0).absValue); 			
			System.out.println(sum);
			
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}

}
