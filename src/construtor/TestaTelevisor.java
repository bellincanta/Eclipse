package construtor;

public class TestaTelevisor {

	public static void main(String[] args) {
		Televisor tv1 = new Televisor();
		Televisor tv2 = new Televisor(20);
		Televisor tv3 = new Televisor(5,100);
		
		tv1.mostrar();
		tv2.mostrar();
		tv3.mostrar();
	}
}

