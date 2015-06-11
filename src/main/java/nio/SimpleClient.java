package nio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by bsu on 14-1-22.
 */
public class SimpleClient {

    public static void main(String[] args) throws Exception{
        Socket s=new Socket("localhost",8888);

        //向服务器端第一次发送字符串
        OutputStream netOut = s.getOutputStream();
        DataOutputStream doc = new DataOutputStream(netOut);
        DataInputStream in = new DataInputStream(s.getInputStream());
        //向服务器端第二次发送字符串
        doc.writeUTF("hi");
        String res = in.readLine();
        System.out.println(res);
        doc.close();
        in.close();
    }

}

