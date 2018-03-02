package SD;

import javax.swing.JFrame;

public class APPDamas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tabuleiro t = new Tabuleiro();
		
		t.CriarTabuleiro();
		t.Pecajogador1();
		t.Pecajogador2();	
		System.out.println();
		//t.ExibirTabuleiro();
		
		
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//t.setSize(800,500);
		t.setVisible(true);
		t.setLocationRelativeTo(null);
	}

}
