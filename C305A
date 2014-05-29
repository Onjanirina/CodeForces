import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class C305A {

	/***/
	public class Group{
		List<String> list=Collections.synchronizedList(new ArrayList<String>());

		/***/
		public void add(String a){
			Iterator<String> i=this.list.iterator();
			while(i.hasNext()){
				if(!canSum(a,i.next()))
					return;
			}
			this.list.add(a);
			// System.err.println(this.list);
		}
	}
	public Group newGroup(String a){
		Group g=new Group();
		g.list.add(a);
		return g;
	}
	
	/***/
	public static boolean canSum(String a,String b){
		int m=Math.max(a.length(), b.length());
		while(a.length()<m)
			a="0"+a;
		while(b.length()<m)
			b="0"+b;
		for(int i=0;i!=a.length();i++)
			if((a.charAt(i)!='0')&&(b.charAt(i)!='0'))
				return false;
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		C305A instance=new C305A();
    	BufferedReader reader =new BufferedReader(new InputStreamReader(System.in)); // STDIN
    	
    	try {

    		Integer n=Integer.valueOf(reader.readLine().trim());
    		String[] numbers=reader.readLine().trim().split(" ", n);    		
    		
    		List<Group> listGroups=Collections.synchronizedList(new ArrayList<Group>());
    		
    		for(int i=0;i!=numbers.length;i++){
    			String num=numbers[i];    		
    			if(!listGroups.isEmpty()){
        			Iterator<Group> iterGroup=listGroups.iterator();
        			while(iterGroup.hasNext())
        				iterGroup.next().add(num);    			    				
    			}
    			listGroups.add(instance.newGroup(num));
    		}
    		
    		if(!listGroups.isEmpty()){
        		Group maxGroup=null;    		
    			Iterator<Group> iterGroup=listGroups.iterator();
    			while(iterGroup.hasNext()){
    				Group g=iterGroup.next();
    				if((maxGroup==null)||(g.list.size()>maxGroup.list.size()))
    					maxGroup=g;
    			}
    			if(maxGroup!=null){
    				System.out.println(maxGroup.list.size()); 
    				Iterator<String> iter=maxGroup.list.iterator();
    				while(iter.hasNext())
    					System.out.print(iter.next()+" ");
    				System.out.println();
    			}
    		}else{ System.out.println(0); }
    		
			reader.close();
						
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
}
