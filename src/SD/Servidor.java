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
            System.out.println("Porta '" + PORTA + "' ocupada");
        }
    }

    private static int getCodNovoCliente() {
        return ++codCli;
    }

    private void aceitarCliente() throws IOException {

        Conexao jogador = null;
        while (true) {
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

                jogador = null;
            }
            System.out.println("Conexão #" + codigo);
        }
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Server running");
        Servidor server = new Servidor();
        server.aceitarCliente();
    }
}