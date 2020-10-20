package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button botonAgregar, botonLimpiar;
    @FXML
    RadioButton radioTodos, radioLista, radioCombo, radioChoice;
    @FXML
    TextField textNombre, textApellido, textTelefono, textoFinal;
    @FXML
    ComboBox comboEstado, comboBox1;
    @FXML
    CheckBox checkBox1;
    @FXML
    ChoiceBox choice1;
    @FXML
    ListView listView1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();
        personalizarListas();
        acciones();
    }

    private void acciones() {
    }

    private void personalizarListas() {
    }

    private void personalizarBotones() {
    }

    private void instancias() {
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {

        }
    }
}
