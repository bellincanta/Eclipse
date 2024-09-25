package metodo;

public class TestaExMetodoHorario {

	public static void main(String[] args) {
		
		ExMetodoHorario h1 = new ExMetodoHorario();
		
		h1.setHorario(11,28,00);
		
		System.out.println("Horario 01: " + h1.toString());
	
		ExMetodoHorario h2 = new ExMetodoHorario();
		
		h2.setHorario(11,80,-110);
		
		System.out.println(h2.toString());

	}

}
