package metodo;

public class TestaExMetodoHora {

	public static void main(String[] args) {
		
		//ExMetodoHora.setHorario(21, 34, 00);
		//ExMetodoHora.setHorario(21, 35, 00);
		//String horario = ExMetodoHora.teste();
				
		ExMetodoHora obj1;
		obj1 = new ExMetodoHora();
				
		obj1.setHorario(22, 06, 0);
		String horario = obj1.toString();		
		System.out.println("A hora atual é: " + horario);
				
		ExMetodoHora obj2 = new ExMetodoHora();
				
		obj2.setHorario(22, 8, 0);
		String horario2 = obj2.toString();		
		System.out.println("A hora atual é: " + horario2);
				
		ExMetodoHora obj3 = new ExMetodoHora();
				
		obj3.setHorario(22, 10, 0);
		String horario3 = obj3.toString();		
		System.out.println("A hora atual é: " + horario3);
	}

}
