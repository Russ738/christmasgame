package me.russell.gui;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;


public class Menu extends Application {

    @Override
    public void start(Stage stage) {
        VBox pane = new VBox();
        Button playButton = new Button();
        playButton.setText("Play");
        playButton.setId("menubutton");
        //playButton.setMaxWidth();
        playButton.setPrefWidth(300);

        //Setting title to the Stage
        stage.setTitle("Event Handlers Example");

        //setting layout type
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(playButton);
        pane.setId("pane");

        //Creating a scene object
        Scene scene = new Scene(pane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);

        //Adding scene to the stage
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
        playButton.setOnMouseClicked((event -> pane.getChildren().remove(playButton)));
    }
    public static void main(String args[]){
        launch(args);
    }
}