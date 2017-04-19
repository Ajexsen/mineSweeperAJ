package View;

import Controller.Controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

/**
 * Created by Ajex
 * github: https://github.com/Ajexsen/
 */
class StatusBar extends BorderPane {
    private Controller controller;
    private Button startButt;


    private Counter boomNr;
    private Counter timerLabel;


    private int timeSeconds = 0;
    private int boomCount;

    private boolean isRunning = false;

    StatusBar(Controller controller) {
        this.controller = controller;


        startButt = new Button("Start");
        boomCount = controller.getBoomNr();
        boomNr = new Counter("BOOM:");
        timerLabel = new Counter("TIME:");

        startButt.setOnAction(e -> {
            controller.getView().restart();
            Timeline timeline = controller.timeline;
            if (isRunning) {
                isRunning = false;
                timeline.pause();
            } else {
                isRunning = true;
                timerLabel.setCounter(timeSeconds);
                controller.timeline = new Timeline();
                timeline = controller.timeline;
                timeline.setCycleCount(Timeline.INDEFINITE);
                timeline.getKeyFrames().add(
                        new KeyFrame(Duration.seconds(1),
                                event -> {
                                    timeSeconds++;
                                    timerLabel.setCounter(timeSeconds);
                                    if (timeSeconds <= 0) {
                                        controller.timeline.stop();
                                    }
                                }));
                timeline.playFromStart();
            }
        });
        this.setLeft(startButt);
        this.setCenter(boomNr);
        this.setRight(timerLabel);
    }

    public void setNr(int nr) {
        nr = boomCount - nr;
        System.out.println("" + nr);
        //boomNr.setText("" + nr);
    }
}
