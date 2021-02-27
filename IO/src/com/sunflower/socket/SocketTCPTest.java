package com.sunflower.socket;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTCPTest {
    @Test
    public void ServerTest() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream socketInputStream = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        OutputStream socketOutputStream = null;
        try {
            serverSocket = new ServerSocket(6969);
            socket = serverSocket.accept();
            socketInputStream = socket.getInputStream();
            bis = new BufferedInputStream(socketInputStream);
            bos = new BufferedOutputStream(new FileOutputStream("D:\\IO\\output\\Socket.txt"));
            int len;
            byte buff[] = new byte[1024];
            long start=System.currentTimeMillis();
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            bos.flush();
            socket.shutdownInput();
            long end=System.currentTimeMillis();
            System.out.println("传输用时：" + (end - start) + "毫秒");//传输用时：380毫秒

            socketOutputStream = socket.getOutputStream();
            socketOutputStream.write("我已经收到文件了".getBytes());
            socketOutputStream.flush();
            socket.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketOutputStream != null) {
                try {
                    socketOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socketInputStream != null) {
                try {
                    socketInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void ClientTest() {
        Socket socket = null;
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;
        InputStream inputStream = null;
        ByteArrayOutputStream arrayOutputStream = null;
        try {
            socket = new Socket("127.0.0.1", 6969);
            bos = new BufferedOutputStream(socket.getOutputStream());
            bis = new BufferedInputStream(new FileInputStream("D:\\IO\\input\\Socket.txt"));
            byte buff[] = new byte[1024];
            int len;
            while ((len = bis.read(buff)) != -1) {
                bos.write(buff, 0, len);
            }
            bos.flush();
            socket.shutdownOutput();

            inputStream = socket.getInputStream();
            arrayOutputStream = new ByteArrayOutputStream();
            while ((len = inputStream.read(buff)) != -1) {
                arrayOutputStream.write(buff, 0, len);
            }
            System.out.println(arrayOutputStream.toString());
            socket.shutdownInput();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (arrayOutputStream != null) {
                try {
                    arrayOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
