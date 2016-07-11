import java.net.Socket;
import java.io.*;
import java.util.*;

class ClientSide{
    public static void main(String[] args){
        try{
            System.out.println("Client starting to connect..");
            Socket s = new Socket("localhost", 8080); 
            Thread threadIn = new Thread(new ClientSocketInput(s));
            Thread threadOut = new Thread(new ClientSocketOutput(s));
            threadIn.start();
            threadOut.start();
        } catch(Exception e){
            System.out.println("Host is not found!");
        }
    }

}
