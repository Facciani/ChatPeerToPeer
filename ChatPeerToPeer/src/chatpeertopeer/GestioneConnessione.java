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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class GestioneConnessione extends Thread{
    DatagramSocket peer;
    InetAddress indirizzo;
    
    public GestioneConnessione(DatagramSocket g, InetAddress i)
    {
        this.peer = g;
        this.indirizzo = i;
    }

    @Override
    public void run() {
        
        while(true)
        {
            byte[] buffer = new byte[1500];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            try {
                peer.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(GestioneConnessione.class.getName()).log(Level.SEVERE, null, ex);
            }
            byte[] dataReceived = packet.getData();
            String messaggioRicevuto = new String(dataReceived, 0, packet.getLength());
            System.out.println(messaggioRicevuto);
            
            
            Scanner tastiera = new Scanner(System.in);
            String risposta = tastiera.nextLine();
            System.out.println(risposta);
 
            byte[] responseBuffer = risposta.getBytes();

            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);

            responsePacket.setAddress(indirizzo);

            responsePacket.setPort(666);

            try {
                peer.send(responsePacket);
            } catch (IOException ex) {
                Logger.getLogger(GestioneConnessione.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
     
}
