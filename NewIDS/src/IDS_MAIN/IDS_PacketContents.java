package IDS_MAIN;


import jpcap.PacketReceiver;
import jpcap.packet.Packet;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *

 */
public class IDS_PacketContents  implements PacketReceiver{
    public void receivePacket(Packet packet){
        IDS_GUI.TA_OUTPUT.append(packet.toString()+ "\n");
    }
}
