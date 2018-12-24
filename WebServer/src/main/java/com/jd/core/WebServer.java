package com.jd.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.nio.file.WatchEvent;

public class WebServer {
    private ServerSocket serverSocket;

    /*
    构造方法初始化变量
     */
    public WebServer() {
        try {
            System.out.println("初始化服务器>>>");
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器初始化完毕！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    程序启动方法
     */
    public void start() {
        try {
            System.out.println("等待客户端连接>>>");
            Socket socket = serverSocket.accept();
            System.out.println("一个客户端连接成功！");

            ClientHandler clientHandler = new ClientHandler(socket);
            Thread t = new Thread(clientHandler);
            t.start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        WebServer webServer = new WebServer();
        webServer.start();
    }


}
