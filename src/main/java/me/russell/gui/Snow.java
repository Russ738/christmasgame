package me.russell.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Time;

public class Snow {
    private static TranslateTransition translateTransition = new TranslateTransition();
    private static ImageView imageView;

    public static void Animation(VBox pane) throws FileNotFoundException {
        if(!pane.getChildren().contains(imageView)){
            Image image = new Image(new FileInputStream("src/main/resources/snow.png"));
            imageView = new ImageView(image);
            System.out.println("no contain");
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
        }
        else if(pane.getChildren().contains(imageView)) {
            translateTransition.play();
        }

    }
}
