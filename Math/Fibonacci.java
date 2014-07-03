package leda.aula4;

public class Fibonacci {

	public static void main(String[] args) throws Exception {
		
		fibonacci(10);
	}

	private static void fibonacci(int n) throws Exception {
		
		if (n <= 0){
			throw new Exception("Numero de termos da serie deve ser maior que 0");
		} else {
			for (int i = 1; i <= n; i++){
				System.out.print(fibonacciNTermos(i) + " ");
			}
		}
	}

	private static int fibonacciNTermos(int n) {
		if (n == 1){
			return 0;
		} else if (n == 2) {
			return 1;
		} else {
			return fibonacciNTermos(n - 1) + fibonacciNTermos(n - 2);
		}
	}
	
}
