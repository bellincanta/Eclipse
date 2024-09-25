package classe;

public class Veiculo {
	public int velocidade;
	public boolean status;
	
	public void ligar() {
		status = true;
	}
	
	public void desligar() {
		status = false;
		
	}
	
	public String mostrarStatus() {
		String exibir = "Status: " + status + "\nVelocidade: "
				+ velocidade;
		return exibir;
	}

	public void acelerar() {
		velocidade++;
	}
}
