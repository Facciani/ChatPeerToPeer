/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpeertopeer;

import java.net.DatagramSocket;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Condivisa {
    
    DatagramSocket serverRicezione;
    String nome;
    String nomeDestinatario;
    
    static Condivisa instance = null;
    boolean mittente;
    
    DatagramSocket serverInvio;
    JFrame frame;
    String messaggio = "";
    boolean connected = false;

    private Condivisa() throws SocketException, UnknownHostException {
        this.serverRicezione = new DatagramSocket(12345);
        serverInvio = new DatagramSocket();
        mittente = false;
        nomeDestinatario = "";
        nome = "Ale";
    }
}
