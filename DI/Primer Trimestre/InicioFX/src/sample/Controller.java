package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Button botonInicial;
    @FXML
    Label textoCambiar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        botonInicial.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //System.out.println("Ejemplo de pulsado");
                textoCambiar.setText("Primera app de JAVA FX");
            }
        });

    }
}
