package sample;

import javafx.scene.image.Image;

import java.util.List;

public abstract class Characters extends AllCharacterProperties {

    protected double speedX,speedY,offSetX,offSetY,damage,boundScale,gravity,bounce;

    Characters( String data ,double xLocation, double yLocation, List<Image> imageStates) {
        super(xLocation, yLocation, imageStates);
        speedX= speedY=5;
        offSetX=offSetY=damage=boundScale=gravity=bounce=0;
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
