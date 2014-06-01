import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C437C {

	/***/
	public static int NODE=0;
	public class Node{
		public int nodeId=NODE++;
		public Integer energy;
		public Set<Integer> linkedNodes=Collections.synchronizedSet(new HashSet<Integer>());
		
		public Node(Integer e){
			this.energy=e;
			mapNodes.put(this.nodeId, this);
		}
		
		public String toString(){ return this.nodeId+" "+this.energy; }
	}
	public Node newNode(Integer e){ return new Node(e); }
	
	/***/
	public class NodeComparator implements Comparator<Node>{
		public int compare(Node arg0, Node arg1){ return arg0.energy.compareTo(arg1.energy); }}
	public NodeComparator newNodeComparator(){ return new NodeComparator(); }
	
	public static Map<Integer,Node> mapNodes=Collections.synchronizedMap(new HashMap<Integer,Node>());
	
	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			String[] s=reader.readLine().trim().split(" ", 2); 
			Integer n=Integer.valueOf(s[0].trim());
			Integer m=Integer.valueOf(s[1].trim());
			
			C437C mInstance=new C437C();
			List<Node> nodes=Collections.synchronizedList(new ArrayList<Node>());
			s=reader.readLine().trim().split(" ", n);
			for(int i=0;i!=n;i++)
				nodes.add(mInstance.newNode(Integer.valueOf(s[i].trim())));
						
			for(int i=0;i!=m;i++){
				s=reader.readLine().trim().split(" ", 2); 
				Integer startNodeId=Integer.valueOf(s[0].trim())-1;
				Integer endNodeId=Integer.valueOf(s[1].trim())-1;				
				mapNodes.get(startNodeId).linkedNodes.add(endNodeId);
				mapNodes.get(endNodeId).linkedNodes.add(startNodeId);
			}
			
			long sum=0;
			Collections.sort(nodes,mInstance.newNodeComparator());
			for(Node node:nodes){
				while(!node.linkedNodes.isEmpty()){
					sum+=(node.energy*node.linkedNodes.size());
					Iterator<Integer> iter=node.linkedNodes.iterator();
					while(iter.hasNext()){
						Integer removeNodeId=iter.next();
						mapNodes.get(removeNodeId).linkedNodes.remove(node.nodeId);
						iter.remove();
					}
				}
			}
				
			System.out.println(sum);			
			reader.close(); 
		}catch(Exception e){}
	}

}
