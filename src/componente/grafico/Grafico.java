package componente.grafico;

import componente.sequencia.ISequencia;

public class Grafico implements IGrafico {
	private boolean preenchido;
	private char caracter;
	private int n;
	
	private ISequencia sequencia;
	
	public Grafico() {
		preenchido = true;
	    caracter = '*';
	    n = 3;
	}

	@Override
	public void connect(ISequencia sequencia) {
		this.sequencia = sequencia;

	}

	@Override
	public void plot() {
		if (sequencia != null) {
			int value = sequencia.primeiro();
			for (int s = 1; s <= n; s++) {
				for (int v = 1; v < value; v++)
					System.out.print((preenchido) ? caracter : ' ');
	            	System.out.println(caracter);
	            	value = sequencia.proximo();
	        }
	    }
	}

	@Override
	public boolean estaPreenchido() {
		return preenchido;
	}

	@Override
	public void setPreenchido(boolean preenchido) {
		this.preenchido = preenchido;

	}

	@Override
	public char getCaracter() {
		return caracter;
	}

	@Override
	public void setCaracter(char caracter) {
		this.caracter = caracter;

	}

	@Override
	public int getN() {
		return n;
	}

	@Override
	public void setN(int n) {
		this.n = n;
	}

}
