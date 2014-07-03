package leda.aula4;

public class GeraSequenciaTeste {

	public static void main(String[] arts) {
		geraSequencia1(10);
		System.out.println();
		geraSequencia2(10);
	}
	
	private static void geraSequencia1(int n){
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			System.out.print(n + " ");
			geraSequencia1(n-1);
		}
	}
	
	private static void geraSequencia2(int n) {
		if (n == 0) {
			System.out.print(n + " ");
		} else {
			geraSequencia2(n - 1);
			System.out.print(n + " ");
		}
	}
}
