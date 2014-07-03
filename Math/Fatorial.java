package leda.aula4;

public class Fatorial {

	public static void main(String[] args) throws Exception {
		
		System.out.println(fatorial(5));
		
	}

	private static int fatorial(int n) throws Exception {
		
		if (n < 0){
			throw new Exception("Numero invalido");
		} else {
			return fatorialDeN(n);
		}
		
	}

	private static int fatorialDeN(int n) {
		if (n == 0 || n == 1){
			return 1;
		} else {
			return n * fatorialDeN(n - 1);
		}
	}
	
}
