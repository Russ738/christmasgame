package me.russell.gui;


import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;


public class Menu extends Application {
    public static VBox pane = new VBox();
    @Override
    public void start(Stage stage) {
        pane.getChildren().removeAll();
        Button playButton = new Button();
        playButton.setText("Play");
        playButton.setId("menubutton");
        //playButton.setMaxWidth();
        playButton.setPrefWidth(300);
        playButton.setFont(Font.font("Freestyle Script",75));
        //Setting title to the Stage
        stage.setTitle("Event Handlers Example");

        //setting the clip
        Rectangle clip =  new Rectangle (790,490);
        clip.setManaged(false);
        clip.setArcWidth(50.0);
        clip.setArcHeight(50.0);
        clip.setLayoutX(5);
        clip.setLayoutY(5);
        clip.setStroke(Color.BLACK);
        //pane.getChildren().add(clip);

        pane.setClip(clip);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(playButton);
        playButton.setAlignment(Pos.CENTER);
        pane.setId("pane");

        //Creating a scene object
        Scene scene = new Scene(pane, 800, 500);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        scene.setFill(Color.TRANSPARENT);
        scene.setOnKeyReleased(ke -> {
            if(ke.getCode() == KeyCode.ESCAPE){
                System.exit(-1);
            }
        });
        //Adding scene to the stage
        stage.initStyle(StageStyle.TRANSPARENT);
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(scene);
        //Displaying the contents of the stage
        stage.show();
        playButton.setOnMouseClicked(e -> {
            pane.getChildren().remove(playButton);
            Game.Animation(pane);

        });



    }

    public static void isOver(int score){
        Text text = new Text("You Lost");
        text.setFont(Font.font("Freestyle Script",75));
        Text score1 = new Text("Score: " + score);
        score1.setFont(Font.font("Freestyle Script",75));
        pane.getChildren().addAll(text,score1);
        Button replayButton = new Button();
        replayButton.setText("Replay");
        replayButton.setFont(Font.font("Freestyle Script",30));
        replayButton.setId("menubutton");
        replayButton.setPrefWidth(200);
        pane.getChildren().add(replayButton);

        replayButton.setOnMouseClicked(e -> {

            Game.Animation(pane);

        });
    }

    public static void main(String args[]){
        launch(args);
    }
}