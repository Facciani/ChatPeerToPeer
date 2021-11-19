/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpeertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
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
    public static void main(String[] args) throws UnknownHostException{
        
        int[] porte = {12345,12346,12347,12348,12349,12350};
        
        int portUtilizzata = 0;
        DatagramSocket server=null;
        for(int i = 0; i<porte.length;i++)
        {
            try {
                 server = new DatagramSocket(porte[i]);
                portUtilizzata = porte[i];
                break;
            } catch (SocketException ex) {
                
            }
        }
        
        if(portUtilizzata == 0)
        {
            System.out.println("Nessuna porta utilizzabile");
        }else
        {
            InetAddress indirizzo = InetAddress.getByName("localhost");
            GestioneConnessione g = new GestioneConnessione(server,indirizzo);
    
            g.start();
            
            
            try {
                g.join();

            } catch (InterruptedException ex) {
                Logger.getLogger(ChatPeerToPeer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
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
