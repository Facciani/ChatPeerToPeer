/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpeertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class RicezioneMessaggio extends Thread{
    Condivisa c;
    GestionePacchetto p;

    public RicezioneMessaggio() throws SocketException, UnknownHostException {
        c = new Condivisa();
    }

    @Override
    public void run() {
        while (true) {
            try {
                byte[] buffer = new byte[1500];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                c.serverRicezione.receive(packet);
            } catch (IOException ex) {
                Logger.getLogger(RicezioneMessaggio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
