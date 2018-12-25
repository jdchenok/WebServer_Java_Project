package http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Response {
    //状态代码
    private int statusCode;
    //响应头
    private Map<String,String> headers;
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
        sendResponseContent();
        sendResponseHeaders();
        sendResponseStatusLine();

    }
    /*
    响应正文
     */
    private void sendResponseContent(){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(entity);
            int len = -1;
            byte[] data = new byte[1024*10];
            while ((len = fis.read(data))!= -1){
                outputStream.write(data,0,len);
            }






        }catch (IOException e){
            e.printStackTrace();

        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /*
    响应头
     */
    private void sendResponseHeaders(){
        Set<Map.Entry<String,String>> set = new hea

    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public File getEntity() {
        return entity;
    }

    public void setEntity(File entity) {
        this.entity = entity;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    /*
        状态行
         */
    private void sendResponseStatusLine(){


    }





}
