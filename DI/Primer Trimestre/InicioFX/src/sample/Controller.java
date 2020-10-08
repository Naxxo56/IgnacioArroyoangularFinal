package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Shadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button botonCambio, botonNueva;
    Shadow sombra;

    Scene segundaEscena;
    Stage stagePrincipal;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        sombra = new Shadow();
    }

    private void acciones() {
        /*
        botonCambio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Cambiando escena...");
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("segunda.fxml"));
                    segundaEscena = new Scene(root, 600, 400);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stagePrincipal = (Stage) botonCambio.getScene().getWindow();
                stagePrincipal.setScene(segundaEscena);
            }
        });
        botonNueva.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("tercera.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 300, 300);
                Stage ventana = new Stage();
                ventana.setScene(scene);
                ventana.setTitle("Nueva ventana");
                ventana.show();



            }
        });

         */
        botonCambio.setOnAction(new ManejoPulsaciones());
        botonNueva.setOnAction(new ManejoPulsaciones());
        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonNueva.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonNueva.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource() == botonCambio) {
                System.out.println("Cambiando escena...");
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("segunda.fxml"));
                    segundaEscena = new Scene(root, 600, 400);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                stagePrincipal = (Stage) botonCambio.getScene().getWindow();
                stagePrincipal.setScene(segundaEscena);
            } else if (actionEvent.getSource() == botonNueva) {
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("tercera.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 300, 300);
                Stage ventana = new Stage();
                ventana.setScene(scene);
                ventana.setTitle("Nueva ventana");
                ventana.show();
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == mouseEvent.MOUSE_ENTERED) {
                //Otra forma:
                //((Button)mouseEvent.getSource()).setEffect(sombra);
                if (mouseEvent.getSource() == botonCambio) {
                    botonCambio.setEffect(sombra);
                } else {
                    botonNueva.setEffect(sombra);
                }

            } else if (mouseEvent.getEventType() == mouseEvent.MOUSE_EXITED) {
                //Otra forma:
                //((Button)mouseEvent.getSource()).setEffect(null);
                if (mouseEvent.getSource() == botonNueva) {
                    botonNueva.setEffect(null);
                } else {
                    botonCambio.setEffect(null);
                }

            }
        }
    }
}
