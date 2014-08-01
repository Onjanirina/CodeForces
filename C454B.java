

import java.util.Scanner;

public class C454B {

	/***/
	public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);
	    
	    int n = scanner.nextInt();
	    int[] r = new int[n];
	    for (int i = 0; i != n; i++)
		r[i] = scanner.nextInt();
	    	    
	    int cBreaks = 0;
	    int lastBreak = 0;
	    
	    for (int i = 0; i != n; i++) {
		int iPrev = (i == 0) ? n - 1: i - 1;
		if( r[i] < r[iPrev]) {
		    cBreaks++;
		    lastBreak = i;
		}
	    }
	    
	    if (cBreaks > 1) {
		
		System.out.println(-1);
		
	    } else {
		
		if (lastBreak == 0)
		    System.out.println(0);
		else System.out.println(n - lastBreak);
	    }
	    
	    scanner.close();
	}

}
