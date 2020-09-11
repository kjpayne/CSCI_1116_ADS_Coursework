/*
 * Author: Kaden Payne
 * Date: 9/9/2020
 * 
 * Removing the largest ball on screen
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
/**
 *
 * @author kjpay
 */
public class BouncingBalls extends Application {
    @Override
    public void start(Stage primaryStage) {
        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");
            
        //creating buttons to add and remove balls
        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);
            
        //ActionEvents to add or remove balls
        btAdd.setOnAction(e -> ballPane.add());
        btSubtract.setOnAction(e -> ballPane.subtract());

        //ActionEvents to pause and play animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        //Scollbar to abjust balls speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        //BorderPane to hold everthing
        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        //creating Scene and showing Stage
        Scene scene = new Scene(pane, 250, 150);
        primaryStage.setTitle("MultipleBounceBall");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
    
    private class MultipleBallPane extends Pane {
        private Timeline animation;
        
        //Constructor
        public MultipleBallPane() {
            animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
            animation.setCycleCount(Timeline.INDEFINITE);
            animation.play();
        }
        
        //Add more balls to pane
        public void add() {
            Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
            getChildren().add(new Ball(30, 30, getRandomNumber(2, 20), color));
            System.out.println(getChildren());
        }
        
        //Removes the largest ball first
        public void subtract() {
            int indexOfMax = 0;
            int indexA = 0;
            int indexB = 0;
            if (getChildren().size() > 0) {
                for (int i = 0; i < getChildren().size(); i++) {
                    Ball ballA = (Ball)(getChildren().get(indexA));
                    Ball ballB = (Ball)(getChildren().get(indexB));
                    if (ballA.getRadius() > ballB.getRadius()) {
                        indexOfMax = indexA;
                        indexB++;
                    }
                    else {
                        indexOfMax = indexB;
                        indexA++;
                    }
                }
                getChildren().remove(indexOfMax);
            }
            System.out.println(getChildren());
        }
        
        //Plays and pauses the balls
        public void play() {
            animation.play();
        }
        public void pause() {
            animation.pause();
        }
        
        //Increase and decrease speed of balls
        public void increaseSpeed() {
            animation.setRate(animation.getRate() + 0.1);
        }
        public void decreaseSpeed() {
            animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
        }
        
        //Rate property getter
        public DoubleProperty rateProperty() {
            return animation.rateProperty();
        }
        
        //Method that moves the balls
        protected void moveBall() {
            for (Node node: this.getChildren()) {
                Ball ball = (Ball)node;
                if (ball.getCenterX() < ball.getRadius() || ball.getCenterX() > getWidth() - ball.getRadius()) {
                    ball.dx *= -1;
                }
                if (ball.getCenterY() < ball.getRadius() || ball.getCenterY() > getHeight() - ball.getRadius()) {
                    ball.dy *= -1;
                }
                
                ball.setCenterX(ball.dx + ball.getCenterX());
                ball.setCenterY(ball.dy + ball.getCenterY());
            }
        }
    }
    
    class Ball extends Circle implements Comparator<Ball>, java.io.Serializable{
        private double dx = 1, dy = 1;
        
        //Creates Ball object
        Ball(double x, double y, double radius, Color color) {
            super(x, y, radius);
            setFill(color);
        }
        
        @Override
        public int compare(Ball o1, Ball o2) {
            double radius1 = o1.getRadius();
            double radius2 = o2.getRadius();
            
            if (radius1 < radius2) {
                return -1;
            }
            else if (radius1 == radius2) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
    //RNG
    public static int getRandomNumber(int num1, int num2) {
        return (int)(num1 + Math.random() * (num2 - num1 + 1));
    }
}
