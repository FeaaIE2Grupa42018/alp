
public class Fazan {
	public String[] bilete;
	public int[] solutii;

	public void joaca(int b) {
		for (int i = 0; i < bilete.length; i++) {
			solutii[b] = i;
			if (valid(b)) {
				if (solutie(b)) {
					afisare();
				} else if (b < bilete.length) {
					joaca(b + 1);
				}
			}
		}
	}

	private void afisare() {
		for (int i = 0; i < solutii.length; i++) {
			System.out.print(bilete[solutii[i]] + " ");
		}
		System.out.println("");

	}

	private boolean solutie(int b) {
		return b == solutii.length - 1;
	}

	private boolean valid(int b) {
		if (b == 0) {
			return true;
		}
		for (int i = 0; i < b; i++) {
			if (solutii[i] == solutii[b]) {
				return false;
			}
		}
		String biletAnterior = bilete[solutii[b - 1]];
		if (biletAnterior.toCharArray()[biletAnterior.length() - 1] != bilete[solutii[b]].toCharArray()[0]) {
			return false;
		}
		return true;
	}
}
