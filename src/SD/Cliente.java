package SD;

import java.io.IOException;
import java.net.Socket;

public class Cliente {

    private int codigo, codDesafiante;
    private Mensageiro mensageiro;


    public Cliente() {

        codDesafiante = -1;
        mensageiro = null;
    }

    private void conectar() {

        try {
            Socket clienteSocket = new Socket(Servidor.IP, Servidor.PORTA);

            mensageiro = new Mensageiro(clienteSocket);
            String mensagem = mensageiro.ler();
            codigo = Integer.parseInt(mensageiro.ler());
            mensageiro.print('S', mensagem + " " + codigo);

            mensagem = "Ola servidor, recebi o codigo " + codigo;
            mensageiro.enviar(mensagem);
            mensageiro.print('C', mensagem);

            aguardarDesafiante();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void aguardarDesafiante() {

        String msg = mensageiro.ler();
        String cod = mensageiro.ler();
        codDesafiante = Integer.parseInt(cod == null ? "-1" : cod);
        mensageiro.print('C', msg + " " + codDesafiante);
        while(true){}
    }


    public static void main(String[] args) {
        new Cliente().conectar();
    }
}