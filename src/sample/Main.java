package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application  {

    static boolean servervar=true;
    String  info,choice;
    public  String choicefromserver;
    Stage window,backdoor;
    Scene mainscene,exitscene;
    static CharacterManager manager = new CharacterManager();
    static Rectangle r1,r1Back,r2,r2Back,r2Front;

    static Rectangle powerbar1,powerbar1back,powewrbar2,powerbar2back,powerbar1Border,powerbar2border,powerbar2transparent;
    static double bar=400;


    static Group root=new Group();

    //screenSIZE
    static double WIDTH=1280;
    static double HEIGHT=700;

    static boolean up,down,left,right,punch,guard,shoot,animationStart,animationStartOpponent;

    //CharactersToPlayWith
    static Hero     Ironman;
    static Opponent Swordman;

    //Image variables
    private List<Image> imageHolder1=new ArrayList<>();
    private List<Image> imageHolder2=new ArrayList<>();

    Image background,heart,fist;
    ImageView back=new ImageView();
    ImageView heartview=new ImageView();
    ImageView heartview2=new ImageView();
    ImageView fistview1=new ImageView();
    ImageView fistview2=new ImageView();
    ImageView showEndScene=new ImageView();



    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        showMain();
        LoadImage();
        drawBar();

    }




    public void drawBar() {

        r1=new Rectangle(70,25,bar,30);
        r1.setFill(Color.rgb(204,30,0));

        r1Back=new Rectangle(65,20,bar+10,40);
        r1Back.setFill(Color.rgb(0,0,0));

        r2=new Rectangle(790,25,bar,30);
        r2.setFill(Color.rgb(204,30,0));

        r2Back=new Rectangle(785,20,bar+10,40);
        r2Back.setFill(Color.rgb(0,0,0));

        r2Front=new Rectangle(790,24,0,32);
        r2Front.setFill(Color.rgb(0,0,0));

        powerbar1back=new Rectangle(70,70,0,15);
        powerbar1back.setFill(Color.YELLOWGREEN);

        powerbar1Border = new Rectangle(65, 65, 290, 25);
        powerbar1Border.setFill(Color.rgb(0,0,0));

        powerbar2border=new Rectangle(895,65,290,25);
        powerbar2border.setFill(Color.rgb(0,0,0));

        powerbar2back=new Rectangle(900,70,280,15);
        powerbar2back.setFill(Color.YELLOWGREEN);

        powerbar2transparent=new Rectangle(900,69,280,17);
        powerbar2transparent.setFill(Color.BLACK);
    }

    private void CreateGameCharacters() {
        switch (choice){

            case "1": Swordman =new Opponent(250,350,imageHolder2,"192.168.43.100",44444,this);
                      break;
            case "2": Swordman =new Opponent(250,350,imageHolder1,"192.168.43.100",44444,this);
                      break;

        }
    }

    private void CreateHero(){
        switch(choice){
            case "1": Ironman=new Hero(250,350,imageHolder1,"127.0.0.1",8080,this);
                      break;
            case "2": Ironman=new Hero(250,350,imageHolder2,"127.0.0.1",8080,this);
                      break;
        }
    }

    private void AddCharacters2(){
        if(choice!=null){
            manager.addPlayer(Ironman);
        }
    }

    private void AddCharacters() {

        if(choice!=null){
            manager.addPlayer(Swordman);
        }
    }

    private void LoadImage() {

        imageHolder1.add(new Image("IMidle1.png"));
        imageHolder1.add(new Image("IMidle2.png"));

        imageHolder1.add(new Image("IMwalk1.png"));
        imageHolder1.add(new Image("IMwalk1.png"));
        imageHolder1.add(new Image("IMwalk1.png"));

        imageHolder1.add(new Image("IMpunch1.png"));
        imageHolder1.add(new Image("IMpunch2.png"));
        imageHolder1.add(new Image("IMpunch3.png"));

        imageHolder1.add(new Image("IMguard1.png"));

        imageHolder1.add(new Image("IMattacked1.png"));
        imageHolder1.add(new Image("IMattacked2.png"));

        imageHolder1.add(new Image("IMthrow1.png"));
        imageHolder1.add(new Image("IMthrow2.png"));
        imageHolder1.add(new Image("IMthrow3.png"));

       // imageHolder1.add(new Image("IMbullet1.png"));




        imageHolder2.add(new Image("HKidle1.png"));
        imageHolder2.add(new Image("HKidle2.png"));

        imageHolder2.add(new Image("HKwalk1.png"));
        imageHolder2.add(new Image("HKwalk1.png"));
        imageHolder2.add(new Image("HKwalk1.png"));

        imageHolder2.add(new Image("HKpunch1.png"));
        imageHolder2.add(new Image("HKpunch2.png"));
        imageHolder2.add(new Image("HKpunch3.png"));

        imageHolder2.add(new Image("HKguard1.png"));

        imageHolder2.add(new Image("HKattacked1.png"));
        imageHolder2.add(new Image("HKattacked2.png"));

        imageHolder2.add(new Image("HKthrow1.png"));
        imageHolder2.add(new Image("HKthrow2.png"));
        imageHolder2.add(new Image("HKthrow3.png"));

        imageHolder1.add(new Image("win.jpg"));
        imageHolder1.add(new Image("lose.png",1280,700,true,false,true));

        imageHolder2.add(new Image("win.jpg"));
        imageHolder2.add(new Image("lose.png",1280,700,true,false,true));

        //imageHolder1.add(new Image("IMbullet1.png"));
    }

    private void startEngine() {
        GameEngine engineobj;
        engineobj=new GameEngine();
        engineobj.start();
    }

    public void showMain() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("sample.fxml"));
        Parent root = loader.load();

        Controller control=loader.getController();
        control.setmain(this);

        window.setTitle("FIGHTER101");
        window.setScene(new Scene(root, WIDTH, HEIGHT));
        window.show();
    }

    public void ShowCredits() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Credits.fxml"));
        Parent root = loader.load();

        Controller control=loader.getController();
        control.setmain(this);

        window.setTitle("Credits");
        window.setScene(new Scene(root,WIDTH,HEIGHT));
        window.show();
    }

    public void showOPTIONS() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Options.fxml"));
        Parent root = loader.load();

        Controller control=loader.getController();
        //control.showimg(control.getVal());
        control.setmain(this);

        window.setTitle("Instructions");
        window.setScene(new Scene(root,WIDTH,HEIGHT));
        window.show();
    }

    public void Avatar() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("AvatarSelector.fxml"));
        Parent root = loader.load();

        Controller control=loader.getController();
        control.setmain(this);

        window.setTitle("Avatar Selection");
        window.setScene(new Scene(root,WIDTH,HEIGHT));
        window.show();

    }

    public void Arena() throws IOException {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Arena_Selector.fxml"));
        Parent root = loader.load();

        Controller control=loader.getController();
        control.setmain(this);

        window.setTitle("Arena Selection");
        window.setScene(new Scene(root,WIDTH,HEIGHT));
        window.show();

        CreateHero();
        AddCharacters2();
    }

    public void closeProgram() throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(getClass().getResource("Alert.fxml"));
        Parent root = loader.load();

        Controller control=loader.getController();
        control.setmain(this);
        exitscene=new Scene(root,500,150);

        backdoor=new Stage();
        backdoor.initModality(Modality.APPLICATION_MODAL);
        backdoor.setTitle("Quit");
        backdoor.setScene(exitscene);
        backdoor.showAndWait();
    }

    public void PLAY() {

        CreateGameCharacters();
        AddCharacters();
        animationStartOpponent = true;
        animationStart = true;
        startEngine();

        Controller control = new Controller();
        control.setmain(this);
        background = new Image("kofxialleybgzyde.gif");
        back.setImage(background);

        heart=new Image("heart.png");
        heartview.setImage(heart);
        heartview.setX(20);
        heartview.setY(20);

        heartview2.setImage(heart);
        heartview2.setX(1210);
        heartview2.setY(20);

        fist=new Image("fist.png");
        fistview1.setImage(fist);
        fistview1.setX(20);
        fistview1.setY(60);

        fistview2.setImage(fist);
        fistview2.setX(1210);
        fistview2.setY(60);


        if (choice != null) {
            root.getChildren().addAll(back, Ironman.showImage,Swordman.showImage, r1Back, r2Back, r1, r2, r2Front,powerbar1Border,powerbar1back,powerbar2border,powerbar2back,powerbar2transparent,heartview,heartview2,fistview1,fistview2,showEndScene);
        }

        mainscene = new Scene(root, WIDTH, HEIGHT);
        window.setTitle("FIGHTER-101");
        window.setScene(mainscene);
        window.show();

        mainscene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case LEFT:
                    left = true;
                    info = "LEFT";
                    break;
                case RIGHT:
                    right = true;
                    info = "RIGHT";
                    break;
                case A:
                    shoot = true;
                    info = "SHOOT";
                    break;
                case D:
                    punch = true;
                    info = "PUNCH";
                    break;
                //case P: sasuke.P=true; break;
               /* case S:     down=true;
                                break;*/
                case Q:
                    guard = true;
                    info = "GUARD";
                    break;
                //case J: sasuke.L=true; break;
                //case L: sasuke.R=true; break;
            }
        });

        mainscene.setOnKeyReleased(e -> {
            switch (e.getCode()) {
                case LEFT:
                    left = false;
                    info = "x";
                    break;
                case RIGHT:
                    right = false;
                    this.info = "x";
                    break;
                case A:
                    shoot = false;
                    this.info = "x";
                    break;
                case D:
                    punch = false;
                    this.info = "x";
                    break;
                case Q:
                    guard = false;
                    info = "x";
                    break;
            }
        });

    }

    public static void main(String[] args) throws IOException {
        launch(args);

    }

}
