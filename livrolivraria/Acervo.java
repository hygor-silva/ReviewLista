import java.util.ArrayList;

public class Acervo {

	private static ArrayList<LivroLivraria> listaLivros = new ArrayList<>();

	public static ArrayList<LivroLivraria> getListaLivros() {
		return listaLivros;
	}
	
	public static void adicionar(LivroLivraria l) {
		listaLivros.add(l);
	}
	
	public static String listar() {
		String saida = "";
		int i =1;
		for(LivroLivraria l : listaLivros) {
			saida += "\n====== Livro N. "+ (i++) + " ======\n";
			saida += l.imprimir()+"\n";
		}
		
		return saida;
	}
	
	public static int pesquisar(String genero) {
		
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if(l.getGenero().equalsIgnoreCase(genero)) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public static int pesquisar(double vInicial, double vFinal) {
		
		int qtd = 0;
		for (LivroLivraria l : listaLivros) {
			if(l.getPreco() >= vInicial && l.getPreco() <= vFinal) {
				qtd++;
			}
		}
		return qtd;
	}
	
	public static boolean remover(String titulo) {
		for (LivroLivraria l : listaLivros) {
			if(l.getTitulo().equalsIgnoreCase(titulo)) {
				listaLivros.remove(l);
				return true;
			}
		}
		return false;
	}

	public static double calcularTotalAcervo() {
		double total = 0;
		for (LivroLivraria l : listaLivros) {
			total += l.getPreco();
		}
		return total;
	}
	
}
