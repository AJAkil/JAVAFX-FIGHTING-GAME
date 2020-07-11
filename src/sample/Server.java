package sample;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {
    int clientcount=0;
    HashMap<String,NetworkUtil>playermap=new HashMap<>();
    ServerSocket socket;

    Server() throws IOException {
        System.out.println("Server Started");
        new writheThreadServer(playermap,"Server");
        try{
            socket=new ServerSocket(8080);
            while(true){
                Socket clientsocket=socket.accept();
                serve(clientsocket);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void serve(Socket clients) {
        clientcount++;
        NetworkUtil ns=new NetworkUtil(clients);
        String cname=Integer.toString(clientcount);
        System.out.println("In serve" + cname);
        playermap.put(cname,ns);
        System.out.println("Client "+cname+" Connected");
        new ReadFromClient(ns, playermap, this);
    }



    public static void main(String[] args) throws IOException {
        Server server=new Server();
    }

}


