import java.io.*;
import java.net.*;

public class UDPServerSimple {
    public static void main(String[] args) {
        // A porta vem do argumento passado na execução
        int portNumber = Integer.parseInt(args[0]);
        // Ainda não existe socket criado; a variável começa sem apontar para objeto
        DatagramSocket aSocket = null;
        try {
            // Cria o socket na porta informada; se ela estiver ocupada, ocorre erro
            aSocket = new DatagramSocket(portNumber);
            while (true) {
                // Reserva espaço para receber até 1000 bytes
                byte[] buffer = new byte[1000];
                // Prepara o pacote que será preenchido na recepção
                DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                System.out.println("Esperando mensagem chegar no receive.");
                // Aqui o programa fica bloqueado até chegar um pacote
                aSocket.receive(request);
                // Converte os bytes recebidos em texto para imprimir
                String data = new String(request.getData());
                // Mostra a mensagem recebida
                System.out.println("Mensagem recebida do Cliente UDP Simples = " + data.trim());
            }
        } catch (SocketException e) {
            System.out.println("Socket " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO " + e.getMessage());
        } finally {
            if (aSocket != null)
                aSocket.close();
        }
    }
}
