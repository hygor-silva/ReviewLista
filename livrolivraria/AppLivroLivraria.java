import java.util.Scanner;

public class AppLivroLivraria {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		Scanner entradaString = new Scanner(System.in);
		
		int menu;
		double vInicial, vFinal;
		
		LivroLivraria objLivro;
		
		String titulo, autor, genero;
		float preco;
		int isbn;
		
		do {
			exibirMenu();
			menu = entrada.nextInt();
			switch(menu) {
			case 1:
				System.out.println("=====> Cadastrar Livro");
				System.out.println("Digite o título: ");
				titulo = entradaString.nextLine();
				System.out.println("Digite o autor: ");
				autor = entradaString.nextLine();
				System.out.println("Digite o gênero: ");
				genero = entradaString.nextLine();
				System.out.println("Digite o ISBN: ");
				isbn = entrada.nextInt();
				System.out.println("Digite o preço: ");
				preco = entrada.nextFloat();
				
				objLivro = new LivroLivraria(titulo, autor, isbn, genero, preco);
				
				Acervo.adicionar(objLivro);
				
				break;
				
			case 2:
				
				System.out.println("=====> Lista de Livros");
				System.out.println(Acervo.listar());
				
				break;
				
			case 3:
				System.out.println("=====> Excluir Livro");
				System.out.println("Digite o Título: ");
				titulo = entradaString.nextLine();
				
				if(! Acervo.getListaLivros().isEmpty()) {
					if(Acervo.remover(titulo)) {
						System.out.println("Livro removido");
					} else {
						System.out.println("Título não foi encontrado");
					}
				} else {
					System.out.println("Não existem livros no acervo");

				}
				
				break;
				
			case 4:
				System.out.println("=====> Pesquisa por Gênero");
				System.out.println("Digite o gênero do livro: ");
				genero = entradaString.nextLine();
				System.out.println("Existem "+ Acervo.pesquisar(genero)+ " Livros do Gênero "+ genero);
				
				break;
				
			case 5:
				System.out.println("=====> Pesquisa por faixa de Preço");
				System.out.println("Digite a faixa inicial e a final: ");
				vInicial = entrada.nextDouble();
				vFinal = entrada.nextDouble();
				
				System.out.println("Existem "+ Acervo.pesquisar(vInicial, vFinal)+ 
						" livros com preço entre "+ String.format("R$ %.2f e R$ %.2f ", vInicial, vFinal));

				break;
				
			case 6:
				System.out.println("=====> Total em R$ de livros do Acervo");
				System.out.println("O total é: "+ String.format("R$ %.2f ", Acervo.calcularTotalAcervo()));

				break;
				
			case 7:
				
				System.out.println("Fechando aplicação");

				break;
				
			default:
				System.out.println("Opção inválida");
			}
			
		}while(menu !=7);

	}

	static void exibirMenu() {
		System.out.println("================ Livro Livraria =====================");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Listar");
		System.out.println("3 - Excluir");
		System.out.println("4 - Pesquisar por Gênero");
		System.out.println("5 - Pesquisar por faixa de Preço");
		System.out.println("6 - Calcular total do Acervo");
		System.out.println("7 - Sair");
		System.out.println("======> Escolha uma opção: ");
		


	}
	
}
