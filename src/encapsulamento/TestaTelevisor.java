package encapsulamento;

public class TestaTelevisor {

	public static void main(String[] args) {
		Televisor tv1;
		tv1 = new Televisor();
		
		tv1.setCanal(30);
		tv1.setVolume(5);
		tv1.aumentarVolume();
		tv1.aumentarVolume();
		tv1.aumentarVolume();
		tv1.diminurVolume();
		
		System.out.println("Canal: " + tv1.getCanal() 
				+ "\nVolume: " + tv1.getVolume());
	}
}

