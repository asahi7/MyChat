import java.net.Socket;
import java.io.*;
import java.util.*;

    public class ClientSocketInput implements Runnable{
        private Socket s;
        private Scanner in;
        public ClientSocketInput(Socket s) throws Exception{
            this.s = s;
            in = new Scanner(s.getInputStream());
        }

        public void run(){
            try{
                while(true){
                    String message = in.nextLine();
                    System.out.println(message);
  //                  in.flush();
                }
            } catch(Exception e){
                System.out.println("Exception! ClientSocketInput!" + e.toString());
            }

    }
    }

