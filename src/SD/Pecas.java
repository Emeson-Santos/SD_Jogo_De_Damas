package SD;

import javax.swing.ImageIcon;

public class Pecas {
	
	
	public static final int PRETA = 0;
	public static final int BRANCA = 1;
	
	private int cor;

	public void setCor(int cor){
		this.cor = cor;
	}
	
	public int getCor(){
		return this.cor;
	}
	
	public ImageIcon getIcon() {
		String peca = (cor == PRETA) ? "peca-preta" : "peca-branca";
		return new ImageIcon(ClassLoader.getSystemResource("Imagens/" + peca + ".png"));
	}
}
