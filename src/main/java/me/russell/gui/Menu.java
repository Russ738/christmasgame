package me.russell.gui;


import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Menu extends Application {
    public static VBox pane = new VBox();
    @Override
    public void start(Stage stage) {
        System.out.println(javafx.scene.text.Font.getFamilies());
        Button playButton = new Button();
        playButton.setText("Play");
        playButton.setId("menubutton");
        //playButton.setMaxWidth();
        playButton.setPrefWidth(300);

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
                try {
                    Game.Animation(pane);


                } catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                }

        });



    }

    public static void isOver(){
        System.out.println("FIN");
        Text text = new Text("You Lost");
        text.setFont(Font.font("Verdana", 40));
        pane.getChildren().add(text);
    }
    public static void main(String args[]){
        launch(args);
    }
}