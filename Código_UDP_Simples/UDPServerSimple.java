import java.net.*;
import java.io.*;

public class UDPServerSimple {
    public static void main(String[] args){
        int portNumber = Integer.parseInt(args[0]);
        DatagramSocket aSocket = null;
        try{
        	aSocket = new DatagramSocket(portNumber);
        	while(true){
                byte[] buffer = new byte[1000];
        		DatagramPacket request = new DatagramPacket(buffer, buffer.length);
                System.out.println("Esperando mensagem chegar no receive.");
        		aSocket.receive(request);				
        		String data = new String(request.getData());
                System.out.println("Mensagem recebida do Cliente UDP Simples = " + data.trim());
        	}
        }catch(SocketException e){
        	System.out.println("Socket " + e.getMessage());
        } catch(IOException e)
        	{System.out.println("IO " + e.getMessage());
        } finally{
        	if(aSocket != null) 
        		aSocket.close();
        }
    }
}                       