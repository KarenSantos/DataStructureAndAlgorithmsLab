package leda.aula4;

public class SequenciaDeNaturais {
	
	public static void main(String[] args) throws Exception {
		
		SequenciaDeNaturais.geraSequencia(20);
	}

	public static void geraSequencia(int n) throws Exception {
		if (n < 0){
			throw new Exception("Numero invalido");
		} else {
			geraSequenciaRecursiva(n);
		}
	}

	private static void geraSequenciaRecursiva(int n){
		if (n == 0){
			System.out.print(n + " ");
		} else {
			geraSequenciaRecursiva(n - 1);
			System.out.print(n + " ");
		}
	}
	

}
