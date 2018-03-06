package SD;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	private static int codCli = 0;
	ServerSocket serverSocket = null;
	
	public static final int PORTA = 6789;
	
	public Servidor() throws IOException{
		
		serverSocket = new ServerSocket(PORTA);
	}
	public static int getCodNovoCliente(){
		return codCli++;
		
	}
	
	public void aceitarCliente() throws IOException{
		if (serverSocket != null) {
			
			while (true) {
				Socket jogador = serverSocket.accept();
				new Conexao(jogador).start();
				System.out.println("Conexão #" + (codCli));
			}
		}
	}
	public static void main(String[] args) throws IOException {
		
		System.out.println("Server morning");
		Servidor server = new Servidor();
		server.aceitarCliente();
	}
	
}
