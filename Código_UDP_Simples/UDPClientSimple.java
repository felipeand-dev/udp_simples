import java.net.*;
import java.io.*;

public class UDPClientSimple {
    public static void main(String[] args){ 

        DatagramSocket aSocket = null;
        try{
        	aSocket = new DatagramSocket();
            byte[] msg = args[0].getBytes();
            InetAddress aHost = InetAddress.getByName(args[1]);
            int serverPort = Integer.parseInt(args[2]);
        	DatagramPacket request = new DatagramPacket(msg, msg.length, aHost, serverPort);
            System.out.println("Enviando mensagem '" + args[0] + "' para o Servidor UDP Simples.");
        	aSocket.send(request);	
        	
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