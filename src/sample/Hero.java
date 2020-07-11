package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.SVGPath;
import javax.print.DocFlavor;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;

import static sample.Main.*;


public class Hero extends Character {
    Main object;
    private int framerate=0, punchrate=0, jumprate=0, attackedrate=0, shootrate=0, healthrate=0 , shootrate2=0;
    private int framespeed=30, punchspeed=15, jumpspeed=10, run=30, attackedspeed=20, shootspeed=20, healthspeed=30 , shootspeed2=10;
    private int state=1, jumpState=1, attackedState=1, shootState=1,var=0,counter=0;

    private boolean fired = false,health=false,rebound=false;
    private boolean flag = false;
    public boolean powerbarfull=false;
    public boolean powered = false;

    public static boolean win,lose;

    private boolean animator=false,healthmater=false;
    private boolean punchmeter1=false, punchmeter2=false;

    static final double NarutoPixelX=350;
    static final double NarutoPixelY=350;
    static  String info;
    NetworkUtil ns;


    Hero( double iX, double iY, List<Image> imageStates,String adrress, int port,Main obj) {
        super( iX, iY, imageStates);
        this.object=obj;

        NetworkUtil ns=new NetworkUtil(adrress,port);
        new writeThreadClient(ns,obj,this);
    }

    private void setBoundary() {
        if(iX>=(WIDTH-NarutoPixelX)) iX=WIDTH-NarutoPixelX;
        if(iX<=0) iX=0;
        if(iY>=HEIGHT-NarutoPixelY) iY=HEIGHT-NarutoPixelY;
        if(iY<=0) iY=0;
    }

    @Override
    public void update() {
        if(right) { iX+=speedX; }
        if(left) { iX-=speedX; }

        showImage.setTranslateX(iX);
        showImage.setTranslateY(iY);

        setBoundary();
        animateCharacter(iX,iY);

        //healthBar();
        power();
        Collison();

    }

    private void power() {
        if(counter==5) {
            if (powerbar1back.getWidth() <= 280) {
                powerbar1back.setWidth(powerbar1back.getWidth() + 4);
                counter = 0;
            }
        }

        if(powerbar1back.getWidth()>=280){
            powerbarfull=true;
        }
    }

    private void healthBar(Opponent obj) {

        if(health){
            if(r1.getWidth()==0.00){
                object.showEndScene.setImage(imageStates.get(15));
            }
            System.out.println(obj.powerbarfull);

            if(obj.powerbarfull && obj.powered) {
                r1.setWidth(r1.getWidth()-40);

                powerbar2transparent.setWidth(280);
                obj.powerbarfull = false;
                obj.powered = false;
                System.out.println("here");
            } else {
                r1.setWidth(r1.getWidth()-.5);
            }

            health=false;
        }
    }



    private void Collison() {
        Collide(Swordman);
    }

    private void Collide(Opponent obj) {
        if (manager.PLAYER.get(0).getShowImage().getBoundsInParent().intersects(manager.PLAYER.get(1).getShowImage().getBoundsInParent())) {

            if(this.showImage.getImage()==manager.PLAYER.get(0).imageStates.get(6)){
                counter++;
            }

            if (((obj.showImage.getImage() == manager.PLAYER.get(1).imageStates.get(6)) || (obj.showImage.getImage() == manager.PLAYER.get(1).imageStates.get(12))) && (this.showImage.getImage() != manager.PLAYER.get(0).imageStates.get(8)) ) {
                var = 1;
                health = true;
                attacked = true;
                healthBar(obj);
                //System.out.println(obj.powerbarfull);
            }
        }
    }

    private void animateCharacter(double x,double y) {

        if (!animator && !up && !down && !left && !right) {
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

        if(right){
            showImage.setScaleX(1);
            this.setFlipH(false);

            if(state==1){
               // System.out.println("Image==1");
                System.out.println("instate 1");

                showImage.setImage(imageStates.get(2));
                if(framerate>=framespeed){
                    state=2;
                    framerate=0;
                }else framerate++;

            }else if(state==2){
                //System.out.println("Image==2");
                showImage.setImage(imageStates.get(3));
                System.out.println("instate 2");
                if(framerate>=framespeed){
                    framerate=0;
                    state=3;
                }else framerate++;

            }else if(state==3){
                //System.out.println("Image==3");
                System.out.println("instate 3");

                showImage.setImage(imageStates.get(4));
                if(framerate>=framespeed){
                    framerate=0;
                    state=1;
                }else framerate++;
            }
        }

        if(left){

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

        if(punch) {
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

        if(guard) {
            showImage.setImage(imageStates.get(8));
        }

        if(attacked) {
            if (attackedState == 1) {
                showImage.setImage(imageStates.get(9));
                if (attackedrate >= attackedspeed) {
                    attackedrate = 0;
                    attackedState = 2;

                    if (flag) attacked = false;
                } else attackedrate++;

            } else if (attackedState == 2) {
                showImage.setImage(imageStates.get(10));
                if (attackedrate >= attackedspeed) {
                    flag = true;
                    attackedrate = 0;
                    attackedState = 1;
                } else attackedrate++;
            }
        }

        if(powerbarfull){
            //ystem.out.println("in shoot "+ powerbarfull);
            if(shoot) {
                //System.out.println("shoot "+shoot);
                //System.out.println("shottstate start "+ shootState);
                if(shootState==1){
                    showImage.setImage(imageStates.get(11));
                    if(shootrate>=shootspeed){
                        shootState=2;
                        shootrate=0;
                    }else shootrate++;

                }else if(shootState==2){
                    showImage.setImage(imageStates.get(12));
                    //showBullet.setImage(imageStates.get(13));
                    if(shootrate>=shootspeed){
                        shootrate=0;
                        shootState=3;
                    }else shootrate++;

                }else if(shootState==3){
                    System.out.println("in state 3");
                    showImage.setImage(imageStates.get(13));

                    if(shootrate>=shootspeed){

                        //System.out.println("in state changer ");
                        shootrate=0;
                        powered = true;
                        shoot = false;
                        shootState=1;
                        //powerbarfull=false;
                    }else shootrate++;
                   //powerbar2transparent.setWidth(280);
                    //System.out.println("shootstate end "+shootState);
                    counter=0;
                }
            }
        }
    }
}





