package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class VentanaPrincipal implements Initializable {

    String peticionAPI = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?s=Soccer&c=Spain";
    ObservableList<Equipo> listaEquipos;
    @FXML
    ListView<Equipo> listView;
    @FXML
    Button comunicar;
    @FXML
    ImageView imagen;

    Equipo equipo;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaEquipos = FXCollections.observableArrayList();
        listView.setItems(listaEquipos);
        try {
            URL urlAPI = new URL(peticionAPI);
            HttpURLConnection http = (HttpURLConnection) urlAPI.openConnection();
            //System.out.println(http.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(http.getInputStream()));
            String datos = bufferedReader.readLine();
            JSONObject jsonObject = new JSONObject(datos);
            //System.out.println(jsonObject);
            JSONArray arrayEquipos = jsonObject.getJSONArray("teams");
            //System.out.println(arrayEquipos);

            for (int i = 0; i < arrayEquipos.length(); i++) {
                JSONObject object = arrayEquipos.getJSONObject(i);
                String nombre = object.getString("strTeam");
                String anio = object.getString("intFormedYear");
                String escudo = object.getString("strTeamBadge");
                String descripcion = object.getString("strDescriptionEN");
                Equipo equipo = new Equipo(nombre,anio,escudo,descripcion);
                listaEquipos.addAll(equipo);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        acciones();

    }

    private void acciones() {
        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipo>() {
            @Override
            public void changed(ObservableValue<? extends Equipo> observableValue, Equipo equipos, Equipo t1) {
                //System.out.println(t1.getNombre());
                imagen.setImage(new Image(t1.getEscudo()));
                equipo = new Equipo(t1.getNombre(),t1.getAnio(),t1.getEscudo(),t1.getDescripcion());
            }
        });
        comunicar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ventana_secundaria.fxml"));
                    Parent root = loader.load();
                    VentanaSecundaria controladorSecundaria = loader.getController();
                    controladorSecundaria.comunicarEquipo(equipo,VentanaPrincipal.this);

                    Scene scene = new Scene(root,600,600);
                    Stage ventanaAdicional = new Stage();
                    ventanaAdicional.setScene(scene);
                    ventanaAdicional.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }
}
