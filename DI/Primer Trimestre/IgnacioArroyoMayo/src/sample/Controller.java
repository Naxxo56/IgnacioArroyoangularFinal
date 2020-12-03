package sample;

import javafx.animation.FadeTransition;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private Button boton_agregar, boton_modificar, boton_enviar;
    @FXML
    TableView<Pedido> tabla;
    @FXML
    private TableView tabla_amazon;
    @FXML
    private ControladoraDos controladoraDos;
    @FXML
    BorderPane borderGeneral;
    @FXML
    private TableColumn columna_envio, columna_nombre, columna_localidad, columna_productos;
    @FXML
    private MenuItem menu_exportar_pedidos, menu_salir;


    ObservableList<Pedido> listaTabla;
    FilteredList<Pedido> listaFiltrada;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        personalizarMenu();
        //personalizarTabla();
        acciones();
    }

    private void personalizarMenu() {
        Image imagen = new Image(getClass().getResourceAsStream("resources/enviar.png"));
        menu_exportar_pedidos.setGraphic(new ImageView(imagen));
        menu_exportar_pedidos.setAccelerator(KeyCombination.keyCombination("Ctrl+E"));
        menu_salir.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("resources/salida.png"))));
        menu_salir.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
    }
    /*
    public void comunicarTexto(Pedido pedido, ControladoraDos controladoraDos) {
        textoAdicional.setText(p.getNombre());
        this.controladoraDos = controladoraDos;
    }

     */
    /*
    private void personalizarTabla() {
        columna_nombre.setCellValueFactory(new PropertyValueFactory("Nombre"));
        columna_productos.setCellValueFactory(new PropertyValueFactory("Productos"));
        columna_envio.setCellValueFactory(new PropertyValueFactory("NºEnvio"));
        columna_localidad.setCellValueFactory(new PropertyValueFactory("Localidad"));

        listaTabla.addAll(new Pedido((int)(Math.random()*100), "Arroyo", "Madrid", "Casa"));


        //tabla.setItems(listaFiltrada);
        listaFiltrada = new FilteredList(listaTabla);
        tabla.setItems(listaFiltrada);
    }

     */

    private void acciones() {
        menu_exportar_pedidos.setOnAction(new ManejoPulsaciones());
        menu_salir.setOnAction(new ManejoPulsaciones());
        boton_agregar.setOnAction(new ManejoPulsaciones());
        boton_enviar.setOnAction(new ManejoPulsaciones());
        boton_modificar.setOnAction(new ManejoPulsaciones());

    }

    class ManejoPulsaciones implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == menu_exportar_pedidos) {
                TextInputDialog textInputDialog = new TextInputDialog("Valor por defecto");
                Optional seleccion = textInputDialog.showAndWait();
                ObservableList lista = FXCollections.observableArrayList();
                lista.addAll(new Pedido(2, "Arroyo", "hola","ha"),
                        new Pedido( 2,"Lowis", "hola","ha"),
                        new Pedido(2 ,"Gaspar", "hola","ha"),
                        new Pedido(2, "Martin", "hola","ha"));

                ChoiceDialog<Pedido> dialogoChoice = new ChoiceDialog<>(lista.get(0), lista);
                Optional<Pedido> seleccionPedido = dialogoChoice.showAndWait();


                FileChooser fileChooser = new FileChooser();
                File file = fileChooser.showOpenDialog(menu_exportar_pedidos.getParentPopup().getScene().getWindow());

                if (file.getParentFile().canWrite()) {
                    FileWriter fileWriter = null;
                    BufferedWriter bufferedWriter = null;
                    try {
                        file.createNewFile();
                        fileWriter = new FileWriter(file);
                        bufferedWriter = new BufferedWriter(fileWriter);
                        bufferedWriter.write(seleccion.get().toString());
                        //salto de linea
                        bufferedWriter.newLine();
                        bufferedWriter.write(seleccionPedido.get().toString());
                        bufferedWriter.newLine();
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("No hay permisos");
                }



            } else if (actionEvent.getSource() == menu_salir) {
                Alert alertInfo = new Alert(Alert.AlertType.CONFIRMATION);
                alertInfo.setTitle("Diálogo información");
                alertInfo.setHeaderText("¿Desea cerrar la aplicacion?");
                alertInfo.setContentText("Pulse aceptar para cerrar");
                Optional<ButtonType> seccion = alertInfo.showAndWait();
                if (seccion.get() == ButtonType.OK) {
                    borderGeneral.getScene().getWindow().hide();
                }


            } else if (actionEvent.getSource() == boton_agregar) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("examenVentana2.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControladoraDos ventanaAdicional2 = loader.getController();
                Scene scene = new Scene(root, 600, 600);
                Stage ventana = new Stage();
                ventana.setScene(scene);
                ventana.show();

                ControladoraDos controladoraDos;

                String nombre, producto, localidad;
                int numPedido = (int) (Math.random() * 1000);


            } else if (actionEvent.getSource() == boton_enviar) {

            } else if (actionEvent.getSource() == boton_modificar) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("examenVentana3.fxml"));
                Parent root = null;
                try {
                    root = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ControladoraTres ventanaAdicional3 = loader.getController();
                Scene scene = new Scene(root, 600, 600);
                Stage ventana = new Stage();
                ventana.setScene(scene);
                ventana.show();

            }


        }
    }
    /*
    public void datosPedido(String nombre,String localidad,String producto,int numPedido){

    }

     */
}
