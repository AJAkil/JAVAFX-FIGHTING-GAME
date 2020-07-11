package sample;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;


public class AlertBox {
    public static void display(){
        Group root=new Group();
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("QUIT");

        Scene scene=new Scene(root,500,150);
        window.setScene(scene);
        window.showAndWait();
    }
}
