package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

import java.io.IOException;

public class Controller {
    Main main;
    String choice;
    int val=-90;

    public int getVal() {
        return val;
    }


        @FXML
        private Button play;

        @FXML
        private Button credits;

        @FXML
        private Button options;

        @FXML
        private Button yes;

        @FXML
        private Button no;

        @FXML
        private Button back;

         @FXML
        private Button proceedfromarena;


        @FXML
        private Button proceedfromavatar;

        private MenuItem player2;

        @FXML
        private Button player1;






    @FXML
        void GoTOArena(ActionEvent event) throws IOException {
            main.Arena();
        }

        @FXML
        void avatarselector(ActionEvent event) throws IOException {
            main.PLAY();
        }

            @FXML
        void battlegrounds(ActionEvent event) throws IOException {
            main.Arena();
        }

        @FXML
        void selectplayer1(ActionEvent event) {
            main.choice="1";
        }

        @FXML
        void selectplayer2(ActionEvent event) {
            main.choice="2";
        }

        @FXML
        void GoBack(ActionEvent event) throws IOException {
            main.showMain();
        }


    @FXML
        void no(ActionEvent event) throws IOException {
            main.backdoor.close();
        }

        @FXML
        void yes(ActionEvent event) {
               main.window.close();
               main.backdoor.close();
        }

        @FXML
        void credits(ActionEvent event) throws IOException {
            try {
                main.ShowCredits();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        void options(ActionEvent event) throws IOException {
            try {
                main.showOPTIONS();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @FXML
        void play(ActionEvent event) throws IOException {
            main.Avatar();
        }

        @FXML
        void exit(ActionEvent event) throws IOException {
                main.closeProgram();
        }

    public void setmain(Main main) {
        this.main = main;
    }
}
