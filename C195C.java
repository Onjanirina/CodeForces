import java.io.*;
import java.util.*;

/**
 * */
public class C195C {
	
	/**
	 * */
	public class Block{
		public Block parentBlock=null;
		public List<Block> listChildren=Collections.synchronizedList(new ArrayList<Block>());
		public Map<String,String> mapCatches=Collections.synchronizedMap(new HashMap<String,String>());
		
		public Block(){}
		
		public Block createBlock(){
			Block childBlock=new Block();
			childBlock.parentBlock=this;
			this.listChildren.add(childBlock);
			return childBlock;
		}
		
		public String handleThrow(String e){
			if(this.mapCatches.containsKey(e))
				return this.mapCatches.get(e);
			return (this.parentBlock!=null)? this.parentBlock.handleThrow(e): "Unhandled Exception";
		}
	}
	
	public Block newBlock(){
		return new Block();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args){		
	    try {	
	    	
	    	Solution solution=new Solution();
	    	BufferedReader reader =new BufferedReader( new InputStreamReader( System.in)); // STDIN
	    	
	    	String s=reader.readLine();
	    	Block rootBlock=solution.newBlock();
	    	Block currentBlock=rootBlock;
	    	Block throwBlock=null;
	    	String throwException="";
	    	
	    	while(s!=null){
	    		s=s.trim();
	    		
	    		// try
	    		if(s.equals("try")){
	    			currentBlock=currentBlock.createBlock();
	    		}
	    		
	    		// catch
	    		if(s.startsWith("catch")){
	    			String data[]=s.substring(s.indexOf("(")+1, s.indexOf(")")).split(",", 2);	    			
	    			String exceptionId=data[0].trim();
	    			String exceptionMessage=data[1].trim().replaceAll("\"", "");
	    			currentBlock.mapCatches.put(exceptionId, exceptionMessage);
	    			currentBlock=currentBlock.parentBlock;
	    		}
	    		
	    		// throw
	    		if(s.startsWith("throw")){
	    			throwBlock=currentBlock;
	    			throwException=s.substring(s.indexOf("(")+1,s.indexOf(")")).trim();
	    		}
	    		
	    		s=reader.readLine();
	    		}
	    	
	    	if(throwBlock!=null)
	    		System.out.println(throwBlock.handleThrow(throwException));
	    	else System.out.println("Unhandled Exception");
	    	
		    }catch(Exception e){
		    	e.printStackTrace(System.err);
		}
	}
}
