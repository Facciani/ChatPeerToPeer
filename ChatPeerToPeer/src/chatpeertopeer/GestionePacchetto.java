/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatpeertopeer;

import java.net.DatagramPacket;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author User
 */
public class GestionePacchetto {
    Condivisa c;
    static GestionePacchetto instance = null;

    private GestionePacchetto() throws SocketException, UnknownHostException {
        c = new Condivisa();
    }

    static GestionePacchetto GetInstance() throws SocketException, UnknownHostException {
        if (instance == null) {
            synchronized (GestionePacchetto.class) {
                if (instance == null) {
                    instance = new GestionePacchetto();
                }
            }
        }
        return instance;
    }
    
    public void lettura(DatagramPacket pacchetto)
    {
        byte[] buffer = pacchetto.getData();
    }
}
