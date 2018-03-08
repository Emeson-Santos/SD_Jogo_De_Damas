package SD;

import java.net.Socket;

public class Conexao extends Thread {

    private Socket conexao;
    private Mensageiro mensageiro;
    private int cod, codDesafiante;
    private String ip, ipDesafiante;
    private boolean aguardar;

    Conexao(int cod, Socket conexao) {
        this.cod = cod;
        this.mensageiro = new Mensageiro(conexao);
    }

    void setAguardar(boolean aguardar) {
        this.aguardar = aguardar;
        interrupt();
    }

    String getIp() {
        return ip;
    }

    int getCod() {
        return cod;
    }

    void setDadosDesafiante(String ip, int cod) {
        this.ipDesafiante = ip;
        this.codDesafiante = cod;
    }

    public void run() {
        super.run();
        String mensagem = "Ola Cliente, sua id eh: ";
        mensageiro.enviar(mensagem);
        mensageiro.enviar(cod + "");
        mensageiro.print('S', mensagem + cod);
        mensageiro.print('C', "Handshake: " + mensageiro.ler());

        aguardarDesafiante();
    }

    private void aguardarDesafiante() {
        while (aguardar) {
            try {
                Thread.sleep(5000);
                mensageiro.print('S', "Aguardando desafiante...");
            } catch (InterruptedException e) {
                //e.printStackTrace();
                mensageiro.print('S', "Desafiante conectado.");
            }
        }
        mensageiro.enviar("Desafiante");
        mensageiro.enviar(codDesafiante + "");

        mensageiro.print('S', mensageiro.ler() + " " + codDesafiante);

        while(true){}
    }
}