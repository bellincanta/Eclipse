package escopo;

public class TestaCelular {

	public static void main(String[] args) {
		Celular c1 = new Celular();
		Celular c2 = new Celular();
		Celular c3 = new Celular();

		Celular.empresa = "IFPR - Campus Cascavel";
		c1.numero = "45 9990-0001";
		
		c2.numero = "45 9990-0002";
		
		c3.numero = "45 9990-0003";

		System.out.println("Celular 01: " 
				+ c1.numero + "Empresa: " + c1.empresa
				+ "\nCelular 02: " 
				+ c2.numero + "Empresa: " + c2.empresa
				+ "\nCelular 03: " 
				+ c3.numero + "Empresa: " + c3.empresa
				);

	}

}
