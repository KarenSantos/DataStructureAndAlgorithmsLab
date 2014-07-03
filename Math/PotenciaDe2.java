package leda.aula4;

public class PotenciaDe2 {

	public static void main(String[] args) throws Exception{

		System.out.println(potencia(4));

	}

	private static int potencia(int n) throws Exception {
		if (n < 0) {
			throw new Exception("Numero invalido");
		} else {
			return calculaPotencia(n);
		}
	}
	
	private static int calculaPotencia(int n){
		if (n == 0){
			return 1;
		} else if (n == 1){
			return 2;
		} else {
			return 2*calculaPotencia(n-1);
		}
	}

}
