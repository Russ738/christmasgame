package me.russell.gui;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.Random;

import static java.lang.Math.random;

public class Game {
    private static int score;
    private static boolean end= false;
    private static Timeline timeline;
    private static Group snowFlakes;
    private static VBox pane;
    private static int hits;
    public static int raise;
    private static Text scoreText = new Text();
    public static int snowNum;
    private static int cycle;
    private static MediaPlayer player;
    public static void Animation(VBox snowPane){
        //File file = new File("snowSmash.wav");


        cycle = 0;
        snowNum = 0;
        raise = 520;
        score = 0;
        hits = 0;
        timeline = new Timeline();
        snowFlakes = new Group();
        pane = snowPane;
        pane.getChildren().clear();
        double width = pane.getWidth();
        double height = pane.getHeight();
        ;
        pane.getChildren().add(scoreText);

        snowFlakes.setManaged(false);
        scoreText.setFont(Font.font("Freestyle Script",50));
        scoreText.setText("Score: " + score);
        scoreText.setTranslateY(-212.5);
        scoreText.setTranslateX(-325);
        getRanSnowFlakes(snowNum++);
        timeline = timeLineRan();
        timeline.setOnFinished(e -> {
            snowFlakes.getChildren().clear();
            getRanSnowFlakes(snowNum++);
            timeLineRan();
            timeline.play();
            snowFlakes.setVisible(true);
        });
        timeline.play();
        return;
    }




    private static Timeline timeLineRan() {

        for (Node snowFlake : snowFlakes.getChildren()) {
            double startY = random()*-100;
            double startX = random() * 750;
            double endY = 550;
            double endX = random() * 900;
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(snowFlake.translateYProperty(), startY),
                            new KeyValue(snowFlake.translateXProperty(), startX)),
                    new KeyFrame(new Duration(4000), // set end position at 40s
                            new KeyValue(snowFlake.translateYProperty(), endY),
                            new KeyValue(snowFlake.translateXProperty(), endX)));
            snowFlakes.setVisible(true);
            snowFlake.setTranslateY(-100);
            snowFlake.setOnMouseClicked(e -> {
                String fileName ="src/main/resources/snowSmash.wav";
                Media m = new Media("file:///" + System.getProperty("user.dir").replace('\\', '/') + "/" + fileName);
                player = new MediaPlayer(m);
                player.play();
                score++;
                scoreText.setText("Score: " + score);
                snowFlake.setVisible(false);
                //particle test
                System.out.println(snowFlake.getBoundsInParent());
                Point2D topLeft = new Point2D(snowFlake.getBoundsInParent().getMinX(),snowFlake.getBoundsInParent().getMinY());
                System.out.println(topLeft);
                Point2D center = topLeft.midpoint(snowFlake.getBoundsInParent().getMaxX(),snowFlake.getBoundsInParent().getMaxY());
                System.out.println(center);
                Circle circle = new Circle(10,Color.WHITE);
                circle.setManaged(false);
                circle.setLayoutX(center.getX());
                circle.setLayoutY(center.getY());

                pane.getChildren().add(circle);






                //--------------
            });
            snowFlake.setPickOnBounds(true);
            snowFlake.boundsInParentProperty().addListener((observable, oldValue, newValue) -> {
                    if (snowFlakes.getBoundsInParent().intersects(0, raise, 1200, 2) && snowFlakes.getId().equals("hit")){
                        snowFlakes.setId("no");
                        snowFlake.setVisible(false);
                        try {
                            if (hits <= 9) {
                                Snow.Animation(pane);
                                hits++;
                            } else {
                                timeline.play();
                                timeline.stop();
                                Menu.isOver(score);
                                return;
                            }
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
            });
        }
        pane.getChildren().add(snowFlakes);
            return timeline;

        }
        private static Group getRanSnowFlakes (int snowNum) {
            pane.getChildren().removeAll(snowFlakes);
            if (!snowFlakes.getChildren().isEmpty()) {
                snowFlakes.getChildren().clear();
            }
            for (int i = 0; i <snowNum; i++) {
                String path = "M50.015,50.021l21.194-4.548l2.453-7.92l-7.92-2.454L50.022,50l5.858-20.875l-5.864-5.862 l-5.861,5.862l5.854,20.855l-15.43-15.233l-7.967,2.294l2.292,7.966l21.082,4.974l-21.196,4.546l-2.453,7.921l7.921,2.454 l15.72-14.902l-5.86,20.876l5.861,5.862l5.863-5.862l-5.854-20.854l15.432,15.23l7.967-2.292l-2.293-7.968L50.015,50.021z M66.512,38.399l3.49,1.082l-1.082,3.491l-9.348,2.004L66.512,38.399z M31.241,42.555l-1.01-3.513l3.512-1.011l6.805,6.718 L31.241,42.555z M33.487,61.6l-3.491-1.082l1.08-3.49l9.35-2.005L33.487,61.6z M47.435,29.981l2.583-2.584l2.584,2.584 l-2.582,9.205L47.435,29.981z M52.562,70.019L49.979,72.6l-2.582-2.581l2.584-9.205L52.562,70.019z M49.987,50.014l-0.005-0.019 l0.012-0.013l0.019,0.003l0.004,0.02l-0.013,0.012L49.987,50.014z M66.256,61.967l-6.805-6.716l9.305,2.193l1.01,3.513 L66.256,61.967z";
                SVGPath svgPath = new SVGPath();
                svgPath.setContent(path);
                svgPath.setFill(Color.WHITE);
                svgPath.setOpacity(Math.random());
                snowFlakes.getChildren().add(svgPath);
                snowFlakes.setId("hit");


            }
            return snowFlakes;
        }

        private static double getRandomNumber ( double min, double max){
            Random r = new Random();
            return (r.nextInt((int) ((max - min) * 10 + 1)) + min * 10) / 10.0;
        }

}