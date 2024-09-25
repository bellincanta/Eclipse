package sobrecarga;

public class SobrecargaSoma {
	public int soma(int w, int x) {
		return (w + x);
	}
	
	public int soma(int w, int x, int z) {
		return (w + x + z);
	}
	
	public int soma(int w, int x, int z, int y) {
		return (w + x + z + y);
	}
}
