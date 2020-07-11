package sample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javafx.application.Platform;
import sample.Opponent.*;


public class ReadFromClient  implements Runnable{
    NetworkUtil ns;
    String information;
    static String holder;
    int clientCount=0;
    Server serverObj;

    public static String getHolder() {
        return holder;
    }

    HashMap<String,NetworkUtil>clientmap;
    public ReadFromClient(NetworkUtil ns, HashMap<String,NetworkUtil>clientmap, Server serverObj) {
        this.ns=ns;
        this.clientmap=clientmap;
        this.serverObj = serverObj;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try{
            while(true){
                if(ns.read()!=null) {

                    String data=(String )ns.read();
                    if(data!=null){
                        //this data is the information of movement;
                        NetworkUtil nc=clientmap.get("2");
                        nc.write(data);
                    }
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
