import java.net.Socket;
import java.io.*;
import java.util.*;


    public class ClientSocketOutput implements Runnable{
        private Socket s;
        private PrintWriter out;
        private Scanner in;
        public ClientSocketOutput(Socket s) throws Exception{
            this.s = s;
            out = new PrintWriter(s.getOutputStream());
            in = new Scanner(System.in);
        }
        public void run(){
            try{
                while(true){
                    String message = in.nextLine();
                    out.println(message);
                    out.flush();
                }
            } catch(Exception e){
                System.out.println("Exception! ClientSocketOutput!" + e.toString());
            }
        }
    }

