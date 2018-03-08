package SD;

import java.io.IOException;
import java.net.ServerSocket;

public class Servidor {

    private static int codCli = 0;
    private ServerSocket serverSocket = null;

    static final String IP = "localhost";
    static final int PORTA = 6789;

    public Servidor() {
        try {
            serverSocket = new ServerSocket(PORTA);
        } catch (IOException e) {
            errln("Porta '" + PORTA + "' ocupada");
        }
    }

    private static int getCodNovoCliente() {
        return ++codCli;
    }

    private void aceitarCliente() throws IOException {

        errln("Servidor iniciado. Aguardando jogadores...");
        Conexao jogador = null;
        boolean flag = true;
        while (flag) {
            int codigo = getCodNovoCliente();
            if (jogador == null) {

                jogador = new Conexao(codigo, serverSocket.accept());
                jogador.setAguardar(true);
                jogador.start();
            } else {

                Conexao desafiante = new Conexao(codigo, serverSocket.accept());

                jogador.setDadosDesafiante(desafiante.getIp(), desafiante.getCod());
                jogador.setAguardar(false);

                desafiante.setDadosDesafiante(jogador.getIp(), jogador.getCod());
                desafiante.start();
                flag = false;
            }

            errln("Jogador #" + codigo + " conectado");
        }
        errln("Conexão estabelecida: a partida ira iniciar");
    }

    private void errln(String mensagem){
        System.err.println("[M] > " + mensagem);
    }

    public static void main(String[] args) throws IOException {

        Servidor server = new Servidor();
        server.aceitarCliente();
    }
}