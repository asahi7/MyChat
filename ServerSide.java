import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

class ServerSide{
    
    private static int port = 8080;
    private static int clientCounter = 0;
    private static ServerSocket ss;

    public static void main(String[] args) throws Exception{
        try{
            ss = new ServerSocket(port);
            Socket cl = null;
            while(true){
                cl = ss.accept();
                ServerProcessing sp = new ServerProcessing(cl);
                Thread t = new Thread(sp);
                t.start();
            }
        } catch(IOException e){
            ss.close();
        }
    }

}

