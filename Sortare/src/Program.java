import java.io.IOException;
import java.util.Arrays;

public class Program {

	public static void main(String[] args) {
		String cale = "sort.txt";
		try {
			NumereRnd.genereazaNumereInFisier(1000, 10, 1000000, cale);
			Integer[] sir = NumereRnd.citesteNumereDinFisier(cale);
			Integer[] sir1 = sir.clone();
			Integer[] sir2 = sir.clone();
			Integer[] sir3 = sir.clone();
			Integer[] sir4 = sir.clone();

			//System.out.println("initial: " + Arrays.toString(sir));

			long start = System.nanoTime();
			bubbleSort(sir);
			long end = System.nanoTime();
			//System.out.println("bubble: " + Arrays.toString(sir));
			System.out.println("bubble: " + (double)(end - start) / 1000000 + " ms ");

			start = System.nanoTime();
			insertSort(sir1);
			end = System.nanoTime();
			//System.out.println("insert: " + Arrays.toString(sir1));
			System.out.println("insert: " + (double)(end - start) / 1000000 + " ms ");
			
			start = System.nanoTime();
			selectSort(sir2);
			end = System.nanoTime();	
			//System.out.println("select: " + Arrays.toString(sir2));
			System.out.println("select: " + (double)(end - start) / 1000000 + " ms ");
			
			start = System.nanoTime();
			mergeSort(sir3, 0, sir3.length-1);
			end = System.nanoTime();	
			//System.out.println("merge: " + Arrays.toString(sir3));
			System.out.println("merge: " + (double)(end - start) / 1000000 + " ms ");
			
			start = System.nanoTime();
			quickSort(sir4, 0, sir3.length-1);
			end = System.nanoTime();	
			//System.out.println("quick: " + Arrays.toString(sir4));
			System.out.println("quick: " + (double)(end - start) / 1000000 + " ms ");	


		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void bubbleSort(Integer[] sir) {
		// O(n*n)
		// O(n) - cel mai bun caz
		boolean ordonat = false;
		int ultim = sir.length;
		int ultimTemp = ultim;
		while (!ordonat) {
			ordonat = true;
			for (int i = 1; i < ultim; i++) {
				if (sir[i] < sir[i - 1]) {
					Integer temp = sir[i];
					sir[i] = sir[i - 1];
					sir[i - 1] = temp;
					ordonat = false;
					ultimTemp = i;
				}
			}
			ultim = ultimTemp;
		}
	}

	private static void insertSort(Integer[] sir) {
		// O(n*n)
		// cazul favorabil O(n)
		for (int i = 1; i < sir.length; i++) {
			Integer curent = sir[i];
			int j = i - 1;
			while (j >= 0 && curent < sir[j]) {
				sir[j + 1] = sir[j];
				j--;
			}
			sir[j + 1] = curent;
		}
	}

	private static void selectSort(Integer[] sir) {
		// O(n*n)
		// cazul favorabil O(n*n)
		for (int i = 0; i < sir.length; i++) {
			int indexMin = i;
			for (int j = i + 1; j < sir.length; j++) {
				if (sir[j] < sir[indexMin]) {
					indexMin = j;
				}
			}
			if (indexMin != i) {
				Integer temp = sir[i];
				sir[i] = sir[indexMin];
				sir[indexMin] = temp;
			}
		}

	}

	private static void merge(Integer[] sir, int s, int m, int d) {

		Integer[] sirS = new Integer[m - s + 1];
		for (int i = 0; i < sirS.length; i++) {
			sirS[i] = sir[s + i];
		}

		Integer[] sirD = new Integer[d - m];
		for (int i = 0; i < sirD.length; i++) {
			sirD[i] = sir[m + 1 + i];
		}

		int i = 0, j = 0, k = s;
		while (i < sirS.length && j < sirD.length) {
			if (sirS[i] < sirD[j]) {
				sir[k] = sirS[i];
				i++;
			} else {
				sir[k] = sirD[j];
				j++;
			}
			k++;
		}

		while (i < sirS.length) {
			sir[k] = sirS[i];
			k++;
			i++;
		}
		while (j < sirD.length) {
			sir[k] = sirD[j];
			k++;
			j++;
		}

	}

	private static void mergeSort(Integer[] sir, int s, int d) {
		if (s < d) {
			int m = s + (d - s) / 2;
			mergeSort(sir, s, m);
			mergeSort(sir, m + 1, d);
			merge(sir, s, m, d);
		}
	}

	private static int partition(Integer[] sir, int s, int d) {
		Integer pivot = sir[d];
		int indexPivot = s;
		for (int i = s; i < d; i++) {
			if (sir[i] < pivot) {
				if (i != indexPivot) {
					int temp = sir[indexPivot];
					sir[indexPivot] = sir[i];
					sir[i] = temp;
				}
				indexPivot++;
			}
		}

		int temp = sir[indexPivot];
		sir[indexPivot] = pivot;
		sir[d] = temp;

		return indexPivot;
	}

	private static void quickSort(Integer sir[], int s, int d) {
		if (s < d) {
			int indexPivot = partition(sir, s, d);
			quickSort(sir, s, indexPivot - 1);
			quickSort(sir, indexPivot + 1, d);
		}
	}
}
