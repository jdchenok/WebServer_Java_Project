package http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * 解析请求方法
 */
public class Request {
    private Socket socket;

    private InputStream inputStream;
    //请求方法
    private String method;
    // 请求路径资源
    private String url;
    //请求使用版本协议
    private String protocol;
    //消息头
    private Map<String, String> headers = new HashMap<>();

    /*
    构造方法初始化变量
     */
    public Request(Socket socket) {
        try {
            this.socket = socket;
            this.inputStream = socket.getInputStream();

            parserRequestLine();
            parseHeaders();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }

    public String getProtocol() {
        return protocol;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    /*
    解析请求行
     */
    private void parserRequestLine() {

        System.out.println("开始解析请求行>>>");
        String line = readLine();
        String[] data = line.split("\\s");
        method = data[0];
        url = data[1];
        protocol = data[2];
        System.out.println(method + url + protocol);
        System.out.println("请求行解析完毕");
    }

    /*
    解析消息头
     */
    private void parseHeaders() {
        System.out.println("开始解析消息头>>>");
        while (true) {
            String line = readLine();
            if ("".equals(line)) {
                break;
            }
            String[] data = line.split("\\s");
            headers.put(data[0], data[1]);
        }
        System.out.println(headers);
        System.out.println("消息头解析完毕");
    }

    /*
    获取请求数据
     */
    private String readLine() {

        try {
            StringBuilder builder = new StringBuilder();
            int d = -1;
            char c1 = 'a', c2 = 'a';
            while ((d = inputStream.read()) != -1) {
                c2 = (char) d;
                if (c1 == 13 && c2 == 10) {
                    break;
                }
                builder.append(c2);
                c1 = c2;
            }
            return builder.toString().trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}
