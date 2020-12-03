package sample;

import javafx.animation.FadeTransition;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Splash implements Initializable {
    @FXML
    BorderPane nodoPrincipal;
    Stage stage;
    @FXML
    ProgressBar progreso;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nodoPrincipal.setBackground(new Background(new BackgroundFill(Color.RED,new CornerRadii(0), Insets.EMPTY)));
        FadeTransition transition = new FadeTransition();
        transition.setNode(nodoPrincipal);
        transition.setDuration(Duration.seconds(10));
        transition.setFromValue(0);
        transition.setToValue(1);
        transition.play();
        progreso.setProgress(0);
        Task task = new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 101; i++) {
                    updateProgress(i, 100);
                    Thread.sleep(10);
                }
                return null;
            }
        };
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                progreso.progressProperty().bind(task.progressProperty());

                new Thread(task).start();
            }
        });
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent workerStateEvent) {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("ventana_principal.fxml"));
                    Scene scene = new Scene(root, 600, 600);
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    nodoPrincipal.getScene().getWindow().hide();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}

