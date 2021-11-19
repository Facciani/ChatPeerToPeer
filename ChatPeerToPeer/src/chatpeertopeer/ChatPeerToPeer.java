/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpeertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ChatPeerToPeer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException, IOException {
        
        DatagramSocket server = new DatagramSocket(12345);
        GestioneConnessione g = new GestioneConnessione(server);
        
        g.run();
        try {
            g.join();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ChatPeerToPeer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*DatagramSocket server = new DatagramSocket(12345);
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            server.receive(packet);
            byte[] dataReceived = packet.getData(); // copia del buffer dichiarato sopra
            String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
            System.out.println(messaggioRicevuto);*/
            
            
            
            
            
            
            /*String risposta = "CIAO CLIENT";
            
            byte[] responseBuffer = risposta.getBytes();
            
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            
            InetAddress indirizzo = InetAddress.getByName("localhost"); 
            pacchetto.setAddress(indirizzo);
            
            responsePacket.setAddress("192.168.0.1");
            
            responsePacket.setPort(packet.getPort());
            
            server.send(responsePacket);*/
    }
    
}
