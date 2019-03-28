import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// System.out.println("Hello Alp");
		String caleFisiser = "numere.txt";

		try {
			NumereRnd.genereazaNumereInFisier(10, 5000, 1000000, caleFisiser);
		} catch (IOException e) {
			// afiseasa mesaj de eroare
			System.out.println("Nu s-a putut genera fisierul");
		}

		Integer[] numere;// = new Integer[0];
		try {
			numere = NumereRnd.citesteNumereDinFisier(caleFisiser);
		} catch (FileNotFoundException e) {
			// afiseasa mesaj de eroare
			System.out.println("Nu s-a putut citi fisierul");
			return;
		}

		Integer min = numere[0];
		Integer max = numere[0];
		for (int i = 1; i < numere.length; i++) {
			if (numere[i] < min) {
				min = numere[i];
			}
			if (numere[i] > max) {
				max = numere[i];
			}
		}

		System.out.println("Minimum este: " + min);
		System.out.println("Maximum este: " + max);
	}

	
}
