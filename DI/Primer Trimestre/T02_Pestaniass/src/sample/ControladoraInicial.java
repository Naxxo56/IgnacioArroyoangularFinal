package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.utils.Persona;

import java.net.URL;
import java.util.ResourceBundle;

public class ControladoraInicial implements Initializable {
    @FXML
    Button botonImagen, botonCambio, botonCapturaTexto,boton_Listas;

    @FXML
    RadioButton radio1, radio2, radio3, radio4;

    @FXML
    ToggleButton toggle1, toggle2;
    @FXML
    TextField textoNormal;
    @FXML
    TextArea textoArea;
    @FXML
    PasswordField textoPass;

    @FXML
    ComboBox combo_Box1;
    @FXML
    ChoiceBox choice_Box1;
    @FXML
    ListView list_View1;

    ObservableList<Persona> listaChoice;
    ObservableList<Persona> listaCombo;
    ObservableList<Persona> listaListView;

    @FXML
    CheckBox check1;

    DropShadow sombraExterior;
    ToggleGroup grupoRadios, grupoToggles;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();
        personalizarListas();
        acciones();

    }

    private void personalizarListas() {
        choice_Box1.setItems(listaChoice);
        listaChoice.addAll(new Persona("Nacho","Arroyo",559846),new Persona("Sergio","Mayo",5556));
        combo_Box1.setItems(listaCombo);
        listaCombo.addAll(new Persona("Alvaro","Moran",11556),new Persona("Alberto","Royo",558996));
        list_View1.setItems(listaListView);
        listaListView.addAll(new Persona("Lorenzo","Carpacho",5424556),new Persona("Gerne","Gaspar",5506));
    }

    private void instancias() {
        sombraExterior = new DropShadow();
        grupoRadios = new ToggleGroup();
        grupoToggles = new ToggleGroup();

        listaChoice = FXCollections.observableArrayList();
        listaCombo = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();

        asociarDatos();
        grupoRadios.getToggles().addAll(radio1, radio2, radio3, radio4);
        grupoToggles.getToggles().addAll(toggle1, toggle2);
    }

    private void asociarDatos() {
        radio1.setUserData(new Persona("Borja", "Martin", 123213));
        radio2.setUserData(new Persona("Jose", "Martin", 123213));
        radio3.setUserData(new Persona("Roberto", "Martin", 123213));
        radio4.setUserData(new Persona("David", "Martin", 123213));
    }

    private void acciones() {

        botonImagen.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonImagen.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_ENTERED, new ManejoRaton());
        botonCambio.addEventHandler(MouseEvent.MOUSE_EXITED, new ManejoRaton());
        botonImagen.setOnAction(new ManejoPulsaciones());
        boton_Listas.setOnAction(new ManejoPulsaciones());
        botonCapturaTexto.setOnAction(new ManejoPulsaciones());
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {
                /*System.out.println("cambio");
                System.out.println(oldValue);
                System.out.println(newValue);*/
                Persona personaRecuerada = (Persona) newValue.getUserData();
                System.out.println(personaRecuerada.getNombre());
            }
        });
        grupoToggles.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                System.out.println("cambio");
            }
        });
        check1.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                //System.out.println(t1);
                botonImagen.setDisable(t1);
            }
        });

        textoNormal.addEventFilter(KeyEvent.KEY_TYPED, new ManejoTeclas());

    }

    private void personalizarBotones() {

        Image imagenOk = new Image(getClass().getResourceAsStream("resources/button_on.png"));
        botonImagen.setGraphic(new ImageView(imagenOk));
        botonImagen.setBackground(null);
        botonCambio.setGraphic(new ImageView
                (new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
        botonCambio.setText("");
        botonCambio.setBackground(null);
        //botonImagen.setEffect(sombraExterior);
    }

    class ManejoTeclas implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent keyEvent) {

        }
    }

    class ManejoRaton implements EventHandler<MouseEvent> {

        @Override
        public void handle(MouseEvent event) {

            // quien ha generado
            // que ha generado
            if (event.getSource() == botonImagen) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonImagen.setEffect(sombraExterior);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonImagen.setEffect(null);
                }
            } else if (event.getSource() == botonCambio) {
                if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_cancel.png"))));
                    botonCambio.setEffect(sombraExterior);
                } else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
                    botonCambio.setGraphic(new ImageView
                            (new Image(getClass().getResourceAsStream("resources/button_ok.png"))));
                    botonCambio.setEffect(null);
                }
            }

            // que evento ha generado
            // quien lo ha hecho

        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == botonImagen) {
                System.out.println(grupoRadios.getSelectedToggle());
            } else if (actionEvent.getSource() == botonCapturaTexto) {
                /*
                System.out.println(textoNormal.getText());
                System.out.println(textoArea.getText());
                System.out.println(textoPass.getText());
                 */
                textoNormal.appendText("s");
                String numero = textoNormal.getText();
            }else if(actionEvent.getSource()==boton_Listas){
                if(choice_Box1.getSelectionModel().getSelectedIndex()!=-1){
                    Persona persona = listaChoice.get(choice_Box1.getSelectionModel().getSelectedIndex());
                    System.out.println(persona);
                }

            }
        }
    }
}