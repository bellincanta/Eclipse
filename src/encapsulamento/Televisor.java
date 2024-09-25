package encapsulamento;

public class Televisor {
	private int volume;
	private int canal;
	
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public int getVolume() {
		return volume;
	}
	
	public void setCanal(int canal) {
		this.canal = canal;
	}
	
	public int getCanal() {
		return canal;
	}
	
	
	public void aumentarVolume() {
		volume++;
	}
	
	public void diminurVolume() {
		volume--;
	}
	
	public void mudarCanal(int canal) {
		this.canal = canal;
	}
	
	public void mostrar() {
		System.out.println("Canal: " + canal + "\nVolume: "
				+ volume);
	}
}
