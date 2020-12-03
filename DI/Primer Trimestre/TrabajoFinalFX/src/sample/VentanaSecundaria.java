package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentanaSecundaria implements Initializable {

    @FXML
    Label textoAdicional,anio;
    @FXML
    TextArea descripcion;
    @FXML
    ImageView escudo;
    @FXML
    Button botonGuardar;
    @FXML
    BorderPane borderGeneral;
    private VentanaPrincipal controladorInicial;
    Equipo equipoUno;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        botonGuardar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser dialogoGuardar = new FileChooser();
                File file = dialogoGuardar.showSaveDialog(borderGeneral.getScene().getWindow());
                ArrayList<Equipo> listaEquipo;
                if (file.getParentFile().canWrite()) {
                    FileWriter fileWriter;
                    BufferedWriter bufferedWriter;
                    try {
                        fileWriter = new FileWriter(file);
                        bufferedWriter = new BufferedWriter(fileWriter);
                        listaEquipo = new ArrayList();
                        listaEquipo.add(equipoUno);

                        for (Equipo eq:listaEquipo) {
                            bufferedWriter.write(String.valueOf(eq));
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void comunicarEquipo(Equipo equipo, VentanaPrincipal controladorInicial){
        textoAdicional.setText("Equipo: "+equipo.getNombre());
        anio.setText("Año de fundacion: "+equipo.getAnio());
        descripcion.setText("Descripcion: "+equipo.getDescripcion());
        escudo.setImage(new Image(equipo.getEscudo()));
        this.controladorInicial = controladorInicial;
        equipoUno = new Equipo(equipo.getNombre(),equipo.getAnio(),equipo.getEscudo(),equipo.getDescripcion());
    }
}


