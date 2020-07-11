package sample;

public class ReadFromServerClient implements Runnable{
    NetworkUtil ns;
    Main obj;
    public ReadFromServerClient(NetworkUtil ns, Main obj) {
        this.ns=ns;
        this.obj=obj;
    }

    @Override
    public void run() {
        try{
            while(true){
                String receivedchoice=(String)ns.read();
                System.out.println("IN client receivedchoice "+receivedchoice);
                obj.choicefromserver=receivedchoice;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
