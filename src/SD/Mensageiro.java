package SD;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Mensageiro {

    private BufferedReader leitor;
    private DataOutputStream emissor;

    Mensageiro (Socket socket){

        try {
            leitor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            emissor = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void print(char prefix, String mensagem){
        System.out.println("[" + prefix + "] > " + mensagem);
    }

    void enviar(String msg){
        try {
            emissor.writeBytes(msg + "\n");
            emissor.flush();
        } catch (IOException e) {
            System.err.println("Erro ao enviar: " + e.getMessage());
        }
    }

    String ler(){
        try {
            return leitor.readLine();
        } catch (IOException e) {
            //System.err.println("Erro ao ler: " + e.getCause().getMessage());
            e.printStackTrace();
        }
        return null;
    }
}