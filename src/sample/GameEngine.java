package sample;

import javafx.animation.AnimationTimer;

import static sample.Main.*;

public class GameEngine extends AnimationTimer  {

    private long lastupdate = 0;


    @Override
    public void handle(long now) {
        //System.out.println("In handle" + now);

        if (animationStart) {
            Ironman.update();
        }
        if (animationStartOpponent) {
            Swordman.update();
        }

        //lastupdate = now;
    }

    public void start(){
        super.start();
    }

    public void stop(){
        super.stop();
    }
}
