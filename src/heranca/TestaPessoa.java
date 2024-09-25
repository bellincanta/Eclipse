package heranca;

import java.util.Scanner;

public class TestaPessoa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        Funcionario p = new Funcionario();

        //String nome, rg, cartao;

        System.out.print("Informe o nome: ");
        //nome = sc.nextLine();
        p.setNome(sc.nextLine());
        System.out.print("Informe o RG: ");
        //rg = sc.nextLine();
        p.setRg(sc.nextLine());
        System.out.print("Informe o Cartão: ");
        //cartao = sc.nextLine();
        p.setCartao(sc.nextLine());

        System.out.print(p.getNome() + p.getRg() + p.getCartao());

        sc.close();

	}

}
