package com.sunflower.socket;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

public class SocketUDPTest {
    @Test
    public void Send() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket();
            byte buff[] = "sunflower.com".getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(buff, 0, buff.length, InetAddress.getByName("127.0.0.1"), 6969);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (datagramSocket != null) {
                datagramSocket.close();
            }
        }
    }
    @Test
    public void Receive() {
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(6969);
            byte buff[]=new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buff, buff.length);
            datagramSocket.receive(datagramPacket);
            System.out.println(datagramPacket.getAddress());///127.0.0.1
            System.out.println(datagramPacket.getPort());//59886
            System.out.println(datagramPacket.getLength());//13
            System.out.println(new String(datagramPacket.getData()));//sunflower.com
            System.out.println(datagramPacket.getSocketAddress());///127.0.0.1:59886
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(datagramSocket!=null){
                datagramSocket.close();
            }
        }
    }
}
