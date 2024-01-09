/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
    /** 
     * Gets the loan data and computes the periodical payment.
     * Expects to get three command-line arguments: sum of the loan (double),
     * interest rate (double, as a percentage), and number of payments (int).  
     */

	// main(string[]) - the entry point of a Java program.
    // args - args contains the supplied command-line
    // arguments as an array of String objects.
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
	/**
	* Uses a sequential search method  ("brute force") to compute an approximation
	* of the periodical payment that will bring the ending balance of a loan close to 0.
	* Given: the sum of the loan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.

	// bruteForceSolver - search for the ideal Periodical payment using the brute force search methood.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		// declaring a first gueass bigger the n 0 for the implementation of the brute force search methood.
    	double guess = loan / n;
		// reseting the value of the flobal variable that counts the iterations of each search methood to 0.
		iterationCounter = 0;
		// implementation of the brute force search methood.
		while (endBalance(loan, rate, n, guess) >= 0) {
			guess += epsilon;
			iterationCounter++;
		}
    	return guess;
    }
    
    /**
	* Uses bisection search to compute an approximation of the periodical payment 
	* that will bring the ending balance of a loan close to 0.
	* Given: the sum of theloan, the periodical interest rate (as a percentage),
	* the number of periods (n), and epsilon, a tolerance level.
	*/
	// Side effect: modifies the class variable iterationCounter.

	// bisectionSolver - search for the ideal Periodical payment using the bisection search methood.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
		// declaring H, L and M values for the implementation of the bisection search methood.
    	double low = 0.0;
		double high = loan;
		double middle = (high + low) / 2;
		// reseting the value of the flobal variable that counts the iterations of each search methood to 0.
		iterationCounter = 0;
		// implementation of the bisection search methood.
		while ((high - low) > epsilon) {
			if ((endBalance(loan, rate, n, middle) * endBalance(loan, rate, n, low)) > 0) {
				low = middle;
			}
			else{
				high = middle;
			}
			middle = (high + low) / 2;
			iterationCounter++;
		}
    	return middle;
    }
	
	/**
	* Computes the ending balance of a loan, given the sum of the loan, the periodical
	* interest rate (as a percentage), the number of periods (n), and the periodical payment.
	*/

	// endBalance - calculate the n'th period's balance by loan, rate, periods and payment
	// according to the excel's calculations.
	private static double endBalance(double loan, double rate, int n, double payment) {
		// declaring the last balance variable starting from loan downwards.
		double bal = loan;
		for (int i = 0; i < n; i++) {
			// calculating the next period's balance as the excel does.
			bal = (bal - payment) * (1 + rate/100);
		}
    	return bal;
	}
}