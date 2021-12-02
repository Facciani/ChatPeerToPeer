/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpeertopeer;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class InvioMessaggio {
    DatagramPacket packet;
    int lastPort;
    InetAddress lastIP;
    Condivisa c;

    public InvioMessaggio(DatagramPacket p) throws SocketException, UnknownHostException {
        packet = p;
        lastPort = 12345;
        lastIP = packet.getAddress();
        this.c = new Condivisa();
    }
    
    public void send(String str) throws IOException {
        byte[] buffer = str.getBytes();
        DatagramPacket pack = new DatagramPacket(buffer, buffer.length);
        pack.setAddress(lastIP);
        pack.setPort(lastPort);
        c.serverInvio.send(pack);
    }
}
