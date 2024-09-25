package classe;

public class TestaVeiculo {

	public static void main(String[] args) {
		Veiculo v1;
		v1 = new Veiculo();
		
		Veiculo v2 = new Veiculo();
		
		v1.velocidade = 0;
		v1.ligar();
		v1.acelerar();
		v1.acelerar();
		v1.acelerar();
		
		System.out.println(v1.mostrarStatus());
		
		v2.velocidade = 0;
		v2.ligar();
		v2.acelerar();
		v2.acelerar();
		v2.acelerar();
		v2.desligar();
		
		System.out.println(v2.mostrarStatus());

	}

}
