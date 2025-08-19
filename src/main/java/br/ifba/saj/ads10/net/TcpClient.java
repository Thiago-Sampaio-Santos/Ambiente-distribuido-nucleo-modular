package br.ifba.saj.ads10.net;

import java.io.*; import java.net.*;

public class TcpClient {
    public static String send(String host, int port, String msg){
        try(Socket s = new Socket(host, port);
            var out = new PrintWriter(new OutputStreamWriter(s.getOutputStream()), true);
            var in = new BufferedReader(new InputStreamReader(s.getInputStream()))) {
            out.println(msg);
            return in.readLine();
        } catch (Exception e){
            return null;
        }
    }
}
