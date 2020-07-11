package sample;


public class writeThreadClient implements Runnable {

    NetworkUtil ns;
    String info;
    Main obj;
    Hero heroObj;

    public writeThreadClient(NetworkUtil ns,Main obj, Hero heroObj){
        this.ns=ns;
        this.obj=obj;
        this.heroObj=heroObj;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try{
            while(true){
                String datas = obj.info; //+ "," + String.valueOf(obj.r1.getWidth()) + "," + String.valueOf(heroObj.iX);
                //System.out.println("in writing end " + datas);
                ns.write(datas);
            }

        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
