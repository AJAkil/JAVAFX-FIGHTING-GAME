package sample;

public class Client {
    Main obj;
    Client(String adrress, int port,Main obj) {
        try {

            this.obj=obj;
            NetworkUtil ns=new NetworkUtil(adrress,port);

            new ReadFromServerClient(ns,obj);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
