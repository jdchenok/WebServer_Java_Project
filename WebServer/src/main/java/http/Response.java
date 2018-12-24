package http;

import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Response {
    //状态代码
    private int statusCode;
    //响应头
    private Map<String,String> headers = new HashMap<>();
    //响应实体，发送给浏览器的数据
    private File entity;

    private OutputStream outputStream;

    public Response(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    /*
    将数据响应到客户端
     */
    public void flush(){


    }

    private void sendResponseContent(){

    }

    private void sendResponseHeaders(){


    }

    private void sendResponseStatusLine(){


    }



}
