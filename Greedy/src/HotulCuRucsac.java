
public class HotulCuRucsac {
	public ObiectFurat[] obiecte;
	public ObiectFurat[] rucsac;
	public int capacitateMax;

	public void umple() {
		sorteaza();
		for (int i = 0; i < obiecte.length; i++) {
			int greutateRamasa = capacitateMax - greutateRucsac();
			if (greutateRamasa == 0) {
				break;
			}
			rucsac[i] = obiecte[i];
			if (greutateRamasa < rucsac[i].greutate) {
				rucsac[i].greutate = greutateRamasa;
			}
		}
	}

	public void arataRucsac() {
		for (int k = 0; k < rucsac.length; k++) {
			if (rucsac[k] == null) {
				break;
			}
			System.out.println("Valoare de " + rucsac[k].valoare + " cu greutatea de " + rucsac[k].greutate);
		}
	}

	public void sorteaza() {
		for (int i = 0; i < obiecte.length; i++) {
			for (int j = 0; j < obiecte.length - 1 - i; j++) {
				if (obiecte[j].raport() < obiecte[j + 1].raport()) {
					ObiectFurat aux = obiecte[j + 1];
					obiecte[j + 1] = obiecte[j];
					obiecte[j] = aux;
				}
			}
		}
	}

	public int greutateRucsac() {
		int suma = 0;
		for (int i = 0; i < rucsac.length; i++) {
			if (rucsac[i] == null) {
				break;
			}
			suma += rucsac[i].greutate;
		}
		return suma;
	}
}
