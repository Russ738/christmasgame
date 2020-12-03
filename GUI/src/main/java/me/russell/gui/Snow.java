package me.russell.gui;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Snow {
    private static TranslateTransition translateTransition = new TranslateTransition();
    private static ImageView imageView;
    public static int increment;
    public static void Animation(VBox pane) throws FileNotFoundException {
        if(!pane.getChildren().contains(imageView)){
            Image image = new Image(new FileInputStream("src/main/resources/snow.png"));
            imageView = new ImageView(image);
            pane.getChildren().add(imageView);
            imageView.setManaged(false);
            imageView.setFitHeight(1000);
            imageView.setFitWidth(800);
            imageView.setX(0);
            imageView.setY(500);
            translateTransition.setDuration(Duration.millis(1000));
            translateTransition.setNode(imageView);
            translateTransition.setByY(-50);
            translateTransition.play();
            increment++;
        }
        else if(pane.getChildren().contains(imageView)){
            increment++;
            translateTransition.play();
            Game.raise -= 20;
        }



    }

}
