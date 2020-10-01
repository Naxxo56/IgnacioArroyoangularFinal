package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        
        String resourcePath="sample.fxml";
        URL location = getClass().getResource(resourcePath);
        FXMLLoader fxmlLoader = new FXMLLoader(location);

        fxmlLoader.load();



        //carga la parte grafica
        Parent root = FXMLLoader.load(getClass().getResource("segunda.fxml"));
        primaryStage.setTitle("Ignacio Arroyo Mayo");

        //parteGrafica, tamX, tamY
        Scene scene = new Scene(root,300,300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
