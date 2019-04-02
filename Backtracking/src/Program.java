
public class Program {

	public static void main(String[] args) {
		Fazan joc = new Fazan();
		joc.bilete = new String[] { "rege", "eugenie", "elefant" };
		joc.solutii = new int[joc.bilete.length];
		joc.joaca(0);
	}

}
