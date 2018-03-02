package SD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tabuleiro extends JFrame {
	
Casa casa[][];

	public void CriarTabuleiro() {

		//criando uma matriz para formação do tabuleiro 
		
		GridLayout gridLayout = new GridLayout(8, 8, 5,5);
		JPanel jPanel1 = new JPanel();
		jPanel1.setLayout(gridLayout);

		setResizable(false);
		casa = new Casa[8][8];
		
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				
				Casa c = new Casa(i, j);
				
				if ((i+j) % 2 == 0){
					c.setBackground(Color.WHITE);
				}else{
					c.setBackground(Color.RED);
				}
				casa[i][j] = c;
				jPanel1.add(c);
			}

		}
		add(jPanel1);
		pack();
		
		
		
		
		
		
		
/*
		System.out.println(" 1  2   3  4  5 6 7  8");

		
		
		for (int i = 0; i < casa.length; i++) {

			String str = String.valueOf(i+1);
			System.out.print(str);
			for (int j = 0; j < casa[0].length; j++) {	

				casa[i][j]= new Casa();
				casa[i][j].setStatus(true);


				if ((i+j)%2==0){
					casa[i][j].setCor("*");
					System.out.print("  " + casa[i][j].getCor()+ " "); 

					//System.out.println("Preta");
				}else{
					casa[i][j].setCor("#");
					System.out.print("  " + casa[i][j].getCor()+ " ");

				}

			}
			*/

			System.out.println();
		
	}
	
	public void Pecajogador1(){

		//System.out.print("aqui");
		for (int i = 0; i < 3; i++) {			
			for (int j = 0; j < 8; j++) {

				if ((i+j)%2 != 0){
					
					casa[i][j].setOcupado(true);
					casa[i][j].alterarPeca(Pecas.PRETA);

					//System.out.print(""+casa[i][j].pecas.getCor());
				//	System.out.print("i: "+i+"j: "+j);
				}				
			}
		}
	}

	public void Pecajogador2(){
		//System.out.println("Jogador 2");
		//System.out.print("aqui");
		for (int i = 7; i >= 5; i--) {			
			for (int j = 7; j >= 0; j--) {

				if ((i+j)%2 != 0){
					
					casa[i][j].setOcupado(true);
					casa[i][j].alterarPeca(Pecas.BRANCA);
					//casa[i][j].pecas.setCor("$" );		 

					//System.out.print(""+casa[i][j].pecas.getCor());
				//	System.out.print("i: "+i+"j: "+j);
				}				


			}
		}
		
		
	}
	public void ExibirTabuleiro(){
		System.out.println("  1  2  3  4  5  6  7  8");	
		for (int i = 0; i < casa.length; i++) {
			
			String str = String.valueOf(i+1);
			System.out.print(str);
			
			for (int j = 0; j < casa[0].length; j++) {

				if (casa[i][j].getOcupado() == true){
					
					//System.out.print(" " + casa[i][j].pecas.getCor()+ " " );
					
				}else{
				
					System.out.print(" " + casa[i][j].getCor()+ " " );
				}

			}
			System.out.println();

		}
	}
}
