package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;

public abstract class AllCharacterProperties {

    List<Image>imageStates=new ArrayList<>();
    static String info;
    protected ImageView showImage;
    protected ImageView Healthbar;
    protected ImageView showBullet;
    protected double iX;
    protected double iY;
    //protected double bulletiX;
    //protected double bulletiY;
    protected boolean isAlive;
    protected boolean isFixed;
    protected boolean hasValu;
    protected boolean isFlipV;
    protected boolean isFlipH;
    protected double pX;
    protected double pY;
    protected boolean attacked;




    public AllCharacterProperties(double iX, double iY, List<Image> imageStates) {
        this.imageStates = imageStates;
        this.iX = iX;
        this.iY = iY;

        //bulletiX=iX;//+229;//imageStates.get(14).getWidth();
        //bulletiY=iY;

        showImage = new ImageView(imageStates.get(0));
        showBullet = new ImageView();
        //Healthbar = new ImageView(imageStates.get(17));

        showImage.setTranslateX(iX);
        showImage.setTranslateY(iY);

        pX=0;
        pY=0;
        isFixed=true;
        isAlive = hasValu = isFlipV = isFlipH = false;
    }

    /*AllCharacterProperties(String data, double xLocation, double yLocation, Image...sprites){
        spriteBound=new SVGPath();
        spriteBound.setContent(data);

        imageStates.addAll(Arrays.asList(sprites));
        iX=xLocation;
        iY=yLocation;

    }*/

    public List<Image> getImageStates() {
        return imageStates;
    }

    public void setImageStates(List<Image> imageStates) {
        this.imageStates = imageStates;
    }

    public ImageView getShowImage() {
        return showImage;
    }

    public void setShowImage(ImageView showImage) {
        this.showImage = showImage;
    }

    public double getiX() {
        return iX;
    }

    public void setiX(double iX) {
        this.iX = iX;
    }

    public double getiY() {
        return iY;
    }

    public void setiY(double iY) {
        this.iY = iY;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public boolean isHasValu() {
        return hasValu;
    }

    public void setHasValu(boolean hasValu) {
        this.hasValu = hasValu;
    }

    public boolean isFlipV() {
        return isFlipV;
    }

    public void setFlipV(boolean flipV) {
        isFlipV = flipV;
    }

    public boolean isFlipH() {
        return isFlipH;
    }

    public void setFlipH(boolean flipH) {
        isFlipH = flipH;
    }

    public double getpX() {
        return pX;
    }

    public void setpX(double pX) {
        this.pX = pX;
    }

    public double getpY() {
        return pY;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }



    public abstract void update();
}

