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
import javafx.scene.control.cell.PropertyValueFactory;
import sample.utils.Pizza;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button botonRealizar, botonModificar, botonPendientes;
    @FXML
    RadioButton radioFamiliar, radioMediana, radioPequeña;
    @FXML
    TextField textoNombre, textoTelefono;
    @FXML
    ComboBox comboPizza;
    @FXML
    TableView tabla;
    @FXML
    TableColumn columnaPizza, columnaNombre, columnaEstado;

    ToggleGroup grupoRadios;
    ObservableList<Pizza> pizzaTablas;
    ObservableList listaCombo;
    boolean estado = false;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarTabla();
        personalizarListas();
        acciones();

    }

    private void personalizarListas() {
        comboPizza.setItems(listaCombo);
        listaCombo.addAll("4 Quesos","Margarita","Hawaiana","Carbonara","Barbacoa");

    }

    private void personalizarTabla() {
        columnaPizza.setCellFactory(new PropertyValueFactory("Pizza"));
        columnaNombre.setCellFactory(new PropertyValueFactory("Nombre"));
        columnaEstado.setCellFactory(new PropertyValueFactory("Estado"));
        //pizzaTablas.add("nacho");
        tabla.setItems(pizzaTablas);
    }

    private void acciones() {
        grupoRadios.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle oldValue, Toggle newValue) {

            }
        });
        botonRealizar.setOnAction(new ManejoPulsaciones());
        tabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Pizza>() {
            @Override
            public void changed(ObservableValue<? extends Pizza> observableValue, Pizza oldValue, Pizza newValue) {
                textoNombre.setText(newValue.getNombre());
                textoTelefono.setText(newValue.getTelefono());
                comboPizza.getSelectionModel().select(newValue.getPizza());
            }
        });
        }

    private void instancias() {
        grupoRadios = new ToggleGroup();
        grupoRadios.getToggles().addAll(radioFamiliar, radioMediana, radioPequeña);
        listaCombo= FXCollections.observableArrayList();
        pizzaTablas =FXCollections.observableArrayList();

    }
    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource()==botonRealizar){
                    Pizza pizza = new Pizza((String) comboPizza.getSelectionModel().getSelectedItem(),textoNombre.getText(),textoTelefono.getText(),false);
                    pizzaTablas.add(pizza);
                }else if(actionEvent.getSource()==botonModificar){

            }else if(actionEvent.getSource()==botonPendientes){

            }
            }

        }
    }

