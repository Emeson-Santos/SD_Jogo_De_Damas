package SD;

public class Regras {

	private static int ESQUERDA = 0;
	private static int DIREITA = 1;

	public static void movimentoBranca(Casa casa){ //Possiveis posi��es de cada peca Branca

		int linha = casa.getLinha();
		int coluna  = casa.getColuna();

		int novaLinha = linha - 1;
		int[] novasColuna = new int[]{-1, -1};
		if(coluna == 0){						//se estiver no limite do tabuleiro ele n�o passa para menos que (zero)
			novasColuna[DIREITA] = coluna + 1; //movimento para direita
		} else if(coluna == 7){					//Se estiver no limite da coluna a peca n�o vai para mais que 7
			novasColuna[ESQUERDA] = coluna - 1; //movimento para esquerda
		} else {
			novasColuna[ESQUERDA] = coluna - 1; //movimento para esquerda
			novasColuna[DIREITA] = coluna + 1;  //movimento para direita
		}
		
		//===========================
		

		System.out.println("movimentos possiveis da pe�a Branca: linha " + novaLinha + ", coluna " + novasColuna[ESQUERDA] + "\n"
				+ "linha " + novaLinha + ", coluna " + novasColuna[DIREITA]);
	}

	public static void movimentoPreta(Casa casa){//Poss�veis posi��es de cada pe�a Preta

		int linha = casa.getLinha();
		int coluna  = casa.getColuna();

		int novaLinha = linha + 1;
		int[] novasColuna = new int[]{-1, -1};
		if(coluna == 0){						//se estiver no limite do tabuleiro ele n�o passa para menos que (zero)
			novasColuna[DIREITA] = coluna + 1; //movimento para direita
		} else if(coluna == 7){					//Se estiver no limite da coluna a peca n�o vai para mais que 7
			novasColuna[ESQUERDA] = coluna - 1; //movimento para esquerda
		} else {
			novasColuna[ESQUERDA] = coluna - 1; //movimento para esquerda
			novasColuna[DIREITA] = coluna + 1;  //movimento para direita
		}

		System.out.println("movimentos possiveis da pe�a Preta: linha " + novaLinha + ", coluna " + novasColuna[ESQUERDA] + "\n"
				+ "linha " + novaLinha + ", coluna " + novasColuna[DIREITA]);
	}

	public void MovimentacaoDamaPreta(){

	}
	public void MovimentacaoDamaBranca(){

	}
	public void Comerpedra(){
		
	}
	public void capturaObrigatoria(){
		
	}	
	

}
