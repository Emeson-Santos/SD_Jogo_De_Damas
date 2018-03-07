package SD;

import java.io.IOException;
import java.net.InetAddress;
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

            String msg = mensageiro.ler();
            codigo = Integer.parseInt(mensageiro.ler());
            System.out.println("Handshake client: <" + msg + ">, codigo: " + codigo);
            msg = "Ola servidor, recebi o codigo " + codigo;
            mensageiro.enviar(msg);

            dadosDesafiante();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void dadosDesafiante() {

        String msg = mensageiro.ler();
        String cod = mensageiro.ler();
        codDesafiante = Integer.parseInt(cod == null ? "-1" : cod);
        System.out.println("Playing client: '" + msg + "' desafiante '" + codDesafiante + "'");
    }


    public static void main(String[] args) {
        new Cliente().conectar();
    }
}