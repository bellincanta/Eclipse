package sobreposicao;

public class TestaAnimal {
	
	public static void main(String args[]) {
		Animal meuAnimal = new Animal();
        meuAnimal.emitirSom();  // Chama o método da superclasse

        // Criação de um objeto da classe Cachorro
        Cachorro meuDog = new Cachorro();
        meuDog.emitirSom();  // Chama o método sobreposto na subclasse
        
        Gato meuCat = new Gato();
        meuCat.emitirSom();
        
	}

}
