import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;
import java.util.*;

    public class ServerProcessing implements Runnable{
        
        private Socket s;
        private InputStream inStream = null;
        private static ArrayList<Socket> listSocket = new ArrayList<Socket>();
        private OutputStream outStream = null;
        private Scanner in = null;
        private PrintWriter out = null;
        boolean exit = false;

        public ServerProcessing(Socket s){
            try{this.s = s;
            this.inStream = s.getInputStream();
            this.outStream = s.getOutputStream();
            listSocket.add(s);
            //clientCountet++;
            } catch(Exception e){
                System.out.println("Stream error");
            }
       }
        
        public void run(){
            //System.out.println("Client number " + clientCounter + " has been connected");
            System.out.println("Client has been connected");
            try{
                in = new Scanner(new InputStreamReader(inStream));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outStream)));
            } catch(Exception e){
                try{
                    s.close();
                } catch(IOException e2){
                    System.out.println("Socket is not closed");
                    //System.out.println("Client number " + clientCounter);
                }
            }
            try{
                while(! exit){
                    String message = in.nextLine();
                    for(Socket socket : listSocket){
                        if(! s.equals(socket)){
                            PrintWriter toOthers = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
                            toOthers.println(message);
                            toOthers.flush();
                        }
                    }
                    if(message.trim().equals("exit")){
                         exit = true;
                    }
                }
                listSocket.remove(s);
                System.out.println("Client has disconnected");
            } catch(IOException e){
                try{
                    s.close();
                } catch(IOException e2){
                    System.out.println("Socket is not closed");
                }
            }
            
        }

        }
