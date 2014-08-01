

import java.util.Scanner;

public class C454A {

	/***/
	public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);
	    
	    int s = 1;
	    int d = 2;
	    int n = scanner.nextInt();
	    for (int i = 0; i != n; i++) {
		
		int r = (n - s) / 2;
		
		for (int j = 0; j != n; j++) {
		    if ((j < r) || ((n - j) <= r))
			System.out.print('*');
		    else System.out.print('D');
		}
		System.out.println();
		
		s += d;
		if (s == n)
		    d = -2;
	    }
	    
	    scanner.close();
	}

}
