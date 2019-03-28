import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		// infinit(10);
		// System.out.println(factorial(3));

		Integer n = 3562;
		System.out.println("n=" + n);
		System.out.println("n invers=" + invers(n));
		
		//compara algoritmul de min clasic vs. recursiv
		final String cale = "min.txt";
		Integer[] numere;
		try {
			NumereRnd.genereazaNumereInFisier(1000, 10, 1000000, cale);
			numere = NumereRnd.citesteNumereDinFisier(cale);
		} catch (IOException e) {			
			e.printStackTrace();
			return;
		}
		
		long start = System.nanoTime();
		minClasic(numere);
		long end = System.nanoTime();
		System.out.println("min clasic: " + (double)(end-start)/1000000 + " ms");
		
		start = System.nanoTime();
		minRecursiv(numere[0], numere, 0);
		end = System.nanoTime();
		System.out.println("min recursiv: " + (double)(end-start)/1000000 + " ms");
		
		

	}

//	static int contor = 0;

	private static void infinit(int contor) {
		if (contor == 0) {
			return;
//			contor++;
		}

		infinit(contor - 1);
		System.out.println("contor: " + contor);
	}

	private static Integer factorial(Integer n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	private static Integer invers(Integer n) {
		if (n < 10) {
			return n;
		}
		Integer intreg = n / 10;
//		Integer exp = (int) Math.floor(Math.log10(n));
		Integer exp = nrCifre(intreg);
		Integer rest = n % 10;

		Integer inv = (int) (rest * Math.pow(10, exp) + invers(intreg));
		return inv;
	}

	private static int nrCifre(Integer n) {
		if (n < 10) {
			return 1;
		}
		return 1 + nrCifre(n / 10);
		/*
		 * int contor = 0; while (n > 0) { contor++; n = n / 10; } return contor;
		 */
	}

	private static Integer minRecursiv(Integer min, Integer[] numere, Integer index) {
		if (index == numere.length - 1) {
			return numere[numere.length - 1];
		}
		min = minRecursiv(min, numere, index + 1);
		return min < numere[index] ? min : numere[index];

	}

	private static Integer minClasic(Integer[] numere) {
		Integer min = numere[0];
		for (int i = 1; i < numere.length; i++) {
			if (numere[i] < min) {
				min = numere[i];
			}
		}
		return min;

	}

}
