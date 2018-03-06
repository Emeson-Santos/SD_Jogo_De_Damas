package SD;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Conexao extends Thread{
	
private Socket conexao;
	
public Conexao(Socket conexao) {
	this.conexao = conexao;
}
	public void run() {
		super.run();
		
		try {
			int codCli = Servidor.getCodNovoCliente();
			
			BufferedReader RecebidoCliente = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
			DataOutputStream enviarCliente = new DataOutputStream(conexao.getOutputStream());
			
			enviarCliente.writeBytes("Ola Clioente sua id é: " + codCli+ "\n");
			System.out.println("Mensagem: " + RecebidoCliente.readLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
