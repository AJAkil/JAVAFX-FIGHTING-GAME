package sample;

public class ReadFromServer  implements Runnable  {

    NetworkUtil ns;
    Opponent obj;
    public ReadFromServer(NetworkUtil obj,Opponent object){
        this.obj=object;
        this.ns=obj;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try{
            while(true){
                if(ns!=null){
                    String x=(String)ns.read();
                    obj.information=x;
                    //System.out.println("here in thread  "+obj.information);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
