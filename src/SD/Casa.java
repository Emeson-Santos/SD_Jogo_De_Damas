package SD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Casa extends JButton implements MouseListener{

	private int i,j;
	private String Cor;
	private boolean status, posicaoValida, ocupado;
	private Pecas pecas;
	private Tabuleiro tabuleiro;

	public Casa(Tabuleiro tabuleiro, int i, int j){
		pecas = new Pecas();
		this.tabuleiro = tabuleiro;
		this.i = i;
		this.j = j;

		setPreferredSize(new Dimension(80, 80));
		addMouseListener(this);
	}

	public int getLinha(){
		return i;
	}

	public int getColuna(){
		return j;
	}

	public void alterarPeca(int cor){
		pecas.setCor(cor);
		setIcon(pecas.getIcon());
	}

	public String getCor() {
		return Cor;
	}

	public void setCor(String cor) {
		Cor = cor;
	}

	public boolean getOcupado() {
		return ocupado;
	}

	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}


	private void destacarMovimento(Color color){

        Regras.Movimentos movimentos = pecas.getCor() == Pecas.BRANCA
                ? Regras.movimentoBranca(i, j)
                : Regras.movimentoPreta(i, j);

        if(posicaoValida && ocupado) {
			int linha = movimentos.getLinha();
			int direita = movimentos.getDireita();
			int esquerda = movimentos.getEsquerda();

			if (movimentoValido(linha, direita)) {
				destacar(tabuleiro.getCasa(linha, direita), color);
			}

			if (movimentoValido(linha, esquerda)) {
				destacar(tabuleiro.getCasa(linha, esquerda), color);
			}
		}
	}


	private void destacar(Casa casa, Color c){
		if(!casa.ocupado) casa.setBackground(c);
	}

	private boolean movimentoValido(int linha, int coluna){
		return linha != Regras.MOVIMENTO_INVALIDO && coluna != Regras.MOVIMENTO_INVALIDO;
	}

	@Override
	public void setBackground(Color bg) {
		super.setBackground(bg);
		if(bg == Color.RED) posicaoValida = true;
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {


		destacarMovimento(Color.MAGENTA);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		//destacarMovimento(Color.RED);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		destacarMovimento(Color.LIGHT_GRAY);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		destacarMovimento(Color.RED);
	}
}
