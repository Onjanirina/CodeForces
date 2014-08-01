

import java.util.Scanner;

public class C454C {

	/***/
	public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);
	    
	    int m = scanner.nextInt();
	    int n = scanner.nextInt();
	    
	    double p = (double) 1 / m;
	    
	    double result = 0;
	    double[] prob = new double[m];
	    double[] probX = new double[m];
	    for (int i = 0; i != m; i++) {
		prob[i] = (i == 0)? p : p + prob[i - 1];
		probX[i] = Math.pow(prob[i], n);
		
		double probY = (i == 0)? probX[i]: probX[i]- probX[i - 1];
		result += ((i + 1) * probY);
	    }
	    
	    System.out.println(result);
	    scanner.close();
	}

}
