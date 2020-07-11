package sample;

import javafx.scene.image.Image;
import javafx.scene.shape.SVGPath;

import java.util.List;

public abstract class Character extends AllCharacterProperties {

    protected double speedX,speedY,bulletspeedX,offSetX,offSetY,damage,boundScale,gravity,bounce;

    /*Character( String data ,double xLocation, double yLocation, Image... sprites) {
        super( data, xLocation, yLocation, sprites);
        speedX= speedY=5;
        offSetX=offSetY=damage=boundScale=gravity=bounce=0;
    }*/

    public Character( double iX, double iY, List<Image> imageStates) {
        super( iX, iY, imageStates);

        speedX = 5;
        speedY = 10;
        bulletspeedX = 10;
        offSetX = offSetY = damage = boundScale = gravity = bounce = 0;
    }


    public double getSpeedX() {
        return speedX;
    }

    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public double getSpeedY() {
        return speedY;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }

    public double getOffSetX() {
        return offSetX;
    }

    public void setOffSetX(double offSetX) {
        this.offSetX = offSetX;
    }

    public double getOffSetY() {
        return offSetY;
    }

    public void setOffSetY(double offSetY) {
        this.offSetY = offSetY;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getBoundScale() {
        return boundScale;
    }

    public void setBoundScale(double boundScale) {
        this.boundScale = boundScale;
    }

    public double getGravity() {
        return gravity;
    }

    public void setGravity(double gravity) {
        this.gravity = gravity;
    }

    public double getBounce() {
        return bounce;
    }

    public void setBounce(double bounce) {
        this.bounce = bounce;
    }


    public abstract void update();
}
