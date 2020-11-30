package me.russell.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;

public class MenuAnimation {
    public Timeline snowing;
    private static SVGPath snowFlakes;
    private String path;
    
    public MenuAnimation(VBox pane){
        path = "M50.015,50.021l21.194-4.548l2.453-7.92l-7.92-2.454L50.022,50l5.858-20.875l-5.864-5.862 l-5.861,5.862l5.854,20.855l-15.43-15.233l-7.967,2.294l2.292,7.966l21.082,4.974l-21.196,4.546l-2.453,7.921l7.921,2.454 l15.72-14.902l-5.86,20.876l5.861,5.862l5.863-5.862l-5.854-20.854l15.432,15.23l7.967-2.292l-2.293-7.968L50.015,50.021z M66.512,38.399l3.49,1.082l-1.082,3.491l-9.348,2.004L66.512,38.399z M31.241,42.555l-1.01-3.513l3.512-1.011l6.805,6.718 L31.241,42.555z M33.487,61.6l-3.491-1.082l1.08-3.49l9.35-2.005L33.487,61.6z M47.435,29.981l2.583-2.584l2.584,2.584 l-2.582,9.205L47.435,29.981z M52.562,70.019L49.979,72.6l-2.582-2.581l2.584-9.205L52.562,70.019z M49.987,50.014l-0.005-0.019 l0.012-0.013l0.019,0.003l0.004,0.02l-0.013,0.012L49.987,50.014z M66.256,61.967l-6.805-6.716l9.305,2.193l1.01,3.513 L66.256,61.967z";
        SVGPath svgPath = new SVGPath();
        svgPath.setContent(path);
        svgPath.setFill(Color.WHITE);
        snowFlakes = svgPath;
        Timeline timeline = new Timeline();
        pane.getChildren().add(snowFlakes);
        //for (int i = 0;i>20;i++) {
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(snowFlakes.translateXProperty(), random() * 100),
                            new KeyValue(snowFlakes.translateYProperty(), random() * 50)),
                    new KeyFrame(new Duration(40000), // set end position at 40s
                            new KeyValue(snowFlakes.translateXProperty(), random() * 800),
                            new KeyValue(snowFlakes.translateYProperty(), random() * 400)));
        //}

        snowing = timeline;
    }

}
