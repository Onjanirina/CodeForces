

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class C443A {

	/***/
	public static void main(String[] args) {
		
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		try{
			
			Set<Character> chars=Collections.synchronizedSet(new HashSet<Character>());
			char[] s=reader.readLine().trim().toCharArray();
			for(char ch:s)
				if((ch!='{')&&(ch!='}')&&(ch!=',')&&(ch!=' '))
					chars.add(Character.valueOf(ch));
			System.out.println(chars.size());
			
			reader.close(); 
		}catch(Exception e){}
	}

}
