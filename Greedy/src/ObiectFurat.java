
public class ObiectFurat {
	public int greutate;
	public int valoare;

	public ObiectFurat(int greutate, int valoare) {
		this.greutate = greutate;
		this.valoare = valoare;
	}

	public double raport() {
		return valoare / greutate;
	}

}
