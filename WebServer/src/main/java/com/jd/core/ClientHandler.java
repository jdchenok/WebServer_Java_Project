package com.jd.core;

import http.Request;

import java.net.Socket;

public class ClientHandler implements Runnable {
    //socket属性
    private Socket socket;

    /*
    构造方法初始化socket
     */
    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    /*
    继承Runnable接口，实现run方法
     */
    @Override
    public void run() {
        System.out.println("开始一个进程处理");
        Request request = new Request(socket);
    }
}
