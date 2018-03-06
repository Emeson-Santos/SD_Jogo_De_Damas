package SD;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {	

	Socket socket;
	private static final String IP = "localhost";
	public Cliente()  {
	try {
		Socket ClienteSocket = new Socket(IP, Servidor.PORTA);
		BufferedReader recebidoServidor = new BufferedReader(new InputStreamReader(ClienteSocket.getInputStream()));
		DataOutputStream enviarServer = new DataOutputStream(ClienteSocket.getOutputStream()); 
		System.out.println("Recebido do servidor: " + recebidoServidor.readLine());
		enviarServer.writeBytes("Boas Vindas" + "\n");
		
		ClienteSocket.close();
	} catch (Exception e) {
		e.printStackTrace();
	}		
	
		
	}
	public static void main(String[] args) {
		new Cliente();
	}
	
}
