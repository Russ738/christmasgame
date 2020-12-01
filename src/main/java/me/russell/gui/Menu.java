package me.russell.gui;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;




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
        playButton.setOnMouseClicked(e -> {
            pane.getChildren().remove(playButton);
            try {
                MenuAnimation.Animation(pane);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        });
        stage.show();

    }

    public static void main(String args[]){
        launch(args);
    }
}