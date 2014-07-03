package leda.aula4;

public class Somatorio {
	
	public static void main(String[] args) throws Exception {
		
		System.out.println(somatorio(10));
		
	}

	private static int somatorio(int n) throws Exception {
		
		if (n <= 0){
			throw new Exception("Numero invalido");
		} else {
			return somatorioDeN(n);
		}
		
	}

	private static int somatorioDeN(int n) {
		if (n == 1){
			return 1;
		} else {
			return n + somatorioDeN(n - 1);
		}
	}

}
