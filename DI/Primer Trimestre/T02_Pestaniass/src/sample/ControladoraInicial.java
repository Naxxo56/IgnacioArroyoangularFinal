package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import sample.utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInicial implements Initializable {
    @FXML
    Button botonImagen, botonCambio;
    @FXML
    RadioButton radioUno, radioDos, radioTres, radioCuatro;

    DropShadow sombraExterior;

    ToggleGroup grupoRadios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();
        acciones();
    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        asociarDatos();
        grupoRadios.getToggles().addAll(radioUno, radioDos, radioTres, radioCuatro);
    }

    private void asociarDatos() {
        radioUno.setUserData(new Persona("Nacho","Arroyo",12345));
        radioDos.setUserData(new Persona("Ernesto","Gaspar",123456));
        radioTres.setUserData(new Persona("Roberto","Reviriego",1234567));
        radioCuatro.setUserData(new Persona("Victor","Pellicer",12345678));
    }

    private void acciones() {
        botonImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());

        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                /*

                System.out.println("Cambio de seleccion");
                System.out.println(oldValue);
                System.out.println(newValue);

                 */
                Persona personaRecuperada = (Persona)newValue.getUserData();
                System.out.println(personaRecuperada.getNombre());
            }
        });


    }

    private void personalizarBotones() {
        //Image imageOk=new Image(String.valueOf(getClass().getResource("resources/button_on.png")));
        //botonImagen.setGraphic(new ImageView(imageOk));
        botonImagen.setGraphic(new ImageView(new Image(String.valueOf(getClass().getResource("resources/button_on.png")))));
        botonImagen.setBackground(null);
        botonCambio.setGraphic(new ImageView(new Image(String.valueOf(getClass().getResource("resources/button_ok.png")))));
        ;
        botonCambio.setText("");
        botonCambio.setBackground(null);
        //botonImagen.setEffect(sombraExterior);
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {
            //quien ha generado
            //que ha generado
            if (event.getSource() == botonImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonImagen.setEffect(sombraExterior);
                } else if ((event.getEventType() == MouseEvent.MOUSE_EXITED)) {
                    botonImagen.setEffect(null);
                }
            } else if (event.getSource() == botonCambio) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_cancel.png"))));
                } else if ((event.getEventType() == MouseEvent.MOUSE_EXITED)) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
                }
            }
        }
    }
}
