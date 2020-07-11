package sample;

import java.util.HashMap;

public class writheThreadServer implements Runnable {
    NetworkUtil ns;
    String hashmapname;
    HashMap<String,NetworkUtil>playermap;
    public writheThreadServer(HashMap<String, NetworkUtil> playermap, String server) {
        this.playermap=playermap;
        this.hashmapname=server;
        new Thread(this).start();
    }

    @Override
    public void run() {

    }
}
