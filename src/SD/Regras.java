package SD;

public class Regras {

	static final int MOVIMENTO_INVALIDO = -1;

	public static Movimentos movimentoBranca(int linha, int coluna){ //Possiveis posi��es de cada peca Branca

		//int coluna  = casa.getColuna();

		Movimentos movimentos = new Movimentos();

		movimentos.setEsquerda(coluna - 1);
		movimentos.setDireita(coluna + 1);
		movimentos.setLinha(linha - 1);
		return movimentos;
	}

	public static Movimentos movimentoPreta(int linha, int coluna){//Poss�veis posi��es de cada pe�a Preta
		Movimentos movimentos = new Movimentos();

		movimentos.setEsquerda(coluna - 1);
		movimentos.setDireita(coluna + 1);
		movimentos.setLinha(linha + 1);
		return movimentos;
	}

	public void MovimentacaoDamaPreta(){

	}
	public void MovimentacaoDamaBranca(){

	}
	public void Comerpedra(){
		
	}
	public void capturaObrigatoria(){
		
	}

	public static class Movimentos{

		private int linha, esquerda, direita;

		private Movimentos() {
			linha = esquerda = direita = MOVIMENTO_INVALIDO;
		}

		int getLinha() {
			return linha;
		}

		private void setLinha(int linha){
			if(posicaoValida(linha)) this.linha = linha;
		}

		int getEsquerda() {
			return esquerda;
		}

		private void setEsquerda(int esquerda){
			if(posicaoValida(esquerda)) this.esquerda = esquerda;
		}

		public int getDireita() {
			return direita;
		}

		private void setDireita(int direita){
			if(posicaoValida(direita)) this.direita = direita;
		}

		private boolean posicaoValida(int posicao){
			return posicao >= 0 && posicao <= 7;
		}
	}
}
