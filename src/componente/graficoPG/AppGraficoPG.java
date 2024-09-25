package componente.graficoPG;

import componente.grafico.*; 

import componente.sequencia.*;

public class AppGraficoPG {

	public static void main(String args[]) {
		IProgressaoGeometrica gp = new ProgressaoGeometrica();
	    gp.setVi(1);
	    gp.setRz(2);
	      
	    IGrafico bc = new Grafico();
	    
	    bc.setPreenchido(true);
	    
	    bc.setCaracter('@');
	    bc.setN(10);
	      
	    bc.connect(gp);
	    bc.plot();
	}
}
