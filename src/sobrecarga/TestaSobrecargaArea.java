package sobrecarga;

public class TestaSobrecargaArea {

	public static void main(String[] args) {
		SobrecargaArea quadrado = new SobrecargaArea();
		SobrecargaArea losango = new SobrecargaArea();
		SobrecargaArea paralelo = new SobrecargaArea();
		
	
		System.out.println("Área de um quadrado: " + quadrado.area(5));
		System.out.println("Área de um losangulo: " + losango.area(10, 10)/2);
		System.out.println("Área de um paraleogramo: " + paralelo.area(10, 10));

	}

}
