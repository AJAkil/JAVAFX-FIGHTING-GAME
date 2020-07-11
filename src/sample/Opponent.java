package sample;

import javafx.scene.image.Image;

import java.util.List;

import static sample.Main.*;
import static sample.Main.r1;

public class Opponent extends Character implements Runnable {

    Main object;
    String information;
    double healthHolder;
    private int framerate=0, punchrate=0, jumprate=0, attackedrate=0, shootrate=0, healthrate=0;
    private int framespeed=30, punchspeed=15, jumpspeed=30, run=30, attackedspeed=20, shootspeed=20, healthspeed=30;
    private int state=1, jumpState=1, attackedState=1, shootState=1,var=0,counter=0;

    private boolean fired = false,health=false,rebound=false;
    private boolean flag = false;
    public boolean powerbarfull=false;
    public boolean powered = false;

    public boolean L,R,P;

    private boolean animator=false,healthmater=false;
    private boolean punchmeter1=false, punchmeter2=false;

    static final double NarutoPixelX=350;
    static final double NarutoPixelY=350;

    NetworkUtil ns;
    public Opponent(double iX, double iY, List<Image> imageStates,String adrress,int port, Main obj) {
        super(iX, iY, imageStates);
        this.object=obj;
        ns=new NetworkUtil(adrress,port);
        new Thread(this).start();
    }

    private void setBoundary() {
        if(iX>=(WIDTH-NarutoPixelX)) iX=WIDTH-NarutoPixelX;
        if(iX<=0) iX=0;
        if(iY>=HEIGHT-NarutoPixelY) iY=HEIGHT-NarutoPixelY;
        if(iY<=0) iY=0;
    }

    @Override
    public void run() {
        try{
            while(true){
                if(ns.read()!=null){
                    String x=(String)ns.read();
                    //String [] array = x.split(",");
                    information = x;
                    //information = array[0];
                    //healthHolder = Double.parseDouble(array[1]);
                    //iX = Double.parseDouble(array[2]);
                }
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void update() {
        System.out.println("in opponent class = " + information);

        if (information!= null) {

            if (information.equals("RIGHT")) {
                iX += speedX;
            }
            if (information.equals("LEFT")) {
                iX -= speedX;
            }

            showImage.setTranslateX(iX);
            showImage.setTranslateY(iY);

            setBoundary();
            animateCharacter(iX, iY);
        }

        //healthBar();
        Collison();
        power();
    }

    private void power() {
        if(counter==5) {
            if (powerbar2transparent.getWidth() >= 0) {
                powerbar2transparent.setWidth(powerbar2transparent.getWidth()-4);
                counter = 0;
            }
        }
        if(powerbar2transparent.getWidth()<=0){
            powerbarfull=true;
        }
    }


    private void healthBar(Hero obj) {

        if(health){
            if(r2Front.getWidth()>=400){
                object.showEndScene.setImage(imageStates.get(14));
            }

            //System.out.println(powerbarfull);
            if(obj.powerbarfull && obj.powered) {

                r2Front.setWidth(r2Front.getWidth() + 40);
                //System.out.println("here");
                powerbar1back.setWidth(0);
                obj.powerbarfull = false;
                obj.powered = false;

            } else {
                r2Front.setWidth(r2Front.getWidth()+.5);
            }

            health=false;
        }
    }

    private void Collison() {
        Collide(Ironman);
    }

    private void Collide(Hero obj) {
        if (manager.PLAYER.get(1).getShowImage().getBoundsInParent().intersects(manager.PLAYER.get(0).getShowImage().getBoundsInParent())) {

            if(this.showImage.getImage()==manager.PLAYER.get(1).imageStates.get(6)){
                counter++;
            }

            if (((obj.showImage.getImage() == manager.PLAYER.get(0).imageStates.get(6)) || (obj.showImage.getImage() == manager.PLAYER.get(0).imageStates.get(12))) && (this.showImage.getImage() != manager.PLAYER.get(1).imageStates.get(8)) ) {
                var = 1;
                health = true;
                attacked = true;
                healthBar(obj);
                System.out.println(obj.powerbarfull);
            }

        }
    }

    private void animateCharacter(double x,double y) {

        if (information.equals("x") && !animator) {
            showImage.setImage(imageStates.get(0));
            if (framerate >= run) {
                animator = true;
                framerate = 0;
            } else framerate++;

        } else if (animator) {
            showImage.setImage(imageStates.get(1));
            if (framerate >= run) {
                animator = false;
                framerate = 0;
            } else framerate++;
        }

        if(information.equals("RIGHT")){
            //System.out.println("When pressed right :  "+information);
            showImage.setScaleX(1);
            this.setFlipH(false);

            if(state==1){
                // System.out.println("Image==1");
                showImage.setImage(imageStates.get(2));
                if(framerate>=framespeed){
                    state=2;
                    framerate=0;
                }else framerate++;

            }else if(state==2){
                //System.out.println("Image==2");
                showImage.setImage(imageStates.get(3));
                if(framerate>=framespeed){
                    framerate=0;
                    state=3;
                }else framerate++;

            }else if(state==3){
                //System.out.println("Image==3");
                showImage.setImage(imageStates.get(4));
                if(framerate>=framespeed){
                    framerate=0;
                    state=1;
                }else framerate++;
            }
        }

        if(information.equals("LEFT")){
            //System.out.println("When pressed left :  "+information);
            showImage.setScaleX(-1);
            this.setFlipH(true);
            if(state==1){
                //System.out.println("Image==1");
                showImage.setImage(imageStates.get(2));
                if(framerate>=framespeed){
                    state=2;
                    framerate=0;
                }else framerate++;

            }else if(state==2){
                //System.out.println("Image==2");
                showImage.setImage(imageStates.get(3));
                if(framerate>=framespeed){
                    framerate=0;
                    state=3;
                }else framerate++;

            }else if(state==3){
                //System.out.println("Image==3");
                showImage.setImage(imageStates.get(4));
                if(framerate>=framespeed){
                    framerate=0;
                    state=1;
                }else framerate++;
            }

        }


        if(information.equals("PUNCH")) {
            if(!punchmeter1 && !punchmeter2) {
                showImage.setImage(imageStates.get(5));
                if (punchrate >= punchspeed) {
                    punchrate = 0;
                    punchmeter1 = true;
                } else punchrate++;

            } else if(punchmeter1){
                showImage.setImage(imageStates.get(6));
                if(punchrate>=punchspeed) {
                    punchrate=0;
                    punchmeter1=false;
                    punchmeter2=true;
                }else punchrate++;

            } else if(punchmeter2){
                showImage.setImage(imageStates.get(7));
                if(punchrate>=punchspeed) {
                    punchrate=0;
                    punchmeter2=false;
                    punch = false;
                }else punchrate++;
            }
        }

        if(information.equals("GUARD")) {
            showImage.setImage(imageStates.get(8));
        }

        if(attacked) {
            //System.out.println("When attacked :  " + information + attacked + attackedState);
            if (attackedState == 1) {
                showImage.setImage(imageStates.get(9));
                if (attackedrate >= attackedspeed) {
                    attackedrate = 0;
                    attackedState = 2;

                    if (flag) attacked = false;
                } else attackedrate++;
            } else if (attackedState == 2) {

                //System.out.println("When attacked :  " + information + attacked + attackedState);
                showImage.setImage(imageStates.get(10));
                if (attackedrate >= attackedspeed) {
                    flag = true;
                    attackedrate = 0;
                    attackedState = 1;
                } else attackedrate++;
            }
        }

        if(powerbarfull){
            if(information.equals("SHOOT")) {
                if(shootState==1){
                    showImage.setImage(imageStates.get(11));
                    if(shootrate>=shootspeed){
                        shootState=2;
                        shootrate=0;
                    }else shootrate++;

                }else if(shootState==2){
                    showImage.setImage(imageStates.get(12));
                    //showBullet.setImage(imageStates.get(16));
                    if(shootrate>=shootspeed){
                        shootrate=0;
                        shootState=3;
                    }else shootrate++;

                }else if(shootState==3){
                    showImage.setImage(imageStates.get(13));
                    if(shootrate>=shootspeed){
                        shootrate=0;
                        powered = true;
                        shoot = false;
                        shootState=1;
                        //powerbarfull=false;
                    }else shootrate++;
                    counter=0;
                }
            }
        }



    }


}
