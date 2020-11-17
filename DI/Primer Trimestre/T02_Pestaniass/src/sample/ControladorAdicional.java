package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladorAdicional implements Initializable {

    @FXML
    Label textoAdicional;
    @FXML
    Button botonVolver;

    private ControladoraInicial controladoraInicial;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
    }

    private void instancias() {
        botonVolver.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vista_inicial.fxml"));
                controladoraInicial.terminarComunicacion("Volver terminado");
                botonVolver.getScene().getWindow().hide();
                controladoraInicial.cerrarVentana();

            }
        });
    }

    public void comunicarTexto(Persona p, ControladoraInicial controladoraInicial) {
        textoAdicional.setText(p.getNombre());
        this.controladoraInicial = controladoraInicial;
    }
}
