import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class NumereRnd {
	
	public static void genereazaNumereInFisier(Integer cateNumere, Integer min, Integer max, String caleFisier)
			throws IOException {

		Random rnd = new Random();
		BufferedWriter writer = new BufferedWriter(new FileWriter(caleFisier));
		while (cateNumere > 0) {
			cateNumere--;
			Integer numar = rnd.nextInt(max - min) + min;
			writer.write(numar.toString());
			writer.newLine();
		}

		writer.flush();
		writer.close();
	}

	public static Integer[] citesteNumereDinFisier(String caleFisier) throws FileNotFoundException {

		ArrayList numere = new ArrayList();

		Scanner cititorFisier = new Scanner(new File(caleFisier));
		while (cititorFisier.hasNextLine()) {
			Integer numar = Integer.parseInt(cititorFisier.nextLine());
			numere.add(numar);
		}

		Integer[] multimeNumere = new Integer[numere.size()];
		for (int i = 0; i < numere.size(); i++) {
			multimeNumere[i] = (Integer) numere.get(i);
		}
		return multimeNumere;

	}

}
