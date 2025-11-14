// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}

	public static boolean is_negative(int x) {
		if (x < 0) {
			return true;
		}
		return false;
	}

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum = x1;
		if (is_negative(x2)){
			for(int i = 0; i < -x2; i++) {
				sum --;
			}	
		}
		else{
			for(int i = 0; i < x2; i++) {
				sum ++;
			}
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int sum = x1;
		if (is_negative(x2)){
			for(int i = 0; i < -x2; i++){
				sum ++;
			}
		}
		else{
			for(int i = 0; i < x2; i++){
				sum --;
			}
		}
		return sum;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int sum = 0;
		if (is_negative(x2)){
			for (int i = 0; i < -x2; i++){
				sum = minus(sum, x1);
		}
		}
		else{
			for (int i = 0; i < x2; i++){
				sum = plus(sum, x1);
		}
		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if (n == 0){
			return 1;
		}
		int sum = x;
		for(int i = 0; i < n-1; i++){
			sum = times(sum, x);
		}
		return sum;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		int res = 0;
		int total = x1;
		int sign = 1;
		// make x1, x2 positive, but remeber the sign for the result
		if (is_negative(x1)){
			sign = pow(sign, -1);
			x1 = -x1;
		}
		if (is_negative(x2)){
			sign = pow(sign, -1);
			x2 = -x2;
		}

		for (int i = 0; i < x1; i++){
			total = minus(total, x2);
			if (total >= 0){
				res ++;
			}
			else {
				return pow(res, sign);
			}
		}
		return pow(res, sign);
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int divResult = div(x1, x2);
		for (int i = 0; i < divResult; i++){
			x1 = minus(x1, x2);
		}
		return x1;
	}


	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		return pow(x, 2);
	}	  	  
}