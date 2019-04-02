
public class Main {

	public static void main(String[] args) {
		System.out.println("Hotul cu rucsac!");

		HotulCuRucsac furt = new HotulCuRucsac();
		furt.capacitateMax = 15;
		ObiectFurat of1 = new ObiectFurat(4, 10);
		ObiectFurat of2 = new ObiectFurat(1, 2);
		ObiectFurat of3 = new ObiectFurat(1, 1);
		ObiectFurat of4 = new ObiectFurat(12, 4);
		ObiectFurat of5 = new ObiectFurat(2, 2);
		furt.obiecte = new ObiectFurat[] { of1, of2, of3, of4, of5 };
		furt.rucsac = new ObiectFurat[furt.obiecte.length];
		furt.umple();
		furt.arataRucsac();

	}

}
