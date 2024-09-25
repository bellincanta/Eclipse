package sobrecarga;

public class TestaSobrecargaSoma {

	public static void main(String[] args) {
		SobrecargaSoma obj1 = new SobrecargaSoma();
		SobrecargaSoma obj2 = new SobrecargaSoma();
		SobrecargaSoma obj3 = new SobrecargaSoma();
		
		System.out.println("A soma de dois números é: " 
				+ obj1.soma(1, 2));
		System.out.println("A soma de três números é: " 
				+ obj2.soma(1, 2, 3));
		System.out.println("A soma de quatro números é: " 
				+ obj3.soma(1, 2, 3, 4));

	}

}
