package SD;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Casa extends JButton implements ActionListener{
	
	private int i,j;
	private String Cor;
	boolean Status;
	private boolean ocupado = false;
	private Pecas pecas;
	Casa casa[][];
	
	public Casa(int i, int j){
		pecas = new Pecas();
		this.i = i;
		this.j = j;
		
		setPreferredSize(new Dimension(80, 80));
		addActionListener(this);
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
	public boolean getStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public boolean getOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if(pecas.getCor() == Pecas.BRANCA){
			Regras.movimentoBranca(this);			
		}
		if(pecas.getCor() == Pecas.PRETA){			
			Regras.movimentoPreta(this);
		}
	}

}
