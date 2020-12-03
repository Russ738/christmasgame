package me.russell.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class SnowParticles {
    private static int x;
    private static PathTransition ptr = new PathTransition();
    public void snowParticles(Bounds parent, Pane pane){
        Group particles =  new Group();
        Timeline timeline = new Timeline();
        for(int i=0;i < 7;i++){
            Circle circle = new Circle();
            circle.setRadius(5);
            circle.setFill(Color.WHITE);
            particles.getChildren().add(circle);
        }
//        for(Node circle:particles.getChildren()){
//            timeline.getKeyFrames().addAll(
//                    new KeyFrame(Duration.ZERO, // set start position at 0
//                            new KeyValue(circle.translateYProperty(), parent.getCenterX()),
//                            new KeyValue(circle.translateXProperty(), startX)),
//                    new KeyFrame(new Duration(4000), // set end position at 40s
//                            new KeyValue(circle.translateYProperty(), endY),
//                            new KeyValue(circle.translateXProperty(), endX)));
//
//        }
        pane.getChildren().add(particles);
        ptr.play();

    }
}
