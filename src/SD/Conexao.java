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

        mensageiro.enviar("Ola Cliente, sua id eh: ");
        mensageiro.enviar(cod + "");
        String msg = mensageiro.ler();

        System.out.println("Handshake Server: <" + msg + ">");
        aguardarDesafiante();
    }

    private void aguardarDesafiante() {
        while (aguardar) {
            try {
                Thread.sleep(2000);
                System.out.println("Aguardando desafiante...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mensageiro.enviar("Desafiante");
        mensageiro.enviar(codDesafiante + "");

        String msg = mensageiro.ler();

        System.out.println("Playing server " + msg);
    }
}